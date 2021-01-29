package web.nexa;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import com.nexacro17.xapi.tx.HttpPlatformResponse;
import com.nexacro17.xapi.tx.PlatformException;
import com.nexacro17.xapi.tx.PlatformType;

//서블릿의 대한 자원관리는 톰캣서버가 싱글톤 패턴으로 관리해줌.
//라이프사이클관리도 톰캣의 책임이다.
//그러니까 예외처리 불가하다.

public class EmpDataSet extends HttpServlet {
	Logger logger = Logger.getLogger(EmpDataSet.class);//배달 사고 확인용
	public void doGet(HttpServletRequest req, HttpServletResponse response)
	
	throws ServletException, IOException
	{
		//http://192.168.0.38:9000/nexa2020/nexa/emp/empManagerAction.do
		response.setContentType("text/xml;charset=utf-8");
		PlatformData out_pData = new PlatformData();
		//
		int    nErrorCode  = 0;//-1
		String strErrorMsg = "START";//FAIL
		DataSet ds = new DataSet("out_emp");

		try {    
			/******* JDBC Connection *******/
			Connection conn = null;//물리적으로 떨어져 있는 오라클서버에 연결통로 생성
			Statement  stmt = null;//쿼리문을 담을 전령객체 선언
			ResultSet  rs   = null;//커서를 조작하는 객체 선언
			
			//아이피로 접근하니까 예외처리 해야됨
			try { 
				//오라클 회사제품인걸 확인할 수 있다.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//오라클 서버에 물리적인 정보를 알수 있다.
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.38:1521:orcl11","scott","tiger");
				//Select문을 자바에서 오라클서버로 전달하는 클래스
				stmt = conn.createStatement();
			  	
				/******* SQL ************/
				String SQL;//쿼리문을 담는다.
				SQL  = "SELECT empno    \n" +
					   "     , ename  	\n" +
					   "     , job    	\n" +
					   "     , mgr      \n" +
					   "     , TO_CHAR(hiredate,'YYYY-MM-DD') hiredate \n" +
					   "     , sal  	\n" +
					   "     , comm    	\n" +
					   "     , deptno   \n" +
					   "  FROM emp     	\n" +
					   " WHERE 1=1      \n" ;
				
				System.out.println(SQL);//작성한 쿼리문을 토드에서 테스트해보고 싶다.        
				rs = stmt.executeQuery(SQL);//오라클에게 Select문을 처리해달라고 하기.
				//넥사에서 그린 화면에 그리드에 매칭될 데이터셋 객체를 생성해요.
				//화면에 매칭(id:ds_emp)할 데이터셋 자바에서 초기화 하기
				ds.addColumn("empno" 	,DataTypes.STRING  ,(short)10);
				ds.addColumn("ename"  	,DataTypes.STRING  ,(short)50);
				ds.addColumn("job"    	,DataTypes.STRING  ,(short)10);
				ds.addColumn("mgr"     	,DataTypes.STRING  ,(short)10);
				ds.addColumn("hiredate" ,DataTypes.STRING  ,(short)10);
				ds.addColumn("sal"  	,DataTypes.STRING  ,(short)10);
				ds.addColumn("comm"    	,DataTypes.STRING  ,(short)10);
				ds.addColumn("deptno"  	,DataTypes.STRING  ,(short)10);
				//조회 로우 수 만큼 반복하면서  63번에 추가될 공간을 먼저 확보하고
				while(rs.next())
				{
					int row = ds.newRow();
					//65번부터 읽어온 정보를 초기화해줌.
					ds.set(row ,"empno"     ,rs.getString("empno"));
					ds.set(row ,"ename"     ,rs.getString("ename"));
					ds.set(row ,"job"       ,rs.getString("job"));
					ds.set(row ,"mgr"       ,rs.getString("mgr"));
					ds.set(row ,"hiredate"  ,rs.getString("hiredate"));
					ds.set(row ,"sal"     	,rs.getString("sal"));
					ds.set(row ,"comm"      ,rs.getString("comm"));
					ds.set(row ,"deptno"    ,rs.getString("deptno"));
				}
				
			} catch (SQLException e) {
				nErrorCode = -1;
				strErrorMsg = e.getMessage();
			}    
			
			/******** JDBC Close ********/
			if ( stmt != null ) try { stmt.close(); } catch (Exception e) {nErrorCode = -1; strErrorMsg = e.getMessage();}
			if ( conn != null ) try { conn.close(); } catch (Exception e) {nErrorCode = -1; strErrorMsg = e.getMessage();}
					
			} catch (Throwable th) {
				nErrorCode = -1;
				strErrorMsg = th.getMessage();
		}
		out_pData.addDataSet(ds);
		nErrorCode  = 0;
		strErrorMsg = "SUCC";
		
//nexa에서 제공하는 클래스로 서버단(서블릿)에서 처리된 결과에 따른 메세지를 전달할때 사용한다.
//서블릿에서 넥사 페이지로 
		VariableList varList = out_pData.getVariableList();
		varList.add("ErrorCode", nErrorCode);
		varList.add("ErrorMsg" , strErrorMsg);
		
		HttpPlatformResponse pRes = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "utf-8");
		pRes.setData(out_pData);

		// Send data
		try {
			pRes.sendData();	
		} catch (PlatformException e) {
			logger.info("PlatformException : "+e.toString());
		}
	}//////////////////////////////////end of doGet
}//////////////////////////////////////end of class
