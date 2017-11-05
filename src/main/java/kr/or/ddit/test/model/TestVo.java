package kr.or.ddit.test.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TestVo {
	
	private	String	userId;
	private	int		amount;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private	Date	birthDay;
	
	public TestVo() {	
	}
	
	public TestVo(String userId, int amount, Date birthDay) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.birthDay = birthDay;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	@Override
	public String toString() {
		return "TestVo [userId=" + userId + ", amount=" + amount + "]";
	}
}