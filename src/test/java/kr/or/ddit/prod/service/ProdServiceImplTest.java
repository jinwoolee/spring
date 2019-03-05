package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.test.LogicTestConfig;

import org.junit.Test;

public class ProdServiceImplTest extends LogicTestConfig{
	
	@Resource(name="prodService")
	private IProdService prodService;
	
	@Test
	public void testGetProdByLgu(){
		/***Given***/
		String lgu = "P101";
		
		/***When***/
		List<ProdVo> prodList = prodService.getProdByLgu(lgu);

		/***Then***/
		assertTrue(prodList.size() > 0);

	}

}
