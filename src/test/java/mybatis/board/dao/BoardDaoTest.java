package mybatis.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import board.model.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value= {"classpath:/mybatis/board/dao/application-context.xml",
							  "classpath:/mybatis/board/dao/context-datasource.xml",
							  "classpath:/mybatis/board/dao/context-transaction.xml"})
public class BoardDaoTest {
	@Resource(name="boardDao")
	private BoardDao boardDao;
	
	@Test
	public void getBoardListTest() {
		/***Given***/
		List<BoardVo> boardList = boardDao.getBoardList();

		/***When***/

		/***Then***/
		assertTrue(boardList.size() > 0);
	}
	
	@Test
	public void getBoardFileListTest() {
		/***Given***/
		BoardVo vo = new BoardVo();
		vo.setBoardno(1);
		
		/***When***/
		BoardVo boardVo = boardDao.getBoardFileList(vo);

		/***Then***/
		assertTrue(boardVo.getFileList().size() > 0);
	}

}
