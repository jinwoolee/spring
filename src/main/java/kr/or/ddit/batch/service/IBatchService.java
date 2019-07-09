package kr.or.ddit.batch.service;

public interface IBatchService {
	
	/** 
	 * Method   : createDaily
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param ym
	 * @return 
	 * Method 설명 : 일실적 일괄 생성
	 */
	int createDaily(String ym);
}
