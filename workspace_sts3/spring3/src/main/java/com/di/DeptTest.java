package com.di;

public class DeptTest {

	public static void main(String[] args) {
		DeptVO dVO = new DeptVO();
		//dVO.deptno = 10;
		dVO.setDeptno(10);
		new DeptVO(10,"영업부","서울");
		new DeptVO(10,"서울");
	}

}
