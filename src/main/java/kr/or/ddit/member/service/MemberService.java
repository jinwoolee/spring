package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.repository.MemberDaoI;

@Transactional
@Service("memberService")
public class MemberService implements MemberServiceI {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Resource(name="memberDao")
	private MemberDaoI memberDao;
	
	public MemberService() {
		//memberDao = new MemberDao();
	}

	@Override
	public MemberVo getMember(String userId) {
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVo> selectAllMember() {
		return memberDao.selectAllMember();
	}

	@Override
	public Map<String, Object> selectMemberPageList(PageVo pageVo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberDao.selectMemberPageList(pageVo));
		
		//15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14.... 올림을 하여 3개의 페이지가 필요
		//Math.ceil()
		int totalCnt = memberDao.selectMemberTotalCnt();
		int pages = (int)Math.ceil( (double)totalCnt/7);
		map.put("pages", pages);

		return map;
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		
//		logger.debug("첫번째 insert 시작전");
//		memberDao.insertMember(memberVo);
//		logger.debug("첫번째 insert 종료후");
		
		//첫번째 쿼리는 정상적으로 실행되지만
		//두번째 쿼리에서 동일한 데이터를 입력하여 PRIMARY KEY 제약조건에 의해 
		//SQL 실행 실패
		//첫번째 쿼리는 성공했지만 트랜잭션 설정을 service 레벨에 설정을 하였기 때문에
		//서비스 메소드에서 실행된 모드 쿼리를 rollback 처리한다
		
//		logger.debug("두번째 insert 시작전");
//		memberDao.insertMember(memberVo);
//		logger.debug("두번째 insert 시작전");
		
		return memberDao.insertMember(memberVo);
	}
	
	@Override
	public int deleteMember(String userid) {
		return memberDao.deleteMember(userid);
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		return memberDao.updateMember(memberVo);
	}

}







