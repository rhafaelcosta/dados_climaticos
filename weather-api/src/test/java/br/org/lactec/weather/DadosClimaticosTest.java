package br.org.lactec.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.exemplo.weather.api.dto.DadosGraficoDTO;

/**
 * Classe respónsvel pelos testes de dados climáticos 
 * @author Rhafael
 *
 */
public class DadosClimaticosTest extends WeatherApplicationTests {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	/**
	 * Método respónsavel por testar a busca dos dados climáticos agrupados por mês e ano 
	 * @throws Exception
	 */
	@Test
	public void getCidade() throws Exception {
		String uri = "/dados/climaticos/graficos/6322752";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		DadosGraficoDTO[] dados = super.mapFromJson(content, DadosGraficoDTO[].class);
		assertTrue(dados.clone().length > 0);

	}

}
