package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;

public class UserServiceTest extends LogicTestEnv{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Resource(name="userService")
	private IuserService userService;

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
		List<UserVo> userList = userService.userList();

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
		int insertCnt = userService.insertUser(userVo);

		/***Then***/
		assertEquals(1, insertCnt);
		
		//data 삭제
		userService.deleteUser(userVo.getUserId());
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
		UserVo userVo = userService.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getName());
		assertEquals("곰-한글", userVo.getAlias());
	}
	
	/** 
	 * Method   : userPagingListTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);

		/***When***/
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");

		/***Then***/
		//pagingList assert
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		//paginationSize assert
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : {} ", paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
	}
	
	/** 
	 * Method   : updateUserTest
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @throws ParseException 
	 * Method 설명 : 사용자 삭제 테스트 
	 */
	@Test
	public void updateUserTest() throws ParseException{
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo originVo = new UserVo("대덕인", "userTest", "중앙로", "userTest1234",
				"대전광역시 중구 중앙로76", "영민빌딩 2층 204호", "34940", sdf.parse("2019-05-31"));
		userService.insertUser(originVo);
		
		UserVo userVo = new UserVo("대덕인_변경", "userTest", "중앙", "userTest1234",
				"대전광역시 중구 중앙로77", "영민빌딩 2층 204-1호", "34945", sdf.parse("2019-05-31"));

		/***When***/
		int updateCnt = userService.updateUser(userVo);

		/***Then***/
		assertEquals(1, updateCnt);
		userService.deleteUser(originVo.getUserId());
	}
}










