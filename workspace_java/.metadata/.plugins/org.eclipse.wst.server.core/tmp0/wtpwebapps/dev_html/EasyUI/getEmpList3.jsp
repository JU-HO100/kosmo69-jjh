<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="web.mvc.EmpDao"%>
<%
		Map<String,Object> pmap = new HashMap<>();
		String g_empno = request.getParameter("g_empno");//사용자가 입력한값으로 바뀜
		if(g_empno!=null){ //g_empno가 null 아닐때 실행 null이면 15번 라인으로 넘어가라
		int empno = Integer.parseInt(g_empno);//사용자가 입력한값(text타입이) int타입으로 바뀐다.
		pmap.put("g_empno",empno);
		}
		String cols = request.getParameter("cols");//empno, ename, sal
		String keyword = request.getParameter("keyword");//
		if (cols != null) {
			if ("empno".equals(cols)) {
				pmap.put("uempno", "empno");
			} else if ("ename".equals(cols)) {
				pmap.put("uename", "ename");
			} else if ("sal".equals(cols)) {
				pmap.put("usal", "sal");
			}
		}
		if (keyword != null) {
			pmap.put("keyword", keyword);//7566 or SMITH or 3000
		}
		StringBuilder sql = new StringBuilder();
		EmpDao dDao = new EmpDao();
		List<Map<String,Object>> empList = dDao.getEmpList(pmap);
		Gson g = new Gson();
		String imsi = g.toJson(empList);
		out.print(imsi);
%>
