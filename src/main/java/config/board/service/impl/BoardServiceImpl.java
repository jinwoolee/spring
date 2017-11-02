package config.board.service.impl;

import java.util.List; 

import board.model.BoardVo;
import config.board.dao.BoardDao;
import config.board.service.BoardService;

public class BoardServiceImpl implements BoardService{
	
	private	BoardDao boardDao;
	
	public BoardServiceImpl() {
		
	}
	
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