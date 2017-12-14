package board.dao;

import java.util.Date;
import java.util.List;

import board.model.BoardVo;

public interface IBoardDao {
	public List<BoardVo> getBoardList(String boardGb);
	
	public Date getDate();
}
