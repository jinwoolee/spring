package kr.or.ddit.test.board.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDao implements IBoardDao{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	
	/**
	* Method : getBoardList
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 게시판 리스트를 조회한다
	*/
	@Override
	public void getBoardList() {
		logger.debug("BoardDao.getBoardList()");
	}
}



