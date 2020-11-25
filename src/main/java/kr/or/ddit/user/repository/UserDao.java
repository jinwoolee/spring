package kr.or.ddit.user.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVo;

@Repository("userDao")
public class UserDao implements UserDaoI{

	@Override
	public UserVo getUser(String username) {
		if(username.equals("brown"))
			return new UserVo(username, "12345", "USERNM", "ALIAS");
		else
			return null;
	}

	@Override
	public List<String> getRoles(String username) {
		List<String> roleList = new ArrayList<String>();
		roleList.add("ROLE_ADMIN");
		roleList.add("ROLE_USER");
		
		if(username.equals("brown"))
			return roleList;
		else
			return null;
	}
	
}
