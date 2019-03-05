package kr.or.ddit.lprod.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.test.WebTestConfig;

public class LprodControllerTest extends WebTestConfig{

	@Test
	public void testLprodList() throws Exception {
		/***Given***/
		mockMvc.perform(get("/lprodList"))
				.andExpect(status().isOk())
				.andExpect(view().name("lprod/lprodList"));
		
		/***When***/

		/***Then***/
	}

}
