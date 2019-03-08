package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserDaoImplTest extends LogicTestConfig{
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	//@Before - @Test - @After
	
	@Before
	public void setup(){
		userDao.deleteUser("test1");
	}
	
	@After
	public void tearDown(){
	}

	/**
	 * Method : testGetAllUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 전체 사용자 조회 테스트
	 */
	@Test
	public void testGetAllUser() {
		/***Given***/
		
		/***When***/
		List<UserVo> userList = userDao.getAllUser();
		for(UserVo userVo : userList)
			System.out.println(userVo);

		/***Then***/
		assertNotNull(userList);
		assertEquals(105, userList.size());
	}
	
	/**
	 * Method : testSelectUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 조회 테스트
	 */
	@Test
	public void testSelectUser(){
		/***Given***/
		
		/***When***/
		UserVo userVo = userDao.selectUser("brown");

		/***Then***/
		assertEquals("brown", userVo.getUserId());
		assertEquals("brown1234", userVo.getPass());
	}
	
	/**
	 * Method : testSelectUserPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void testSelectUserPagingList(){
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);
		
		/***When***/
		List<UserVo> userList = userDao.selectUserPagingList(pageVo);
		for(UserVo user : userList)
			System.out.println(user);
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
	}
	
	/**
	 * Method : testGetUserCnt
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 수 조회 테스트
	 */
	@Test
	public void testGetUserCnt(){
		/***Given***/
		
		/***When***/
		int userCnt = userDao.getUserCnt();

		/***Then***/
		assertEquals(105, userCnt);
	}
	
	/**
	 * Method : testPagination
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void testPagination(){
		/***Given***/
		int userCnt = 105;
		int pageSize = 10;
		
		/***When***/
		
		int lastPage = userCnt/pageSize + (userCnt%pageSize > 0 ? 1 : 0);
		
		/***Then***/
		assertEquals(11, lastPage);
	}
	
	@Test
	public void testPagination2(){
		/***Given***/
		int userCnt = 110;
		int pageSize = 10;
		
		/***When***/
		
		int lastPage = userCnt/pageSize + (userCnt%pageSize > 0 ? 1 : 0);
		
		/***Then***/
		assertEquals(11, lastPage);
	}
	
	/**
	 * Method : testInsertUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 등록 테스트
	 */
	@Test
	public void testInsertUser(){
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("test1");
		userVo.setUserNm("테스트");
		userVo.setAlias("별명");
		userVo.setAddr1("대전 중구 대흥로 76");
		userVo.setAddr2("2층 ddit");
		userVo.setZipcode("34942");
		userVo.setPass("testpass");
		
		/***When***/
		int insertCnt = userDao.insertUser(userVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	/**
	 * Method : testUpdateUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 정보 수정 테스트
	 */
	@Test
	public void testUpdateUser(){
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("test1");
		userVo.setUserNm("테스트");
		userVo.setAlias("별명");
		userVo.setAddr1("대전 중구 대흥로 76");
		userVo.setAddr2("2층 ddit");
		userVo.setZipcode("34942");
		userVo.setPass("testpass");
		int insertCnt = userDao.insertUser(userVo);
		
		/***When***/
		userVo.setUserNm("테스트_변경");
		int updateCnt = userDao.updateUser(userVo);
		UserVo selectUser = userDao.selectUser(userVo.getUserId());
		
		/***Then***/
		assertEquals(1, insertCnt);
		assertEquals(1, updateCnt);
		assertEquals("테스트_변경", selectUser.getUserNm());
	}
	
	@Test
	public void testUpdatePass(){
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		userVo.setPass("brown1234");
		
		/***When***/
		int updateCnt = userDao.updatePass(userVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
}










