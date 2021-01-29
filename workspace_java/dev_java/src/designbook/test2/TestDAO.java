package designbook.test2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnectionMgr;

public class TestDAO {
	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	TestViewVO tVO = null;
	TestSignEvent tse = null;
	LoginEvent le = null;
	
	public TestDAO(TestSignEvent tse) {
		this.tse = tse;
	}
	public TestDAO(LoginEvent le) {
		this.le = le;
	}
	public TestViewVO Login(String MEM_ID, String MEM_PW) {
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		tVO = new TestViewVO();
		sql.append(" SELECT MEM_ID,MEM_PW FROM member69 ");
		sql.append("  WHERE MEM_ID = ? ");
		sql.append("  AND   MEM_PW = ? ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, MEM_ID);//Login메소드 파라미터의 1번째 자리
			pstmt.setString(2, MEM_PW);//Login메소드 파라미터의 2번째 자리
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tVO.setMEM_ID(rs.getString("MEM_ID"));
				tVO.setMEM_PW(rs.getString("MEM_PW"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tVO;
	}
	public TestViewVO SingUpjon(String MEM_ID) {
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		tVO = new TestViewVO();
		sql.append(" SELECT MEM_ID FROM member69 ");
		sql.append(" WHERE MEM_ID = ? ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, MEM_ID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tVO.setMEM_ID(rs.getString("MEM_ID"));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return tVO;
	}
	public int SingUpins(String MEM_ID, String MEM_PW, String MEM_NAME, String ZIPCODE) {
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int rs = 0;
		sql.append(" INSERT INTO member69(MEM_ID, MEM_PW,MEM_NAME,ZIPCODE)  VALUES(?,?,?,?)");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareCall(sql.toString());
			pstmt.setString(1, MEM_ID);
			pstmt.setString(2, MEM_PW);
			pstmt.setString(3, MEM_NAME);
			pstmt.setString(4, ZIPCODE);
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

}
