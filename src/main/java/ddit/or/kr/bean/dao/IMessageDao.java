package ddit.or.kr.bean.dao;

import java.util.Date;

/**
 * 메세지 dao 인터페이스
 * @author sam
 *
 */
public interface IMessageDao {
	
	/*sayHello : 인사말을 리턴한다.
	 */
	public String sayHello(String locale);

	/**
	 * Method : getDate
	 * 최초작성일 : 2017. 12. 19.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : 객체 생성시의 date 객체를 리턴
	 */
	public Date getDate();
}



