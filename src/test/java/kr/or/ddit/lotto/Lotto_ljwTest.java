package kr.or.ddit.lotto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class Lotto_ljwTest {

	/**
	* Method : lottoEecuteTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 당첨번호 생성하기 테스트
	*/
	@Test
	public void lottoEecuteTest() {
		/***Given***/
		int noOfwinningBall = 45;
		Lotto_ljw lotto = new Lotto_ljw();
		lotto.setNoOfwinningBall(noOfwinningBall);

		/***When***/
		int[] winningNumbers = lotto.execute();
		
		/***Then***/
		assertEquals(noOfwinningBall, winningNumbers.length);
		for(int i : winningNumbers)
			System.out.println("ball : " + i);
	}
	
	/**
	* Method : lottoDuplicataeTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 로또번호 중복 체크
	*/
	@Test
	public void lottoDuplicataeTest() {
		/***Given***/
		Lotto_ljw lotto = new Lotto_ljw();
		int[] winningBalls_fail = new int[] {1, 2, 3, 4, 5, 5};
		int[] winningBalls_success = new int[] {1, 2, 3, 4, 5, 6};

		/***When***/
		int[] balls_fail = lotto.duplicateCheck(winningBalls_fail);
		int[] balls_success = lotto.duplicateCheck(winningBalls_success);

		/***Then***/
		assertNull(balls_fail);
		assertEquals(lotto.getNoOfwinningBall(), balls_success.length);
	}

}
