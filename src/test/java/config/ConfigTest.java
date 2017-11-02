package config;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.board.dao.BoardDao;
import config.board.service.BoardService;
import config.board.service.impl.BoardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ConfigTest {
	Logger logger = LoggerFactory.getLogger(ConfigTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void javaConfigBeanTest() {
		logger.debug("start javaConfigBeanTest");
		
		//given
		
		//when
		
		//then
		for(String beanName : applicationContext.getBeanDefinitionNames())
			logger.debug(beanName);
		
		
		logger.debug("end javaConfigBeanTest");
	}
	
	@Test
	public void javaConfigBeanDITest() {
		logger.debug("start javaConfigBeanDITest");
		
		/***Given***/
		BoardDao		boardDao		= applicationContext.getBean("boardDao", BoardDao.class);
		BoardService	boardService	= applicationContext.getBean("boardService", BoardServiceImpl.class);
		
		/***When***/
		
		/***Then***/
		assertNotNull(boardDao);
		assertNotNull(boardService);
		assertEquals(boardDao, boardService.getBoardDao());
		logger.debug("end javaConfigBeanDITest");
	}
}