package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.util.model.PageVo;

@Repository("lprodDao")
public class LprodDaoImpl implements ILprodDao {

	/**
	 * Method : getAllLprod
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 제품 카테고리 전체 조회
	 */
	@Override
	public List<LprodVo> getAllLprod(SqlSession sqlSession) {
		List<LprodVo> lprodList = sqlSession.selectList("lprod.getAllLprod");
		return lprodList;
	}

	/**
	 * Method : selectLprodPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 제품 카테고리 페이징 조회
	 */
	@Override
	public List<LprodVo> selectLprodPagingList(SqlSession sqlSession, PageVo pageVo) {
		List<LprodVo> lprodList = sqlSession.selectList("lprod.selectLprodPagingList", pageVo);		
		return lprodList;
	}

	/**
	 * Method : getLprodCnt
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 제품 카테고리 전체 건수 조회
	 */
	@Override
	public int getLprodCnt(SqlSession sqlSession) {
		int totalCnt = sqlSession.selectOne("lprod.getLprodCnt");
		return totalCnt;
	}

}
