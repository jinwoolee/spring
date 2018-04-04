package board.service.impl;

import java.util.List;

import board.dao.BoardDao;
import board.model.BoardVo;
import board.service.BoardService;

public abstract class BoardAbstractService implements BoardService{
	
	public List<BoardVo> getBoardList(String boardGb) {
		return getBoardDaoLookupMethod().getBoardList(boardGb);
	}
	
	//매번 새로운 bean을 생성하는 방법
	//1.<aop:scoped-proxy>
	//2.lookup method
	public abstract BoardDao getBoardDaoLookupMethod();
}