package ddit.or.kr.bean.scan;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.or.kr.bean.scan.dao.MessageDao;
import ddit.or.kr.bean.scan.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/bean/scan/application-context.xml"})
public class ComponentScanTest {
	
	//기존 : xml에서 빈 선언
	//변경 : xml에서 component-scan
	//ddit.or.kr.bean.scan 패지키에 MessageDao class, MessageService class를 빈으로 등록
	
	@Resource(name="messageService")	
	private MessageService messageService;
	
	//빈 주입
	@Resource(name="messageDao")	
	private MessageDao messageDao;
	
	//xml component scan 설정이 정상적으로 이루어졌는지 테스트
	//테스트 방법 : 스프링컨테이너에서 주입받은 객체(messageService, messageDao)가 
	//			정상적으로 생성되었는지(null이 아닌지) 체크하고
	//			messageService.sayHello() 메소드를 통해 예상되는 결과값을 비교하여 
	//			스프링 빈이 component scan을 통해 정상적으로 생성되고, 관리되는지를 확인
	@Test
	public void componentScanTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(messageService);
		assertNotNull(messageDao);
		assertEquals("hello", messageService.sayHello());
	}

}




