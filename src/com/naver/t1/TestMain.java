package com.naver.t1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naver.view.DeptView;

public class TestMain {

	public static void main(String[] args) {
		TestDAO td = new TestDAO();
		//td.selectTest();
		//td.selectTest2();
		//td.selectTest3();
		String ename = "smith".toUpperCase();
		//td.selectTest4(ename);

		TestDAO2 td2 = new TestDAO2();
		int deptno=92;
		String dname="TEST";
		String loc="BUSAN";
		//td2.insertTest(deptno,dname,loc);
		//td.selectTest();

		int empno=7778;
		ename="YOUNG";
		String job="CLERK";
		int mgr=7369;
		deptno=20;
		//td2.insertTest2(empno,ename,job,mgr,deptno);

		TestDAO3 td3 = new TestDAO3();
		deptno = 90;
		loc="SEOUL";
		try {
			td3.update1(deptno, loc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		deptno=10;
		DeptView dv = new DeptView();

		DeptDTO dd = td3.deptSelectOne(deptno);
		//받은 부서값에 따른 값이 없으면 리턴받는 값이 null. 따라서 null인 경우는 없는 부서
		if(dd != null) {
			dv.view(dd);
		} else {
			dv.view("없는부서");
		}










	}

}
