<%@ page import = "org.apache.commons.logging.*" %>
<%@ page import = "com.nexacro17.xapi.data.*" %>
<%@ page import = "com.nexacro17.xapi.tx.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.io.*" %>
<%@ page contentType = "text/xml; charset=UTF-8" %>

<%
	String _DRIVER  = "oracle.jdbc.driver.OracleDriver";//ClassNotFoundException
	String _URL = "jdbc:oracle:thin:@192.168.0.38:1521:orcl11";
	String _USER = "scott";//final이 없어서 보안이 안된다.
	String _PW = "tiger";//보안의 문제로 언제든 바꿀수 있어야 함으로 final을 사용하지 않았다.

// PlatformData
PlatformData out_pData = new PlatformData();
String sDept = (request.getParameter("sDept") == null) ? "" : request.getParameter("sDept");
	
int    nErrorCode  = 0;
String strErrorMsg = "START";

try {    
	/******* JDBC Connection *******/
	Connection con = null;
	Statement  stmt = null;
	ResultSet  rs   = null;
	
	try { 
		
		Class.forName(_DRIVER);//드라이버 찾기 최적화
		con = DriverManager.getConnection(_URL, _USER, _PW);//"인스턴스화", 연결통로 , con으로 받았음
		stmt = con.createStatement();
	  
		/******* SQL ************/
		String SQL;
		SQL  = "SELECT empno    \n" +
			   "     , ename  \n" +
			   "     , deptno    \n" +
			   "  FROM emp     \n" +
			   " WHERE 1=1        \n" ;
		
		System.out.println(SQL);        

		rs = stmt.executeQuery(SQL);
	  
		DataSet ds = new DataSet("out_emp");
		ds.addColumn("empno" 	  ,DataTypes.INT  ,(short)10 );
		ds.addColumn("ename"  ,DataTypes.STRING  ,(short)50 );
		ds.addColumn("deptno"    ,DataTypes.INT  ,(short)10 );
		
			
		while(rs.next())//커서를 이동하면서
		{
			int row = ds.newRow();//데이터셋에 로우를 추가하고
			ds.set(row ,"empno"     ,rs.getInt("empno")  );
			ds.set(row ,"ename"     ,rs.getString("ename"));
			ds.set(row ,"deptno"    ,rs.getInt("deptno")  );
			
		}
		  
		// #1 dataset -> PlatformData
		out_pData.addDataSet(ds);

		// #2 dataset -> PlatformData
		//DataSetList dsList = out_pData.getDataSetList();
		//dsList.add(ds);

		nErrorCode  = 0;
		strErrorMsg = "SUCC";
		
	} catch (SQLException e) {
		nErrorCode = -1;
		strErrorMsg = e.getMessage();
	}    
	
	/******** JDBC Close ********/
	if ( stmt != null ) try { stmt.close(); } catch (Exception e) {nErrorCode = -1; strErrorMsg = e.getMessage();}
	if ( con != null ) try { con.close(); } catch (Exception e) {nErrorCode = -1; strErrorMsg = e.getMessage();}
			
	} catch (Throwable th) {
		nErrorCode = -1;
		strErrorMsg = th.getMessage();
}

VariableList varList = out_pData.getVariableList();
varList.add("ErrorCode", nErrorCode);
varList.add("ErrorMsg" , strErrorMsg);


/*
Variable varErrCD = new Variable("ErrorCode");
varErrCD.set(nErrorCode);

Variable varErrMSG = new Variable("ErrorMsg");
varErrMSG.set(strErrorMsg);

out_pData.addVariable(varErrCD);
out_pData.addVariable(varErrMSG);
*/

HttpPlatformResponse pRes = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "utf-8");
pRes.setData(out_pData);

// Send data
pRes.sendData();
%>
