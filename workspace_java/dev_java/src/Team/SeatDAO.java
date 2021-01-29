package Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class SeatDAO {
	MDBConnectionMgr 	mdbMgr 	= null;
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 			rs 		= null;
	int result;
	String seatnum;
	
	public SeatDAO() {
	}
	
	public void SeatNum(String seat1, String seat2, String seat3, String seat4) {
		mdbMgr 	= MDBConnectionMgr.getInstance();
		con 	= mdbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO SEATNUM (String seat1, String seat2, String seat3, String seat4 ) ");
		sql.append(" values(?, ?, ?, ?) ");
		System.out.println(seat1);
		System.out.println(seat2);
		System.out.println(seat3);
		System.out.println(seat4);
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, seat1);
			pstmt.setString(2, seat2);
			pstmt.setString(3, seat3);
			pstmt.setString(4, seat4);
			
			result = pstmt.executeUpdate();
			System.out.println("insert 변경된 row"+result);
		} catch (SQLException se) {
			System.out.println(se.toString());
			System.out.println("[[query]]===>"+sql.toString() );
		}	 catch (Exception e) {
			System.out.println(e.toString());
		}	 finally {
			 if(pstmt != null) {
				 try {
					 pstmt.close();
				 } catch (Exception e2) {
				 }
			 }
			 if(con != null) {
				 try {
					 con.close();
				 } catch (Exception e2) {
					 
				 }
			 }
		}//////////// end of finally
		return;	
	}//////////////// end of insert

}
