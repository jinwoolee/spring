import board.dao.BoardDao;
import board.service.BoardService;
import board.service.impl.BoardServiceImpl;

public class DI_interface {
	public static void main(String[] args) {
		BoardService		boardService		=	new	BoardServiceImpl();
		BoardDao			boardDao			=	new	BoardDao();
		boardService.setBoardDao(boardDao);
	}
}
