package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.User;

public class UserDaoTest extends RootTestConfig{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

	private String userId = "brownTest";
	
	//userDao를 테스트 하기 위해 필요한거
	//db 연결, 트랜잭션, dao
	@Resource(name="userDao")
	private IUserDao userDao;
	
	/**
	* Method : getUserListTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : getUserList 테스트
	*/
	@Test
	public void getUserListTest() {
		/***Given***/

		/***When***/
		List<User> userList = userDao.getUserList();
		
		/***Then***/
		assertTrue(userList.size() > 105);
	}
	
	/**
	* Method : getUserTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	*/
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		
		/***When***/
		User userVo = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		//assertEquals("brown1234", userVo.getPass());
		assertEquals("c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44", userVo.getPass());
		
	}
	
	/**
	* Method : getUserListOnlyHalfTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 사용자 리스트 절반 조회 테스트
	*/
	@Test
	public void getUserListOnlyHalfTest() {
		/***Given***/
		
		/***When***/
		List<User> userList = userDao.getUserListOnlyHalf();

		/***Then***/
		assertEquals(50, userList.size());
	}
	
	/**
	* Method : getUserPagingListTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	*/
	@Test
	public void getUserPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);

		/***When***/
		List<User> userList = userDao.getUserPagingList(page);

		/***Then***/
		assertEquals(10, userList.size());
		//assertEquals("xuserid22", userList.get(0).getUserId());
	}
	
	/**
	* Method : getUserTotalCnt
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 전체 사용자 건수 조회 테스트
	*/
	@Test
	public void getUserTotalCnt() {
		/***Given***/
		
		/***When***/
		int totalCnt = userDao.getUserTotalCnt();

		/***Then***/
		assertTrue(totalCnt > 105);
		//assertEquals(105, totalCnt);
	}
	
	/**
	* Method : insertUserTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	*/
	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		
		user.setUserId(userId);
		user.setUserNm("브라운테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		
		/***When***/
		int insertCnt = userDao.insertUser(user);
		//sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	/**
	* Method : updateUserTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* @throws ParseException
	* Method 설명 : 사용자 정보 수정 테스트
	*/
	@Test
	public void updateUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		
		user.setUserId(userId);
		user.setUserNm("브라운테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		user.setFilename("");
		user.setRealfilename("");
		
		int insertCnt = userDao.insertUser(user);
		
		/***When***/
		user.setUserNm("브라운수정");
		int updateCnt = userDao.updateUser(user);
		
		User dbUser = userDao.getUser(userId);
		//sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
		assertEquals(1, updateCnt);
		assertEquals("브라운수정", dbUser.getUserNm());
	}
}





