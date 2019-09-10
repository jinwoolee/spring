package kr.or.ddit.test.board.service;

import kr.or.ddit.test.board.dao.IBoardDao;

public interface IBoardService {

	/**
	* Method : getBoardList
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 게시판 리스트를 조회한다
	*/
	void getBoardList();
	
	void setBoardDao(IBoardDao boardDao);
	
	void setBoardNm(String boardNm);
}







