package ddit.or.kr.validator.model;

public class BoardVo {
	
	private	String	title;
	private	String	cont;
	private	String	userId;
	private String	language;
	
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", cont=" + cont + ", userId="
				+ userId + ", language=" + language + "]";
	}
}
