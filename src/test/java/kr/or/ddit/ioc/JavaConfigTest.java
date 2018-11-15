package kr.or.ddit.ioc;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardServiceInf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JavaConfig.class})
public class JavaConfigTest {

	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	/**
	* Method : javaConfigBeanTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : javaconfig를 통해 스프링 빈이 정상적으로 생성 되었는지 테스트
	*/
	@Test
	public void javaConfigBeanTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(boardDao);
		assertNotNull(boardService);
	}

}






