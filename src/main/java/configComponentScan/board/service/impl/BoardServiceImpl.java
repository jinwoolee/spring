package configComponentScan.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import board.model.BoardVo;
import configComponentScan.board.dao.BoardDao;
import configComponentScan.board.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name="boardDao")
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