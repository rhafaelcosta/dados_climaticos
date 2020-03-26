package br.com.exemplo.weather.api.repository.impl;

import java.time.LocalDate;
import java.util.List;

import br.com.exemplo.weather.api.dto.DadosGraficoDTO;
import br.com.exemplo.weather.api.model.DadosClimaticos;

/**
 * Interface respónsavel por definir as consultas personalizadas para dados climaticos
 * @author Rhael
 *
 */
public interface DadosClimaticosRepositoryQuery {

	/**
	 * Método respónsavel por buscar os dados climaticos
	 * @param cidadeId
	 * @param inicio
	 * @param fim
	 * @return List<DadosClimaticos>
	 */
	public List<DadosClimaticos> buscarDadosClimaticos(Long cidadeId, LocalDate inicio, LocalDate fim);
	
	/**
	 * Método respónsavel por buscar os dados climaticos agrupados por Mês e Ano
	 * @param cidadeId
	 * @param inicio
	 * @param fim
	 * @return List<DadosGraficoDTO>
	 */
	public List<DadosGraficoDTO> buscarDadosAgrupadosPorMesAno(Long cidadeId, LocalDate inicio, LocalDate fim);
	
}
