package com.di;

public class DeptVO {
	private int deptno = 0;
	private String dname = null;
	private String loc = null;
	public DeptVO(int i, String string, String string2) {
		this.deptno = i;
		this.dname = string;
		this.loc = string2;
	}
	public DeptVO() {
		// TODO Auto-generated constructor stub
	}
	public DeptVO(int i, String loc) {
		this.deptno = i;
		this.loc = loc;
	}
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
