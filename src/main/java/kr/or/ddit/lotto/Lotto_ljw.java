package kr.or.ddit.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.util.CollectionUtils;

public class Lotto_ljw {
	private int noOfBall;			//볼의 갯수
	private int noOfwinningBall;	//당첨번호 갯수
	
	public Lotto_ljw() {
		this.noOfBall = 45;				//기본 당첨 볼긔 갯수 45개
		this.noOfwinningBall = 6; 		//기본 볼의 갯수 3개
	}
	
	public Lotto_ljw(int noOfBall, int noOfWinningBall) {
		this.noOfBall = noOfBall;				
		this.noOfwinningBall = noOfWinningBall; 		
	}
	
	public int getNoOfBall() {
		return noOfBall;
	}

	public void setNoOfBall(int noOfBall) {
		this.noOfBall = noOfBall;
	}

	public int getNoOfwinningBall() {
		return noOfwinningBall;
	}

	public void setNoOfwinningBall(int noOfwinningBall) {
		this.noOfwinningBall = noOfwinningBall;
	}

	/**
	* Method : execute
	* 작성자 : sem
	* 변경이력 :
	* @return
	* Method 설명 : 당첨번호 생성하기 (중복된 번호가 없어야 한다)
	*/
	public int[] execute() {
		int[] winningBalls = new int[noOfwinningBall];
		
		List<Integer> balls = new ArrayList<Integer>();
		for(int i = 1; i <= noOfBall; i++)
			balls.add(i);
		
		Random random = new Random();
		
		for(int i = 0; i < noOfwinningBall; i++) {	
			int ball = balls.get(random.nextInt(balls.size()));
			balls.remove(new Integer(ball));
			winningBalls[i] = ball; 
		}
		
		return duplicateCheck(winningBalls);
	}

	/**
	* Method : duplicateCheck
	* 작성자 : sem
	* 변경이력 :
	* @param winningBallsO
	* @return
	* Method 설명 : 당첨 번호 중복체크
	*/
	public int[] duplicateCheck(int[] winningBalls) {
		List<Integer> balls = CollectionUtils.arrayToList(winningBalls);
		Set<Integer> ballSets = new HashSet<Integer>(balls);
		
		if(balls.size() == ballSets.size() &&
		   ballSets.size()	== noOfwinningBall)
			return winningBalls;
		else 
			return null;
	}

}



