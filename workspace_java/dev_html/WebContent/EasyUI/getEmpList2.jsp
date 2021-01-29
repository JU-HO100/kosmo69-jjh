<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, web.mvc.*" %>
<%@ page import="com.google.gson.Gson" %>
<% 
	String cols = request.getParameter("cols");
	String keyword = request.getParameter("keyword");
	//쿼리문을 갱신하기 위해서는 원본이 바뀌지 않는 String대신 StringBuilder을 사용한다.
	StringBuilder sql = new StringBuilder();
	
	//입양할때 더 집중해야 한다. -위치의 중요성.  
	//부분적으로 연관되는 것들은 모두 수정해야 한다.
	//실수가 더 많이 발생한다. 
	//위치 먼저 파악을 해야 한다.
	//위치 앞뒤에는 표시를 해주어야 한다.

///////////////////////////////////////////////////////////////////////////////////////////////////////////
		List<Map<String, Object>> empList = new ArrayList<>();//n개 row를 담기 위해서
		Map<String, Object> rmap = null;//선언만 해야한다. - 값음 지금 정하면 안된다.
		//List의 안에 있는 Map은 1개 row만 담게 된다.
		try {    
			/******* JDBC Connection *******/
			Connection conn = null;//물리적으로 떨어져 있는 오라클서버에 연결통로 생성
			Statement  stmt = null;//쿼리문을 담을 전령객체 선언
			ResultSet  rs   = null;//커서를 조작하는 객체 선언
			
// 			cols="ename";
// 			keyword="30";
// 			keyword="'KING'";
			//아이피로 접근하니까 예외처리 해야됨
			try { 
				//오라클 회사제품인걸 확인할 수 있다.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//오라클 서버에 물리적인 정보를 알수 있다.
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.38:1521:orcl11","scott","tiger");
				//Select문을 자바에서 오라클서버로 전달하는 클래스
				stmt = conn.createStatement();
			  	
				/******* SQL ************/
				//테이블 이름과 컬럼명만 바뀐다. - 나머지는 모두 반복이다. - 반복되는 코드는 줄일다. -mybatis을 사용해야하는 이유
				String SQL;//쿼리문을 담는다.
				sql.append("SELECT empno ");
				sql.append("   , ename   ");
				sql.append("   , job   	 ");
				sql.append("   , mgr   	 ");
				sql.append("   , TO_CHAR(hiredate,'YYYY-MM-DD') hiredate");
				sql.append("   , sal   	 ");
				sql.append("   , NVL(comm, 0) as 'COMM'");
				sql.append("   , deptno  ");
				sql.append(" FROM emp    ");
				if(cols!=null && cols.length()>0 && keyword!=null && keyword.length() > 0){
					sql.append(" WHERE " +cols +"="+keyword);
				cols=null;
				keyword=null;
				}
				
// 				System.out.println(SQL);//작성한 쿼리문을 토드에서 테스트해보고 싶다.        
				rs = stmt.executeQuery(sql.toString());//오라클에게 Select문을 처리해달라고 하기.
				//넥사에서 그린 화면에 그리드에 매칭될 데이터셋 객체를 생성해요.
				//화면에 매칭(id:rmap_emp)할 데이터셋 자바에서 초기화 하기 - 오라클에 있는 컬럼을 모두 꺼내서 자바코드를 옮겨보는 연습을 해보자 - *중요(타입과 크기)
				while(rs.next())
				{
					rmap = new HashMap<>();//
// 					int row = rmap.newRow();
					//65번부터 읽어온 정보를 초기화해줌.
					rmap.put("EMPNO" 	,rs.getInt("empno"));//deptno의 type은 숫자이다.
					rmap.put("ENAME" 	,rs.getString("ename"));//deptno의 type은 숫자이다.
					rmap.put("JOB" 		,rs.getString("job"));
					rmap.put("MGR" 		,rs.getInt("mgr"));
					rmap.put("HIREDATE"	,rs.getString("hiredate"));
					rmap.put("SAL"  	,rs.getDouble("sal"));
					rmap.put("COMM"  	,rs.getDouble("comm"));
					rmap.put("DEPTNO"	,rs.getInt("deptno"));
					empList.add(rmap);
				}//////////////////////////end of while ///////////////////////////////////
			
			} catch (SQLException e) {
				out.print("SQLExeption :"+e.toString());
			}//////////////////////////////end of try-catch //////////////////////////////    
			

			/******** JDBC Close ********/
			if ( stmt != null ) try { stmt.close(); } catch (Exception e) {}
			if ( conn != null ) try { conn.close(); } catch (Exception e) {}
		} catch(Exception e){
				out.print("Exeption :"+e.toString());
		}/////////////////////////////////end of try-catch ////////////////////////////// 
		Gson g = new Gson();//google에서 제공하는 API
		String imsi = g.toJson(empList);//
// 		out.print(deptList);
		out.print(imsi);
		//위의 2가지 경우 중 어떤걸 써야 하나?
///////////////////////////////////////////////////////////////////////////////////////////////////////////
%>
