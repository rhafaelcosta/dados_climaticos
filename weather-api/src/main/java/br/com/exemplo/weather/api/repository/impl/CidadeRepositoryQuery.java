package br.com.exemplo.weather.api.repository.impl;

import java.util.List;

import br.com.exemplo.weather.api.dto.CidadeDTO;

public interface CidadeRepositoryQuery {

	public List<CidadeDTO> listar();
	
}
