package kr.or.ddit.prod.repository;

import java.util.List;

import kr.or.ddit.prod.model.Prod;

public interface IProdDao {
	
	/**
	* Method : getProdList
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param lprod_gu
	* @return
	* Method 설명 : 제품 리스트 조회
	*/
	List<Prod> getProdList(String lprod_gu);
}
