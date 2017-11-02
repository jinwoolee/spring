package configComponentScan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import configComponentScan.board.dao.BoardDao;
import configComponentScan.board.service.BoardService;
import configComponentScan.board.service.impl.BoardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ConfigComponentScanTest {
	Logger logger = LoggerFactory.getLogger(ConfigComponentScanTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void javaConfigComponentScanBeanTest() {
		logger.debug("start javaConfigComponentScanBeanTest");
				
		//given
		
		//when
		
		//then
		for(String beanName : applicationContext.getBeanDefinitionNames())
			logger.debug(beanName);
		
		logger.debug("end javaConfigComponentScanBeanTest");
	}
	
	@Test
	public void javaConfigComponentScanBeanDITest() {
		logger.debug("start javaConfigComponentScanBeanDITest");
		
		/***Given***/
		BoardDao		boardDao		= applicationContext.getBean("boardDao", BoardDao.class);
		BoardService	boardService	= applicationContext.getBean("boardService", BoardServiceImpl.class);
		
		/***When***/
		
		/***Then***/
		assertNotNull(boardDao);
		assertNotNull(boardService);
		assertEquals(boardDao, boardService.getBoardDao());
		logger.debug("end javaConfigComponentScanBeanDITest");
	}
	
	@Test
	public void javaConfigPropertyTest() {
		/***Given***/
		Environment env = applicationContext.getEnvironment();
		
		/***When***/

		/***Then***/
		logger.debug("property jdbc.driver : " + env.getProperty("jdbc.driver"));
		assertEquals("oracle.jdbc.driver.OracleDeriver", env.getProperty("jdbc.driver"));
	}
}