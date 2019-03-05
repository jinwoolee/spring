package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LprodDaoImplTest extends LogicTestConfig{

	@Resource(name="lprodDao")
	private ILprodDao lprodDao;
	
	private SqlSession sqlSession;
	
	@Before
	public void setup(){
		sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	}
	
	@After
	public void tearDown(){
		sqlSession.close();
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
		List<LprodVo> lprodList = lprodDao.getAllLprod(sqlSession);

		/***Then***/
		assertTrue(lprodList.size() > 0);
	}
	
	/**
	 * Method : testSelectLprodPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 제품 카테고리 페이징 조회 테스트
	 */
	@Test
	public void testSelectLprodPagingList(){
		/***Given***/
		PageVo pageVo = new PageVo(1, 5);
		
		/***When***/
		List<LprodVo> lprodList = lprodDao.selectLprodPagingList(sqlSession, pageVo);

		/***Then***/
		assertEquals(5, lprodList.size());
	}
	
	@Test
	public void testGetLprodCnt(){
		/***Given***/
		
		/***When***/
		int totalCnt = lprodDao.getLprodCnt(sqlSession);

		/***Then***/
		assertEquals(19, totalCnt);
	}

}
