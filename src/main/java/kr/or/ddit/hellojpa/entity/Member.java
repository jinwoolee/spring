package kr.or.ddit.hellojpa.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int age;
	
	@Column(name = "username", nullable = true, length = 20)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private MemberType membeType;
	
//	@Column(name="TEAM_ID")
//	private Long teamId;
	
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MemberType getMembeType() {
		return membeType;
	}
	public void setMembeType(MemberType membeType) {
		this.membeType = membeType;
	}
//	public Long getTeamId() {
//		return teamId;
//	}
//	public void setTeamId(Long teamId) {
//		this.teamId = teamId;
//	}
//	@Override
//	public String toString() {
//		return "Member [id=" + id + ", age=" + age + ", name=" + name + ", membeType=" + membeType + ", teamId="
//				+ teamId + "]";
//	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", age=" + age + ", name=" + name + ", membeType=" + membeType + ", team=" + team
				+ "]";
	}
	
	
	
}
