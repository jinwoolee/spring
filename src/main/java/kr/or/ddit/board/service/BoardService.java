package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.board.dao.IboardDao;

@Transactional
@Service
public class BoardService implements IboardService{
	
	//property or filed
	@Resource(name="boardDao")
	private IboardDao boardDao;
	
	private String name;
	
	public BoardService() {
	}
	
	public BoardService(IboardDao boardDao) {
		this.boardDao = boardDao;
	}

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
