package board.service.impl;

import java.util.Date;
import java.util.List; 

import board.dao.BoardDao;
import board.dao.IBoardDao;
import board.model.BoardVo;
import board.service.BoardService;

public class BoardServiceImpl implements BoardService{
	private	IBoardDao boardDao;
	public Date date = new Date();
	
	public BoardServiceImpl() {
		
	}
	public BoardServiceImpl(IBoardDao boardDao) {
		this.boardDao	=	boardDao;
	}
	
	public IBoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(IBoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public List<BoardVo> getBoardList(String boardGb) {
		return boardDao.getBoardList(boardGb);
	}
	@Override
	public Date getDate() {
		return date;
	}
}