package kr.or.ddit.jdbc.model;

import java.util.Date;

public class BoardVo {
	private	int		seq;
	private	String	title;
	private	String	cont;
	private	String	language;
	private	String	reg_id;
	private	Date	reg_dt;
	
	
	public BoardVo(String title, String cont, String reg_id, Date reg_dt) {
		this(title, cont, reg_id);
		this.reg_dt	=	reg_dt;
	}
	public BoardVo(String title, String cont, String reg_id) {
		this.title	=	title;
		this.cont	=	cont;
		this.reg_id	=	reg_id;
	}
	
	public BoardVo() {
		
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
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
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", cont=" + cont + ", reg_id=" + reg_id + ", reg_dt=" + reg_dt + "]";
	}
}