package kr.or.ddit.hellojpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Team {
	
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "team")
	private List<Member> memberList;
	

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

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

//	@Override
//	public String toString() {
//		return "Team [id=" + id + ", name=" + name + ", memberList=" + memberList + "]";
//	}

//	@Override
//	public String toString() {
//		return "Team [id=" + id + ", name=" + name + "]";
//	}
	
	
	
	
	
}
