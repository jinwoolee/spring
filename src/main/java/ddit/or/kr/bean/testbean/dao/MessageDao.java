package ddit.or.kr.bean.testbean.dao;

import org.springframework.stereotype.Repository;

/**
 * component scan 테스트를 위한 messageDao
 * MessageDao.java
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

public class MessageDao {
	
	/**
	 * Method : sayHello
	 * 최초작성일 : 2017. 12. 20.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : 간단한 문자열 반환
	 */
	public String sayHello(){
		return "hello";
	}
}

