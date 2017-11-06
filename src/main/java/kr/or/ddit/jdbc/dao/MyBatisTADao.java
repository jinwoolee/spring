package kr.or.ddit.jdbc.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.jdbc.model.BoardVo;

@Repository
public class MyBatisTADao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Transactional(propagation=Propagation.REQUIRED)
	public List<BoardVo> boardList(Map<String, Integer> map){
		return sqlSessionTemplate.selectList("boardList", map);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int boardTotalCnt() {
		return sqlSessionTemplate.selectOne("boardTotalCnt");
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int insertBoard(BoardVo boardVo) {
		return sqlSessionTemplate.insert("insertBoard", boardVo);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int updateBoard(BoardVo boardVo) {
		return sqlSessionTemplate.update("updateBoard", boardVo);
	}
}