package annotation.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import annotation.board.dao.BoardDao;
import annotation.board.service.BoardService;
import board.model.BoardVo;

@Service("boardService2")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name="boardDao")
	private	BoardDao boardDao;
	
	public BoardServiceImpl() {
		
	}
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao	=	boardDao;
	}
	public void methodInjection(BoardDao boardDao) {
		this.boardDao	=	boardDao;
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