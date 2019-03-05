package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.test.LogicTestConfig;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class ProdDaoImplTest extends LogicTestConfig{
	
	@Resource(name="prodDao")
	private IProdDao prodDao;
	
	private SqlSession sqlSession;
	
	@Before
	public void setup(){
		sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	}
	
	@Test
	public void testGetProdByLgu(){
		/***Given***/
		String lgu = "P101";
		
		/***When***/
		List<ProdVo> prodList = prodDao.getProdByLgu(sqlSession, lgu);

		/***Then***/
		assertTrue(prodList.size() > 0);

	}

}
