package annotation.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import board.model.BoardVo;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BoardDao {
	
	public List<BoardVo> getBoardList(String boardGb) {
		//db에서 조회가 된 결과 라고 생각하자.          
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		boardList.add(new BoardVo("title--1", "content--1", "brown", "2017-10-30"));
		boardList.add(new BoardVo("title--2", "content--2", "brown", "2017-10-30"));
		boardList.add(new BoardVo("title--3", "content--3", "brown", "2017-10-30"));
		
		return boardList;
	}
}