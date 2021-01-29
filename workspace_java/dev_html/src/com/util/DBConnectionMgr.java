package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionMgr {
	public static final String _DRIVER  = "oracle.jdbc.driver.OracleDriver";//ClassNotFoundException
	public static final String _URL 	= "jdbc:oracle:thin:@192.168.0.38:1521:orcl11";
	public static String _USER 			= "scott";//final이 없어서 보안이 안된다.
	public static String _PW 			= "tiger";//보안의 문제로 언제든 바꿀수 있어야 함으로 final을 사용하지 않았다.
	public Connection con = null;
	public static DBConnectionMgr dbmgr = null;//공통코드는 합의해서 하나로 만들면 좋다.
//	public DBConnectionMgr getInstance() {//메소드를 통해서 객체 주입받기
	//싱글톤 패턴에 대해 생각해 보기
	public static DBConnectionMgr getInstance() {//
		if(dbmgr == null) {
			dbmgr = new DBConnectionMgr();
		}
		return dbmgr;
	}
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
	//이 메소드는 싱글톤이 아니다.
	//사용한 자원 반납하기. - 자바 성능 튜닝팀의 권장사항 - 명시적으로 처리하는 코드
	//생성한 역순으로 한다.
	//생성하기 순서 - Connection - PrecparedStatement - ResultSet
	public void freeConnection(Connection con
								   , PreparedStatement pstmt
								   , ResultSet rs) {
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println("Exception ===>"+e.toString());
				}
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						System.out.println("Exception ===>"+e.toString());
					}
			}
				if(con!=null) {
					try {
						con.close();
					} catch (Exception e) {
						System.out.println("Exception ===>"+e.toString());
					}
				}
			}
		}//////////////////////end of freeConnection
	public void freeConnection(Connection con, PreparedStatement pstmt) {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					System.out.println("Exception ===>"+e.toString());
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					System.out.println("Exception ===>"+e.toString());
				}
			}
		}//////////////////////end of freeConnection
}
