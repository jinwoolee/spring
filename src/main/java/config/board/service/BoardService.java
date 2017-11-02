package config.board.service;

import java.util.List;  

import config.board.dao.BoardDao;
import board.model.BoardVo;

public interface BoardService {
	public BoardDao getBoardDao();
	
	public void setBoardDao(BoardDao boardDao);
	
	public List<BoardVo> getBoardList(String boardGb);
		
}