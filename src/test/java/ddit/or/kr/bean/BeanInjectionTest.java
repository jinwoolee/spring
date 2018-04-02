package ddit.or.kr.bean;

import static org.junit.Assert.*; 

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ddit.or.kr.bean.dao.IMessageDao;
import ddit.or.kr.bean.service.IMessageService;
import ddit.or.kr.bean.service.MessageService;

public class BeanInjectionTest {
	Logger logger = LoggerFactory.getLogger(BeanInjectionTest.class);
	
	//설명서를 바탕으로 IOC 컨테이너(spring 컨테이너)를 만든다.
	private final ApplicationContext context = 
		new ClassPathXmlApplicationContext("ddit/or/kr/bean/application-context.xml");

	//스프링 컨테이너의 singleton 확인 
	@Test
	public void springSingletonTest() {
		/***Given***/
		
		/***When***/
		//messageDao 라고 하는 bean 요청
		IMessageDao messageDao = context.getBean("messageDao", IMessageDao.class);
		
		//messageDao 라고 하는 bean 요청
		IMessageDao messageDao2 = context.getBean("messageDao", IMessageDao.class);

		/***Then***/
		//스프링에서는 bean id혹은 name이 같으면 같은 객체로 인식을합니다. 
		assertSame(messageDao, messageDao2);
	}
	
	//스프링 컨테이너의 singlteon과 디자인 패턴의 singleton의 차이 테스트
	@Test
	public void springSingtonTest2(){
		/***Given***/
		
		/***When***/
		IMessageDao messageDao = context.getBean("messageDao", IMessageDao.class);
		IMessageDao messageDaoClone = context.getBean("messageDaoClone", IMessageDao.class);

		/***Then***/
		//스프링 bean 설정의 id, name 별로 싱글턴 객체가 구성됨을 확인
		assertNotSame(messageDao, messageDaoClone);
	}
	
	//속성을 통한 빈주입 테스트
	@Test
	public void setterInectionTest(){
		/***Given***/
		
		/***When***/
		//messgeService 객체에 dao객체가 정상적으로 설정되었는지 테스트
		IMessageService messageService = context.getBean("messageService", IMessageService.class);

		/***Then***/
		assertEquals("sayHello", messageService.sayHello(""));
	}
	
	//생성자를 통한 빈주입 테스트
	@Test
	public void constructBeanInjectionTest(){
		/***Given***/
		
		/***When***/
		//messgeService 객체에 dao객체가 정상적으로 설정되었는지 테스트
		IMessageService messageService = context.getBean("messageServiceConstruct", IMessageService.class);

		/***Then***/
		assertEquals("sayHello", messageService.sayHello(""));
	}
	
	//factory method로 생성한 스프링 singleton 객체의 동일 객체테스트
	//스프링 messageDaoFactory bean을 서로 다른 참조객체로 두번 호출하여 두개의 객체가 같은 객체인지 테스트 코드 작성
	@Test
	public void factoryMethodTest(){
		/***Given***/
		

		/***When***/
		IMessageDao messageDaoFactory1 = context.getBean("messageDaoFactory", IMessageDao.class);
		
		IMessageDao messageDaoFactory2 = context.getBean("messageDaoFactory", IMessageDao.class);

		/***Then***/
		assertSame(messageDaoFactory1, messageDaoFactory2);
	}
	
	//bean scope : prototype
	//bean을 선언(scope="prototype") : messageDaoPrototype
	//messageDaoPrototype 빈을 두번 호출해서, 두개의 객체 같을까요?
	@Test
	public void prototypeTest(){
		/***Given***/

		/***When***/
		IMessageDao messageDaoPrototype1 = context.getBean("messageDaoPrototype", IMessageDao.class);
		IMessageDao messageDaoPrototype2 = context.getBean("messageDaoPrototype", IMessageDao.class);
		
		/***Then***/
		assertNotSame(messageDaoPrototype1, messageDaoPrototype2);
	}
	
	//singleton bean에 prototype의 bean을 주입한 경우
	//(messageService(signlteton)에 messageDao(prototype)
	//prototype bean은 singlton bean 안에서 정상적으로 prototype 속성을 유지하는지 확인하는 테스트
	@Test
	public void scopeTest(){
		/***Given***/
		
		/***When***/
		MessageService service = context.getBean("messageServiceProto", MessageService.class);
		IMessageDao dao		=	service.getMessageDao();
		IMessageDao dao2	=	service.getMessageDao();
		
		/***Then***/
		//dao객체가 prototype scope 이라고 해도 
		//service 객체가 singleton 객체이면 prototype 속성이 적용되지 않는다.
		//assertNotSame(dao, dao2);
		assertSame(dao, dao2);
	}
	
	//dao객체를 aop 기능을 이용하여 proxy로 선언
	@Test
	public void scopeProxyTest(){
		/***Given***/
		
		/***When***/
		MessageService service = context.getBean("messageServiceProxy", MessageService.class);
		IMessageDao dao		=	service.getMessageDao();
		IMessageDao dao2	=	service.getMessageDao();
		
		IMessageDao messageDao = context.getBean("messageDao", IMessageDao.class);
		
		/***Then***/
		//디버깅시 dao, dao2는 proxy객체라는걸 확인할 수 있다. (비교군 : messageDao)
		//proxy객체는 동일하고, 실제 delegate되는 개체가 다르기 때문에
		//proxy 객체 자체는 동일한 객체로 판단됨
		//assertNotSame(dao, dao2);
		assertSame(dao, dao2);
	}
	
	//dao객체를 aop 기능을 이용하여 proxy로 선언
	@Test
	public void scopeProxy2Test(){
		/***Given***/
		
		/***When***/
		MessageService service = context.getBean("messageServiceProxy", MessageService.class);
		IMessageDao dao = service.getMessageDao();
		Date daoDate = dao.getDate();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IMessageDao dao2 = service.getMessageDao();
		Date daoDate2 = dao2.getDate();
		
		logger.debug("daoDate : {}, {} " ,daoDate.toString(), daoDate.getTime());
		logger.debug("daoDate2 : {}, {} " ,daoDate2.toString(), daoDate2.getTime());
		
		/***Then***/
		//assertNotEquals(daoDate.toString(), daoDate2.toString());
		assertNotEquals(daoDate.getTime(), daoDate2.getTime());
	}
}








