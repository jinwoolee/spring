
package ddit.or.kr.bean.service;

import ddit.or.kr.bean.dao.IMessageDao;

/**
 * 메세지 서비스 구현체
 * @author sam
 *
 */
public class MessageService implements IMessageService {
	
	private IMessageDao messageDao;		//messageDao
	
	public MessageService(){
	}
	
	/**
	 * @param messageDao
	 */
	public MessageService(IMessageDao messageDao){
		this.messageDao = messageDao;
	}
	
	//객체 조립설명서(application-context.xml) 설정한대로 mesageDao를 주입한다.
	
	/**
	 * Method : setMessageDao
	 * 최초작성일 : 2017. 12. 19.
	 * 작성자 : sam
	 * 변경이력 :
	 * @param messageDao
	 * Method 설명 : messageDao setter
	 */
	public void setMessageDao(IMessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	public IMessageDao getMessageDao() {
		return messageDao;
	}
	

	/**
	 * Method : sayHello
	 * 최초작성일 : 2017. 12. 19.
	 * 작성자 : sam
	 * 변경이력 :
	 * @param locale
	 * @return
	 * Method 설명 : 인사말 출력
	 */
	@Override
	public String sayHello(String locale) {
		return messageDao.sayHello(locale);
	}
		
}






