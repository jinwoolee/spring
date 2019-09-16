package kr.or.ddit.lprod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;

@Repository
public class LprodDao implements ILprodDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	* Method : getLprodList
	* 작성자 : SEM-PC
	* 변경이력 :
	* @return
	* Method 설명 : 제품 그룹 리스트 조회
	*/
	@Override
	public List<Lprod> getLprodList() {
		return sqlSession.selectList("lprod.getLprodList");
	}

	/**
	* Method : getLprodPagingList
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 제품 그룹 페이징 리스트 조회
	*/
	@Override
	public List<Lprod> getLprodPagingList(Page page) {
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}

	/**
	* Method : getLprodTotalCnt
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품 그룹 전체 건수 조회
	*/
	@Override
	public int getLprodTotalCnt() {
		return sqlSession.selectOne("lprod.getLprodTotalCnt");
	}

}
