package ddit.or.kr.validator.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Jsr303BoardVo {
	
	@NotEmpty
	private	String	title;
	
	@NotEmpty
	private	String	cont;
	
	@NotEmpty
	private	String	userId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", cont=" + cont + ", userId="
				+ userId + "]";
	}
}
