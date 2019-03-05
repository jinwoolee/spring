package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class LprodServiceImplTest extends LogicTestConfig{

	@Resource(name="lprodService")
	private ILprodService lprodService;
	
	@Before
	public void setup(){
	}

	/**
	 * Method : testGetAllLprod
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 제품 카테고리 조회
	 */
	@Test
	public void testGetAllLprod() {
		/***Given***/
		
		/***When***/
		List<LprodVo> lprodList = lprodService.getAllLprod();

		/***Then***/
		assertTrue(lprodList.size() > 0);
	}
	
	@Test
	public void testSelectLprodPagingList(){
		/***Given***/
		PageVo pageVo = new PageVo(1, 5);
		
		/***When***/
		Map<String, Object> resultMap = lprodService.selectLprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>)resultMap.get("lprodList");
		int totalCnt = (Integer)resultMap.get("totalCnt");

		/***Then***/
		assertEquals(5, lprodList.size());
		assertEquals(19, totalCnt);

	}

}
