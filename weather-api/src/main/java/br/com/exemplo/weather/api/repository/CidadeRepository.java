package br.com.exemplo.weather.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.weather.api.model.Cidade;
import br.com.exemplo.weather.api.repository.impl.CidadeRepositoryQuery;

/**
 * Interface que herda as implementações do JPA para a classe Cidade
 * @author Rhafael
 *
 */
public interface CidadeRepository extends JpaRepository<Cidade, Long>, CidadeRepositoryQuery {

	/**
	 * Método respónsavel por buscar cidade pelo nome
	 * @param nome
	 * @return Cidade
	 */
	Cidade findByNomeLike(String nome);
	
	/**
	 * Método respónsavel por buscar cidade que está syncronizando os dados
	 * @return Cidade
	 */
	Cidade findByAtivoIsTrue();
		
}
