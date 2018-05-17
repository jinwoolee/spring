package conversion.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class FormattVo {

	private	Date			reg_dt;
	
	public FormattVo() {

	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	@Override
	public String toString() {
		return "FormattVo [reg_dt=" + reg_dt + "]";
	}

}