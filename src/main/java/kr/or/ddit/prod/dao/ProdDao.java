package kr.or.ddit.prod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.prod.model.ProdVo;

@Repository
public class ProdDao implements IprodDao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ProdVo> getProdList(String prod_lgu) {
		return sqlSession.selectList("getProdList", prod_lgu);
	}

}






