package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.prod.model.ProdVo;

public interface IProdDao {

	/**
	 * Method : getProdByLgu
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param lgu 
	 * @return
	 * Method 설명 : 카테고리 하위 제품 조회
	 */
	List<ProdVo> getProdByLgu(SqlSession sqlSession, String lgu);

}
