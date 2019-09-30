package com.naver.t1;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.transform.Source;

import oracle.jdbc.driver.OracleDriver;

public class TestDAO {
	
	public void selectTest4(String ename) {
		//emp : empno, ename, sal, job
		String user="scott";
		String password="tiger";
		String url="jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			System.out.println("드라이버로딩완료");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("로그인 및 접속성공");
			
			String sql = "select empno,ename,sal,job from EMP where ename='"+ename+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int empno = rs.getInt(1);
				int sal = rs.getInt(3);
				String job = rs.getString(4);
				
				System.out.println(empno);
				System.out.println(ename);
				System.out.println(sal);
				System.out.println(job);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}//selectTest4 메서드 끝
	
	public void selectTest3() {
		//emp : 부서별 급여총합계, 급여평균
		String user="scott";
		String password="tiger";
		String url="jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			System.out.println("드라이버로딩완료");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("로그인 및 접속성공");
			
			String sql = "select deptno,sum(sal) sum,avg(sal) avg from emp group by deptno";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno"); 
				int sum = rs.getInt("sum"); //컬럼명은 출력되는 것으로 한다.
				double avg = rs.getDouble("avg");
				
				System.out.println(deptno);
				System.out.println(sum);
				System.out.println(avg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} //selectTest3 메서드 끝
	
	public void selectTest2() {
		//emp : 이름, 월급, 커미션, 잡, 부서번호
		String user="scott";
		String password="tiger";
		String url="jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			System.out.println("드라이버로딩완료");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("로그인 및 접속성공");
			
			String sql = "select * from emp";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				System.out.println(ename);
				System.out.println(job);
				System.out.println(comm);
				System.out.println(deptno);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} //selectTest2 메서드 끝

	public void selectTest() {
		//<1> 4가지 정보가 필요하다 (id/pw/ip/port/driver class)

		//1. id (String)
		String user ="scott";

		//2. pw (String)
		String password="tiger";

		//3. ip와 port (db가 저장된 ip : port num : sdi)
		String url="jdbc:oracle:thin:@192.168.56.101:1521:xe"; // data source exploer - scott 오른쪽 properties - driver properties - connection url

		//4. driver class 마련
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try {
			//<2> driver를 메모리에 로딩 
			Class.forName(driver);  //객체로 만들기 (다소 예외적) / driver를 메모리에 로딩 / 위에 String으로 받은 문자열을 '클래스'로 만들어서 사용하겠다.
			System.out.println("드라이버 로딩 완료");

			//<3> connection 정보를 획득하기 (db서버에 로그인하기)
			con = DriverManager.getConnection(url, user, password);
			System.out.println("로그인 및 접속 성공");

			//<4> query 작성
			String sql = "select * from dept"; //자바에서는 query문에 ';'붙이지 않는다.

			//<5> query 전송준비
			st = con.createStatement(); 

			//<6> query 전송 및 처리
			rs = st.executeQuery(sql);
			
			while(rs.next()) { //한줄읽기. 읽은 줄에 값이 없을때 false뜬다. false뜨면 종료
				// int deptno = rs.getInt("deptno"); //읽은 한줄에서 컬럼명이 deptno인 값을 찾아 넣어주기
				int deptno = rs.getInt(1); //db의 인덱스 번호는 1부터 시작
				String dname = rs.getString("dname"); //읽은 한줄에서 컬럼명이 dname인 값을 찾아 넣어주기
				String loc = rs.getString("loc"); //읽은 한줄에서 컬럼명이 loc인 값을 찾아 넣어주기

				System.out.println(deptno);
				System.out.println(dname);
				System.out.println(loc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} //selectTest 메서드 끝

}
