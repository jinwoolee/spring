package board.service;

import java.util.Date;
import java.util.List;

import board.dao.BoardDao;
import board.dao.IBoardDao;
import board.model.BoardVo;

public interface BoardService {
	public IBoardDao getBoardDao();

	public void setBoardDao(IBoardDao boardDao);
	
	public List<BoardVo> getBoardList(String boardGb);

	public Date getDate();
}