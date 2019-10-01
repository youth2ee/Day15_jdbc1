package com.naver.t1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO2 {

	public void insertTest2(int empno, String ename, String job, int mgr, int deptno) {
		//emp 
		//empno, ename, job, mgr :매개변수로 받은 임의값
		//job : 기존의 job 중에 하나를 입력
		//mgr : 기존의 empno 중 하나를 입력
		//deptno : 기존의 dept 부서번호 중 1개

		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		PreparedStatement st=null;

		String hiredate = "1992-07-20";
		int sal = 2500;
		int comm = 400;


		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String sql = "insert into EMP (empno,ename,job,mgr,deptno,hiredate,sal,comm) "+
					"values(?,?,?,?,?,?,?,?)";

			st = con.prepareStatement(sql);
			
			st.setInt(1, empno);
			st.setString(2, ename);
			st.setString(3, job);
			st.setInt(4, mgr);
			st.setInt(5, deptno);
			st.setString(6, hiredate);
			st.setInt(7, sal);
			st.setInt(8, comm);
			
			
			int result = st.executeUpdate(); 

			if(result>0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}



		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}



	}

	public void insertTest(int deptno, String dname, String loc) {
		//deptno:91, 부서명:s1, 지역:인천
		//deptno:92, 부서명:TEST, 지역:부산

		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		Statement st=null;

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);

			String sql = "insert into DEPT (deptno,dname,loc) " + 
					"values("+deptno+",'"+dname+"','"+loc+"')";

			st = con.createStatement();
			int result = st.executeUpdate(sql); 
			// insert는 결과값을 숫자로 받으므로 int result로 받는다.
			//select는 executeQuery로 받고, 나머지 DML은 executeUpdate로 받는다. 

			if(result>0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}
