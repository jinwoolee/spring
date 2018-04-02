package ddit.or.kr.bean.javaconfig;

import static org.junit.Assert.*; 

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.or.kr.bean.testbean.dao.MessageDao;
import ddit.or.kr.bean.testbean.service.MessageService;

//스프링 컨테이너 생성
@ContextConfiguration(classes={JavaConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class JavaConfigTest {

	@Resource(name="messageService")	
	private MessageService messageService;
	
	
	//빈 주입
	// <bean id="이름" class="패키지.해당구현체" scope="prototype" />
	//MessageDao messageDao = context.getBean("messageDao", MessageDao.class);
	@Resource(name="messageDao")
	private MessageDao messageDao;
	
	@Resource(name="messageDao")
	private MessageDao messageDao1;
	
	@Resource(name="messageDao")
	private MessageDao messageDao2;
	
	@Resource(name="messageDaoPrototype")
	private MessageDao messageDao3;
	
	@Resource(name="messageDaoPrototype")
	private MessageDao messageDao4;
	
	//java 구성으로 스프링 빈이 정상적으로 구성되었는지 테스트
	//java config에서 구성한 빈 : messageService, messageDao의 null 여부를 체크함으로써
	//스프링 컨테이너가 정상적으로 구성되었는지 확인 할수 있다.
	@Test
	public void javaConfigTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotNull(messageService);
		assertNotNull(messageDao);
		assertEquals("hello", messageService.sayHello());
	}
	
	//java config scope test
	//messageDao : default, singleton
	//messageDaoPrototype : prototype
	
	@Test
	public void javaconfigScopeTest(){
		/***Given***/

		/***When***/

		/***Then***/
		assertSame(messageDao1, messageDao2);//singleton 비교
		assertNotSame(messageDao3, messageDao4);//prototype 비교
	}

}






