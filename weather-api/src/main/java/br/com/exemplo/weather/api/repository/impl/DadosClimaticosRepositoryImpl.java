package br.com.exemplo.weather.api.repository.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.exemplo.weather.api.dto.DadosGraficoDTO;
import br.com.exemplo.weather.api.model.DadosClimaticos;

public class DadosClimaticosRepositoryImpl implements DadosClimaticosRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	// Método responsável por listar todos os dados climaticos, aplicando os filtros informados
	@Override
	public List<DadosClimaticos> buscarDadosClimaticos(Long cidadeId, LocalDate inicio, LocalDate fim) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<DadosClimaticos> criteria = builder.createQuery(DadosClimaticos.class);
		Root<DadosClimaticos> root = criteria.from(DadosClimaticos.class);

		Predicate[] predicates = criarRestricoes(cidadeId, inicio, fim, builder, root);
		criteria.where(predicates);

		TypedQuery<DadosClimaticos> query = manager.createQuery(criteria);

		return query.getResultList();
		
	}

	// Método responsável por agrupor os dados da cidade por mês e ano
	@Override
	public List<DadosGraficoDTO> buscarDadosAgrupadosPorMesAno(Long cidadeId, LocalDate inicio, LocalDate fim) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();		
		CriteriaQuery<DadosGraficoDTO> criteria = criteriaBuilder.createQuery(DadosGraficoDTO.class);		
		Root<DadosClimaticos> root = criteria.from(DadosClimaticos.class);
		
		criteria.select(criteriaBuilder.construct(DadosGraficoDTO.class,
				criteriaBuilder.function("month", Integer.class, root.get("data")),
				criteriaBuilder.function("year", Integer.class, root.get("data")),
				criteriaBuilder.avg(root.get("temperatura")),
				criteriaBuilder.avg(root.get("temperaturaMaxima")),
				criteriaBuilder.avg(root.get("temperaturaMinima")),
				criteriaBuilder.avg(root.get("umidade")),
				criteriaBuilder.avg(root.get("pressao"))
		));
				
		Predicate[] predicates = criarRestricoes(cidadeId, inicio, fim, criteriaBuilder, root);
		criteria.where(predicates);
		
		criteria.groupBy(root.get("cidade").get("id"), criteriaBuilder.function("month", Integer.class, root.get("data")), criteriaBuilder.function("year", Integer.class, root.get("data")));
		
		TypedQuery<DadosGraficoDTO> query = manager.createQuery(criteria);

		return query.getResultList();
	}
	
	// Método responsável por criar os filtros do SELECT
	private Predicate[] criarRestricoes(Long cidadeId, LocalDate inicio, LocalDate fim, CriteriaBuilder builder, Root<DadosClimaticos> root) {
		
		List<Predicate> predicates = new ArrayList<>();		
		predicates.add(builder.equal(root.get("cidade").get("id"), cidadeId));		
		
		if (inicio != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("data"), inicio));
		}
		
		if (fim != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("data"), fim));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}