package kr.or.ddit.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.model.UserVo;

@Service
public class UserService implements IuserService{
	
	@Resource(name="userDao")
	private IuserDao userDao;

	/** 
	 * Method   : userList
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 전체 사용자 리스트 조회 
	 */
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}

	/** 
	 * Method   : insertUser
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param userVo
	 * @return 
	 * Method 설명 : 사용자 입력
	 */
	@Override
	public int insertUser(UserVo userVo) {
		int insertCnt = 0;
		//정상적으로 입력
		insertCnt += userDao.insertUser(userVo);
		
		//동일한데이터를 재입력 했으니까 => ORA-00001 (unique constraint)
		insertCnt += userDao.insertUser(userVo);
		
		//첫번째 useDao.insertUser(userVo)에서 입력된 데이터도 rollback이 되어 있어야 한다
		return insertCnt;
	}

	/** 
	 * Method   : deleteUser
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param userId 
	 * Method 설명 : 사용자 삭제 
	 */
	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

}





