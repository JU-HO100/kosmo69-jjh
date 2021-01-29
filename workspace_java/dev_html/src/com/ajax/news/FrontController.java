package com.ajax.news;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import org.apache.log4j.Logger;

import com.ajax.member.MemberLogic;
import com.util.HashMapBinder;

public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	//forward, redirect
	//문제1.doGet과 doPost 모두 리턴타입이 void 임에도 불구하고 처리된 결과를 jsp페이지에 유지해야한다.
	//어떻게 해야하나? view.forward(req,res)
	//왜 forward하기 전에 setAttribute를 해야 하는가? - 담기
	//담은 내용을 받아와야하기 때문에 - 유지해야 하므로 반드시 해야 한다.
	@Override
	/************************************************************************
	 * Tomcat서버로 부터 req, res를 주입받아야 한다.
	 * 주입 받아야 사용할 수 있다. - 주입받기 전에는 사용할 수 없다.
	 * 
	 ***************************************************************************/
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
			{
				logger.info("doGet 호출 성공");
				MemberLogic memLogic = new MemberLogic();
				//URL을 통해서 업무에 대한 경우의 수를 나누어야 한다. 그럼 어떻게 해야하지?
				//crudNews.mem?work=getNewsList
				//crudNews.mem?work=getNewsDetail
				//crudNews.mem?work=getNewsInsert
				//crudNews.mem?work=getNewsUpdate
				//crudNews.mem?work=getNewsDelete
				//select 전체조회 - n개 row
				String work = req.getParameter("work");
				if("login".equals(work)) {
					Map<String,Object> pmap = new HashMap<>();
					memLogic.login(pmap);
					pmap.put("mem_id", req.getParameter("mem_id"));
					pmap.put("mem_pw", req.getParameter("mem_pw"));
					String mem_name = memLogic.login(pmap);
					//쿠기나 세션에 저장하기
					req.setAttribute("mem_name", mem_name);
					RequestDispatcher view = req.getRequestDispatcher("./loginAction2.jsp");
					view.forward(req, res);
					logger.info(view);
				}
				else if("getNewsList".equals(work)) {
					List<Map<String,Object>> newsList = null;
					NewsLogic newsLogic = new NewsLogic();
					newsList = newsLogic.getNewsList();//의미없는 값인 0을 넣었다. 
					req.setAttribute("newsList", newsList);
					RequestDispatcher view = req.getRequestDispatcher("getNewsList.jsp");
					view.forward(req,res);
					
				}
				//상세 조회 일때 - 한개 row - read.jsp 응답페이지 or forward되는 페이지가 다르니까 - if
				else if("getNewsDetail".equals(work)) {
					List<Map<String,Object>> newsList = null;
					NewsLogic newsLogic = new NewsLogic();
					int n_no = 0;
					n_no = Integer.parseInt(req.getParameter("n_no"));
					newsList = newsLogic.getNewsDetail(n_no);
					req.setAttribute("newsList", newsList);
					RequestDispatcher view = req.getRequestDispatcher("getNewsDetail.jsp");
					view.forward(req,res);
				}
				//insert - 등록일 때
				else if("getNewsInsert".equals(work)) {
					NewsLogic newsLogic = new NewsLogic();
					int result = 0;
					Map<String,Object> pmap = new HashMap<>();
					HashMapBinder hmb = new HashMapBinder(req);
					hmb.bind(pmap);
					result = newsLogic.NewsInsert(pmap);
					if(result == 1) {
						res.sendRedirect("crudNews.mem?work=NewsInsert");
					}else {
						res.sendRedirect("crudNewsError.jsp");
					}
				}
				//updat - 정보 수정일 때
				else if("getNewsUpdate".equals(work)) {
					NewsLogic newsLogic = new NewsLogic();
					int result = 0;
					Map<String,Object> pmap = new HashMap<>();
					HashMapBinder hmb = new HashMapBinder(req);
					hmb.bind(pmap);
					result = newsLogic.NewsUpdate(pmap);
					res.sendRedirect("crudNews.mem?work=NewsUpdate");
					
				}
				//delete - 정보 삭제일 때
				else if("getNewsDelete".equals(work)) {
					NewsLogic newsLogic = new NewsLogic();
					int result = 0;
					int num = 0;
					num = Integer.parseInt(req.getParameter("num"));
					result = newsLogic.NewsDelete(num);
					res.sendRedirect("crudNews.mem?work=NewsDelete");
				}
			}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
			{
				logger.info("doPost 호출 성공");
				
			}
}
