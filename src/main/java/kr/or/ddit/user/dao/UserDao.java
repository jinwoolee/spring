package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

@Repository
public class UserDao implements IuserDao{
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;

	/** 
	 * Method   : userList
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 사용자 전체 리스트 조회 
	 */
	@Override
	public List<UserVo> userList() {
		return sqlSession.selectList("user.userList");
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
		return sqlSession.insert("user.insertUser", userVo);
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
		return sqlSession.delete("user.deleteUser", userId);
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
		return sqlSession.selectOne("user.getUser", userId);
	}

	/** 
	 * Method   : updateUser
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param userVo
	 * @return 
	 * Method 설명 : 사용자 정보 수정
	 */
	@Override
	public int updateUser(UserVo userVo) {
		return sqlSession.update("user.updateUser", userVo);
	}

	/** 
	 * Method   : usersCnt
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 사용자 전체수 조회
	 */
	@Override
	public int usersCnt() {
		return sqlSession.selectOne("user.usersCnt");
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
	public List<UserVo> userPagingList(PageVo pageVo) {
		return sqlSession.selectList("user.userPagingList", pageVo);
	}
	
	@Override
	public List<UserVo> userListForPassEncrypt() {
		return sqlSession.selectList("user.userListForPassEncrypt");
	}

	@Override
	public int updateUserEncryptPass(UserVo userVo) {
		return sqlSession.update("user.updateUserEncryptPass", userVo);
	}
	
		
}





