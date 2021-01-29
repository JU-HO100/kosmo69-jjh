package com.mvc2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {
   Logger logger = Logger.getLogger(MemberController.class);
   
   private MemberLogic mLogic = null;
   @RequestMapping("login3.sp3")
   public String login(HttpServletRequest req, HttpServletResponse res)
         throws ServletException, IOException 
   {
      logger.info("로그인 호출 성공");
      //사용자가 화면에 입력한 아이디와 비번 넘기기
      Map<String,Object> pmap = new HashMap<>();
      pmap.put("mem_id", req.getParameter("mem_id"));
      pmap.put("mem_pw", req.getParameter("mem_pw"));
      logger.info("mem_id:"+pmap.put("mem_pw", req.getParameter("mem_pw")));
      String msg = null;
      Map<String,Object> rmap = null;
      rmap = mLogic.login(pmap);
      return "redirect:loginAccount.jsp";
   }
//        HttpSession session = req.getSession();
////        session.setAttribute("smsg", msg);
////        session.setAttribute("s_id", msg);
//        session.setAttribute("rmap", rmap);
//        viewName="/onLineTest/loginAccount.jsp";
//        //세션에 값을 저장하므로 요청이 유지 되지 않아도 된다.
//        isRedirect = true;
//        af.setRedirect(isRedirect);
//        af.setViewName(viewName); 
}