package mybatis.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import board.model.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{
	
	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardVo> getBoardList() {
		return sqlSession.selectList("getBoardList");
	}
}
