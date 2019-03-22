package kr.or.ddit.user.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.WebTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;

public class UserControllerTest extends WebTestConfig{
	
	private static final String USER_INSERT_TEST_ID = "sallyTest2";
	
	@Resource(name="userService")
	private IUserService userService;
	
	@Before
	public void initData(){
		userService.deleteUser(USER_INSERT_TEST_ID);
	}
	
	/**
	 * Method : testUserAllList
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 전체 조회 테스트
	 * @throws Exception 
	 */
	@Test
	public void testUserAllList() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/user/userAllList")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<UserVo> userList = (List<UserVo>)mav.getModel().get("userList");

		/***Then***/
		assertEquals("user/userAllList", viewName);
		assertNotNull(userList);
		assertTrue(userList.size() > 100);
	}
	
	/**
	 * Method : testUserPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void testUserPagingList() throws Exception{
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/user/userPagingList")).andReturn();
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		ModelMap modelMap = mav.getModelMap();
		
		List<UserVo> userList = (List<UserVo>)modelMap.get("userList");
		int userCnt = (Integer)modelMap.get("userCnt");
		int page = (Integer)modelMap.get("page");
		int pageSize = (Integer)modelMap.get("pageSize");

		/***Then***/
		assertEquals("user/userPagingList", viewName);
		assertNotNull(userList);
		assertEquals(10, userList.size());
		assertTrue(userCnt > 100);
		assertEquals(1, page);
		assertEquals(10, pageSize);
	}
	
	/**
	 * Method : testUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 상세 조회 테스트
	 * @throws Exception 
	 */
	@Test
	public void testUser() throws Exception{
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/user/user")
										.param("userId", "brown"))
										.andReturn();
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		UserVo userVo = (UserVo)mav.getModel().get("userVo");

		/***Then***/
		assertEquals("user/user", viewName);
		assertNotNull(userVo);
		assertEquals("brown", userVo.getUserId());
		assertEquals("브라운", userVo.getUserNm());
	}
	
	//@Test
	//public void testProfileImg(){}
	
	
	/**
	 * Method : testUserForm
	 * 작성자 : SEM
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 사용자 등록폼 요청 테스트
	 */
	@Test
	public void testUserForm() throws Exception{
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/user/userForm")).andReturn();
		//mockMvc.perform(get("/user/userForm"))
		//		.andExpect(MockMvcResultMatchers.view().name("user/userForm"));
				
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();

		/***Then***/
		assertEquals("user/userForm", viewName);
	}
	
	/**
	 * Method : testUserForm_post
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 등록 요청 테스트
	 */
	@Test
	public void testUserForm_post_success() throws Exception{
		/***Given***/
		
		File profileFile = new File("D:\\공유폴더\\web\\레인저스사진\\moon.png");
		FileInputStream fis = new FileInputStream(profileFile);
		
		MockMultipartFile file =
				new MockMultipartFile("profile", "moon.png", "image/png", fis);
		
		MvcResult mvcResult =
				mockMvc.perform(fileUpload("/user/userForm").file(file)
				.param("userId", USER_INSERT_TEST_ID)
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "34942")
				.param("pass", "testpass"))
			.andExpect(view().name("redirect:/user/userPagingList"))
			.andReturn();
		
		/***When***/
		HttpSession session = mvcResult.getRequest().getSession();
		
		/***Then***/
		assertEquals("정상 등록 되었습니다", session.getAttribute("msg"));
	}
	
	
	/**
	 * Method : testUserForm_post_fail_duplicateUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 사용자 등록요청(중복 사용자로 인한 등록 실패 케이스) 테스트
	 */
	@Test
	public void testUserForm_post_fail_duplicateUser() throws Exception{
		/***Given***/
		
		File profileFile = new File("D:\\공유폴더\\web\\레인저스사진\\moon.png");
		FileInputStream fis = new FileInputStream(profileFile);
		
		MockMultipartFile file =
				new MockMultipartFile("profile", "moon.png", "image/png", fis);
		
		MvcResult mvcResult =
				mockMvc.perform(fileUpload("/user/userForm").file(file)
				.param("userId", "sally")
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "34942")
				.param("pass", "testpass"))
			.andExpect(view().name("user/userForm"))
			.andReturn();
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String msg = (String)mav.getModel().get("msg");
		
		/***Then***/
		assertEquals("중복체크에 실패 했습니다.", msg);
	}
	
	/**
	 * Method : testUserForm_post_fail_insertError
	 * 작성자 : SEM
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 사용자 등록 (zipcode 사이즈 sql에러) 테스트
	 */
	@Test
	public void testUserForm_post_fail_insertError() throws Exception{
		/***Given***/
		
		File profileFile = new File("D:\\공유폴더\\web\\레인저스사진\\moon.png");
		FileInputStream fis = new FileInputStream(profileFile);
		
		MockMultipartFile file =
				new MockMultipartFile("profile", "moon.png", "image/png", fis);
		
		MvcResult mvcResult =
				mockMvc.perform(fileUpload("/user/userForm").file(file)
				.param("userId", USER_INSERT_TEST_ID)
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "3494234942")
				.param("pass", "testpass"))
			.andExpect(view().name("user/userForm"))
			.andReturn();
		
		/***When***/
		
		/***Then***/
	}
	
	@Test
	public void testUserModifyForm_get() throws Exception{
		/***Given***/
		mockMvc.perform(get("/user/userModifyForm")
						.param("userId", "brown"))
				.andExpect(status().is(200))
				.andExpect(view().name("user/userModifyForm"))
				.andExpect(model().attributeExists("userVo"));
		
		/***When***/

		/***Then***/
	}
	
	/**
	 * Method : testUsesrModifyForm_post_success
	 * 작성자 : SEM
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 사용자 정보 수정 테스트(프로파일 갱신)
	 */
	@Test
	public void testUsesrModifyForm_post_success_newProfile() throws Exception{
		/***Given***/
		File profileFile = new File("D:\\공유폴더\\web\\레인저스사진\\moon.png");
		FileInputStream fis = new FileInputStream(profileFile);
		
		MockMultipartFile file =
				new MockMultipartFile("profile", "moon.png", "image/png", fis);
		
		mockMvc.perform(fileUpload("/user/userModifyForm").file(file)
				.param("userId", "userId1")
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "34942")
				.param("pass", "testpass"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/user/user?userId=userId1"));
		
		/***When***/

		/***Then***/
	}
	
	@Test
	public void testUsesrModifyForm_post_success_noProfile() throws Exception{
		/***Given***/
		
		mockMvc.perform(fileUpload("/user/userModifyForm").file(new MockMultipartFile("profile", new byte[]{}))
				.param("userId", "userId1")
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "34942")
				.param("pass", "testpass"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/user/user?userId=userId1"));
		
		/***When***/

		/***Then***/
	}
	
	@Test
	public void testUsesrModifyForm_post_fail() throws Exception{
		/***Given***/
		File profileFile = new File("D:\\공유폴더\\web\\레인저스사진\\moon.png");
		FileInputStream fis = new FileInputStream(profileFile);
		
		MockMultipartFile file =
				new MockMultipartFile("profile", "moon.png", "image/png", fis);
		
		mockMvc.perform(fileUpload("/user/userModifyForm").file(file)
				.param("userId", "userId1")
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "3494234942")
				.param("pass", "testpass"))
			.andExpect(status().isOk())
			.andExpect(view().name("user/userModifyForm"));
		
		/***When***/

		/***Then***/
	}
	
	
}











