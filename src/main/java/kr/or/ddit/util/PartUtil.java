package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PartUtil {

	private static final String UPLOAD_PATH = "d:\\springUpload\\";

	/** 
	 * Method   : getExt
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param fileName
	 * @return 
	 * Method 설명 : 파일명으로부터 파일 확장자를 반환
	 */
	public static String getExt(String fileName) {
		String ext = "";
		String[] splited = fileName.split("\\.");
		if(splited.length != 1)
			ext = splited[splited.length-1];
		
		return ext.equals("") ? "" : "." + ext;
	}
	
	/** 
	 * Method   : checkUploadFolder
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param yyyy
	 * @param mm 
	 * Method 설명 : 년, 월 업로드 폴더가 존재하는지 체크, 없을 경우 폴더 생성
	 */
	public static void checkUploadFolder(String yyyy, String mm){
		File yyyyFolder = new File(UPLOAD_PATH + yyyy);
		//신규년도로 넘어갔을때 해당 년도의 폴더를 생성한다
		if(!yyyyFolder.exists())
			yyyyFolder.mkdir();
		
		//월에 해당하는 폴더가 있는지 확인
		File mmFolder = new File(UPLOAD_PATH + yyyy + File.separator + mm);
		if(!mmFolder.exists())
			mmFolder.mkdir();
	}
	
	/** 
	 * Method   : getUploadPaht
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param yyyy
	 * @param mm
	 * @return 
	 * Method 설명 : 업로드 경로를 반환
	 */
	public static String getUploadPath(){
		//업로드할 폴더 확인
		//년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가 있는지
		Date dt = new Date();
		SimpleDateFormat yyyyMMSdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = yyyyMMSdf.format(dt);
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		PartUtil.checkUploadFolder(yyyy, mm);
		return UPLOAD_PATH + yyyy + File.separator + mm; 
	}
}








