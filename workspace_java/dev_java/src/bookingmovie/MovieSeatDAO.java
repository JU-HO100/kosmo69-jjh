package bookingmovie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;


public class MovieSeatDAO {

	MDBConnectionMgr mdbMgr	 = null;
	Connection con			 = null;
	PreparedStatement pstmt  = null;
	ResultSet rs 			 = null;
	int result;
	ArrayList<String> savedseat = new ArrayList<>();
	ArrayList<String> saved_s_code = new ArrayList<>();
	MovieSeatVO mVO = new MovieSeatVO();
	ScheduleVO sVO = new ScheduleVO();
	//SeatTest3 st3 = null;
	MovieEvent me = null;
	
	public MovieSeatDAO() {
		// TODO Auto-generated constructor stub
	}
	public MovieSeatDAO(MovieEvent me) {
		this.me = me;
	}
	public String getSeatCode(String date, String time) {
		//System.out.println(date+", "+time);
		String s_code = null;
		mdbMgr = MDBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT seat_code");
		sql.append(" FROM  schedule ");
		sql.append(" WHERE  day = ?");
		sql.append(" AND  time = ?");
			
		try {
			con = mdbMgr.getConnection();
			pstmt =con.prepareStatement(sql.toString());			
			pstmt.setString(1,  date);
			pstmt.setString(2,  time);
			rs = pstmt.executeQuery();						
			 if(rs.next()) {
			sVO.setSEAT_CODE(rs.getString("seat_code"));
			 }
		
			saved_s_code.add(sVO.getSEAT_CODE());
			
		} catch(Exception e) {
			
		}
		finally {  
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {}
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {}
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {}
            }            
        }

