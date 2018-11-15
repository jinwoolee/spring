package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface BoardDaoInf {
	
	List<BoardVo> selectBoardList();
}
