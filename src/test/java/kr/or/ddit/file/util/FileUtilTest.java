package kr.or.ddit.file.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUtilTest {
	
	//FileUtil.getFileExt(String fileName);
	//확장자가 있을경우 .을 포함한 확장자 값을 리턴
	//확장자가 없을경우 "" whitespace를 리턴
	// 테스트값 : sally.png ==> .png
	// 테스트값 : sally  ==> ""
	
	//테스트 코드를 운영코드보다 먼저 작성하는 방법
	//Test Driven Development (TDD)
	/**
	* Method : getFileExtExists
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출(확장자가 있는경우)
	*/
	@Test
	public void getFileExtExists() {
		/***Given***/
		String fileName = "sally.png";

		/***When***/
		String ext = FileUtil.getFileExt(fileName);

		/***Then***/
		assertEquals(".png", ext);
	}
	
	/**
	* Method : getFileExtExists
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출(확장자가 있는경우, 파일명에 점이 들어가는경우)
	*/
	@Test
	public void getFileExtExistsMultiDot() {
		/***Given***/
		String fileName = "sally.brown.png";

		/***When***/
		String ext = FileUtil.getFileExt(fileName);

		/***Then***/
		assertEquals(".png", ext);
	}
	
	/**
	* Method : getFileExtNotExists
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출(확장자가 없는경우)
	*/
	@Test
	public void getFileExtNotExists() {
		/***Given***/
		String fileName = "sally";

		/***When***/
		String ext = FileUtil.getFileExt(fileName);

		/***Then***/
		assertEquals("", ext);
	}

}






