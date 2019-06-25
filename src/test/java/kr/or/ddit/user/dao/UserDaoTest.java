package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest extends LogicTestEnv{
	
	@Resource(name="userDao")
	private IuserDao userDao;
	
	/** 
	 * Method   : userListTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 사용자 전체 리스트 조회 테스트 
	 */
	@Test
	public void userListTest() {
		/***Given***/

		/***When***/
		List<UserVo> userList = userDao.userList();

		/***Then***/
		assertNotNull(userList);
		assertTrue(userList.size() >= 100);
		assertEquals(106, userList.size());
	}

	/** 
	 * Method   : insertUserTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertUserTest() throws ParseException{
		/***Given***/
		//사용자 정보를 담고 있는 vo객체 준비
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = new UserVo("대덕인", "userTest", "중앙로", "userTest1234",
				"대전광역시 중구 중앙로76", "영민빌딩 2층 204호", "34940", sdf.parse("2019-05-31"));
		
		/***When***/
		int insertCnt = userDao.insertUser(userVo);

		/***Then***/
		assertEquals(1, insertCnt);
		
		//data 삭제
		userDao.deleteUser(userVo.getUserId());
	}
	
	/** 
	 * Method   : getUserTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVo userVo = userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getName());
		assertEquals("곰-한글", userVo.getAlias());
	}
}









