package net.tomato_step4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;

import com.util.DBConnectionMgr;

import oracle.jdbc.OracleCallableStatement;

public class ChatDAO {
	//선언부
	CallableStatement 		cstmt 	= null;
	OracleCallableStatement ocstmt 	= null;
	Connection 				con 	= null;
	DBConnectionMgr 		dbMgr 	= DBConnectionMgr.getInstance();
	//로그인 처리 메소드 구현
//	String nickName = null;
	public String procLogin(String mem_id, String mem_pw) {
		String nickName = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_login2020(?,?,?)}");
			cstmt.setString(1, mem_id);//메소드의 파라미터에 입력된 1번째 값을 호출
			cstmt.setString(2, mem_pw);//메소드의 파라미터에 입력된 2번째 값을 호출
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);//java의 sql문에 입력된  VARCHAR 타입의 입력된 값 가져온다.
			cstmt.executeUpdate();
			nickName = cstmt.getString(3);/*닉네임 출력*/
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return nickName;
	}
	public static void main(String[] args) {
		ChatDAO tdao = new ChatDAO();
		String nickName = tdao.procLogin("test", "123");
		
	}
}
