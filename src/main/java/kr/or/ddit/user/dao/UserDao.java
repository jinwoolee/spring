package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

@Repository
public class UserDao implements UserDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	//jspuser 테이블 데이터전체 조회 쿼리
	//select query id : selectUserAll
	
	public List<UserVo> selectUserAll(){
		
		//selectOne : 데이터가 한건일때
		//selectList : 여러건의 데이터를 조회
		//메소드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디
		return template.selectList("user.selectUserAll");
	}
	
	public UserVo selectUser(String userId){
		
		//selectOne : 데이터가 한건일때
		//selectList : 여러건의 데이터를 조회
		//메소드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디
		return template.selectOne("user.selectUser", userId);
	}
	
	public UserVo selectUser(UserVo userVo){
		
		//selectOne : 데이터가 한건일때
		//selectList : 여러건의 데이터를 조회
		//메소드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디
		return template.selectOne("user.selectUserByVo", userVo);
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		return template.selectList("user.selectUserPageList", pageVo);
	}

	/**
	* Method : getUserCnt
	* 작성자 : sem
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	@Override
	public int getUserCnt() {
		return template.selectOne("user.getUserCnt");
	}

	/**
	* Method : insertUser
	* 작성자 : sem
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		return template.insert("user.insertUser", userVo);
	}

	/**
	* Method : deleteUser
	* 작성자 : sem
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :사용자 삭제
	*/
	@Override
	public int deleteUser(String userId) {
		return template.delete("user.deleteUser", userId);
	}

	/**
	* Method : updateUser
	* 작성자 : sem
	* 변경이력 :
	* @param userVo
	* Method 설명 : 사용자 정보 수정
	*/
	@Override
	public int updateUser(UserVo userVo) {
		return template.delete("user.updateUser", userVo);
	}
	
}









