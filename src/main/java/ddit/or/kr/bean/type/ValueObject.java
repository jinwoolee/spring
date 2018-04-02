package ddit.or.kr.bean.type;

import java.util.Date;

public class ValueObject {
	private	String	name;
	private	String	title;
	private	Date	dt;		//request.getParameter("dt")
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
}
