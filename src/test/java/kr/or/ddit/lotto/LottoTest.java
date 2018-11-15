package kr.or.ddit.lotto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;

public class LottoTest {
	
	@Test
	public void lottoTest() {
		/***Given***/
		Lotto lotto = new Lotto();
		
		/***When***/
		lotto.setBallCount(55);
		lotto.setLotteryNumber(6);
		
		int[] winningNumber = lotto.execute();
		for(int number : winningNumber)
			System.out.println("number : " + number);
		/***Then***/
		assertEquals(6, winningNumber.length);
	}

}
