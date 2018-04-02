package ddit.or.kr.bean.type.fmconversion;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class ValueObject {
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regDt;
	
	@DateTimeFormat(pattern="yyyy.MM.dd")
	private Date modDt;
	
	@NumberFormat(pattern="#,###")
	private	int	 price;
	
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public Date getModDt() {
		return modDt;
	}
	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
