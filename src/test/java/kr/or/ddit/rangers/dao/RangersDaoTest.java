package kr.or.ddit.rangers.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.rangers.model.RangerVo;
import kr.or.ddit.test.ServiceDaoTestConfig;

public class RangersDaoTest extends ServiceDaoTestConfig{

	@Resource(name="rangersDao")
	private RangersDaoInf rangersDao;
	
	
	/**
	* Method : selectAllRangersTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 레인저스 정보 전체 조회
	*/
	@Test
	public void selectAllRangersTest() {
		/***Given***/
	
		/***When***/
		List<RangerVo> rangersList = rangersDao.selectAllRangers(); 

		/***Then***/
		assertEquals(3, rangersList.size());
	}
	
	/**
	* Method : insertRanserTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 레인저 입력 테스트
	*/
	@Test
	public void insertRanserTest() {
		/***Given***/
		RangerVo ranger = new RangerVo();
		ranger.setRangersId("moon");
		ranger.setName("문");

		/***When***/
		int insertCnt = rangersDao.insertRanger(ranger);

		/***Then***/
		assertEquals(1, insertCnt);
	}

}






