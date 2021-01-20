package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest extends ModelTestConfig{

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "brown";

		/***When***/
		MemberVo memberVo = memberService.getMember(userid);

		/***Then***/
		assertEquals("브라운", memberVo.getUsernm());
	}
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/

		/***When***/
		List<MemberVo> memberList = memberService.selectAllMember();

		/***Then***/
		assertTrue(memberList.size() > 13 );
	}
	
	@Test
	public void selectMemberPageList() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 5);
		
		/***When***/
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		
		List<MemberVo> memberList = (List<MemberVo>)map.get("memberList");
		int pages = (int)map.get("pages");
		
		/***Then***/
		assertEquals(5, memberList.size());
		assertEquals(4, pages);
	}
	
	@Test
	public void insertMember_SUCCESS_Test() {
		/***Given***/
		MemberVo memberVo = new MemberVo("temp_jpa_my", "dditpass", "대덕인재n", "개발원", "", "", "", "", "");
		/***When***/
		int insertCnt = memberService.insertMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void insertMember_FAIL_Test() {
		/***Given***/
		MemberVo memberVo = new MemberVo("temp", "dditpass", "대덕인재", "개발원", 
										"", "", "", "", "");
		/***When***/
		int insertCnt = memberService.insertMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteMember() {
		/***Given***/
		String userid = "brown";
		
		/***When***/
		int deleteCnt = memberService.deleteMember(userid);

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void updateMember() {
		/***Given***/
		MemberVo memberVo = new MemberVo("brown", "dditpass", "대덕인재", "개발원", 
										"", "", "", "", "");

		/***When***/
		int updateCnt = memberService.updateMember(memberVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
}








