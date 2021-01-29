package Team;

import java.awt.Image;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MovieDAO {
	// 선언부
	   MDBConnectionMgr 	mdbMgr   	= null;
	   Connection 			con         = null;
	   PreparedStatement 	pstmt 		= null;
	   ResultSet 			rs          = null;
	   Display d = null;
	   // ID, PW 체크 0 or 1
	   int result		;
	// 생성자
	   public MovieDAO () {  }
	   public MovieDAO (Display d) { 
		   this.d = d;
	   }
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
		}
	///////////////////////// 영 화  날  짜  시  간  ///////////////////////// 
		
	///////////////////////// 메 인 테 스 트 용  ///////////////////////// 
		public static void main(String[] agrs) {
	}
}
