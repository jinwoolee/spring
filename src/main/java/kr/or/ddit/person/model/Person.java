package kr.or.ddit.person.model;

import kr.or.ddit.board.repository.BoardRepositoryI;

public class Person {
	private int age;
	private BoardRepositoryI boardRepository;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BoardRepositoryI getBoardRepository() {
		return boardRepository;
	}
	public void setBoardRepository(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}
}
