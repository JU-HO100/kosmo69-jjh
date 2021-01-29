package oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*데이터의 영속성을 유지하기 위해서 필수로 사용되는 DB서버의 중요한 정보를 재사용할 수 있도록 공통코드로 만들었다.*/
public class DBConnectionMgr {
	public static final String _DRIVER  = "oracle.jdbc.driver.OracleDriver";//ClassNotFoundException
	public static final String _URL 	= "jdbc:oracle:thin:@192.168.38:1521:orcl11";
	public static String _USER 			= "scott";//final이 없어서 보안이 안된다.
	public static String _PW 			= "tiger";//보안의 문제로 언제든 바꿀수 있어야 함으로 final을 사용하지 않았다.
	public Connection con = null;
	//물리적으로 떨어져 있는 오라클 서버와 연결 통로 만들기
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
	public static void main(String args[]) {
		DBConnectionMgr dbMgr = new DBConnectionMgr();
		dbMgr.con = dbMgr.getConnection();
		System.out.println("con=====>"+dbMgr.con);
	}
	/*사용한 자원 반납하기. - 자바 성능 튜닝팀의 권장사항 - 명시적으로 처리하는 코드
	*자바에서는 가비지 컬렉터가 살고 있어서 사용한 자원을 스레드를 활용한 쓰레기 값 청소 스케줄에 따라 삭제 해준다.
	*그러나 스레드 스케줄을 기다리는 시간이 있으므로 동시 접속자를 관리하는 서버제품들의 언어들은 모두 명시적으로 삭제요청할것.
	*가비지 값을 삭제해주세요 -> System.gc();//쓰레기통에 있는 것을 비워주세요.
	*쓰레기 값은 언제 결정될까요?
	*A a = new A(); a = null; a = new A(); 초기화	
	*생성한 역순으로 한다.
	*생성하기 순서 - Connection - PrecparedStatement - ResultSet*/
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
}
