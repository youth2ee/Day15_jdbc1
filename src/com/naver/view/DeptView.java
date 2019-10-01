package com.naver.view;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptView {
	
	public void view(ResultSet rs) throws Exception{
		
		if(rs.next()) {
			int deptno = rs.getInt(1);
			String dname = rs.getString(2);
			String loc = rs.getString(3);
			
			System.out.println(deptno);
			System.out.println(dname);
			System.out.println(loc);
			
		}
		
	}

}
