package mvc3.online;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.online.ModelAndView;

public interface Controller3 {
	public ModelAndView3 execute2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
