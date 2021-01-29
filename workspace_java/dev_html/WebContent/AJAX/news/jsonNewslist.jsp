<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int x = 1;//전역변수 - 디클러 레이션
	public String newsList(String news[]){
		StringBuilder sb = new StringBuilder();
		sb.append("<table width='200px' border='1'>");
// 		for(int i=0;i<news.length;i++){
			sb.append("<tr><td>"+news[0]+"<br>"+news[1]+"<br>"+news[2]+"</td></tr>");
// 		}
		sb.append("</table>");
		return sb.toString();
	}
%>
<%
	//스크립틀릿
	String news1[] ={"제목1","내용1","작업1"};
	String news2[] ={"제목2","내용2","작업2"};
	String news3[] ={"제목3","내용3","작업3"};
	String datas = "";
	switch(x){
	case 1:
		datas = newsList(news1);
		x++;
		break;
	case 2:
		datas = newsList(news2);
		x++;
		break;
	case 3:
		datas = newsList(news3);
		x=1;//다시 1번뉴스 그룹으로 초기화 했다.
		break;
	}//////////////////////// end of switch
	out.clear();
	out.print(datas);
%>