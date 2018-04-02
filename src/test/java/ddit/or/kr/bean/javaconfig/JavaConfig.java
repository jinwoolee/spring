package ddit.or.kr.bean.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ddit.or.kr.bean.testbean.dao.MessageDao;
import ddit.or.kr.bean.testbean.service.MessageService;

/**
 * 스프링 컨테이너 설정 객체
 * JavaConfig.java
 *
 * @author sam
 * @since 2017. 12. 20.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2017. 12. 20. sam 최초 생성
 *
 * </pre>
 */
//java파을을 통해 spring 컨테이너 구성을 위한 annotation
@Configuration
public class JavaConfig {
	
	//xml messageDao bean 선언 : <bean id=""/>
	//component scan : @Repository, @Service
	//java 메소드에 @Bean 어노테이션 적용
	
	//messageDao bean 선언
	// <bean id="이름" class="패키지.해당구현체" scope="prototype" /
	@Bean(name="messageDao")
	public MessageDao getMessageDao(){
		return new MessageDao();
	}
	
	//messageService
	@Bean(name="messageService")
	public MessageService getMessageService(){
		MessageService messageService = new MessageService();
		messageService.setMessageDao(getMessageDao());
		return messageService;
	}
	
	//messageDao bean prototype 선언
	@Bean(name="messageDaoPrototype")
	@Scope(value="prototype")
	public MessageDao getMessageDaoPrototype(){
		return new MessageDao();
	}
}










