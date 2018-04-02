package ddit.or.kr.user.service;

import java.util.List;

import ddit.or.kr.user.model.UserVo;

public interface UserService {

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
	
	/**
	 * Method : insertUserException
	 * 최초작성일 : 2017. 12. 29.
	 * 작성자 : sam
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 선언전 트랜잭션 예외 발생시 롤백 확인용 메소드
	 */
	int insertUserException(UserVo userVo)  throws RuntimeException;
}







