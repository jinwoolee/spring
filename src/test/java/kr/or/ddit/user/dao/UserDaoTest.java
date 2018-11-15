package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest extends ServiceDaoTestConfig{
	
	@Resource(name="userDao")
	private UserDaoInf userDao;
	
	private final String TEST_USER_ID = "testUserId2";
	
	@Before
	public void setup(){
		 userDao.deleteUser(TEST_USER_ID);
	}
	
	//운영 메소드이름 + Test
	@Test
	public void selectUserAllTest() {
		/***Given***/

		/***When***/
		List<UserVo> userList = userDao.selectUserAll();
		System.out.println(userList);

		/***Then***/
		assertEquals(114, userList.size());
	}
	
	@Test
	public void selectUserTest() {
		/***Given***/

		/***When***/
		UserVo userVo = userDao.selectUser("brown");
		System.out.println(userVo);

		/***Then***/
		assertNotNull(userVo);
		assertEquals("브라운3", userVo.getName());
		assertEquals("brown", userVo.getUserId());
	}
	
	@Test
	public void selectUserByVoTest() {
		/***Given***/

		/***When***/
		//parameter, result
		UserVo userVo = userDao.selectUser("brown");
		System.out.println(userVo);

		/***Then***/
		assertNotNull(userVo);
		assertEquals("브라운3", userVo.getName());
		assertEquals("brown", userVo.getUserId());
	}
	
	@Test
	public void selectUserPageListTest(){
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);

		/***When***/
		List<UserVo> userList = userDao.selectUserPageList(pageVo);

		/***Then***/
		assertEquals(10, userList.size());
	}
	
	/**
	* Method : getUserCntTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 사용자 전체 건수 조회 테스트
	*/
	@Test
	public void getUserCntTest(){
		/***Given***/
		
		/***When***/
		int totalUserCnt = userDao.getUserCnt();

		/***Then***/
		assertEquals(114, totalUserCnt);
	}
	
	@Test
	public void insertUserTest(){
		/***Given***/
		//userVo 준비
		UserVo userVo = new UserVo();
		userVo.setUserId(TEST_USER_ID);
		userVo.setPass("pass1234");
		userVo.setName("testUserId");
		userVo.setAddr1("대전 중구 중앙로 76");
		userVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		userVo.setZipcd("34940");
		
		GregorianCalendar gc = new GregorianCalendar(2018, 7, 8);
		userVo.setBirth(new Date(gc.getTimeInMillis()));
		
		userVo.setEmail("newUser@gmail.com");
		userVo.setTel("0422228202");
		//userVo.setProfile("/path/sally.png");

		/***When***/
		int insertCnt = userDao.insertUser(userVo);

		/***Then***/
		//입력건수 비교
		assertEquals(1, insertCnt);
	}
	
	/**
	* Method : updateUserTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 사용자 정보 수정 테스트
	*/
	@Test
	public void updateUserTest(){
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId(TEST_USER_ID);
		userVo.setPass("pass1234");
		userVo.setName("testUserId");
		userVo.setAddr1("대전 중구 중앙로 76");
		userVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		userVo.setZipcd("34940");
		userVo.setProfile("");
		
		GregorianCalendar gc = new GregorianCalendar(2018, 7, 8);
		userVo.setBirth(new Date(gc.getTimeInMillis()));
		
		userVo.setEmail("newUser@gmail.com");
		userVo.setTel("0422228202");
		userDao.insertUser(userVo);

		/***When***/
		userVo.setName("testUserId_up");
		userDao.updateUser(userVo);
		
		UserVo selectedUserVo = userDao.selectUser(TEST_USER_ID);

		/***Then***/
		assertEquals("testUserId_up", selectedUserVo.getName());

	}
}












