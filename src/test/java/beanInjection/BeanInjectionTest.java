package beanInjection;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import board.dao.BoardDao;
import board.service.BoardService;
import board.service.impl.BoardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml"})
public class BeanInjectionTest {
	Logger logger = LoggerFactory.getLogger(BeanInjectionTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void injectionTest() {
		logger.debug("start injectionTest");
		
		//given
		BoardService boardServiceSetter				= applicationContext.getBean("boardServiceSetter", BoardServiceImpl.class);
		BoardService boardServiceConstructor		= applicationContext.getBean("boardServiceConstructor", BoardServiceImpl.class);
		BoardService boardServiceMethodInjection	= applicationContext.getBean("boardServiceMethodInjection", BoardServiceImpl.class);
		
		//when
		
		//then
		
		//setter
		assertTrue(boardServiceSetter.getBoardDao() != null);
		assertNotNull(boardServiceSetter.getBoardDao());
		
		//constructor
		assertTrue(boardServiceConstructor.getBoardDao() != null);
		assertNotNull(boardServiceConstructor.getBoardDao());
		
		//method injection
		assertTrue(boardServiceMethodInjection.getBoardDao() != null);
		assertNotNull(boardServiceMethodInjection.getBoardDao());
		
		assertEquals(boardServiceSetter.getBoardDao(), boardServiceConstructor.getBoardDao());
		assertEquals(boardServiceConstructor.getBoardDao(), boardServiceMethodInjection.getBoardDao());
		
		logger.debug("end injectionTest");
	}		
}