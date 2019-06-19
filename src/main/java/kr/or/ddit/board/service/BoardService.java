package kr.or.ddit.board.service;

import kr.or.ddit.board.dao.IboardDao;

public class BoardService implements IboardService{
	
	private IboardDao boardDao;
	private String name;

	@Override
	public String sayHello() {
		return boardDao.sayHello();
	}
	


	public void setBoardDao(IboardDao boardDao) {
		this.boardDao = boardDao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public IboardDao getBoardDao() {
		return this.boardDao;
	}

	
	
}
