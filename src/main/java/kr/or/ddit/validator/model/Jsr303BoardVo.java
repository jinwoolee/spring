package kr.or.ddit.validator.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Jsr303BoardVo {
	private	int		seq;
	
	@NotEmpty
	private	String	title;
	@NotEmpty
	private	String	cont;
	@NotEmpty
	private	String	reg_id;
	
	private	Date	reg_dt;
	
	public Jsr303BoardVo() {
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

	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", title=" + title + ", cont=" + cont + ", reg_id=" + reg_id + ", reg_dt="
				+ reg_dt + "]";
	}
	
}