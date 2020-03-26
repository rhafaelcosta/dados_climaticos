package br.com.exemplo.weather.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.weather.api.model.DadosClimaticos;
import br.com.exemplo.weather.api.repository.impl.DadosClimaticosRepositoryQuery;

/**
 * Interface que herda as implementações do JPA para a classe DadosClimaticos
 * @author Rhafael
 *
 */
public interface DadosClimaticosRepository extends JpaRepository<DadosClimaticos, Long>, DadosClimaticosRepositoryQuery {

}
