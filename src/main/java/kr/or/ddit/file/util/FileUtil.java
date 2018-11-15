package kr.or.ddit.file.util;

public class FileUtil {

	//FileUtil.getFileExt(String fileName);
	//확장자가 있을경우 .을 포함한 확장자 값을 리턴
	//확장자가 없을경우 "" whitespace를 리턴
	// 테스트값 : sally.png ==> .png
	// 테스트값 : sally ==> ""
	
	/**
	* Method : getFileExt
	* 작성자 : sem
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일 확장자 추출
	*/
	public static String getFileExt(String fileName) {
		//sally.png  ==> .png
//		String[] split = fileName.split("\\.");		//sally / png
//		
//		if(split.length == 1)	//확장자가 없는 경우
//			return "";
//		else
//			return "." + split[split.length-1];
		
		int lastDotIndex = fileName.lastIndexOf(".");
		
		if(lastDotIndex < 0)	//dot이 없는경우
			return "";
		else
			return fileName.substring(lastDotIndex);
					
					
	}

}










