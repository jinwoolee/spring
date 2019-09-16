package kr.or.ddit.prod.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.prod.model.Prod;

public class ProdDaoTest extends RootTestConfig{

	@Resource(name="prodDao")
	private IProdDao prodDao;
	
	/**
	* Method : testGetProdList
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 제품 리스트 조회 테스트
	*/
	@Test
	public void testGetProdList() {
		/***Given***/
		//IProdDao prodDao = new ProdDao();
		String lprod_gu ="P101";
				
		/***When***/
		List<Prod> prodList = prodDao.getProdList(lprod_gu);

		/***Then***/
		assertEquals(6, prodList.size());
	}

}
