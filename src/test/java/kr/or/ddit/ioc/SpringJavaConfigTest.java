package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ranger.dao.IRangerDao;
import kr.or.ddit.ranger.service.IRangerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringJavaConfig.class})
public class SpringJavaConfigTest {
	private Logger logger = LoggerFactory.getLogger(SpringJavaConfigTest.class);
	
	//@Autowired
	@Resource(name="getRangerDao")
	private IRangerDao rangerDao;
	
	@Resource(name="rangerService")
	private IRangerService rangerService;
	
	@Test
	public void testRangerDao() {
		/***Given***/
		
		/***When***/
		logger.debug("rangers : {}", rangerDao.getRangers());

		/***Then***/
		assertNotNull(rangerDao);
	}
	
	@Test
	public void testRangerService() {
		/***Given***/
		
		/***When***/
		logger.debug("rangers : {}", rangerService.getRangers());

		/***Then***/
		assertNotNull(rangerService);
	}
	
	/**
	 * Method : testRangerDaoEquals
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : rangerSerivce 스프링 빈에 주입된 rangerDao 객체가
	 *              ragerDao 스프링 빈과 일치하는지 테스트
	 */
	@Test
	public void testRangerDaoEquals() {
		/***Given***/
		
		/***When***/
		IRangerDao rangerServiceDao = rangerService.getRangerDao();

		/***Then***/
		assertEquals(rangerDao, rangerServiceDao);
	}
}














