package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface IUserService {

	/**
	 * Method : getAllUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 정보 조회
	 */
	List<UserVo> getAllUser();

	/**
	 * Method : selectUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param string
	 * @return
	 * Method 설명 : 사용자 조회
	 */
	UserVo selectUser(String string);

	/**
	 * Method : selectUserPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	Map<String, Object> selectUserPagingList(PageVo pageVo);

	/**
	 * Method : insertUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	int insertUser(UserVo userVo);

	/**
	 * Method : deleteUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param string
	 * Method 설명 : 사용자 삭제
	 */
	int deleteUser(String userId);

	/**
	 * Method : updateUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 정보 수정
	 */
	int updateUser(UserVo userVo);

	/**
	 * Method : encryptPass
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 비밀번호 일괄 암호화 적용
	 */
	int encryptPass();

}







