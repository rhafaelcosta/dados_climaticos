package br.com.exemplo.weather.api.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.exemplo.weather.api.model.Cidade;
import br.com.exemplo.weather.api.model.DadosClimaticos;
import br.com.exemplo.weather.api.modelApi.Main;
import br.com.exemplo.weather.api.modelApi.WeatherData;
import br.com.exemplo.weather.api.repository.CidadeRepository;
import br.com.exemplo.weather.api.repository.DadosClimaticosRepository;

@Service
public class DadosClimaticosService {

	private final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather?units=metric&APPID=80730ceb55c51bebae397cfc46e03344";

	@Autowired
	private DadosClimaticosRepository dadosClimaticosRepository;
	
	@Autowired	
	private CidadeRepository cidadeRepository;

	// Método responsavel por consumir a API openweathermap
	// FixedDelay 900000 = 15 Minutos
	@Scheduled(fixedDelay = 900000)
	public void buscarDadosClimaticos() {
		try {
			Cidade cidade = cidadeRepository.findByAtivoIsTrue();

			RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<WeatherData> response = restTemplate.getForEntity(WEATHER_API_URL + "&id=" + cidade.getId(), WeatherData.class);

	        WeatherData cb = response.getBody();

	        salvarDados(cb.getMain(), cidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Método respónsavel por salvar os dados climaticos
	private void salvarDados(Main dados, Cidade cidade) {
		dadosClimaticosRepository.save(convertWheatherObjectToDadosClimaticos(dados, cidade));
	}
	
	// Método respónsavel por converter os dados climaticos que a API openweathermap retorna
	private DadosClimaticos convertWheatherObjectToDadosClimaticos(Main dados, Cidade cidade) {
		DadosClimaticos dc = new DadosClimaticos();		
		
		dc.setCidade(cidade);			
		dc.setPressao(dados.getPressure());
		dc.setTemperatura(dados.getTemp());
		dc.setTemperaturaMaxima(dados.getTemp_max());
		dc.setTemperaturaMinima(dados.getTemp_min());
		dc.setUmidade(dados.getHumidity());
		dc.setData(LocalDate.now());
		
		return dc;
	}
	
}
