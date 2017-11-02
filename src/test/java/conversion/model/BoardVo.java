package conversion.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardVo {
	private	String			title;
	private	String			content;
	private	String			reg_id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private	Date			reg_dt;
	
	public BoardVo() {
		super();
	}

	public BoardVo(String title, String content, String reg_id, Date reg_dt) {
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_dt = reg_dt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "BoardVo [title=" + title + ", content=" + content + ", reg_id=" + reg_id + ", reg_dt=" + reg_dt + "]";
	}
}