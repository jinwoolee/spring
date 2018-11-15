package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface UserServiceInf {
	List<UserVo> selectUserAll();
	
	UserVo selectUser(String userId);
	
	UserVo selectUser(UserVo userVo);

	/**
	* Method : selectUserPageList
	* 작성자 : sem
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 조회
	*/
	Map<String, Object> selectUserPageList(PageVo pageVo);

	/**
	* Method : insertUser
	* 작성자 : sem
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 입력
	*/
	int insertUser(UserVo userVo);
	
	/**
	* Method : deleteUser
	* 작성자 : sem
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :사용자 삭제
	*/
	int deleteUser(String userId);

	/**
	* Method : updateUser
	* 작성자 : sem
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보 수정
	*/
	int updateUser(UserVo userVo);
}