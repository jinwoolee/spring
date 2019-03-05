package kr.or.ddit.prod.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.test.WebTestConfig;

public class ProdControllerTest extends WebTestConfig{

	@Test
	public void testProdList() throws Exception {
		/***Given***/
		mockMvc.perform(get("/prodList").param("lgu", "P101"))
				.andExpect(view().name("prod/prodList"))
				.andExpect(model().attributeExists("prodList"));
				
		/***When***/

		/***Then***/
	}

}
