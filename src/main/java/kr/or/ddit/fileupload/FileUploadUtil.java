package kr.or.ddit.fileupload;

public class FileUploadUtil {
	
	//form-data; name="img"; filename="sally.png"
	//filename="sally.png; form-data; name="img";"
	//==> sally.png
	
	//FileUploadUtilTest
	public static String getFilename(String contentDisposition) {
		String[] attrs = contentDisposition.split("; ");
		for(String attr : attrs) {
			String[] attrArray =  attr.split("=");
			if(attrArray[0].equals("filename")) {
				return attrArray[1].replaceAll("\"", "");		//더블 쿼테이션 제거
			}
		}
		return "";
	}
	
	// filename : sally.png ==> png
	public static String getExtension(String filename) {
		if(filename == null || filename.indexOf(".") == -1 )
			return "";
		else {
			return filename.split("\\.")[1];
		}
	}
}

