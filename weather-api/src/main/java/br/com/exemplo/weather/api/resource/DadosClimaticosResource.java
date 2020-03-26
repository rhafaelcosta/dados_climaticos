package br.com.exemplo.weather.api.resource;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.weather.api.dto.DadosGraficoDTO;
import br.com.exemplo.weather.api.model.DadosClimaticos;
import br.com.exemplo.weather.api.repository.DadosClimaticosRepository;

/**
 * Classe respónsavel por agrupar os recursos REST de dados climaticos
 * @author Rhafael
 *
 */
@RestController
@RequestMapping("/dados/climaticos")
public class DadosClimaticosResource {

	@Autowired
	private DadosClimaticosRepository dadosClimaticosRepository;

	/**
	 * Listar todos os dados climáticos
	 * @return Lista de dados climáticos 
	 */
	@GetMapping	
	public List<DadosClimaticos> listar() {
		return dadosClimaticosRepository.findAll();
	}
	
	/**
	 * Listar os dados climáticos por cidade, data inicial e data final
	 * @param cidadeId
	 * @param dataInicial
	 * @param dataFinal
	 * @return Lista de dados climáticos
	 */
	@GetMapping("/graficos/{cidadeId}")
	public List<DadosGraficoDTO> buscarDadosAgrupadosPorMesAno(@PathVariable Long cidadeId, 
											 @RequestParam(name = "dataInicial", required= false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio,
											 @RequestParam(name = "dataFinal", required= false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fim) {

		return dadosClimaticosRepository.buscarDadosAgrupadosPorMesAno(cidadeId, inicio, fim);

	}

}
