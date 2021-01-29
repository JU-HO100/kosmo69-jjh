package web.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZipCodeDaoSimulation {

	public static void main(String[] args) {
		ZipCodeDao zDao = new ZipCodeDao();
//		String dong = "가산동";
//		List<ZipCodeVO> dongList = zDao.getZipCodeList2(dong);//request.getParameter
//		List<Map<String,Object>> dongList = zDao.getZipCodeList("공덕동");
//		System.out.println(dongList);
		
		
		
		List<Map<String,Object>> zdoList = zDao.getZdo();
		String zdo = zdoList.toString();
		
		System.out.println(zdo);
//		List<ZipCodeVO> zList = zDao.getZipCodeList2("공덕동");
//		for(ZipCodeVO zVO:zList) {
//			int zipcode = zVO.getZipcode();
//			System.out.println(zipcode);
//		}
		
		/*
		ZipCodeVO[] zVOS = zcDao.getZipCodeList("공덕동");
		for(ZipCodeVO zVO:zVOS) {
			int zipcode = zVO.getZipcode();
			String address = zVO.getAddress();
			System.out.println(zipcode+"-"+address);
		}*/
	}
}
