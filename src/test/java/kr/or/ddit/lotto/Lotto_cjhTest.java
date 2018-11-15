package kr.or.ddit.lotto;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import kr.or.ddit.lotto.LottoMaker_cjh;

public class Lotto_cjhTest {

	@Test
	public void lottoTest() {
		
		//필요한 공의 갯수
		int randomBallsMaxnum = 65;
		//추첨 공의 갯수
		int needBallsMaxNum = 65;
		
		int[] lottoResults =  new LottoMaker_cjh().lottoMaker(randomBallsMaxnum, needBallsMaxNum);
		
		assertNotNull(lottoResults);
		
		System.out.println(Arrays.toString(lottoResults));
		
	}

}
