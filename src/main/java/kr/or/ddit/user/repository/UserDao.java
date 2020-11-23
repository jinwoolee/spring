package kr.or.ddit.user.repository;

import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVo;

@Repository("userDao")
public class UserDao implements UserDaoI{

	@Override
	public UserVo getUser(String username) {
		return new UserVo(username, "MAKEBYMETHOD", "USERNM", "ALIAS");
	}
	
}
