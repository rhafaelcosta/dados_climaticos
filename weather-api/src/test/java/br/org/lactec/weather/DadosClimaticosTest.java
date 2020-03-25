package br.org.lactec.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.exemplo.weather.api.dto.DadosGraficoDTO;

public class DadosClimaticosTest extends WeatherApplicationTests {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

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
