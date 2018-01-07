package mybatis.board.dao;

import java.util.List;

import board.model.BoardVo;

public interface BoardDao {

	List<BoardVo> getBoardList();

	BoardVo getBoardFileList(BoardVo vo);

}
