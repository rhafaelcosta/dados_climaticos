package br.com.exemplo.weather.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.weather.api.dto.CidadeDTO;
import br.com.exemplo.weather.api.model.Cidade;
import br.com.exemplo.weather.api.repository.CidadeRepository;
import br.com.exemplo.weather.api.service.CidadeService;

/**
 * Classe respónsavel por agrupar os recursos REST de cidades
 * @author Rhafael
 *
 */
@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CidadeService cidadeService;

	/**
	 * Listar todas as cidades
	 * @return List<CidadeDTO>
	 */
	@GetMapping
	public List<CidadeDTO> listar() {
		return cidadeRepository.listar();
	}
	
	/**
	 * Buscar cidade pelo nome
	 * @param nome
	 * @return Cidade
	 */
	@GetMapping("/porNome")
	public Cidade findByName(@RequestParam String nome) {
		return cidadeRepository.findByNomeLike(nome);
	}
	
	/**
	 * Buscar cidade que está syncronizando os dados do servidor openweathermap
	 * @return Cidade
	 */
	@GetMapping("/sync")
	public CidadeDTO findBySync() {
		Cidade cidade = cidadeRepository.findByAtivoIsTrue();
		return new CidadeDTO(cidade.getId(), cidade.getNome());
	}

	/**
	 * Método respónsavel por alterar a cidade que vai syncronizar os dados climáticos
	 * @param codigo
	 * @return Cidade
	 */
	@PutMapping("/{codigo}/ativo")
	public ResponseEntity<Cidade> atualizarPropriedadeAtivo(@PathVariable Long codigo) {
		try {
			Cidade cidade = cidadeService.alterarCidadeSync(codigo);
			return ResponseEntity.status(HttpStatus.OK).body(cidade);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}		
	}

}
