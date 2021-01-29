package book.ch5;

import nickname.DeptVO;

public class DeptVoSimulation {
	public static void main(String[] args) {//로우(가로)타입의 주소번지는 한번에 한가지만 담을수 있어서 인스턴스화를 추가할때마다 해야한다
		DeptVO dVO = new DeptVO();
		DeptVO[] dVOS = new DeptVO[3];
		dVO.setDeptno(10);
		dVO.setDname("ACCOUNTING");
		dVO.setLoc("NEW YORK");
		dVOS[0] = dVO;
		System.out.println(dVO.getDeptno());
		System.out.println(dVO.getDname());
		System.out.println(dVO.getLoc());//변수이름은 같지만 주소번지는 달라진다
		dVO = new DeptVO();
		dVO.setDeptno(20);
		dVO.setDname("RESEARCH");
		dVO.setLoc("DALLAS");
		dVOS[1] = dVO;
		System.out.println("===================");
		System.out.println(dVO.getDeptno());
		System.out.println(dVO.getDname());
		System.out.println(dVO.getLoc());
		dVO = new DeptVO();
		dVO.setDeptno(30);
		dVO.setDname("SALES");
		dVO.setLoc("CHICAGO");
		dVOS[2] = dVO;
		System.out.println("===================");
		System.out.println(dVO.getDeptno());
		System.out.println(dVO.getDname());
		System.out.println(dVO.getLoc());
		for(int i=0;i<dVOS.length;i++) {//length가 있으면 원소의 갯수를 지정해준다
			DeptVO rVO = dVOS[i];
			System.out.println(rVO.getDeptno()+","+rVO.getDname()+","+rVO.getLoc());
		}
	}//
}
