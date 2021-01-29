package Team;

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
	ArrayList<String> savedseat = new ArrayList<>();
	ArrayList<String> saved_s_code = new ArrayList<>();
	MovieSeatVO mVO = new MovieSeatVO();
	ScheduleVO sVO = new ScheduleVO();
	//SeatTest3 st3 = null;
	MovieEvent me = null;
	
	public MovieSeatDAO() {
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
			//Vector v = new Vector();
			 if(rs.next()) {
			sVO.setSEAT_CODE(rs.getNString("seat_code"));
			 }
			//v.add(sVO);	
//			sVOS = new ScheduleVO[v.size()];
//			v.copyInto(sVOS);
//			System.out.println("1"+sVOS.length);
//			for(int x=0;x<sVOS.length;x++) {
			saved_s_code.add(sVO.getSEAT_CODE());
			
		} catch(Exception e) {
			
		}
		finally { //다쓰면 연결을 해제해야한다. 해제를 안시키면 다른 사용자가 쓸수 없으므로. 닫을때 finally를 사용하여 닫는다.
            // 열렸는지 체크하면서 닫아줘야한다. 값이변경됬는지 보고 열린지 판단 / resultset부터 반대로 확인 > statement > connection 순으로
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
//		System.out.println("1"+sVO.getSEAT_CODE());
//		for(String temp : saved_s_code) {
//			System.out.println(temp);
//		}
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
		finally { //다쓰면 연결을 해제해야한다. 해제를 안시키면 다른 사용자가 쓸수 없으므로. 닫을때 finally를 사용하여 닫는다.
            // 열렸는지 체크하면서 닫아줘야한다. 값이변경됬는지 보고 열린지 판단 / resultset부터 반대로 확인 > statement > connection 순으로
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
	 public int updSeat(String booknum, String s_code) {
		 System.out.println(booknum+", "+s_code);
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
			System.out.println(sql);
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
			finally { //다쓰면 연결을 해제해야한다. 해제를 안시키면 다른 사용자가 쓸수 없으므로. 닫을때 finally를 사용하여 닫는다.
	            // 열렸는지 체크하면서 닫아줘야한다. 값이변경됬는지 보고 열린지 판단 / resultset부터 반대로 확인 > statement > connection 순으로
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
			System.out.println("오류확인용");
			
		return result;
				
	   }   
}
