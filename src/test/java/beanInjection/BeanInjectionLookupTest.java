
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
import board.dao.IBoardDao;
import board.service.BoardService;
import board.service.impl.BoardAbstractService;
import board.service.impl.BoardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context-lookup.xml"})
public class BeanInjectionLookupTest {
	Logger logger = LoggerFactory.getLogger(BeanInjectionLookupTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	//prototype의 boardDao객체를 singleton boardService에 주입
	@Test
	public void prototypeInjtectionToSingletonBeanTest() {
		//given
		BoardService boardService = applicationContext.getBean("boardService", BoardService.class); 
				
		//when
		IBoardDao boardDao = boardService.getBoardDao();
		IBoardDao boardDao2 = boardService.getBoardDao();
		
		//then
		//boardDao는 prototype이므로 boardService의 boardDao는 매번 새로운 boardDao를 리턴 할것 같지만
		//항상 같은 dao를 리턴한다.
		assertEquals(boardDao, boardDao2);
		assertEquals(boardDao.getDate().getTime(), boardDao2.getDate().getTime());
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
	
	
	
	//http://www.logicbig.com/tutorials/spring-framework/spring-core/scoped-proxy/
	// jdk dynamic proxy - 방식(interface ) 
	@Test
	public void jdkInterfaceProxyInectionTest() {
		//given
		BoardService boardService = applicationContext.getBean("boardServiceProxy", BoardService.class);
		
		//when
		IBoardDao boardDao = boardService.getBoardDao();
		long dateTime = boardDao.getDate().getTime();
		//시간을 두고 객체를 호출한다.
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IBoardDao boardDao2 = boardService.getBoardDao();
		long dateTime2 = boardDao2.getDate().getTime();
	
		//then
		//jdk에 의해 생성된 proxy객체는 동일하나, 그 안의 구현체는 매번 달라진다.
		assertEquals(boardDao, boardDao2);
		
		//또한 getBoardDao메소드를 통해 받은 boardDao객체라 하더라도 실행시 프록시에 전달되는 객체는 달라질 수 있다.
		for(int i = 0; i < 10; i ++)
			logger.debug("{}, {}", boardDao.getDate().getTime(), boardDao.hashCode());
		
		for(int i = 0; i < 10; i ++)
			logger.debug("{}", boardService.getDate().getTime());
		
		logger.debug("{}, {}", dateTime, dateTime2);
		assertNotEquals(dateTime, dateTime2);
	}
	
	
	//cgilib 방식의 proxy 테스트
	@Test
	public void cglibProxyInectionTest() {
		//given
		BoardService boardService = applicationContext.getBean("boardServiceProxy2", BoardService.class);
		
		IBoardDao boardDao = boardService.getBoardDao();
		IBoardDao boardDao2 = boardService.getBoardDao();
		
		//when
		for(int i = 0; i < 10; i ++)
			logger.debug("{}, {}", boardDao.getDate().getTime(), boardDao.hashCode());
		
		for(int i = 0; i < 10; i ++)
			logger.debug("{}", boardService.getDate().getTime());

		//then
		assertNotEquals(boardDao, boardDao2);
	}
}