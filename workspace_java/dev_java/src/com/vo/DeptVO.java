package com.vo;
//오라클의 컬렴명과 VO의 변수명 Map키값은 반드시 일치시킬것.
public class DeptVO {
	private int deptno = 0;
	private String dname = "";//null로 한다면 nullpointexception에러를 만날수 있다.
	private String loc = "";
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
