package br.com.exemplo.weather.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.weather.api.model.Cidade;
import br.com.exemplo.weather.api.repository.impl.CidadeRepositoryQuery;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, CidadeRepositoryQuery {
	
	Cidade findByNomeLike(String nome);
	Cidade findByAtivoIsTrue();
		
}
