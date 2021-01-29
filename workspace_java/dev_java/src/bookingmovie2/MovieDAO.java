package bookingmovie2;

import java.awt.Image;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class MovieDAO {
// 선언부
   MDBConnectionMgr 	mdbMgr   	= null;
   Display 				d 			= null;
   Connection 			con         = null;
   PreparedStatement 	pstmt 		= null;
   ResultSet 			rs          = null;
//   MovieEvent me = null;
   // ID, PW 체크 0 or 1
   int result		;
   ArrayList<String> saved_seq = new ArrayList<>();
// 생성자
   public MovieDAO () {  }
   public MovieDAO (Display d) { 
	   this.d = d;
   }
	//	public MovieDAO(MovieEvent me) {
//		this.me = me;
//	}
	// Strat //
///////////////////////// 회 원 가 입 insert /////////////////////////
	public void join ( String id, String pw, String memname, String phone ) {
 		//오라클 연결 실행
 		mdbMgr = MDBConnectionMgr.getInstance();
 		con = mdbMgr.getConnection();
 		StringBuilder sql = new StringBuilder();
 		sql.append("INSERT INTO CUSTOME ( cus_id, cus_pw, cus_name, cus_tel ) ");
		sql.append(" values(?, ?, ?, ?) ");
		System.out.println(id);
		System.out.println(pw);
		try {
	         pstmt = con.prepareStatement(sql.toString());
	         pstmt.setString(1, id);
	         pstmt.setString(2, pw);
	         pstmt.setString(3, memname);
	         pstmt.setString(4, phone);
	         
	         result = pstmt.executeUpdate();
	         System.out.println("insert 변경된 row수"+result);
		}	catch (SQLException se) {
			      System.out.println(se.toString());
			      System.out.println("[[query]]=="+sql.toString());
			   }	catch (Exception e) {
			      System.out.println(e.toString());
			   }	finally { //try catch문 다음에 온다.
				   			  //try에서 오류의 상관없이 반드시 사용해야 할때 쓴다.
				   			  //finally 무조건 실행문 // ex. 서버종료실행문
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
		}//////////////////// ☆end of inSert
///////////////////////// 회원가입 insert /////////////////////////
	
// Strat //
///////////////////////// I D 체 크 /////////////////////////
	public int memberCheckID(String id_t) {
      MovieMemberVO mVOS[] = null;//결정 안됨
      mdbMgr = MDBConnectionMgr.getInstance(); 
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT NVL((SELECT 1 FROM CUSTOME WHERE CUS_ID in ?), 0) res FROM dual ");
      try {
         con =mdbMgr.getConnection();
         pstmt = con.prepareStatement(sql.toString());
         pstmt.setString(1, id_t);
         rs = pstmt.executeQuery();
         while(rs.next()) {
         result=rs.getInt("res");
         }
      } catch (Exception e) {
         System.out.println("Exception:"+e.toString());
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
      return result;
	}
///////////////////////// I D 체 크 /////////////////////////
	
// Strat //
///////////////////////// P W 체 크 /////////////////////////
      public int memberCheckPW(String pw_t) {
          MovieMemberVO mVOS[] = null;//결정 안됨
          mdbMgr = MDBConnectionMgr.getInstance(); 
          StringBuilder sql = new StringBuilder();
          sql.append("SELECT NVL((SELECT 1 FROM CUSTOME WHERE CUS_PW in ? ), 0) res FROM dual ");
          try {
             con =mdbMgr.getConnection();
             pstmt = con.prepareStatement(sql.toString());
             pstmt.setString(1, pw_t);
             rs = pstmt.executeQuery();
             while(rs.next()) {
             result=rs.getInt("res");
             }
          } catch (Exception e) {
             System.out.println("Exception:"+e.toString());
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
          return result;
   }
///////////////////////// P W 체 크 /////////////////////////
      
// Strat //
///////////////////////// 영 화 정 보 불 러 오 기 /////////////////////////
    public MovieMemberVO getMovieList(String movie_code) {
    mdbMgr = MDBConnectionMgr.getInstance(); 
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT title, genre, director, actor, running_time, story ");
    sql.append(" FROM movie ");
    sql.append(" WHERE m_code = ?");
    MovieMemberVO mVO = null;
    try {
       con =mdbMgr.getConnection();
       pstmt = con.prepareStatement(sql.toString());
       pstmt.setString(1, movie_code);
       rs = pstmt.executeQuery();
       if(rs.next()) {
          mVO = new MovieMemberVO();
          mVO.setTitle(rs.getString("title"));
          mVO.setGenre(rs.getString("genre"));
          mVO.setDirector(rs.getString("director"));
          mVO.setActor(rs.getString("actor"));
          mVO.setRunning_time(rs.getString("running_time"));
          mVO.setStory(rs.getString("story"));
       }
    } catch (Exception e) {
       System.out.println("Exception:"+e.toString());
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
    return mVO;
 }
///////////////////////// 영 화 정 보 불 러 오 기 /////////////////////////
///////////////////////// 로그인시에 임시예매번호 insert /////////////////////////
		public void ins_t_booknum(String id) {
		//오라클 연결 실행
		mdbMgr = MDBConnectionMgr.getInstance();
		con = mdbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO T_BOOK (T_BOOKNUM, CUS_ID) ");
		sql.append(" values(BOOK_SEQ.NEXTVAL, ?) ");
	
		
		try {
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, id);
		
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
}
		//////////////////// ☆end of inSert
///////////////////////// 영화선택시 무비코드 insert /////////////////////////
		public void upd_m_code(String m_code, String title, String seq) {
		//오라클 연결 실행
		mdbMgr = MDBConnectionMgr.getInstance();
		con = mdbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE T_BOOK SET ");
		sql.append(" M_CODE = ?, ");
		sql.append(" TITLE = ? ");
		sql.append(" WHERE t_booknum = ?");
		System.out.println(m_code);
		System.out.println(title);
		
		try {
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, m_code);
		pstmt.setString(2, title);
		pstmt.setString(3, seq);
		
		result = pstmt.executeUpdate();
		//System.out.println("insert 변경된 row수"+result);
			}	catch (SQLException se) {
		System.out.println(se.toString());
		System.out.println("[[query]]=="+sql.toString());
			}	catch (Exception e) {
		System.out.println(e.toString());
			}	
		finally {
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
		}
		
		//////////////////// ☆end of inSert
///////////////////////// 시퀀스넘버가져오기 /////////////////////////
		public String getSEQVal(String id) {
			//System.out.println(date+", "+time);
			MovieMemberVO mVO = new MovieMemberVO();
			String seq = null;
			mdbMgr = MDBConnectionMgr.getInstance();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT t_booknum");
			sql.append(" FROM  t_book ");
			sql.append(" WHERE  cus_id = ?");
				
			try {
				con = mdbMgr.getConnection();
				pstmt =con.prepareStatement(sql.toString());			
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();						
				//Vector v = new Vector();
				 if(rs.next()) {
				mVO.setT_Booknum(rs.getNString("t_booknum"));
				 }
				//v.add(sVO);	
//				sVOS = new ScheduleVO[v.size()];
//				v.copyInto(sVOS);
//				System.out.println("1"+sVOS.length);
//				for(int x=0;x<sVOS.length;x++) {
				saved_seq.add(mVO.getT_Booknum());
				
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
//			System.out.println("1"+sVO.getSEAT_CODE());
//			for(String temp : saved_s_code) {
//				System.out.println(temp);
//			}
			seq = saved_seq.get(0);
			//System.out.println(s_code);
			return seq;
		}
///////////////////////// 시퀀스넘버가져오기 /////////////////////////
// Strat //
///////////////////////// 영 화  날  짜  시  간  /////////////////////////     
	public String[] getSCHList() {
    MDBConnectionMgr mdbMgr = MDBConnectionMgr.getInstance();
	con = mdbMgr.getConnection();
	String[] schedule = null;
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT distinct day FROM schedule");
	sql.append(" ORDER BY day asc");
	try {
		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		String imsi = null;
		Vector<String> v= new Vector<String>();
		while (rs.next()) {
			imsi = rs.getString("day");
			v.add(imsi);
		}	
		schedule = new String[v.size()];
		v.copyInto(schedule);
	} catch (Exception e) {
		System.out.println("Exception"+e.toString());
	}
	return schedule;
} 
	
	public void refreshData(String date, String code) {
		System.out.println(date+", "+code);
		MDBConnectionMgr mdbMgr = MDBConnectionMgr.getInstance();
		con = mdbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DAY,TIME,SEAT_CODE FROM SCHEDULE ");
		//test 영화선택창 연동
		//sql.append("SELECT DAY,TIME,SEAT_CODE FROM SCHEDULE ");
		sql.append(" WHERE DAY = ? ");
		sql.append(" AND M_CODE = ? ");
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, date);
			pstmt.setString(2, code);
			rs = pstmt.executeQuery();
			Vector<ScheduleVO> v = new Vector<>();
			ScheduleVO sVOS[] = null;
			ScheduleVO sVO = null;
			while(rs.next()) {
				sVO = new ScheduleVO();
				////////////////////test 영화선택창 연동
				/*		if(movie_select.a==rs.getString("seat_code")) {
						sVO.setDAY(rs.getString("DAY"));
						sVO.setTIME(rs.getString("TIME"))
				}*/
				sVO.setDAY(rs.getString("DAY"));
				sVO.setTIME(rs.getString("TIME"));
				
				v.add(sVO);
			}
				sVOS = new ScheduleVO[v.size()]; 
				v.copyInto(sVOS);
		     if(v.size()>0) {
		            while(d.dtm_sche.getRowCount()>0) {
		            	d.dtm_sche.removeRow(0);
		            }
		     }
				for(int x=0;x<sVOS.length;x++) {
					Vector<Object> oneRow = new Vector<>();
					oneRow.add(0,sVOS[x].getDAY());
					oneRow.add(1,sVOS[x].getTIME());
					d.dtm_sche.addRow(oneRow);
				}
		}catch(SQLException se) {
			System.out.println(se.toString());
			System.out.println("[query]=="+sql.toString());
		}catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
//		d.jf3.add("Center",d.jsp_sche);
	}
///////////////////////// 영 화  날  짜  시  간  /////////////////////////
///////////////////////// 영화시간 좌석코드 UPDATE /////////////////////////
public void upd_m_time(String m_time, String seat_code, String seq) {
//오라클 연결 실행
mdbMgr = MDBConnectionMgr.getInstance();
con = mdbMgr.getConnection();
StringBuilder sql = new StringBuilder();
sql.append("UPDATE T_BOOK SET ");
sql.append(" M_TIME = ?, ");
sql.append(" SEAT_CODE = ? ");
sql.append(" WHERE t_booknum = ?");

try {
pstmt = con.prepareStatement(sql.toString());
pstmt.setString(1, m_time);
pstmt.setString(2, seat_code);
pstmt.setString(3, seq);

result = pstmt.executeUpdate();
//System.out.println("insert 변경된 row수"+result);
}	catch (SQLException se) {
System.out.println(se.toString());
System.out.println("[[query]]=="+sql.toString());
}	catch (Exception e) {
System.out.println(e.toString());
}	
finally {
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
}

//////////////////// ☆end of inSert
	
///////////////////////// 메 인 테 스 트 용  ///////////////////////// 
	public static void main(String[] agrs) {
}
}