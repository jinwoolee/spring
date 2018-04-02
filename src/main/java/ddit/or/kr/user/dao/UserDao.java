package ddit.or.kr.user.dao;

import java.util.List;

import ddit.or.kr.user.model.UserVo;

/**
 * user dao interface
 * UserDao.java
 *
 * @author sam
 * @since 2017. 12. 29.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2017. 12. 29. sam 최초 생성
 *
 * </pre>
 */
public interface UserDao {
	
	List<UserVo> userListAll();

	/**
	 * Method : insertUser
	 * 최초작성일 : 2017. 12. 29.
	 * 작성자 : sam
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 추가
	 */
	int insertUser(UserVo userVo);
}







