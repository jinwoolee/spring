import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import board.dao.BoardDao;
import board.model.BoardVo;
import board.service.BoardService;
import board.service.impl.BoardServiceImpl;

public class Main {
	
	
	public static void main(String[] args) {
		//classpath xml
		ApplicationContext	xmlContext				=	new ClassPathXmlApplicationContext(new String[] {"classpath:application-context.xml"});
		
		//classpath
		ApplicationContext	genericXmlContext		=	new GenericXmlApplicationContext("classpath:application-context.xml");
		
		//file
		ApplicationContext	genericXmlFileContext	=	new GenericXmlApplicationContext("file:/Applications/ljw/lecture_workspace/springBean/src/main/resources/application-context.xml");

		//java config
		//ApplicationContext	annotationConfigContext	=	new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		BoardDao boardDao = xmlContext.getBean("boardDao", BoardDao.class);
		List<BoardVo> daoBoardList = boardDao.getBoardList("test");
		for(BoardVo vo : daoBoardList)
			System.out.println(vo);
		
		BoardService boardService = xmlContext.getBean("boardService", BoardServiceImpl.class);
		List<BoardVo> boardServiceList = boardService.getBoardList("test");
		for(BoardVo vo : boardServiceList)
			System.out.println(vo);
	}
}