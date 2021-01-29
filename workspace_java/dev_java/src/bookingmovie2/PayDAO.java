package bookingmovie2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Team.MDBConnectionMgr;
import Team.Pay;

public class PayDAO {
	MDBConnectionMgr 	mdbMgr 	= null;
	Display 			d		= null;
	MovieEvent 			me 		= null;
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 			rs 		= null;
	int result;
	TBookVO sVO = null;
	
	public PayDAO() {
	}
	

	public PayDAO(Display display) {
		this.d = display;
	}


	public PayDAO(MovieEvent movieEvent) {
		this.me = movieEvent;
	}


	public void payInfo(String CUS_ID, String M_CODE) {
		System.out.println();
		MDBConnectionMgr mdbMgr = MDBConnectionMgr.getInstance();
		con = mdbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT T_BOOKNUM,CUS_ID,M_CODE,TITLE,M_TIME,SEAT1,SEAT2,SEAT3,SEAT4,PRICE FROM T_BOOK ");
		//test 
		sql.append(" WHERE CUS_ID = ? ");
		sql.append(" AND M_CODE = ? ");
		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, CUS_ID);
			pstmt.setString(2, M_CODE);
			
			
			rs = pstmt.executeQuery();
			Vector<TBookVO> v = new Vector<>();
			TBookVO sVOS[] = null;
			while(rs.next()) {
				sVO = new TBookVO();
				sVO.setT_BOOKNUM(rs.getString("T_BOOKNUM"));
				sVO.setCUS_ID	(rs.getString("CUS_ID"));
				sVO.setM_CODE	(rs.getString("M_CODE"));
				sVO.setTITLE	(rs.getString("TITLE"));
				sVO.setM_TIME	(rs.getString("M_TIME"));
				sVO.setSEAT1	(rs.getString("SEAT1"));
				sVO.setSEAT2	(rs.getString("SEAT2"));
				sVO.setSEAT3	(rs.getString("SEAT3"));
				sVO.setSEAT4	(rs.getString("SEAT4"));
				sVO.setPRICE	(rs.getString("PRICE"));
				
				
				v.add(sVO);
			}
				sVOS = new TBookVO[v.size()]; 
				v.copyInto(sVOS);
		     if(v.size()>0) {
		            while(d.dtm_sche.getRowCount()>0) {
		            	d.dtm_sche.removeRow(0);
		            }
		     }
				for(int x=0;x<sVOS.length;x++) {
					Vector<Object> oneRow = new Vector<>();
					oneRow.add(0,sVOS[x].getT_BOOKNUM());
					oneRow.add(1,sVOS[x].getM_CODE());
					oneRow.add(2,sVOS[x].getM_TIME());
					oneRow.add(3,sVOS[x].getSEAT1());
					oneRow.add(4,sVOS[x].getSEAT2());
					oneRow.add(5,sVOS[x].getSEAT3());
					oneRow.add(6,sVOS[x].getSEAT4());
					
					d.dtm_sche.addRow(oneRow);
				}
		}catch(SQLException se) {
			System.out.println(se.toString());
			System.out.println("[query]=="+sql.toString());
		}catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}//////////// end of finally
		return;	
	}//////////////// end of insert
	public static void main(String[] args) {
		PayDAO pDAO = new PayDAO();
		
		
	}
	
	
}
