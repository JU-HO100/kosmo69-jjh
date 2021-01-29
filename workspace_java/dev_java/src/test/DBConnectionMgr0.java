package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionMgr0 {
	public static String _DRIVER = "oracle.jdbc.driver.OracleDriver";//ClassNotFoundException
	public static String _URL	 = "jdbc:oracle:thin:@192.168.38.1521:orcl11";
	public static String _USER	 = "scott";//final이 없어서 보안이 약하다.
	public static String _PW	 = "tiger";//보안의 문제로 언제든 바꿔야 할 수 있음으로 final를 사용하지 않았다.
	public Connection con = null;
	public static DBConnectionMgr0 dbMgr = new DBConnectionMgr0();//null아닐 때 & 싫을 때  
//	public static DBConnectionMgr0 dbMgr = null;//다른 곳에서 쓰기위해서는 public를 써야한다.
	public static DBConnectionMgr0 getInstance() {//Instance를 직접 접근하고 싶다면 앞에 static를 붙여준다. 싱글톤
		if(dbMgr==null) {//dbMgr이 가리키는게 없다면(null) 인스턴스화 해주세요
			dbMgr = new DBConnectionMgr0();
		}
		return dbMgr;//리턴 값에 오브젝트 타입이 왔다.
		
	}
	//
	public Connection getConnection() {
		try {//예외처리를 하였다. 실행시에 에러가 발생할 가능성이 있는 코드는 try..catch안에 써준다.
			Class.forName(_DRIVER);//드라이버 찾기 최적화
			con = DriverManager.getConnection(_URL, _USER, _PW);//"인스턴스화", 연결통로 , con으로 받았음 
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
		} catch (Exception e) {
			System.out.println("연결실패!!!."+e.toString());			
		}
		return con;
	//	return null; NullPointerException - "인스턴스화 문제로 발생한다.
	}
	//사용한 자원 반납하기
	//생성한 역순으로 한다.
	//생성하기 순서 - 1.Connection - 2.PreparedStatement - 3.ResultSet
	public void freeConnection(Connection con
							, PreparedStatement pstmt
							, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("Exception ====>"+e.toString());
			}
		}
	
		if(pstmt!= null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println("Exception ====>"+e.toString());
			}
		}

		if(con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println("Exception ====>"+e.toString());
			}
		}
	}///////////////////end of freeConnection
}
