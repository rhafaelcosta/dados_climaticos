package br.com.exemplo.weather.api.repository.impl;

import java.util.List;

import br.com.exemplo.weather.api.dto.CidadeDTO;

/**
 * Interface respónsavel por definir as consultas personalizadas para clientes
 * @author Rhael
 *
 */
public interface CidadeRepositoryQuery {

	/**
	 * Método respónsavel por lisatr todas as cidades
	 * @return List<CidadeDTO>
	 */
	public List<CidadeDTO> listar();
	
}
