package ddit.or.kr.bean.scan.service;

import javax.annotation.Resource;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import ddit.or.kr.bean.scan.dao.MessageDao;



/**
 * component scan 테스트를 위한 messageService
 * MessageService.java
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
//@Controller, @Service, @Repository
@Service("messageService")	// xml : <bean id="messageService" />
public class MessageService {

	//빈 주입
	@Resource(name="messageDao")	//<property name="messageDao" ref="messageDao"/>
	private MessageDao messageDao;
	
	public String sayHello(){
		return messageDao.sayHello();
	}
}




