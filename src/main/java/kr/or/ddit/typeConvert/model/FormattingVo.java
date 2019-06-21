package kr.or.ddit.typeConvert.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class FormattingVo {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reg_dt;	//등록일
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date mod_dt;	//수정일
	
	@NumberFormat(pattern="#,###")
	private int number;
	
	public FormattingVo() {
		
	}
	
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public Date getMod_dt() {
		return mod_dt;
	}
	public void setMod_dt(Date mod_dt) {
		this.mod_dt = mod_dt;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
