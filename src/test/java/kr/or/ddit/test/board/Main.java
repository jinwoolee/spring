package kr.or.ddit.test.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.test.board.dao.BoardDao;
import kr.or.ddit.test.board.dao.IBoardDao;
import kr.or.ddit.test.board.service.BoardService;
import kr.or.ddit.test.board.service.IBoardService;

public class Main {
	public static void main(String[] args) {
		//기존 객체 생성 방법 : new 
		IBoardDao dao = new BoardDao();
		IBoardService boardService = new BoardService();
		boardService.setBoardDao(dao);
		
		
		//1.spring ioc 컨테이너를 이용한 객체 생성
		//  객체를 만드는 설명서를 spring 한테 위임
		ApplicationContext context 	= new ClassPathXmlApplicationContext("classpath:kr/or/ddit/spring/ioc/application-context-test.xml");
		
		//2. 스프링 컨테이너(== ioc 컨테이너)로 부터 원하는 객체를 요청 : DL(Dependency Lookup)
		IBoardDao cDao = (IBoardDao)context.getBean("boardDao");
		cDao.getBoardList();
		
		IBoardService cService = context.getBean("boardService", IBoardService.class);
		cService.getBoardList();
		
		IBoardService cServiceCo = context.getBean("boardServiceCo", IBoardService.class);
		cServiceCo.getBoardList();
	}
}







