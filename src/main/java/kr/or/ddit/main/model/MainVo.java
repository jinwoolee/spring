package kr.or.ddit.main.model;

import java.util.List;

public class MainVo {
	
	private List<String> userIdList;
	private List<String> nameList;
	private List<AddrVo> addrVoList;
	
	public List<String> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}
	public List<String> getNameList() {
		return nameList;
	}
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
	public List<AddrVo> getAddrVoList() {
		return addrVoList;
	}
	public void setAddrVoList(List<AddrVo> addrVoList) {
		this.addrVoList = addrVoList;
	}
	@Override
	public String toString() {
		return "MainVo [userIdList=" + userIdList + ", nameList=" + nameList + ", addrVoList=" + addrVoList + "]";
	}
	
	
		
}
