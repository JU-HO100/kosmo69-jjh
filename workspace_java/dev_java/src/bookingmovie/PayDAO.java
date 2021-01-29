package bookingmovie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;


public class PayDAO {
	MDBConnectionMgr 	mdbMgr 	= null;
	Display 			d		= null;
	MovieEvent 			me 		= null;
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 			rs 		= null;
	int result;
	TBookVO sVO = null;
	ArrayList<String> saved_info = null;
	
	public PayDAO() {}
	

	public PayDAO(Display display) {
		this.d = display;
	}


	public PayDAO(MovieEvent movieEvent) {
		this.me = movieEvent;
	}

/////////////////////////////////////최종결재화면에 출력할 값 Select////////////////////////////////////
	public void payInfo(String seq) {
		saved_info = new ArrayList<>();
		MDBConnectionMgr mdbMgr = MDBConnectionMgr.getInstance();
		con = mdbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT T_BOOKNUM, CUS_ID,M_CODE,TITLE,M_TIME,SEAT_CODE,SEAT1,SEAT2,SEAT3,SEAT4,PRICE FROM T_BOOK ");
		//test 
		sql.append(" WHERE T_BOOKNUM = ? ");
		
		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, seq);			
			rs = pstmt.executeQuery();
			Vector<TBookVO> v = new Vector<>();
			TBookVO sVOS[] = null;
			while(rs.next()) {
				sVO = new TBookVO();
				sVO.setT_BOOKNUM(rs.getString("T_BOOKNUM"));
				sVO.setTITLE	(rs.getString("TITLE"));
				sVO.setM_CODE	(rs.getString("M_CODE"));
				sVO.setM_TIME	(rs.getString("M_TIME"));
				sVO.setPRICE	(rs.getString("PRICE"));
				sVO.setSEAT1	(rs.getString("SEAT1"));
				sVO.setSEAT2	(rs.getString("SEAT2"));
				sVO.setSEAT3	(rs.getString("SEAT3"));
				sVO.setSEAT4	(rs.getString("SEAT4"));
				
				
				
				v.add(sVO);
			}
				sVOS = new TBookVO[v.size()]; 
				v.copyInto(sVOS);
		    
				for(int x=0;x<sVOS.length;x++) {
					saved_info.add(sVOS[x].getT_BOOKNUM());//String배열 0번
					saved_info.add(sVOS[x].getTITLE());//1
					saved_info.add(sVOS[x].getM_CODE());//2
					saved_info.add(sVOS[x].getM_TIME());//3
					saved_info.add(sVOS[x].getPRICE());//4
					saved_info.add(sVOS[x].getSEAT1());//5
					if(sVOS[x].getSEAT2()!=null)saved_info.add(sVOS[x].getSEAT2());//5
					if(sVOS[x].getSEAT3()!=null)saved_info.add(sVOS[x].getSEAT3());//6
					if(sVOS[x].getSEAT4()!=null)saved_info.add(sVOS[x].getSEAT4());//7
					
					
				}
		}catch(SQLException se) {
			System.out.println(se.toString());
			System.out.println("[query]=="+sql.toString());
		}catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}//////////// end of finally
		return;	
	}////////////////
/////////////////////////////////////최종결재화면에 출력할 값 Select////////////////////////////////////
	
////////////////////////////// 예매진행과정 취소시 임시예매테이블 값 null로 초기화//////////////////////////
	public void changeTimeSeat (String seq) {
		//오라클 연결 실행
				System.out.println(seq);
				mdbMgr = MDBConnectionMgr.getInstance();
				con = mdbMgr.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE T_BOOK");
				sql.append("    SET M_TIME = NULL,");
				sql.append("    SEAT_CODE = NULL,");
				sql.append("    SEAT1 = NULL,");
				sql.append("    SEAT2 = NULL,");
				sql.append("    SEAT3 = NULL,");
				sql.append("    SEAT4 = NULL,");
				sql.append("    PRICE = NULL");
				sql.append("    WHERE T_BOOKNUM = ?");
				
				try {
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, seq);
				
				result = pstmt.executeUpdate();
				//System.out.println("insert 변경된 row수"+result);
				}	catch (SQLException se) {
				System.out.println(se.toString());
				System.out.println("[[query]]=="+sql.toString());
				}	catch (Exception e) {
				System.out.println(e.toString());
				}	finally {
					if(pstmt!=null) {
						try {
							pstmt.close();
				    } catch (Exception e2) {
				       // TODO: handle exception
				    }
				 }
					if(con!=null) {
				    try {
				       con.close();
				    } catch (Exception e2) {
				       // TODO: handle exception
				    }
				 }
				}////////////// ☆end of finally
				return;
		}//////////////////// ☆en
////////////////////////////예매진행과정 취소시 임시예매테이블 값 null로 초기화//////////////////////////
	
/////////////////////////////// 확정예매내역으로 예매번호  update ///////////////////////////////////////////
	public void lastIn1 (String booknum, String seq) {
		//오라클 연결 실행
				mdbMgr = MDBConnectionMgr.getInstance();
				con = mdbMgr.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE BOOK SET ");
				sql.append("    BOOKNUM = ? ");
				sql.append("    WHERE T_BOOKNUM= ? ");
				
				try {
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, booknum);
				pstmt.setString(2, seq);
				result = pstmt.executeUpdate();

				System.out.println("insert 변경된 row수"+result);
				}	catch (SQLException se) {
				System.out.println(se.toString());
				System.out.println("[[query]]=="+sql.toString());
				}	catch (Exception e) {
				System.out.println(e.toString());
				}	finally {
					if(pstmt!=null) {
						try {
							pstmt.close();
				    } catch (Exception e2) {
				       // TODO: handle exception
				    }
				 }
					if(con!=null) {
				    try {
				       con.close();
				    } catch (Exception e2) {
				       // TODO: handle exception
				    }
				 }
				}////////////// ☆end of finally
		}//////////////////// ☆en	
///////////////////////////////// 확정예매내역으로 예매번호  update ///////////////////////////////////////////
///////////////////////////////////임시예매내역에서 확정예매내역으로 자료  insert///////////////////////////////////////////	
	public void lastIn2 (String seq) {
		//오라클 연결 실행
				mdbMgr = MDBConnectionMgr.getInstance();
				con = mdbMgr.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO BOOK");
				sql.append("(T_BOOKNUM, CUS_ID, M_CODE, TITLE, M_TIME, SEAT_CODE, SEAT1, SEAT2, SEAT3, SEAT4, PRICE) ");
				sql.append(" SELECT T_BOOKNUM, CUS_ID, M_CODE, TITLE, M_TIME, SEAT_CODE, SEAT1, SEAT2, SEAT3, SEAT4, PRICE ");
				sql.append(" FROM T_BOOK WHERE T_BOOKNUM = ?");
				
				try {
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, seq);
				result = pstmt.executeUpdate();

				}	catch (SQLException se) {
				System.out.println(se.toString());
				System.out.println("[[query]]=="+sql.toString());
				}	catch (Exception e) {
				System.out.println(e.toString());
				}	finally {
					if(pstmt!=null) {
						try {
							pstmt.close();
				    } catch (Exception e2) {
				       // TODO: handle exception
				    }
				 }
					if(con!=null) {
				    try {
				       con.close();
				    } catch (Exception e2) {
				       // TODO: handle exception
				    }
				 }
				}////////////// ☆end of finally
		}//////////////////// ☆en	
/////////////////////////////////임시예매내역에서 확정예매내역으로 자료  insert///////////////////////////////////////////
	////////////////////////////////////////////////

	
}
