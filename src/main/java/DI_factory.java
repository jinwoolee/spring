import board.dao.BoardDao;
import board.service.BoardService;

public class DI_factory {
	public static void main(String[] args) {
		BoardFactory boardFactory	= new BoardFactory();
		BoardService boardService	= boardFactory.getBoardService("oracle");
	}
}
