package com.naver.t1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naver.util.DBConnector;
import com.naver.view.DeptView;

public class TestDAO3 { //data access object : 데이터베이스에 연결하여 추가,삭제함

	public DeptDTO deptSelectOne(int deptno) {
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs =null;
		DeptDTO dd = null;
		
		try {
			con = DBConnector.getConnect();
			String sql = "select * from dept where deptno=?";
			st = con.prepareStatement(sql);
			
			st.setInt(1, deptno);
			
			rs = st.executeQuery();
			//resultSet은 close시키면 끝나므로 리턴할 수 없다.
			
			if(rs.next()) { //여기서는 dept테이블에서 지정된 deptno에 따른 한줄(횡)만 받으면 되므로 반복문 필요없다.
				dd = new DeptDTO();
				dd.setDeptno(rs.getInt(1));
				dd.setDname(rs.getString(2));
				dd.setLoc(rs.getString(3));
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return dd;

	}//deptSelectOne 메서드 끝


	public void update1(int deptno, String loc) throws Exception {

		//DBConnector db = new DBConnector();
		//객체를 생성자에서 호출해서 생성해도 됨
		//그러나 DBConnector클래스에서 메서드를 static으로 바꿨으므로 객체생성할 필요없다.

		Connection con = DBConnector.getConnect();
		//con.dbconnectot.g

		String sql = "update dept set loc=? where deptno=?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, loc);
		st.setInt(2, deptno);

		int result = st.executeUpdate();

		if(result>0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}

	} //update1 메서드 끝



	public void insert1(int deptno, String dname, String loc) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		PreparedStatement st=null; 
		//쿼리문을 미리 보내고, 거기에 들어가는 데이터를 나중에 보내는 형태

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String sql = "insert into dept (deptno, dname, loc) "
					+"values (?,?,?)"; 
			//preparedStatement는 이상태로 먼저보낸다. 다만 데이터 자리에 ?를 넣어서 보낸다.

			st = con.prepareStatement(sql); //sql문만 먼저 미리 전송한다.

			//?에 데이터값 넣어주기
			st.setInt(1, deptno); //앞자리에 ?가 몇번인지 쓰고, 다음자리에 그 값을 넣어준다.
			st.setString(2, dname); //string이지만 ''안붙여도 된다
			st.setString(3, loc);

			//최종 전송후 결과물 처리
			int result = st.executeUpdate(); //sql문을 미리 보냈으므로 여기는 빈칸으로 보낸다.

			if(result>0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} //insert1 메서드 끝

}
