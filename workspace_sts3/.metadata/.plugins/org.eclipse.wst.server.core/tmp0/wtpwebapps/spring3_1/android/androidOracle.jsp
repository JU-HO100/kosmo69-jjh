<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	String url = "jdbc:oracle:thin:@192.168.0.38:1521:orcl11";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String mem_id = request.getParameter("memb_id");
	String mem_pw = request.getParameter("memb_pw");
	String mem_name = "";
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT mem_name FROM chat_momber WHERE mem_id='"+mem_id+"AND mem_pw="+mem_pw+"'");
	try{
		//SqlSessionFactoryBean이 사용할 때에는 아래의 코드량이 줄어든다. - 대신해준다
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, "SCOTT", "TIGER");
		stmt = con.createStatement();//SqlSession or SqlSessionTemplate.selectOne|insert|update
		rs = stmt.executeQuery(sql.toString());//<select resulType="map"
		rs.next();
		mem_name = rs.getString("mem_name");
		out.print("서버 연동"+mem_name+"님 환영합니다.");
	} catch(SQLException se) {
		out.print(se.toString());
	} catch(Exception e){
		out.print(e.toString());
	} finally{//품질관리팀 - QC팀 - 자원반납하기 - 명시적 처리
	//사용한 자원 반납하기 - 세션에 대한 누수 방지
		try{
			if(rs!=null) rs.close();//오라클 쪽에서 세션에 대한 누수가 방치되면 더이상 서버 접속 불가
			if(stmt !=null) stmt.close();
			if(con !=null) stmt.close();
		}catch(Exception e){
			
		}
	}
	
%>
