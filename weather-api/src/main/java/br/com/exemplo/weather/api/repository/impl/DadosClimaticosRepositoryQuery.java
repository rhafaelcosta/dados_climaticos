package br.com.exemplo.weather.api.repository.impl;

import java.time.LocalDate;
import java.util.List;

import br.com.exemplo.weather.api.dto.DadosGraficoDTO;
import br.com.exemplo.weather.api.model.DadosClimaticos;

public interface DadosClimaticosRepositoryQuery {

	public List<DadosClimaticos> buscarDadosClimaticos(Long cidadeId, LocalDate inicio, LocalDate fim);
	public List<DadosGraficoDTO> buscarDadosAgrupadosPorMesAno(Long cidadeId, LocalDate inicio, LocalDate fim);
	
}
