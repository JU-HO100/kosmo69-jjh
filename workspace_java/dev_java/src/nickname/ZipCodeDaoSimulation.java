package nickname;

import movieteam.MovieZipCodeSearch;

public class ZipCodeDaoSimulation {

	public static void main(String[] args) {
//		ZipCodeDao zcDao = new ZipCodeDao();
		MovieZipCodeSearch zc = new MovieZipCodeSearch();
		System.out.println(zc.getZdoList());
		
		
		
		
		/*
		ZipCodeVO[] zVOS = zcDao.getZipCodeList("공덕동");
		for(ZipCodeVO zVO:zVOS) {
			int zipcode = zVO.getZipcode();
			String address = zVO.getAddress();
			System.out.println(zipcode+"-"+address);
		}*/
	
	}

}
