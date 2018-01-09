package mybatis.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import board.model.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{
	private Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardVo> getBoardList() {
		logger.debug("{}", "getBoardList()");
		return sqlSession.selectList("getBoardList");
	}

	@Override
	public BoardVo getBoardFileList(BoardVo vo) {
		logger.debug("{}", "getBoardFileList(BoardVo vo)");
		return sqlSession.selectOne("getBoardFileList", vo);
	}
}
