package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
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
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<UserVo> userList = userDao.getAllUser(sqlSession);
		sqlSession.close();
		return userList;
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
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserVo userVo = userDao.selectUser(sqlSession, userId);
		sqlSession.close();
		
		return userVo;
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
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("userList", userDao.selectUserPagingList(sqlSession, pageVo));
		resultMap.put("userCnt", userDao.getUserCnt(sqlSession));
		
		sqlSession.close();
		
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
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertCnt = userDao.insertUser(sqlSession, userVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
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
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deletetCnt = userDao.deleteUser(sqlSession, userId);
		
		sqlSession.commit();
		sqlSession.close();
		
		return deletetCnt;
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
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int updateCnt = userDao.updateUser(sqlSession, userVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
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
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int updateCnt = 0;
		
		//사용자 전체 정보조회
		List<UserVo> userList = userDao.getAllUser(sqlSession);
		
		//사용자 비밀번호를암호화
		for(UserVo userVo : userList){
			userVo.setPass(KISA_SHA256.encrypt(userVo.getPass()));
			updateCnt += userDao.updatePass(sqlSession, userVo);
		}
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
	}

}





