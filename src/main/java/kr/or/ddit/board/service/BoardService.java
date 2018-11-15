package kr.or.ddit.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

//annotation 통해 빈 스캔이 될수 있도록 설정
@Service("boardService")
public class BoardService implements BoardServiceInf{
	
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	public BoardService() {
		
	}
	
	public BoardService(BoardDaoInf boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<BoardVo> selectBoardList() {
		return boardDao.selectBoardList();
	}

	public BoardDaoInf getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(BoardDaoInf boardDao) {
		this.boardDao = boardDao;
	}
	
	

}
