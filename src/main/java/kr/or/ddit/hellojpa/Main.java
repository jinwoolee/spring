package kr.or.ddit.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.hellojpa.entity.Member;
import kr.or.ddit.hellojpa.entity.MemberType;
import kr.or.ddit.hellojpa.entity.Team;

public class Main {
	
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Member member = new Member();
			//member.setId(100L);
			member.setName("브라운");
			member.setMembeType(MemberType.ADMIN);
			//member.setTeamId(team.getId());
			member.setTeam(team);
			
			em.persist(member);
			
			em.flush();   //sql 즉시 실행
			em.clear();	  //cache 비우기
			
			Member findMember = em.find(Member.class, member.getId());
			logger.debug("{}", findMember);
			//findMember.getTeamId();	// ????
			
			//Team findTeam = em.find(Team.class, findMember.getTeamId());
			//logger.debug(findTeam.toString());
			logger.debug("{}", findMember.getTeam());
			
			
			
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		
		emf.close();
	}
}
