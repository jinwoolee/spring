package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

public interface IProdService {

	/**
	 * Method : getProdByLgu
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param lgu
	 * @return
	 * Method 설명 : 카테고리 하위 제품 리스트 조회
	 */
	List<ProdVo> getProdByLgu(String lgu);

}
