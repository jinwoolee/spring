package board.service.impl;

import java.util.List;

import board.dao.BoardDao;
import board.model.BoardVo;
import board.service.BoardService;

public abstract class BoardAbstractService implements BoardService{
	
	public List<BoardVo> getBoardList(String boardGb) {
		return getBoardDaoLookupMethod().getBoardList(boardGb);
	}
	
	public abstract BoardDao getBoardDaoLookupMethod();
}