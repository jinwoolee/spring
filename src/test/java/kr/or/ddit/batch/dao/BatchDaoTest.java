package kr.or.ddit.batch.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.batch.model.BatchVo;
import kr.or.ddit.testenv.LogicTestEnv;

public class BatchDaoTest extends LogicTestEnv{
	
	private static final Logger logger = LoggerFactory.getLogger(BatchDaoTest.class);
	
	@Resource(name="batchDao")
	private IBatchDao batchDao;
	
	/** 
	 * Method   : createDailyTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 일실적 일괄 생성 테스트
	 */
	@Test
	public void createDailyTest() {
		/***Given***/
		String ym = "201907";

		/***When***/
		int createCnt = batchDao.createDaily(ym);

		/***Then***/
		assertEquals(69, createCnt);
	}
	
	/** 
	 * Method   : deleteDailyTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 일실적 일괄삭제
	 */
	@Test
	public void deleteDailyTest() {
		/***Given***/
		String ym = "201907";
		batchDao.createDaily(ym);

		/***When***/
		int deleteCnt = batchDao.deleteDaily(ym);

		/***Then***/
		assertEquals(69, deleteCnt);
	}

	/** 
	 * Method   : insertBatchTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 배치 실행 데이터 생성 테스트
	 */
	@Test
	public void insertBatchTest() {
		/***Given***/
		BatchVo batchVo = new BatchVo();
		batchVo.setBcd("01");		//일실적 배치 : 01
		batchVo.setSt("01");		//배치 실행상태 : 01 - 진행중

		/***When***/
		logger.debug("before insertBatch batchVo.getBid() : {}", batchVo.getBid()); 
		int insertCnt = batchDao.insertBatch(batchVo);
		logger.debug("after insertBatch batchVo.getBid() : {}", batchVo.getBid());

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	/** 
	 * Method   : updateBatchTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 배치데이터 업데이트 테스트
	 */
	@Test
	public void updateBatchTest() {
		/***Given***/
		BatchVo batchVo = new BatchVo();
		batchVo.setBcd("01");		//일실적 배치 : 01
		batchVo.setSt("01");		//배치 실행상태 : 01 - 진행중
		
		batchDao.insertBatch(batchVo);			//bid가 들어가 있는상태
		
		logger.debug("bid : {}", batchVo.getBid());
		
		batchVo.setSt("02");		//배치 실행상태 : 01 - 진행중

		/***When***/
		int updateCnt = batchDao.updateBatch(batchVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
}