		s_code = saved_s_code.get(0);
		//System.out.println(s_code);
		return s_code;
	}
	
	
	
	public void getSeatInfoList(String s_code) {
		
		mdbMgr = MDBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT *");
		sql.append(" FROM   seat");
		sql.append(" WHERE  s_code = ?");
		savedseat.clear();
		try {
			con = mdbMgr.getConnection();
			pstmt =con.prepareStatement(sql.toString());			
			pstmt.setString(1,  s_code);
			rs = pstmt.executeQuery();						
			Vector v = new Vector();
			while(rs.next()) {
				
				
				mVO.setA1(rs.getNString("a1"));
				mVO.setA2(rs.getNString("a2"));
				mVO.setA3(rs.getNString("a3"));
				mVO.setA4(rs.getNString("a4"));
				mVO.setA5(rs.getNString("a5"));
				mVO.setA6(rs.getNString("a6"));
				
				mVO.setB1(rs.getNString("b1"));
				mVO.setB2(rs.getNString("b2"));
				mVO.setB3(rs.getNString("b3"));
				mVO.setB4(rs.getNString("b4"));
				mVO.setB5(rs.getNString("b5"));
				mVO.setB6(rs.getNString("b6"));
				
				mVO.setC1(rs.getNString("c1"));
				mVO.setC2(rs.getNString("c2"));
				mVO.setC3(rs.getNString("c3"));
				mVO.setC4(rs.getNString("c4"));
				mVO.setC5(rs.getNString("c5"));
				mVO.setC6(rs.getNString("c6"));
				
				mVO.setD1(rs.getNString("d1"));
				mVO.setD2(rs.getNString("d2"));
				mVO.setD3(rs.getNString("d3"));
				mVO.setD4(rs.getNString("d4"));
				mVO.setD5(rs.getNString("d5"));
				mVO.setD6(rs.getNString("d6"));
				
				mVO.setE1(rs.getNString("e1"));
				mVO.setE2(rs.getNString("e2"));
				mVO.setE3(rs.getNString("e3"));
				mVO.setE4(rs.getNString("e4"));
				mVO.setE5(rs.getNString("e5"));
				mVO.setE6(rs.getNString("e6"));
				v.add(mVO);	
			}
			MovieSeatVO bVOS[] = new MovieSeatVO[v.size()];
			v.copyInto(bVOS);
			
			for(int x=0;x<bVOS.length;x++) {
			savedseat.add(bVOS[x].getA1());
			savedseat.add(bVOS[x].getA2());
			savedseat.add(bVOS[x].getA3());
			savedseat.add(bVOS[x].getA4());
			savedseat.add(bVOS[x].getA5());
			savedseat.add(bVOS[x].getA6());
			savedseat.add(bVOS[x].getB1());
			savedseat.add(bVOS[x].getB2());
			savedseat.add(bVOS[x].getB3());
			savedseat.add(bVOS[x].getB4());
			savedseat.add(bVOS[x].getB5());
			savedseat.add(bVOS[x].getB6());
			savedseat.add(bVOS[x].getC1());
			savedseat.add(bVOS[x].getC2());
			savedseat.add(bVOS[x].getC3());
			savedseat.add(bVOS[x].getC4());
			savedseat.add(bVOS[x].getC5());
			savedseat.add(bVOS[x].getC6());
			savedseat.add(bVOS[x].getD1());
			savedseat.add(bVOS[x].getD2());
			savedseat.add(bVOS[x].getD3());
			savedseat.add(bVOS[x].getD4());
			savedseat.add(bVOS[x].getD5());
			savedseat.add(bVOS[x].getD6());
			savedseat.add(bVOS[x].getE1());
			savedseat.add(bVOS[x].getE2());
			savedseat.add(bVOS[x].getE3());
			savedseat.add(bVOS[x].getE4());
			savedseat.add(bVOS[x].getE5());
			savedseat.add(bVOS[x].getE6());
			}
		} catch(Exception e) {
			
		}
		finally { 
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {}
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {}
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {}
            }            
        }	
	}
	///////////////////////잔여좌석정보//////////////////////////
	public int real_seatinfo(String s_code) {
		int cnt = 0;
		getSeatInfoList(s_code);
		for(int x=0;x<savedseat.size();x++) {
				if(savedseat.get(x)==null) {
				cnt++;
				}
		}
		return cnt;
	}
	///////////////////////잔여좌석정보///////////////////////////
	///////////////////////임시예매내역에 선택좌석 업데이트/////////////////////////////
	public void upd_t_booknum(String seq) {
		//오라클 연결 실행
		System.out.println(seq);
		mdbMgr = MDBConnectionMgr.getInstance();
		con = mdbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE T_BOOK SET");
		int j=1;
		for(j=1;j<me.sldseat.length;j++) {
			sql.append(" seat"+j+" = ?,");
		}
		sql.append(" seat"+j+" = ?,");
		sql.append(" price = ?");
		sql.append(" WHERE t_booknum = ?");
		
		
		
		try {
		int i = 1;
		j = 0;
		pstmt = con.prepareStatement(sql.toString());
		for(i=1;i<= me.sldseat.length;i++) {
		pstmt.setString(i, me.sldseat[j]);
		System.out.println(me.sldseat[j]);
		j++;
		}
		int p = 9000;
		pstmt.setString(i,""+((i-1)*p));
		pstmt.setString(++i, seq);
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
		return;
}//////////////////// ☆en	
///////////////////////임시예매내역에 선택좌석 업데이트/////////////////////////////	
	
//////////////////////////////결제완료후 좌석에 예매좌석확정시키기/////////////////////////////////	 
	 public int updSeat(String booknum, String s_code) {
//		 System.out.println(booknum+", "+s_code);
		 int result = 0;
	      con = mdbMgr.getConnection();
	      int j = 0;
	      StringBuilder sql = new StringBuilder();
			sql.append("UPDATE seat SET ");
			for(j=0;j<(me.sldseat.length-1);j++) {
			sql.append(" "+me.sldseat[j]+" = ?,");
			}
			sql.append(" "+me.sldseat[j]+" = ?");
			sql.append(" WHERE s_code = ?");
//			System.out.println(sql);
			try {
				int i = 1;
				pstmt = con.prepareStatement(sql.toString());
				for(i=1;i<= me.sldseat.length;i++) {
				pstmt.setString(i, booknum);
				}
				pstmt.setString(i, s_code);
				result= pstmt.executeUpdate();
			}catch (Exception e) {
		    	 e.printStackTrace();
		}
			finally { 
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException e) {}
	            }
	            if (pstmt != null) {
	                try {
	                    pstmt.close();
	                } catch (SQLException e) {}
	            }
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (SQLException e) {}
	            }            
	        }
//			System.out.println("오류확인용");
			
		return result;
				
	   }  

}
