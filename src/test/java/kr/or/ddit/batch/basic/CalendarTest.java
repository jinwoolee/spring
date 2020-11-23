package kr.or.ddit.batch.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalendarTest {

	@Test
	public void test() {
		/***Given***/
		String ym = "202011";

		/***When***/
		String y = ym.substring(0, 4);
		String m = ym.substring(4);

		/***Then***/
		assertEquals("2020", y);
		assertEquals("11", m);
	}

}
