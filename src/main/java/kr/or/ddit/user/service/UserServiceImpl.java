package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	public UserServiceImpl(){
	}
	

	/**
	 * Method : getAllUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 정보 조회
	 */
	@Override
	public List<UserVo> getAllUser() {
		return userDao.getAllUser();
	}


	/**
	 * Method : selectUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 조회
	 */
	@Override
	public UserVo selectUser(String userId) {
		return userDao.selectUser(userId);
	}


	/**
	 * Method : selectUserPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> selectUserPagingList(PageVo pageVo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("userList", userDao.selectUserPagingList(pageVo));
		resultMap.put("userCnt", userDao.getUserCnt());
		
		return resultMap;
	}


	/**
	 * Method : insertUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}


	/**
	 * Method : deleteUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param userId
	 * Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}


	/**
	 * Method : updateUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 정보 수정
	 */
	@Override
	public int updateUser(UserVo userVo) {
		return userDao.updateUser(userVo);
	}


	/**
	 * Method : encryptPass
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 비밀번호 일괄 암호화 적용
	 */
	@Override
	public int encryptPass() {
		
		int updateCnt = 0;
		
		//사용자 전체 정보조회
		List<UserVo> userList = userDao.getAllUser();
		
		//사용자 비밀번호를암호화
		for(UserVo userVo : userList){
			userVo.setPass(KISA_SHA256.encrypt(userVo.getPass()));
			updateCnt += userDao.updatePass(userVo);
		}
		return updateCnt;
	}

}





