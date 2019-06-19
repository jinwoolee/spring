package kr.or.ddit.board.service;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IboardDao;

public interface IboardService {
	
	String sayHello();
	IboardDao getBoardDao();
}
