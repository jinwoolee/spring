package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUtilTest {

	/**
	* Method : getExtensionTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 파일 확장자 가져오기 테스트
	*/
	@Test
	public void getExtensionTest() {
		/***Given***/
		String fileName = "sally.png";

		/***When***/
		String ext = FileUtil.getExtension(fileName);

		/***Then***/
		assertEquals(".png", ext);
	}
	
	/**
	* Method : getExtensionTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 파일 확장자 가져오기 테스트 (확장자가 없는경우)
	*/
	@Test
	public void getExtension_NoExtension_Test() {
		/***Given***/
		String fileName = "sally";

		/***When***/
		String ext = FileUtil.getExtension(fileName);

		/***Then***/
		assertEquals("", ext);
	}
	
	
	/**
	* Method : getExtensionTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 파일 확장자 가져오기 테스트 (파일명에 dot 이 여러개 존재하는 경우)
	*/
	@Test
	public void getExtension_MultiDot_Test() {
		/***Given***/
		String fileName = "sally.ranger.png";

		/***When***/
		String ext = FileUtil.getExtension(fileName);

		/***Then***/
		assertEquals(".png", ext);
	}
	
}
