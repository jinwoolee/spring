package kr.or.ddit.board.repository;

import kr.or.ddit.board.model.BoardVo;

public interface BoardRepositoryI {
	BoardVo getBoard(int boardNo);
}
