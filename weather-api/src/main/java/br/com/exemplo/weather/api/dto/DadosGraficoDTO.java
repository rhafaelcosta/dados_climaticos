package br.com.exemplo.weather.api.dto;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class DadosGraficoDTO {

	private String data;		
	private Double temperatura;	
	private Double temperaturaMaxima;
	private Double temperaturaMinima;
	private Double umidade;
	private Double pressao;

	public DadosGraficoDTO() { }
	
	public DadosGraficoDTO(Integer Mo, Integer Year, Double temperatura, Double temperaturaMaxima,
			Double temperaturaMinima, Double umidade, Double pressao) {
		this.data= Month.of(Mo).getDisplayName(TextStyle.FULL_STANDALONE, new Locale("pt", "BR")) + "/" + Year;
		this.temperatura = temperatura;
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMinima = temperaturaMinima;
		this.umidade = umidade;
		this.pressao = pressao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Double getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(Double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public Double getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(Double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public Double getUmidade() {
		return umidade;
	}

	public void setUmidade(Double umidade) {
		this.umidade = umidade;
	}

	public Double getPressao() {
		return pressao;
	}

	public void setPressao(Double pressao) {
		this.pressao = pressao;
	}
		
}
