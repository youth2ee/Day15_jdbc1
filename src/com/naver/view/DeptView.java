package com.naver.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naver.t1.DeptDTO;

public class DeptView {
	
	public void view(String str) {
		System.out.println(str);
		
	}

	public void view(DeptDTO dd){
		System.out.println(dd.getDeptno());
		System.out.println(dd.getDname());
		System.out.println(dd.getLoc());

	}

}


