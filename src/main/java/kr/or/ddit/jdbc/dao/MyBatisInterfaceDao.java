package kr.or.ddit.jdbc.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.jdbc.model.BoardVo;

@Repository
@MyBatis
public interface MyBatisInterfaceDao {

	public List<BoardVo> boardList(Map<String, Integer> map);

	public int boardTotalCnt();

	public int insertBoard(BoardVo boardVo);

	public int updateBoard(BoardVo boardVo);
}