package kr.or.ddit.user.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.ddit.user.model.UserVo;

public class UserDetail extends User{

	private UserVo userVo;
	
	public UserDetail(UserVo userVo, Collection<? extends GrantedAuthority> authorities) {
		super(userVo.getUserid(), userVo.getPass(), authorities);
		this.userVo = userVo;
	}

	public UserVo getUserVo() {
		return userVo;
	}
	
}
