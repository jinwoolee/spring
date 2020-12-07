package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest extends ModelTestConfig{

	@Resource(name="memberDao")
	private MemberDaoI memberDao;

	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "brown";

		/***When***/
		MemberVo memberVo = memberDao.getMember(userid);

		/***Then***/
		assertEquals("브라운", memberVo.getUsernm());
	}
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/

		/***When***/
		List<MemberVo> memberList = memberDao.selectAllMember();

		/***Then***/
		assertTrue(memberList.size() > 13 );
	}
	
	@Test
	public void selectMemberPageList() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 5);
		
		/***When***/
		List<MemberVo> memberList = memberDao.selectMemberPageList(pageVo);

		/***Then***/
		assertEquals(5, memberList.size());
	}
	
	@Test
	public void selectMemberTotalCnt() {
		/***Given***/

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt();

		/***Then***/
		assertEquals(17, totalCnt);
	}
	
	@Test
	public void insertMember_Test() {
		/***Given***/
		MemberVo memberVo = new MemberVo("temp", "dditpass", "대덕인재", "개발원", 
										"", "", "", "", "");
		/***When***/
		int insertCnt = memberDao.insertMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteMember() {
		/***Given***/
		String userid = "brown";
		
		/***When***/
		int deleteCnt = memberDao.deleteMember(userid);

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void updateMember() {
		/***Given***/
		MemberVo memberVo = new MemberVo("brown", "dditpass", "대덕인재", "개발원", 
										"", "", "", "", "");

		/***When***/
		int updateCnt = memberDao.updateMember(memberVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
}








