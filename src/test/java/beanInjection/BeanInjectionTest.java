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
import board.service.impl.BoardAbstractService;
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
		BoardService boardServiceSetter					= applicationContext.getBean("boardServiceSetter", BoardService.class);
		BoardService boardServiceConstructor			= applicationContext.getBean("boardServiceConstructor", BoardService.class);
		BoardAbstractService boardServiceLookupMethod	= applicationContext.getBean("boardServiceLookupMethod", BoardAbstractService.class);
		
		//when
		
		//then
		
		//setter
		assertTrue(boardServiceSetter.getBoardDao() != null);
		assertNotNull(boardServiceSetter.getBoardDao());
		
		//constructor
		assertTrue(boardServiceConstructor.getBoardDao() != null);
		assertNotNull(boardServiceConstructor.getBoardDao());
		
		//method lookup
		assertTrue(boardServiceLookupMethod.getBoardDaoLookupMethod() != null);
		assertNotNull(boardServiceLookupMethod.getBoardDaoLookupMethod());
		
		assertEquals(boardServiceSetter.getBoardDao(), boardServiceConstructor.getBoardDao());
		assertEquals(boardServiceConstructor.getBoardDao(), boardServiceLookupMethod.getBoardDaoLookupMethod());
		
		logger.debug("end injectionTest");
	}		
}