package oracle.db;

import java.util.ArrayList;
import java.util.List;

import oracledb.DeptVO;

public class VariableTest {
	void m3(List<DeptVO> dList) {/*메소드에 담았다*/
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(10);
		dVO.setDname("영업부");
		dList.add(dVO);
		dVO = new DeptVO();
		dVO.setDeptno(20);
		dVO.setDname("총무부");
		dList.add(dVO);
	}
	
	public static void main(String[] args) {
		VariableTest vt 	= new VariableTest();
		List<DeptVO> dList 	= new ArrayList<>();/*싱글 스레드 -읽고 쓰는 속도가 빠르다 */
		vt.m3(dList);
		for(DeptVO rdVO:dList) {
			System.out.println(rdVO.getDeptno()+","+rdVO.getDname());
		}
	}

}
