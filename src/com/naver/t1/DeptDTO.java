package com.naver.t1;

public class DeptDTO { 
	//DTO : data transfer object : 데이터를 운반
	//= VO : value object
	
	//DAO : data access object : 데이터베이스에 연결하여 추가삭제한다. 
	
	//멤버변수 :DTO의 모든 멤버변수의 접근지정자는 private로 되어야 한다.
	//게터세터
	//멤버변수명은 table의 컬럼명과 동일하게
	//DataType은 table컬럼의 DataType과 동일하게
	//디폴트생성자는 존재해야함 따라서 매개변수있는 생성자만들대 디폴트생성자 따로 만들어줘야한다.
	
	private int deptno;
	private String  dname;
	private String loc;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	

}
