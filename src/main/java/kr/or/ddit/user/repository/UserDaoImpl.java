package kr.or.ddit.user.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

// <bean id="" class=""
// @Repository에서 별다른 설정을 하지 않으면 스프링 빈 이름으로 class 이름에서 첫글자를 소문자로 한
// 문자열이 스프링 빈의 이름으로 설정된다
// UserDaoImpl ==> userDaoImpl

//  UserDao  / UserDaoImpl ==> @Resource(name="userDaoImpl")
//  UserDaoI / UserDao     ==> @Resource(name="userDao")

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public UserVo selectUser(String userid) {
		return template.selectOne("users.selectUser", userid);
	}

	@Override
	public List<UserVo> selectAllUser() {
		return template.selectList("users.selectAllUser");
	}

	@Override
	public List<UserVo> selectPagingUser(PageVo pageVo) {
		return template.selectList("users.selectPagingUser", pageVo);
	}

	@Override
	public int selectAllUserCnt() {
		return template.selectOne("users.selectAllUserCnt");
	}

	@Override
	public int modifyUser(UserVo userVo) {
		return template.update("users.modifyUser", userVo);
	}

	@Override
	public int registUser(UserVo userVo) {
		return template.insert("users.registUser", userVo);
	}

	@Override
	public int deleteUser(String userid) {
		return template.delete("users.deleteUser", userid);
	}

}
