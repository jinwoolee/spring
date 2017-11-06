package kr.or.ddit.jdbc.dao;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.jdbc.model.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml",
								"/config/spring/context-datasource.xml",
								"/config/spring/context-transaction-annotation.xml"})
public class MybatisTADaoTest {
	Logger logger = LoggerFactory.getLogger(MybatisTADaoTest.class);
	
	@Resource(name="myBatisTADao")
	private MyBatisTADao myBatisTADao; 
	
	@Test
	public void boardListTest() {
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", 1);
		map.put("end", 5);
		
		/***When***/
		List<BoardVo> boardList = myBatisTADao.boardList(map);
		for(BoardVo boardVo : boardList)
			logger.debug(boardVo.toString());

		/***Then***/
		assertNotNull(boardList);
	}
	
	@Test
	public void boardTotalCntTest() {
		/***Given***/

		/***When***/
		int totalCnt = myBatisTADao.boardTotalCnt();
		logger.debug(String.valueOf(totalCnt));
		
		/***Then***/
		assertTrue(totalCnt >= 0);
	}
	
	@Test
	public void boardInsertTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setSeq(-1);
		boardVo.setTitle("제목입니다. ");
		boardVo.setCont("내용입니다. ");
		boardVo.setReg_id("brown");
		
		/***When***/
		int insertCnt = myBatisTADao.insertBoard(boardVo);
		logger.debug("insert cnt : " + insertCnt);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void boardUpdateTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setSeq(-1);
		boardVo.setTitle("수정된 제목입니다. ");
		boardVo.setCont("수정된 내용입니다. ");
		boardVo.setReg_id("brown");
		
		/***When***/
		int updateCnt = myBatisTADao.updateBoard(boardVo);
		logger.debug("updateCnt : " + updateCnt);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}
}