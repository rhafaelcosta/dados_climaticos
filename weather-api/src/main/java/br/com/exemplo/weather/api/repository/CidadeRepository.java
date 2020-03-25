package br.com.exemplo.weather.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.weather.api.model.Cidade;
import br.com.exemplo.weather.api.repository.impl.CidadeRepositoryQuery;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, CidadeRepositoryQuery {

	// Método respónsavel por buscar cidade pelo nome 
	Cidade findByNomeLike(String nome);
	
	// Método respónsavel por buscar cidade que está syncronizando os dados
	Cidade findByAtivoIsTrue();
		
}
