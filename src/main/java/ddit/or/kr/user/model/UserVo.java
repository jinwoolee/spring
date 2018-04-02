package ddit.or.kr.user.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement(name="userVo")
public class UserVo {
	private	String	userId;
	private	String	userNm;
	private	String	userAlias;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private	Date	regDt = new Date();
	
	public UserVo(){
		
	}
	
	public UserVo(String userId, String	userNm, String userAlias){
		this.userId = userId;
		this.userNm = userNm;
		this.userAlias = userAlias;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserAlias() {
		return userAlias;
	}
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userNm=" + userNm
				+ ", userAlias=" + userAlias + ", regDt=" + regDt + "]";
	}
	
}
