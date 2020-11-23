package kr.or.ddit.user.repository;

import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {

	UserVo getUser(String username);

}
