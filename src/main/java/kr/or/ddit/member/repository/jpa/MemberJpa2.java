package kr.or.ddit.member.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.hellojpa.entity.Member;

@Transactional(propagation = Propagation.REQUIRED)
@Repository
public interface MemberJpa2 extends JpaRepository<Member, Long>{

}
