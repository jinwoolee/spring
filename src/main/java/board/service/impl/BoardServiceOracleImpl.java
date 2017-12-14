package board.service.impl;

import java.util.Date;
import java.util.List;

import board.dao.BoardDao;
import board.dao.IBoardDao;
import board.model.BoardVo;
import board.service.BoardService;

public class BoardServiceOracleImpl implements BoardService{
	private	IBoardDao		boardDao;
	private Date date = new Date();
	
	public IBoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(IBoardDao boardDao) {
		this.boardDao	=	boardDao;
	}
	
	public List<BoardVo> getBoardList(String boardGb) {
		//boardServiceImpl과는 다른 로직이 일부 추가.
		return boardDao.getBoardList(boardGb);
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Override
	public BoardDao getBoardDaoLookupMethod() {
		return null;
	}*/
}
