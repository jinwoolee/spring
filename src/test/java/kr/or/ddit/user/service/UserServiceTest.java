package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserServiceTest extends ServiceDaoTestConfig{
	private final String TEST_USER_ID = "testUserId2";
	
	//junit 실행주기
	//@BeforeClass 어노테이션이 적용된 메소드 실행(최초 1회)
	//@Before 어노테이션이 적용된 메소드 실행(테스트 메소드 실행전 실행), 단 static 메소드로 선언
	//@Test
	//@After 어노테이션이 적용된 메소드 실행(테스트 메소드 실행후 실행)
	//@AfterClass 어노테이션이 적용된 메소드 실행(최초 1회), 단 static 메소드로 선언
	
	//beforeClass 
	//before --> selectUserAll --> after 
	//before --> selectUser(String) --> after
	//before --> selectUser(UserVo) --> after
	//afterClass

	@Resource(name="userService")
	private UserServiceInf userService;
	
	@Resource(name="userDao")
	private UserDaoInf userDao;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
	
	@Before
	public void before(){
		System.out.println("before");
		userDao.deleteUser(TEST_USER_ID);
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	
	// 운영 메소드이름 + Test
	@Test
	public void selectUserAllTest() {
		/*** Given ***/

		/*** When ***/
		List<UserVo> userList = userService.selectUserAll();
		System.out.println(userList);

		/*** Then ***/
		assertEquals(114, userList.size());
	}

	@Test
	public void selectUserTest() {
		/*** Given ***/

		/*** When ***/
		UserVo userVo = userService.selectUser("brown");
		System.out.println(userVo);

		/*** Then ***/
		assertNotNull(userVo);
		assertEquals("브라운3", userVo.getName());
		assertEquals("brown", userVo.getUserId());
	}

	@Test
	public void selectUserByVoTest() {
		/*** Given ***/

		/*** When ***/
		// parameter, result
		UserVo userVo = userService.selectUser("brown");
		System.out.println(userVo);

		/*** Then ***/
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
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		
		int pageCnt = (Integer)resultMap.get("pageCnt");

		/***Then***/
		assertEquals(10, userList.size());
		assertEquals(12, pageCnt);
	}
	
	/**
	* Method : insertUserTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 사용자 입력
	*/
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

		/***When***/
		int insertCnt = userService.insertUser(userVo);

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
		userService.insertUser(userVo);

		/***When***/
		userVo.setName("testUserId_up");
		userService.updateUser(userVo);
		
		UserVo selectedUserVo = userService.selectUser(TEST_USER_ID);

		/***Then***/
		assertEquals("testUserId_up", selectedUserVo.getName());

	}
}








