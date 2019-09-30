package com.naver.t1;

public class TestMain {

	public static void main(String[] args) {
		TestDAO td = new TestDAO();
		//td.selectTest();
		//td.selectTest2();
		//td.selectTest3();
		String ename = "smith".toUpperCase();
		td.selectTest4(ename);

	}

}
