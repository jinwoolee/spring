package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.prod.model.ProdVo;

@Repository("prodDao")
public class ProdDaoImpl implements IProdDao {

	/**
	 * Method : getProdByLgu
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 카테고리 하위 제품 조회
	 */
	@Override
	public List<ProdVo> getProdByLgu(SqlSession sqlSession, String lgu) {
		List<ProdVo> prodList = sqlSession.selectList("prod.getProdByLgu", lgu);
		return prodList;
	}

}
