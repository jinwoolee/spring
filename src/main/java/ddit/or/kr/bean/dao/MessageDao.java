package ddit.or.kr.bean.dao;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 메세지 dao 구현체
 * @author sam
 *
 */
public class MessageDao implements IMessageDao {
	private Logger logger = LoggerFactory.getLogger(MessageDao.class);
	private Date date = new Date();
	
	public static IMessageDao getInstance(){
		return new MessageDao();
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
		String msg = "sayHello";
		
		//System.out.println : 더이상 사용하지 않는다. --> 시스템에 성능상 부담이 된다.
		//log 라이브러리를 사용하는 이유 : 개발의 편의성, 운영시 로그 출력부분을 설정을 통해 제어
		logger.debug("{}, {}", msg, "22"); //-->운영환경에서는 로그 레벨을 높혀 debug 레벨은 출력되지 않도록한다
		
		return msg;
	}

	/**
	 * Method : getDate
	 * 최초작성일 : 2017. 12. 19.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : 객체 생성시의 date 객체 반환
	 */
	@Override
	public Date getDate() {
		return date;
	}
}



