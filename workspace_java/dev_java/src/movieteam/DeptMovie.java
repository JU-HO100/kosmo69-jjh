package movieteam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DeptMovie {
	DBConnectionMgrMovie    dbMgr  	= new DBConnectionMgrMovie(this);
	   Connection          	con    	= null;
	   PreparedStatement    pstmt  	= null;
	   ResultSet            rs     	= null;
	   SignupEvent 			se 		= null;
	   MovieSignup			ms		= null;
	
	   public DeptMovie() {
	}
	public DeptMovie(SignupEvent signupEvent) {
		this.se = signupEvent;
	}
	
	
	public DeptMovie(MovieSignup movieSignup) {
		this.ms = movieSignup;
	}
	/*****************************************************************************
	    * 회원 등록 구현
	    * @param mm_id    회원아이디
	    * @param mm_hp    회원핸드폰번호
	    * @param mm_pw    회원패스워드
	    * @param mm_name  회원이름
	    * @return       0이면 등록 실패, 1이면 등록 성공
	    ****************************************************************************/
	   public int deptInsert(String MM_ID, int MM_HP, int MM_PW, String MM_NAME) {
	      int result = 0;
	      //insert문 등록
	      StringBuilder sql = new StringBuilder();
	      sql.append("INSERT INTO MOVIEMEMBER(MM_ID,MM_HP,MM_PW,MM_NAME) VALUES(?,?,?,?)");
	      try {
	         con = dbMgr.getConnection();
	         pstmt = con.prepareStatement(sql.toString());
	         pstmt.setString(1, MM_ID);
	         pstmt.setInt(2, MM_HP);
	         pstmt.setInt(3, MM_PW);
	         pstmt.setString(4, MM_NAME);
	         result = pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return result;
	   }
	   /*****************************************************************************
	    * 회원 수정 구현
	    * @param mm_id  아이디
	    * @param mm_hp  회원핸드폰번호
	    * @param mm_pw  회원패스워드
	    * @return       0이면 등록 실패, 1이면 등록 성공
	    ****************************************************************************/
	   public int deptUpdate(String MM_ID, int MM_HP, int MM_PW) {
	      int result = 0;
	      //update문 등록
	      StringBuilder sql = new StringBuilder();
	      sql.append("UPDATE MOVIEMEMBER SET MM_PW=?,MM_HP = ?  WHERE MM_ID = ?");
	      try {
	         con = dbMgr.getConnection();
	         pstmt = con.prepareStatement(sql.toString());
	         pstmt.setInt(1, MM_PW);
	         pstmt.setInt(2, MM_HP);
	         pstmt.setString(3, MM_ID);
	         result = pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return result;
	   }   
	   /****************************************************************************
	    * 회원 삭제 구현
	    * @param   mm_id 아이디
	    * @return  0이면 등록 실패, 1이면 등록 성공
	    ****************************************************************************/
	   public int deptDelete(String MM_ID) {
	      int result = 0;
	      //delete문 등록
	      StringBuilder sql = new StringBuilder();
	      sql.append("DELETE FROM MOVIEMEMBER WHERE MM_DEPTNO = ?");
	      try {
	         con = dbMgr.getConnection();
	         pstmt = con.prepareStatement(sql.toString());
	         pstmt.setString(1, MM_ID);
	         result = pstmt.executeUpdate();         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }      
	      return result;
	   }   
	   
	   /****************************************************************************
	    * 현재 회원 목록 조회 구현
	    * @param  mm_id 아이디
	    * @return List<MovieVO>
	    ***************************************************************************/
	   public List<MemberVO> deptList(String MM_ID) {
	      List<MemberVO> depts = new ArrayList<>();
	      //delete문 등록
	      StringBuilder sql = new StringBuilder();
	      sql.append("SELECT MM_ID FROM MOVIEMEMBER");
//	      sql.append("SELECT MM_ID, setMM_HP, setMM_PW, setMM_NAME FROM MOVIEMEMBER");
	      try {
	         con = dbMgr.getConnection();
	         pstmt = con.prepareStatement(sql.toString());
	         rs = pstmt.executeQuery();
	         MemberVO dVO = null;
	         while(rs.next()) {
	            dVO = new MemberVO();
	            dVO.setMM_ID(rs.getString("MM_ID"));
//	            dVO.setMM_HP(rs.getInt("MM_HP"));
//	            dVO.setMM_PW(rs.getString("MM_PW"));
//	            dVO.setMM_NAME(rs.getString("MM_NAME"));
	            depts.add(dVO);
	         }
	         System.out.println(depts);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return depts;
	   }      
	   public static void main(String[] args) {
		  DeptMovie dm = new DeptMovie();
//	      dm.deptList(0);
	      int result1 = dm.deptInsert("MM_ID",10456789, 1234, "생성");//ID,핸드폰번호,PW,이름
	      int result2 = dm.deptUpdate("MM_ID",10456123, 2345);//ID,핸드폰번호,PW
//	      int result3 = dm.deptDelete(MM_ID);//ID
//	      System.out.println(result1);
	      System.out.println(result1+", "+result2);
//	      System.out.println(result1+", "+result2+", "+result3);
	   }
}
