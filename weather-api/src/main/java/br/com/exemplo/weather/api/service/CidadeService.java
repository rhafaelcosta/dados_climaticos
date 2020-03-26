package br.com.exemplo.weather.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exemplo.weather.api.model.Cidade;
import br.com.exemplo.weather.api.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	/**
	 * Método respónsavel por alterar a cidade que está syncronizando os dados
	 * @param codigo
	 * @return Cidade
	 */
	public Cidade alterarCidadeSync(Long codigo) {

		Cidade cidadeAtiva = cidadeRepository.findByAtivoIsTrue();		
		Cidade cidade = cidadeRepository.findById(codigo).get();
		
		cidadeAtiva.setAtivo(false);
		cidade.setAtivo(true);

		cidadeRepository.save(cidadeAtiva);
		cidadeRepository.save(cidade);
		
		return cidade;
	}
	
}
