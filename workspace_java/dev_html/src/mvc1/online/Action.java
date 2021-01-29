package mvc1.online;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Action {
		//void 자리에 클래스를 넣었다.- 리턴타입을 바꾸엇다.
	   public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException;
	   
	   
	}
