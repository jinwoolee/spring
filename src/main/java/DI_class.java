import board.dao.BoardDao;
import board.service.impl.BoardServiceImpl;

public class DI_class {
	public static void main(String[] args) {
		BoardServiceImpl	boardService		=	new	BoardServiceImpl();
		BoardDao			boardDao			=	new	BoardDao();
		boardService.setBoardDao(boardDao);
	}
}