package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.board.service.IboardService;

public class SpringIocTest {

	/** 
	 * Method   : springIocTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 스프링 컨테이너 생성 테스트
	 */
	@Test
	public void springIocTest() {
		/***Given***/
		//스프링 컨테이너 생성
		ApplicationContext context =
			new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-ioc-test.xml");

		/***When***/
		IboardService boardService = (IboardService)context.getBean("boardService");
		String msg = boardService.sayHello();

		/***Then***/
		assertNotNull(boardService);
		assertEquals("boardDao sayHello", msg);

	}

}








