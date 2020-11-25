package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {

	UserVo getUser(String username);

	List<String> getRoles(String username);

}
