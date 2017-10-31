package board.service.impl;

import java.util.List;

import board.dao.BoardDao;
import board.model.BoardVo;
import board.service.BoardService;

public class BoardServiceOracleImpl implements BoardService{
	private	BoardDao		boardDao;
	
	public BoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao	=	boardDao;
	}
	
	@Override
	public void methodInjection(BoardDao boardDao) {
		this.boardDao	=	boardDao;
		
	}

	public List<BoardVo> getBoardList(String boardGb) {
		//boardServiceImpl과는 다른 로직이 일부 추가.
		return boardDao.getBoardList(boardGb);
	}
}
