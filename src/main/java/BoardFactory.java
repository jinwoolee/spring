import board.dao.BoardDao;
import board.service.BoardService;
import board.service.impl.BoardServiceOracleImpl;

public class BoardFactory {
	private	BoardService boardService;
	
	public BoardService getBoardService(String gb) {
		if(boardService == null) {
			if(gb.equals("oracle"))
				boardService = new BoardServiceOracleImpl();
			else
				boardService = new BoardServiceOracleImpl();
			
	        BoardDao boardDao	= new BoardDao();
	        boardService.setBoardDao(boardDao);
		}
		return boardService;
	}
}