package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.util.model.PageVo;

public interface ILprodDao {

	/**
	 * Method : getAllLprod
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 제품 카테고리 전체 조회
	 */
	List<LprodVo> getAllLprod(SqlSession sqlSession);

	/**
	 * Method : selectLprodPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 제품 카테고리 페이징 조회
	 */
	List<LprodVo> selectLprodPagingList(SqlSession sqlSession, PageVo pageVo);

	/**
	 * Method : getLprodCnt
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 제품 카테고리 건수 조회
	 */
	int getLprodCnt(SqlSession sqlSession);

}
