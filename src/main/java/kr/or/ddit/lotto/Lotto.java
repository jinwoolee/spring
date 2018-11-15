package kr.or.ddit.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class Lotto {
	private int ballCount;
	private int lotteryNumber;
	
	public int getBallCount() {
		return ballCount;
	}
	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}
	public int getLotteryNumber() {
		return lotteryNumber;
	}
	public void setLotteryNumber(int lotteryNumber) {
		this.lotteryNumber = lotteryNumber;
	}
	
	public int[] execute() {
		
		int[] winningNumber = new int[lotteryNumber];
		List<Integer> randomList = new ArrayList<Integer>();
		for (int i = 0; i < lotteryNumber; i++) {
			int a = (int) (Math.random() * ballCount + 1);
			boolean chk = false;
			for (int j = 0; j < i; j++) {
				if (a == randomList.get(j)) {
					chk = true;
				}
			}
			if (chk == true) {
				i--;
				continue;
			}
			randomList.add(a);
		}
		
		for(int i=0; i<randomList.size(); i++) {
			winningNumber[i] = randomList.get(i);
		}
		
		return winningNumber;
		
	}
}



