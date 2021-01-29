package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import nickname.ZipCodeVO;

public class ZipCodedao0 {
	DBConnectionMgr0 dbMgr 	= null;
	Connection con 			= null;
	PreparedStatement pstmt =null;
	ResultSet rs 			= null;
	public ZipCodeVO[] getZipCodeList(String dong) {//객체 배열 9번라인에서 결정이 되지 않아서 String 배열을 썻다.
		ZipCodeVO zVOS[] = null;//결정이 되지 않아 인스턴스화를 할수 없음.
		dbMgr = DBConnectionMgr0.getInstance();
		StringBuilder sql = new StringBuilder();
	sql.append("SELECT zipcode, address   ");
	sql.append("  FROM zipcode_t          ");
	sql.append(" WHERE dong LIKE ?  ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			ZipCodeVO zVO = null;
			Vector v = new Vector();
			while(rs.next()) {
				zVO = new ZipCodeVO();//주소번지를 계속 다르게하기 위함
				zVO.setZipcode(rs.getInt("zipcode"));
				zVO.setAddress(rs.getString("address"));
				v.add(zVO);
			}
			zVOS = new ZipCodeVO[v.size()];//vector에 add한 갯수만큼 반환해준다.
		} catch (Exception e) {
			
		}
		return zVOS;
	}
}

