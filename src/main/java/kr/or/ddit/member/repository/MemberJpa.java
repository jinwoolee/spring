package kr.or.ddit.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.or.ddit.member.model.MemberVo;

@Repository
public interface MemberJpa extends JpaRepository<MemberVo, String>/*, JpaSpecificationExecutor<MemberVo>*/{
	
}
