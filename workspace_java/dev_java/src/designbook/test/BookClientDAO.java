package designbook.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.util.DBConnectionMgr;

import oracle.jdbc.OracleCallableStatement;

public class BookClientDAO {
	//선언
	DBConnectionMgr dbMgr = null;//싱글톤패턴 - 1개를 가지고 여러곳에서 쓴다.
	Connection con = null;//물리적 거리가 있는 서버랑 연결해준다.
	PreparedStatement pstmt = null;//SQL문을 전달해준다.
	ResultSet rs = null;
//	CallableStatement cstmt = null;//프로시저를 오라클에 요청시 사용함.
//	OracleCallableStatement ostmt = null;//오라클에서 제공하는 API
	BookClientVO bVO = null; 
	
	public BookClientDAO() {}
	
	
	
	public BookClientVO Booklogin(String MEM_ID, String MEM_PW) {
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		bVO = new BookClientVO();
		sql.append("SELECT MEM_ID,MEM_PW FROM member69");
		sql.append(" WHERE MEM_ID = ? ");
		sql.append(" AND   MEM_PW = ? ");
		System.out.println("1");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, MEM_ID);
			pstmt.setString(2, MEM_PW);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			bVO.setMEM_ID(rs.getString("MEM_ID"));//setMEM_ID = 메소드이다 ex)가져온다는 의미가 아님.
			bVO.setMEM_PW(rs.getString("MEM_PW"));
			System.out.println("bVO.mem_id===>"+bVO.getMEM_ID());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return bVO;
	}
	
	public int bookinserth(String mem_id, String mem_pw, String mem_name, String gender) {
		StringBuilder sql = new StringBuilder();
		int rs = 0;
		sql.append(" INSERT INTO member69(mem_id,mem_pw,mem_name,gender) VALUES(?,?,?,?) ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareCall(sql.toString());
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pw);
			pstmt.setString(3, mem_name);
			pstmt.setString(4, gender);
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public BookClientVO Bookconf(String MEM_ID) {
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		bVO = new BookClientVO();
		sql.append("SELECT MEM_ID FROM member69");
		sql.append(" WHERE MEM_ID = ? ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, MEM_ID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			bVO.setMEM_ID(rs.getString("MEM_ID"));//setMEM_ID = 메소드이다 ex)가져온다는 의미가 아님.
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return bVO;
	}
}
