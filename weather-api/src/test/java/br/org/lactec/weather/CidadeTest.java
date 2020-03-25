package br.org.lactec.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.exemplo.weather.api.model.Cidade;

public class CidadeTest extends WeatherApplicationTests {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getCidadeList() throws Exception {

		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/cidades").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		Cidade[] list = super.mapFromJson(content, Cidade[].class);
		assertTrue(list.length > 0);

	}

	@Test
	public void getCidade() throws Exception {

		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/cidades/sync").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		Cidade cidade = super.mapFromJson(content, Cidade.class);
		assertTrue(cidade != null);

	}

	@Test
	public void updateCidade() throws Exception {
		String uri = "/cidades/6322752/ativo";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.put(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		Cidade cidade = super.mapFromJson(content, Cidade.class);
		assertTrue(cidade != null);

	}

}