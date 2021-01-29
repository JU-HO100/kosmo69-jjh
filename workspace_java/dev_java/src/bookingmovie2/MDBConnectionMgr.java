package bookingmovie2;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MDBConnectionMgr {
	//데이터베이스와 연결하는 객체
	public	Connection				con		=	null;
	public	PreparedStatement	pstmt		=	null;
	public	ResultSet				rs			=	null;
	
	//싱글톤 패턴
	private static MDBConnectionMgr mdbMgr	= new MDBConnectionMgr();
	public static final String _DRIVER		= "oracle.jdbc.driver.OracleDriver";
//	public static final String _URL			= "jdbc.oracle:thin@142.30.1.140:1521:orcl11";
	public static final String _URL			= "jdbc:oracle:thin:@192.168.0.38:1521:orcl11";
	
	public static final String _USER			= "scott";
	public static final String _PW			= "tiger";
	
	//메소드를 통해서 객체 주입 받기, 인스턴스 4레벨
	public static MDBConnectionMgr getInstance() {
		if(mdbMgr == null) {
			mdbMgr = new MDBConnectionMgr();
		}
		return mdbMgr;
	}
	
	//물리적으로 떨어져 있는 오라클 서버와 연결 통로 만들기
	public Connection getConnection () {
		try {//에외처리
			Class.forName(_DRIVER);//1. JDBC 드라이버 로딩.
			//Class.forName(“driver”)을 이용해서 Driver Class를 로딩하면 객체가 생성되고
			//, DriverManager에 등록된다.
			con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (ClassNotFoundException ce) {
			//Driver 클래스를 찾이 못할 경우
			//, ClassNotFoundExcption 예외가 발생
		} catch (Exception e) {
//			System.out.println("연결 실패!!!"+e.toString());

			
//☆☆ 이놈의 역활은? - 에러 메시지 출력하기.
//			** 결과
//			e.getMessage() = 에러내용입니다.
//			e.toString() = java.lang.Exception: 에러내용입니다.
//			e.printStackTrace() = java.lang.Exception: 에러내용입니다.
//			              at ExeThrowException.main(ExeThrowException.java:5)
//
//			** 기능
//			e.getMessage() : 에러 이벤트와 함께 들어오는 메세지 출력
//			e.toString() : 에러 이벤트의 toString()을 호출해서 간단한 에러 메시지 확인
//			e.printStackTrace() : 에러 메세지의 발생 근원지를 찾아 단계별로 에러 출력
			e.printStackTrace();
			
			
		}return con; //NullPointerException 주의
	}
	
//☆☆ 이놈의 역활은? - getConnectionDataSource
//	InitialContext()는 웹 어플리케이션이 처음으로 배치될때 설정되고
//	모든 설정된 엔트리와 자원은 JNDI namespace의 java:comp/env 부분에 놓이게 된다.
//
//	접근 방식은,
//
//	//현재 환경의 naming context 획득하기
//	Context initCtx = new InitialContext();
//	Context envCtx = (Context)init.lookup("java:comp/env");
//
//	//DataSource 찾기
//	DataSource ds =(DataSource)initCtx.lookup("jdbc/OracleDB");
//
//
//	//컨넥션 을 얻어온다.
//	return ds.getConnection();
//
//
//	private Connection getConnection() throws Exception{
//
//	   Context initCtx = new InitialContext();
//	   Context envCtx = (Context)init.lookup("java:comp/env");
//	   DataSource ds =(DataSource)initCtx.lookup("jdbc/OracleDB");
//
//	   return ds.getConnection();
//	}
	   public Connection getConnectionDataSource()
	   {
	      try {
	         Context initCtx = new InitialContext();
	         DataSource ds = 
	            (DataSource)initCtx.lookup("java:comp/env/ibbPool");
	            con = ds.getConnection();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return con;
	   }
//☆☆ 이놈의 역활은? - Connection Pool
//	   커넥션 풀이란 db와 연결하는 커넥션을 미리 생성해두고 풀에 저장해두었다 필요할때 꺼내쓰고,
//	   사용후에는 다시 풀에 반환하는 기법을 말한다.
//	   (멀티쓰레드의 쓰레드풀과 유사하다.)
//	   커넥션을 미리 생성해두기 때문에 커넥션을 사용자가 db를 사용할때마다 매번 생성을 하는것보다
//	   더 빠른 속도를 보장한다.
//	   또한 커넥션의 최대 생성 갯수도 제어해주기 때문에 많은 사용자가 몰려도 과부화를 방지할 수 있다.
	   
	   
	//사용한 자원 반납하기
	//생성한 역순으로 한다.
	//생성하기 순서 - Connection - PreparedStatement - ResultSet
	   
	   public static void freeConnection(ResultSet rs, PreparedStatement pstmt, Connection con){
		      try {
		         if(rs !=null) rs.close();
		         if(pstmt !=null) pstmt.close();
		         if(con !=null) con.close();
		      } catch (Exception e) {
		         e.printStackTrace();
//		         System.out.println("Exception ===> "+e.toString());
		      }
		   }
		   public static void freeConnection(PreparedStatement pstmt, Connection con){
		      try {
		         if(pstmt !=null) pstmt.close();
		         if(con !=null) con.close();
		      } catch (Exception e) {
		         e.printStackTrace();
//		         System.out.println("Exception ===> "+e.toString());
		      }
		   }
		   public static void freeConnection(ResultSet rs, CallableStatement cstmt, Connection con){
		      try {
		         if(rs !=null) rs.close();
		         if(cstmt !=null) cstmt.close();
		         if(con !=null) con.close();
		      } catch (Exception e) {
		         e.printStackTrace();
//		         System.out.println("Exception ===> "+e.toString());
		      }
		   }
		   public static void freeConnection(CallableStatement cstmt, Connection con){
		      try {
		         if(cstmt !=null) cstmt.close();
		         if(con !=null) con.close();
		      } catch (Exception e) {
		         e.printStackTrace();
//		         System.out.println("Exception ===> "+e.toString());
		      }
		   }

	public static void main(String[] args) {
		MDBConnectionMgr mdbMgr = new MDBConnectionMgr();
	    Connection con = mdbMgr.getConnection();
	    System.out.println("con : "+con);
		   }
}
