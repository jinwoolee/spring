package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.util.model.PageVo;

public interface ILprodService {

	/**
	 * Method : getAllLprod
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 제품 카테고리 전체 조회
	 */
	List<LprodVo> getAllLprod();

	/**
	 * Method : selectLprodPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 제품 카테고리 페이징 조회
	 */
	Map<String, Object> selectLprodPagingList(PageVo pageVo);

}
