package kr.or.ddit.common.model;

import java.util.List;

public class Rangers {
	
	private List<String> userid;

	public List<String> getUserid() {
		return userid;
	}

	public void setUserid(List<String> userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Rangers [userid=" + userid + "]";
	}
	
}
