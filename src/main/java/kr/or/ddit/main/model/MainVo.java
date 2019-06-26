package kr.or.ddit.main.model;

import java.util.Arrays;

public class MainVo {
	
	private String[] userId;
	private String[] name;
	public String[] getUserId() {
		return userId;
	}
	public void setUserId(String[] userId) {
		this.userId = userId;
	}
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MainVo [userId=" + Arrays.toString(userId) + ", name=" + Arrays.toString(name) + "]";
	}
	
	
}
