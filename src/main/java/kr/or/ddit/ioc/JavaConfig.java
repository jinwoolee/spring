package kr.or.ddit.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@Configuration
public class JavaConfig {
	
	//boardDao spring bean 등록
	// <bean id="boardDao" class="kr.or.ddit.board.dao.BoardDao"/>
	@Bean(name = {"boardDao"})
	public BoardDaoInf getBoardDao() {
		return new BoardDao();
	}
	
	//boardService spring bean 등록
	@Bean(name= {"boardService"})
	public BoardServiceInf boardService() {
		BoardServiceInf boardService = new BoardService();
		boardService.setBoardDao(getBoardDao());
		
		return boardService;
	}
}











