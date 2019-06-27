package kr.or.ddit.main.model;

import java.util.List;

public class MainVo {
	
	private List<String> userId;
	private List<String> name;
	
	private List<AddrVo> addr;

	public List<String> getUserId() {
		return userId;
	}

	public void setUserId(List<String> userId) {
		this.userId = userId;
	}

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public List<AddrVo> getAddr() {
		return addr;
	}

	public void setAddr(List<AddrVo> addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MainVo [userId=" + userId + ", name=" + name + ", addr=" + addr + "]";
	}
	
}
