package kr.or.ddit.util.model;

import java.io.File;

public class FileInfo {
	
	private File file;				//업로드 경로를 포함한 파일 객체
	private String orginalFileName;	//업로드한 실제 파일명
	private String extName;			//파일 확장자 (.포함)
	
	public FileInfo() {}
	
	public FileInfo(File file, String extName, String originalFileName) {
		this.file = file;
		this.extName = extName;
		this.orginalFileName = originalFileName;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getOrginalFileName() {
		return orginalFileName;
	}
	public void setOrginalFileName(String orginalFileName) {
		this.orginalFileName = orginalFileName;
	}
	public String getExtName() {
		return extName;
	}
	public void setExtName(String extName) {
		this.extName = extName;
	}
	
}
