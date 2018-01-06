package board.model;

public class BoardFileVo {
	
	private	String	fileno;
	private	String	boardno;
	private	String	filenm;
	private	String	filepath;
	private	String	filetype;
	private	String	filesize;
	public String getFileno() {
		return fileno;
	}
	public void setFileno(String fileno) {
		this.fileno = fileno;
	}
	public String getBoardno() {
		return boardno;
	}
	public void setBoardno(String boardno) {
		this.boardno = boardno;
	}
	public String getFilenm() {
		return filenm;
	}
	public void setFilenm(String filenm) {
		this.filenm = filenm;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	
	@Override
	public String toString() {
		return "BoardFileVo [fileno=" + fileno + ", boardno=" + boardno + ", filenm=" + filenm + ", filepath="
				+ filepath + ", filetype=" + filetype + ", filesize=" + filesize + "]";
	}	
}
