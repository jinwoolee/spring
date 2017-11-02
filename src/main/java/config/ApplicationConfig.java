package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import config.board.dao.BoardDao;
import config.board.service.BoardService;
import config.board.service.impl.BoardServiceImpl;

@Configuration
public class ApplicationConfig {

	@Bean(name={"boardDao"})
	public BoardDao getBoardDao() {
		return new BoardDao();
	}
	
	@Bean
	public BoardService boardService() {
		BoardService boardService = new BoardServiceImpl();
		boardService.setBoardDao(getBoardDao());
		return boardService;
	}
}