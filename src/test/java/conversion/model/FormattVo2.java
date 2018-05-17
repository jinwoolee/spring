package conversion.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class FormattVo2 {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private	Date			reg_dt;
	
	@DateTimeFormat(pattern = "MM-yyyy-dd")
	private	Date			mod_dt;
	
	@NumberFormat(pattern = "#,###")
	private int				amount;
	
	public FormattVo2() {

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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "FormattVo2 [reg_dt=" + reg_dt + ", mod_dt=" + mod_dt + ", amount=" + amount + "]";
	}

}