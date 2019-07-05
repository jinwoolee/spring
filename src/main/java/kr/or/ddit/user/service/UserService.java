package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.model.UserVo;

@Transactional
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
		//insertCnt += userDao.insertUser(userVo);
		
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

	/** 
	 * Method   : getUser
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param userId
	 * @return 
	 * Method 설명 : 사용자 정보 조회 
	 */
	@Override
	public UserVo getUser(String userId) {
		return userDao.getUser(userId);
	}

	/** 
	 * Method   : userPagingList
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param pageVo
	 * @return 
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userDao.userPagingList(pageVo));

		int usersCnt = userDao.usersCnt();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		return resultMap;
	}

	/** 
	 * Method   : updateUser
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param userVo
	 * @return 
	 * Method 설명 : 사용자 수정 
	 */
	@Override
	public int updateUser(UserVo userVo) {
		return userDao.updateUser(userVo);
	}

	/** 
	 * Method   : encryptPassAllUser
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	 * 			   : 재적용 하질 말것 !!!!!	  
	 */
	@Override
	public int encryptPassAllUser() {
		//사용하지 마세요!!! 이미 암호화 적용 되었습니다
				if( 1 == 1)
					return 0;
				
				//1.모든 사용자 정보를 조회 (단, 기존 암호화 적용 사용자 제외, brown, userTest)
				List<UserVo> userList = userDao.userListForPassEncrypt();
				
				//2.조회된 사용자의 비밀번호를 암호화 적용후 사용자 업데이트
				int updateCntSum = 0;
				for(UserVo userVo : userList){
					String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
					userVo.setPass(encryptPass);
					
					int updateCnt = userDao.updateUserEncryptPass(userVo);
					updateCntSum += updateCnt;
				}
				//3.sqlSession 객체를 commit, close
				
				return updateCntSum;		
	}

}









