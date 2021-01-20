package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.repository.jpa.MemberJpa;

//@Service
public class MemberJpaService implements MemberServiceI{
	
	@Autowired
	private MemberJpa memberJpa;

	@Override
	public MemberVo getMember(String userId) {
		return memberJpa.findOne(userId);
	}

	@Override
	public List<MemberVo> selectAllMember() {
		return memberJpa.findAll();
	}

	@Override
	public Map<String, Object> selectMemberPageList(PageVo pageVo) {
		
		Pageable pageable = new PageRequest(pageVo.getPage(), pageVo.getPageSize());
		
		Page<MemberVo> memberPage = memberJpa.findAll(pageable);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("memberList", memberPage.getContent());
		resultMap.put("pages", memberPage.getTotalPages());
		
		return resultMap;
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		MemberVo memberVo1 = memberJpa.save(memberVo);
		MemberVo memberVo2 = memberJpa.save(memberVo);
		return 1;
	}

	@Override
	public int deleteMember(String userid) {
		MemberVo memberVo = new MemberVo(userid, null);
		memberJpa.delete(memberVo);
		return 1;
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		memberJpa.save(memberVo);
		return 1;
	}

}
