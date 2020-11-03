package kr.or.ddit.board.repository;

import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVo;

/**
* BoardRepository.java
*
* @author SEM
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* SEM 최초 생성
*
* </pre>
*/
@Repository("boardRepository")
public class BoardRepository implements BoardRepositoryI{

	@Override
	public BoardVo getBoard(int boardNo) {
		//db에서 조회를 해야하나, 지금은 설정이 갖춰지지 않았으므로
		//가짜 객체(Mock)를 반환한다
		if(boardNo == 1) {
			return new BoardVo(1, "첫번째 글", "내용");
		}
		else
			return null;
	}

}
