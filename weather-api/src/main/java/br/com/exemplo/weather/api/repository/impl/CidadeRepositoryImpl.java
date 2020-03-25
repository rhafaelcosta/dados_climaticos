package br.com.exemplo.weather.api.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.exemplo.weather.api.dto.CidadeDTO;
import br.com.exemplo.weather.api.model.Cidade;

public class CidadeRepositoryImpl implements CidadeRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	// Método respónsavel por listar todas as cidades cadastras
	@Override
	public List<CidadeDTO> listar() {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CidadeDTO> criteria = builder.createQuery(CidadeDTO.class);
		Root<Cidade> root = criteria.from(Cidade.class);
		
		criteria.select(builder.construct(CidadeDTO.class, root.get("id"), root.get("nome")));
		criteria.orderBy(builder.asc(root.get("nome")));
		
		TypedQuery<CidadeDTO> query = manager.createQuery(criteria);
				
		return query.getResultList();		
	}

}