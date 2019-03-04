package kr.or.ddit.user.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.WebTestConfig;
import kr.or.ddit.user.model.UserVo;

public class UserControllerTest extends WebTestConfig{

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
	
	
	

}







