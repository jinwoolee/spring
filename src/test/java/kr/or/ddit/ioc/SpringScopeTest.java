package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context.xml"})
public class SpringScopeTest {

	//DI
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardDaoSingleton")
	private BoardDaoInf boardDaoSingleton;
	
	@Resource(name="boardDaoSingleton")
	private BoardDaoInf boardDaoSingleton2;
	
	/**
	* Method : springBeanScopeSingletonTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 스프링의 scope singleton 테스트
	*/
	@Test
	public void springBeanScopeSingletonTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotEquals(boardDao, boardDaoSingleton);
		assertEquals(boardDaoSingleton, boardDaoSingleton2);
	}

}









