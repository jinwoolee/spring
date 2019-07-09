package kr.or.ddit.batch.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.batch.dao.IBatchDao;
import kr.or.ddit.batch.model.BatchVo;

@Service
public class BatchService implements IBatchService{
	
	@Resource(name="batchDao")
	private IBatchDao batchDao;
	
	/** 
	 * Method   : createDaily
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param ym
	 * @return 
	 * Method 설명 : 일실적 일괄 생성 
	 */
	@Override
	public int createDaily(String ym) {
		//배치 정보 생성
		BatchVo batchVo = new BatchVo();
		batchVo.setBcd("01");			//배치 구분 코드 : 01-일실적 배치
		batchVo.setSt("01");			//배치 상태 코드 : 01-진행중
		batchDao.insertBatch(batchVo);
		
		batchDao.deleteDaily(ym);
		int insertCnt = batchDao.createDaily(ym);
		
		//배치 정보 상태 수정
		batchVo.setSt("02");			//배치 상태 코드 : 02-정상 완료
		batchDao.updateBatch(batchVo);
		
		return insertCnt;
	}

}







