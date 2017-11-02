package annotation;

import static org.junit.Assert.*; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import annotation.board.dao.BoardDao;
import board.model.BoardVo;
import annotation.board.service.BoardService;
import annotation.board.service.impl.BoardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml"})
public class AnnotationTest {
	Logger logger = LoggerFactory.getLogger(AnnotationTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
	//service, repository에 이름 값을 설정하지 않을 경우 
	//bean 이름이 어떻게 설정되는지 확인한다.
	@Test
	public void annotationBeanTest() {
		logger.debug("start annotationBeanTest");
		
		//given
		
		//when
		
		//then
		for( String beanName : applicationContext.getBeanDefinitionNames() )
			logger.debug(beanName);
		
		logger.debug("end annotationBeanTest");
	}
	
	//boardService 객체에 @Resource설정한 boardDao객체가 DI 되었는지 확인 
	@Test
	public void annotationDITest() {
		/***Given***/
		BoardDao boardDao = applicationContext.getBean("boardDao", BoardDao.class);
				
		/***When***/

		/***Then***/
		for(BoardVo boardVo : boardDao.getBoardList(""))
			logger.debug(boardVo.toString());
		assertNotNull(boardDao);
	}
	
	//boardDao bean scope singleton 테스트 (boardDao scope 설정)
	@Test
	public void annotationSingletonTest() {
		/***Given***/
		BoardDao protoTypeBoardDaoBean1 = applicationContext.getBean("boardDao", BoardDao.class);
		BoardDao protoTypeBoardDaoBean2 = applicationContext.getBean("boardDao", BoardDao.class);
		
		/***When***/

		/***Then***/
		assertEquals(protoTypeBoardDaoBean1, protoTypeBoardDaoBean2);
	}
		
	//boardDao bean scope prototype 테스트 (boardDao scope 설정)
	//@Test
	public void annotationProtoTypeTest() {
		/***Given***/
		BoardDao protoTypeBoardDaoBean1 = applicationContext.getBean("boardDaoProto", BoardDao.class);
		BoardDao protoTypeBoardDaoBean2 = applicationContext.getBean("boardDaoProto", BoardDao.class);
		
		/***When***/

		/***Then***/
		assertNotEquals(protoTypeBoardDaoBean1, protoTypeBoardDaoBean2);
	}
}