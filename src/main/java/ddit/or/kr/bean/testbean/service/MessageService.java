package ddit.or.kr.bean.testbean.service;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service;
import ddit.or.kr.bean.testbean.dao.MessageDao;



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
public class MessageService {

	private MessageDao messageDao;
	
	public String sayHello(){
		return messageDao.sayHello();
	}

	/**
	 * Method : setMessageDao
	 * 최초작성일 : 2017. 12. 20.
	 * 작성자 : sam
	 * 변경이력 :
	 * @param messageDao2
	 * Method 설명 : messageDao setter
	 */
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	public MessageDao getMessageDao() {
		return this.messageDao;
	}
}




