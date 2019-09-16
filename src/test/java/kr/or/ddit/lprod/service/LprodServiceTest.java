package kr.or.ddit.lprod.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.model.Lprod;

public class LprodServiceTest extends RootTestConfig{

	@Resource(name="lprodService")
	private ILprodService lprodService;
	
	/**
	* Method : getLpordListTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 제품 그룹 리스트 조회 테스트
	*/
	@Test
	public void getLpordListTest() {
		/***Given***/
	
		/***When***/
		List<Lprod> lprodList = lprodService.getLprodList();

		/***Then***/
		assertEquals(9, lprodList.size());
	}
	
	/**
	* Method : getLprodPagingListTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 제품 그룹 페이징 리스트 조회 테스트
	*/
	@Test
	public void getLprodPagingListTest() {
		/***Given***/
		Page page = new Page(1, 5);

		/***When***/
		Map<String, Object> resultMap = lprodService.getLprodPagingList(page);
		List<Lprod> lprodList = (List<Lprod>)resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");

		/***Then***/
		assertEquals(5, lprodList.size());
		assertEquals(2, paginationSize);
	}
	
	

}
