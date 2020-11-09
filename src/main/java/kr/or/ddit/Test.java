package kr.or.ddit;

import kr.or.ddit.common.model.PageVo;

public class Test {
	
	static int a = 10;
	
	private int b;
	
	public Test(int b) {
		this.b = b;
	}

	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}

	public static void main(String[] args) {
		
		a=20;
		
		Test t = new Test(5);
		Test t2 = new Test(10);
		System.out.println("t.getB() : " + t.getB());
		System.out.println("t2.getB() : " + t2.getB());
		
		System.out.println("t.a : " + t.a);
		System.out.println("t2.a : " + t2.a);
		
	}
}
