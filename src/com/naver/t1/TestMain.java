package com.naver.t1;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		ResultSet rs=null;
		try {
			rs = td3.deptSelectOne(deptno);
			DeptView dv = new DeptView();
			dv.view(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		

	}

}
