package ddit.or.kr.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ddit.or.kr.user.dao.UserDao;
import ddit.or.kr.user.model.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<UserVo> userListAll() {
		return userDao.userListAll();
	}

	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	/**
	 * Method : insertUserException
	 * 최초작성일 : 2017. 12. 29.
	 * 작성자 : sam
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * @throws RuntimeException
	 * Method 설명 : 사용자 입력후 강제로 RuntimeException 발생. 롤백이 이루어지는지 확인 
	 */
	@Override
	public int insertUserException(UserVo userVo) throws RuntimeException{
		int insertCnt = userDao.insertUser(userVo);
		
		if(true)
			throw new RuntimeException();
		
		insertCnt += userDao.insertUser(userVo);
		
		return insertCnt;
	}

}





