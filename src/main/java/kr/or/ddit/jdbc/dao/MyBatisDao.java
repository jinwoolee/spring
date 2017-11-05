package kr.or.ddit.jdbc.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.jdbc.model.BoardVo;

@Repository
public class MyBatisDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	public List<BoardVo> boardList(Map<String, Integer> map){
		return sqlSessionTemplate.selectList("boardList", map);
	}

	public int boardTotalCnt() {
		return sqlSessionTemplate.selectOne("boardTotalCnt");
	}

	public int insertBoard(BoardVo boardVo) {
		return sqlSessionTemplate.insert("insertBoard", boardVo);
	}

	public int updateBoard(BoardVo boardVo) {
		return sqlSessionTemplate.update("updateBoard", boardVo);
	}
}