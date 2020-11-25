package kr.or.ddit.user.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDaoI;
import kr.or.ddit.user.security.model.UserDetail;

@Component("userService")
public class UserService implements UserDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Resource(name="userDao")
	private UserDaoI userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.debug("loadUserByUsername");
		
		//사용자 정보 조회
		UserVo userVo = userDao.getUser(username);
		
		//사용자 권한 조회
		List<String> roleList = userDao.getRoles(username);
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for(String role : roleList) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		
		UserDetail userDetail = new UserDetail(userVo, roles);
		
		return userDetail;
	}

}
