package board.dao;

import java.util.ArrayList; 
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.model.BoardVo;

public class BoardDao implements IBoardDao{
	Logger logger = LoggerFactory.getLogger(BoardDao.class);
	
	private	Date date = new Date();
	
	public List<BoardVo> getBoardList(String boardGb) {
		//db에서 조회가 된 결과 라고 생각하자.          
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		boardList.add(new BoardVo("title--1", "content--1", "brown", "2017-10-30"));
		boardList.add(new BoardVo("title--2", "content--2", "brown", "2017-10-30"));
		boardList.add(new BoardVo("title--3", "content--3", "brown", "2017-10-30"));
		
		return boardList;
	}
	
	public static BoardDao getInstance() {
		return new BoardDao();
	}

	@Override
	public Date getDate() {
		return date;
	}
	
	@PostConstruct
	public void sayHello() {
		logger.debug("sayHello");
	}
	
}