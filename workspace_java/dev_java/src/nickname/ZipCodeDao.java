package nickname;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

import com.util.DBConnectionMgr;

public class ZipCodeDao {
	 
	DBConnectionMgr dbMgr 	= null;//다른패키지에 있음으로 import를 해야한다.  1.
	Connection con 			= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	public ZipCodeVO[] getZipCodeList(String dong) {//2.
		ZipCodeVO zVOS[] = null;//결정안됨 3.
		dbMgr = DBConnectionMgr.getInstance();//getInstance - 싱글톤 = 하나를 가지고 공유해서 쓴다.
		StringBuilder sql = new StringBuilder();//인스턴스화
        sql.append("SELECT zipcode, address  ") ;//주소번지와 주소 찾기
        sql.append(" FROM zipcode_t          ") ;//zipcode_t 테이블 안에서
        sql.append(" WHERE dong LIKE ? 		 ") ;
		try {
			con = dbMgr.getConnection();//초기화
			pstmt = con.prepareStatement(sql.toString());//객체
			pstmt.setString(1, dong+"%");//%연산자는 모든것 이라는 의미이다. 24번라인의 dong 을 다 보여줘라는 뜻
			rs = pstmt.executeQuery();//데이터베이스에서 데이터를 가져와서 결과 집합을 반환합니다.
									  //이 메서드는 Select 문에서만 실행하는 특징이 있습니다
			ZipCodeVO zVO = null; //ZipCodeVO를 zVO로 다시 선언
			Vector v = new Vector();//Vector를 v로 초기화
			while(rs.next()) {
				zVO = new ZipCodeVO(); //zVO를 ZipCodeVO의 복사본으로 가져옴
				zVO.setZipcode(rs.getInt("zipcode")); //zVO의zipCode는 rs. 
				zVO.setAddress(rs.getString("address")); //zVO의 address
				v.add(zVO);//Vector에 zVO를 입력
			}
			zVOS = new ZipCodeVO[v.size()];
			v.copyInto(zVOS);
		} catch (Exception e) {
			
		}
		return zVOS;
	}
}
