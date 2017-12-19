package kr.or.ddit.jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.jdbc.model.BoardVo;

@Repository
@MyBatis
public interface MyBatisInterfaceDao {

	List<BoardVo> boardList(Map<String, Integer> map);

	int boardTotalCnt();

	int insertBoard(BoardVo boardVo);

	int updateBoard(BoardVo boardVo);
}