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
	
	@Test
	public void getBoardListCacheTest() {
		/***Given***/
		
		//sql mapper 파일에 cache 설정후
		//같은 sql mapper를 호출시 sql 실행 로그가 몇번 작성되는지 확인
		//sql mapper 설정 : <cache></cache> 
		//--> 해당 mapper의 select 문에 대해 cache 설정됨 (mapper 전체에 cache 설정 후, 개별 sql문 마다 미사용 여부 설정 가능)
		// <select id... useCache="false">
		List<BoardVo> boardList = boardDao.getBoardList();
		List<BoardVo> boardList2 = boardDao.getBoardList();

		/***When***/

		/***Then***/
		assertTrue(boardList.size() > 0);
	}
}
