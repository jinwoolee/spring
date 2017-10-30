package board.service.impl;

import java.util.List;

import board.dao.BoardDao;
import board.model.BoardVo;
import board.service.BoardService;

public class BoardServiceImpl implements BoardService{

	private	BoardDao boardDao;
	
	public BoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public List<BoardVo> getBoardList(String boardGb) {
		return boardDao.getBoardList(boardGb);
	}

}
