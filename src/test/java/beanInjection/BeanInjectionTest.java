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
		
		//when
		
		//then
		
		//setter
		assertTrue(boardServiceSetter.getBoardDao() != null);
		assertNotNull(boardServiceSetter.getBoardDao());
		
		//constructor
		assertTrue(boardServiceConstructor.getBoardDao() != null);
		assertNotNull(boardServiceConstructor.getBoardDao());
		
		logger.debug("end injectionTest");
	}
	
	//팩토리 메서드(static)에 의해 생성된 빈
	@Test
	public void factoryMethodTest() {
		//given
		BoardDao boardDao = applicationContext.getBean("boardDaoFactoryMethod", BoardDao.class);
		BoardDao boardDao2 = applicationContext.getBean("boardDaoFactoryMethod", BoardDao.class);
		
		//when

		//then
		assertEquals(boardDao, boardDao2);
	}
}