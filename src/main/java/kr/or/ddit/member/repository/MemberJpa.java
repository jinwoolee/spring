package kr.or.ddit.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.member.model.MemberVo;

@Transactional(transactionManager = "jpaTransactionManager")
@Repository
public interface MemberJpa extends JpaRepository<MemberVo, String>/*, JpaSpecificationExecutor<MemberVo>*/{
	
}
