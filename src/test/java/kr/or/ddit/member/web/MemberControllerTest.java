package kr.or.ddit.member.web;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.portlet.MockMultipartActionRequest;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

public class MemberControllerTest extends WebTestConfig{

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@Before
	public void setupData() {
		/*String userid = "ljw";
		memberService.deleteMember(userid);*/
	}
	
	@Test
	public void memberListTest() throws Exception {
		mockMvc.perform(get("/member/list"))
				.andExpect(view().name("tiles/member/memberListContent"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("memberList"))
				.andExpect(model().attributeExists("pages"))
				.andDo(print());
	}
	
	@Test
	public void memberTest() throws Exception {
		mockMvc.perform(get("/member/member").param("userid", "brown"))
				.andExpect(view().name("tiles/member/memberContent"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("memberVo"))
				.andDo(print());
	}
	
	@Test
	public void memberRegistViewTest() throws Exception {
		mockMvc.perform(get("/member/regist"))
		.andExpect(view().name("tiles/member/registContent"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void memberRegistTest() throws Exception {
		ClassPathResource cpr = new ClassPathResource("/kr/or/ddit/upload/sally.png");
		InputStream is = cpr.getInputStream();
		
		MockMultipartFile file = new MockMultipartFile("profile", "sally.png", "image/png", is);

		mockMvc.perform(fileUpload("/member/regist").file(file)
							.param("userid", "ljw_new")
							.param("pass", "pass1234")
							.param("usernm", "이진우")
							.param("alias", "SEM")
							.param("addr1", "대전 중구 중앙로 76")
							.param("addr2", "영민빌딩 404호")
							.param("zipcode", "34940"))
		.andExpect(view().name("redirect:/member/list"))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
	@Test
	public void memberRegistFailTest() throws Exception {
		ClassPathResource cpr = new ClassPathResource("/kr/or/ddit/upload/sally.png");
		InputStream is = cpr.getInputStream();
		
		MockMultipartFile file = new MockMultipartFile("profile", "sally.png", "image/png", is);

		mockMvc.perform(fileUpload("/member/regist").file(file)
							.param("userid", "ljw")
							.param("pass", "pass1234")
							.param("usernm", "이진우")
							.param("alias", "SEM")
							.param("addr1", "대전 중구 중앙로 76")
							.param("addr2", "영민빌딩 404호")
							.param("zipcode", "34940"))
		.andExpect(view().name("tiles/member/registContent"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void memberUpdateViewTest() throws Exception {
		mockMvc.perform(get("/member/update").param("userid", "brown"))
				.andExpect(status().isOk())
				.andExpect(view().name("tiles/member/updateContent"))
				.andExpect(model().attributeExists("memberVo"))
				.andDo(print());
	}
	
	@Test
	public void memberUpdateTest() throws Exception {
		
		/***Given***/
/*		MemberVo memberVo = new MemberVo("ljw", "pass1234", "이진우", "sem",
						"대전 중구 중앙로 76", "영민빌딩 404호", "34940", 
						"d:\\profile\\ljw.png", "ljw.png");
	
		int insertCnt = memberService.insertMember(memberVo);*/

		/***When***/
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		MockMultipartFile file = new MockMultipartFile("profile", "sally.png", "image/png", is);
		
		mockMvc.perform(fileUpload("/member/update").file(file)
						.param("userid", "ljw")
						.param("pass", "pass1234")
						.param("usernm", "이진우")
						.param("alias", "SEM")
						.param("addr1", "대전 중구 중앙로 76")
						.param("addr2", "영민빌딩 404호")
						.param("zipcode", "34940"))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/member/member?userid=ljw"));
		
		/***Then***/
		//assertEquals(1, insertCnt);
	}

}
