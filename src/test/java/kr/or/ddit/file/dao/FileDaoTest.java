package kr.or.ddit.file.dao;


import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoTestConfig;


public class FileDaoTest extends ServiceDaoTestConfig{
	
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**
	* Method : insertFileTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 파일정보 입력 테스트
	*/
	
	@Test(timeout=5000)
	public void insertFileTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("8c44b77d-1305-402f-b7a6-f4a1e3df9259.png");
		fileVo.setOrg_file_name("sally.png");
		fileVo.setFile_ext(".png");
		fileVo.setFile_path("D:\\A_TeachingMaterial\\6.JspSpring\\upload");
		
		/***When***/
		int insertCnt = fileDao.insertFile(fileVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}

}











