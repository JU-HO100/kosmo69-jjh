package com.basic;import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A extends Object {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			//Tomcat서버에서 요청한게 아니기 때문에 NullPointerException이 발생한다.
			//
			res.sendRedirect("/index.jsp");//NullPointerException발생
		} catch (IOException e) {
			e.printStackTrace();//디버깅
		}
		
	}
	public static void main(String[] args) {
		A a = new A();
		HttpServletRequest req = null;
		HttpServletResponse res = null;
		//doGet메소드를 내가 호출하였다. -개발자 - 그래서 NullPointerException이 발생
		//톰캣서버랑 통신만 할 수 있다면 직접 호출하지 않아도 된다. - CallBack 메소드
		//누가 호출하나요? 서버(톰캣) - 언제호출하나요? xxx.do로 요청했을 때
		//누가 주입해주나요? 톰캣 - 
		a.doGet(req, res);
	}
}
