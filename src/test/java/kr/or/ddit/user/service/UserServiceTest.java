package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.test.config.ModelTestConfig;
import kr.or.ddit.user.model.UserVo;

public class UserServiceTest extends ModelTestConfig {

	@Resource(name = "userService")
	private UserService userService;

	@Before
	public void setup() {
		// 테스트에서 사용할 신규 사용자 추가
		UserVo userVo = new UserVo("testUser", "테스트사용자", "testUserPass", new Date(), "대덕", "대전 중구 중앙로 76", "4층",
				"34940", "brown.png", "uuid-generated-filename.png");

		userService.registUser(userVo);

		// 신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제
		userService.deleteUser("ddit_n");
	}

	@After
	public void tearDodwn() {
		userService.deleteUser("testUser");
	}

	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUserTest() {
		/*** Given ***/

		/*** When ***/
		List<UserVo> userList = userService.selectAllUser();

		/*** Then ***/
		assertEquals(17, userList.size());
	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/*** Given ***/
		String userid = "brown";

		/*** When ***/
		UserVo user = userService.selectUser(userid);

		/*** Then ***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}

	// 사용자 아이디가 존재하지 않을 때, 특정 사용자 조회
	@Test
	public void selectUserNotExsistTest() {
		/*** Given ***/
		String userid = "brownNotexists";

		/*** When ***/
		UserVo user = userService.selectUser(userid);

		/*** Then ***/
		assertNull(user);
	}

	// 사용자 페이징 조회 테스트
	@Test
	public void selectPagingUserTest() {
		/*** Given ***/
		PageVo pageVo = new PageVo(2, 5);

		/*** When ***/
		// List<UserVo> userList = userDao.selectPagingUser(page, pagesize);
		Map<String, Object> map = userService.selectPagingUser(pageVo);
		List<UserVo> userList = (List<UserVo>) map.get("userList");
		//int userCnt = (int) map.get("userCnt");

		/*** Then ***/
		assertEquals(5, userList.size());
		//assertEquals(17, userCnt);
	}

	@Test
	public void modifyUserTest() {
		/*** Given ***/

		// userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		UserVo userVo = new UserVo("ddit", "대덕인재", "dditpass", new Date(), "개발원_m", "대전시 중구 중앙로 76", "4층 대덕인재개발원",
				"34940", "brown.png", "uuid-generated-filename.png");

		/*** When ***/
		int updateCnt = userService.modifyUser(userVo);

		/*** Then ***/
		assertEquals(1, updateCnt);
	}

	@Test
	public void registUserTest() {
		/*** Given ***/
		// userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		UserVo userVo = new UserVo("ddit_n", "대덕인재", "dditpass", new Date(), "개발원_m", "대전시 중구 중앙로 76", "4층 대덕인재개발원",
				"34940", "brown.png", "uuid-generated-filename.png");

		/*** When ***/
		int insertCnt = userService.registUser(userVo);

		/*** Then ***/
		assertEquals(1, insertCnt);
	}

}
