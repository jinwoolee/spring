package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.model.BoardVo;

public interface BoardService {
	public BoardDao getBoardDao();

	public void setBoardDao(BoardDao boardDao);
	
	public void methodInjection(BoardDao boardDao);
	
	public List<BoardVo> getBoardList(String boardGb);
		
}