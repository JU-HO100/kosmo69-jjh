<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.util.HangulConversion" %>
<%
//커피머신의 번호
	String coffeemaker = request.getParameter("coffeemaker");
//커피주문을 한사람의 이름
	String name = request.getParameter("name");//한글이 깨지지 않게 해줬다.
	for(double i=0;i<9000000000.0;i++){
	   //커피를 만드는 시늉을 한다.시간을 번다.
	}
	//기존에 갖고 있던 정보를 출력버퍼에서 삭제하기
	//이걸 안하면 계속 1번 머신 정보만 유지될 수도 있다.
	out.clear();//1번 머신에서 쓰고 있으니 2번 머신으로 갈수 있게 비워준다.
	out.print(coffeemaker+name);//1번 이순신 , 2번 강감찬
%>