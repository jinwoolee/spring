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
@ContextConfiguration(locations={"application-context-lookup.xml"})
public class BeanInjectionLookupTest {
	Logger logger = LoggerFactory.getLogger(BeanInjectionLookupTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void prototypeInjtectionToSingletonBeanTest() {
		//given
		BoardService boardService = applicationContext.getBean("boardService", BoardService.class); 
				
		//when
		BoardDao boardDao = boardService.getBoardDao();
		BoardDao boardDao2 = boardService.getBoardDao();
		
		//then
		assertNotEquals(boardDao, boardDao2);
	}
	
	@Test
	public void lookupInjectionTest() {
		logger.debug("start injectionTest");
		
		//given
		BoardAbstractService boardServiceLookupMethod	= applicationContext.getBean("boardServiceLookupMethod", BoardAbstractService.class);
		BoardAbstractService boardServiceLookupMethod2	= applicationContext.getBean("boardServiceLookupMethod", BoardAbstractService.class);
		
		//when
		
		//then
		assertNotEquals(boardServiceLookupMethod.getBoardDaoLookupMethod(), boardServiceLookupMethod.getBoardDaoLookupMethod());
		assertNotEquals(boardServiceLookupMethod.getBoardDaoLookupMethod(), boardServiceLookupMethod2.getBoardDaoLookupMethod());
		
		logger.debug("end injectionTest");
	}
	
	@Test
	public void proxyInectionTest() {
		//given
		BoardService boardService = applicationContext.getBean("boardServiceProxyInjection", BoardService.class) ;
		//여기서부터
		//when

		//then
	}
}