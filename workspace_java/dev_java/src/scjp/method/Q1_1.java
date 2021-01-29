package scjp.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import nickname.ZipCodeVO;

class QS1{
	ZipCodeVO zVO = null;
	ZipCodeVO[] zVOS = null;
	public void init() {
		List li 	 = new Vector();
		ArrayList al = new ArrayList();
		Vector v 	 = new Vector();
		zVO = new ZipCodeVO();
		zVO.setZipcode(20509);
		zVO.setAddress("서울시 금천구 가산동");
		li.add(zVO);
		v.add(zVO);
		zVO = new ZipCodeVO();
		zVO.setZipcode(22503);
		zVO.setAddress("서울시 마포구 공덕동");
		li.add(zVO);
		v.add(zVO);
		zVOS = new ZipCodeVO[li.size()];
//		li.copyInto(zVOS);
//		al.copyInto(zVOS);
		v.copyInto(zVOS);
		
	}
}

public class Q1_1 {

	public static void main(String[] args) {
		QS1 qs1 = new QS1();
		qs1.init();
		for(int x=0;x<qs1.zVOS.length;x++) {
			System.out.println("zVOS["+x+"]===>"+qs1.zVOS[x].getZipcode()+","+ qs1.zVOS[x].getAddress());
		}
		
	}

}
