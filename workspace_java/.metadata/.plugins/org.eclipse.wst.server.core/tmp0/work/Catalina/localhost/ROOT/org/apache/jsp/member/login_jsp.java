/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.38
 * Generated at: 2021-01-27 06:07:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.google.gson.Gson;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1609059653918L));
    _jspx_dependants.put("/loginContent.jsp", Long.valueOf(1611027032568L));
    _jspx_dependants.put("/kakaoLogin.jsp", Long.valueOf(1611677801300L));
    _jspx_dependants.put("/loginHeader.jsp", Long.valueOf(1610285683495L));
    _jspx_dependants.put("/common/bootstrap_common.jsp", Long.valueOf(1611325921671L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.google.gson.Gson");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");

       StringBuilder path = new StringBuilder(request.getContextPath());
       path.append("/");
    
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"image/favicon.ico\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path.toString() );
      out.write("css/team.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path.toString() );
      out.write("css/bootstrap.min.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path.toString() );
      out.write("js/bootstrap.min.js\"></script> \r\n");
      out.write("\r\n");
      out.write("<!-- carousel -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("  \r\n");
      out.write("<!-- font -->\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap\" rel=\"stylesheet\"> \r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Single+Day&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Jua&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("<!-- EasyUI -->\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.jeasyui.com/easyui/themes/material/easyui.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.jeasyui.com/easyui/themes/icon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.jeasyui.com/easyui/themes/color.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path.toString() );
      out.write("css/demo.css\">\r\n");
      out.write("    \r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(path.toString() );
      out.write("js/commons.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"https://www.jeasyui.com/easyui/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"https://www.jeasyui.com/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("<!-- Ajax -->\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- kakao Login API -->\r\n");
      out.write("<script src=\"https://developers.kakao.com/sdk/js/kakao.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("<!-- google chart -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n");
String msg =(String)request.getAttribute("msg"); 
      out.write("<title>오늘 뭐 먹지?</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function loginAction() {\r\n");
      out.write("\t//아이디 공백 확인\r\n");
      out.write("    if($(\"#m_id\").val() == \"\"){\r\n");
      out.write("      alert(\"아이디 입력바람\");\r\n");
      out.write("      $(\"#m_id\").focus();\r\n");
      out.write("      return false;\r\n");
      out.write("    }\r\n");
      out.write("\t\r\n");
      out.write("  //비밀번호 공백 확인\r\n");
      out.write("    if($(\"#m_pw\").val() == \"\"){\r\n");
      out.write("      alert(\"비밀번호를 입력해주세요\");\r\n");
      out.write("      $(\"#m_pw\").focus();\r\n");
      out.write("      return false;\r\n");
      out.write("    }\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("function findIdAction() {\r\n");
      out.write("\tlocation.href=\"/findId.jsp\";\r\n");
      out.write("}\r\n");
      out.write("function findPwAction() {\r\n");
      out.write("\tlocation.href=\"/findPw.jsp\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
if(msg!=null){
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\talert(\"");
      out.print(msg);
      out.write("\");\r\n");
      out.write("</script>\r\n");
} 
      out.write("<table align=\"center\" style=\"width: 70% ; height: 100%;\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<table align=\"center\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td style=\"padding-top: 6%; padding-bottom: 8%\">\r\n");
      out.write("\t\t\t<a href=\"/member/index.jsp\">\r\n");
      out.write("\t\t\t<input type=\"image\" src=\"/images/logo.jpg\" style=\"width: 250px;''\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>");
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      out.write("<div class=\"container\" align=\"center\" style=\"width: 100%; text-align: center; background-color: white;\">\r\n");
      out.write("\t\t\t\t\t<form method=\"post\" action=\"/member/memLogin.np\">\r\n");
      out.write("\t\t\t\t\t\t\t<table align=\"center\" style=\"width: 50%; margin-top: 5%;'\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"padding-bottom: 5%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input id=\"m_id\" name=\"m_id\" class=\"username\" type=\"text\" placeholder=\"아이디 입력\" style=\"border: solid 1px black;\" required> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input id=\"m_pw\" name=\"m_pw\"  class=\"password\" type=\"password\" style=\"border: solid 1px black;\" placeholder=\"비밀번호 입력\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div style=\"padding-top: 4%;\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"btn btn-outline-dark\" type=\"submit\" value=\"Login\" onclick=\"loginAction()\" style=\"width: 100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"btn btn-outline-dark\" type=\"button\" value=\"아이디 찾기\" style=\"width: 47%\" onclick=\"findIdAction();\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"btn btn-outline-dark\" type=\"button\" value=\"비밀번호 찾기\" style=\"width: 47%\" onclick=\"findPwAction();\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>");
      out.write("</td>\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t");

	//response.setIntHeader("Refresh",5);

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>카카오 로그인</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("<script src=\"https://developers.kakao.com/sdk/js/kakao.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- =============================== 카카오 로그인 ================================================== -->\r\n");
      out.write("<div id=\"kakao-login-btn\"></div>\r\n");
      out.write("<!-- <div id=\"d_test\">d_test</div> -->\r\n");
      out.write("<script type='text/javascript'>\r\n");
      out.write("\tvar kakaoNick = \"\";\r\n");
      out.write("\tvar kakaoMail = \"\";\r\n");
      out.write("//     <![CDATA[\r\n");
      out.write("   // 사용할 앱의 JavaScript 키를 설정해 주세요.\r\n");
      out.write("   Kakao.init('15f5287d753e527b86e1f231f7128313');\r\n");
      out.write("   \r\n");
      out.write("   // 카카오 로그인 버튼을 생성합니다.\r\n");
      out.write("   Kakao.Auth.loginFom({\r\n");
      out.write("     success: function(authObj) {\r\n");
      out.write("//     \talert(JSON.stringify(authObj));\r\n");
      out.write("\r\n");
      out.write("    \t// 세션이 종료된 이후에도 토큰을 유지.\r\n");
      out.write("// \t\tpersistAccessToken: true,\r\n");
      out.write("\t\t// 세션이 종료된 이후에도 refresh토큰을 유지.\r\n");
      out.write("// \t\tpersistRefreshToken: true,\r\n");
      out.write("\t\t\r\n");
      out.write("//     \t로그인 성공시, API를 호출합니다.\r\n");
      out.write("    \tKakao.API.request({\r\n");
      out.write("\t \t    url: '/v2/user/me',\r\n");
      out.write("\t \t    success: function(response) {\r\n");
      out.write("\t \t    \tconsole.log(response);\r\n");
      out.write("// \t    \t    user.host = 'kakao'\r\n");
      out.write("\t\t\t\tkakaoId = rewponse.id; //id\r\n");
      out.write("\t    \t    kakaoMail = response.kakao_account.email; //유저의 이메일\r\n");
      out.write("\t    \t    var user = response.kakao_account //계정 정보\r\n");
      out.write("\t    \t    kakaoNick = response.properties.nickname; //유저가 등록한 별명\r\n");
      out.write("\t    \t    \r\n");
      out.write("\t    \t    console.log(kakaoNick);\r\n");
      out.write("\t    \t    console.log(kakaoMail);\r\n");
      out.write("\t//  \t\talert(\"이름 : \"+kakaoNick); //로그인한 유저 이름\r\n");
      out.write("\t//     \t    session.setAttribute(\"email\",kakaoMail);\r\n");
      out.write("\t//     \t    sessionStorage.setItem(\"email\",kakaoMail);\r\n");
      out.write("\t// \t\t\tsession.setAttribute(\"kakaoNick\",kakaoNick);\r\n");
      out.write("\t//     \t    sessionStorage.setItem(\"kakaoNick\",kakaoNick);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("// \t\t\t\t$('').append(html);\r\n");
      out.write("//     \t    \tlocation.href='/member/index.jsp?'\r\n");
      out.write("\t \t    \r\n");
      out.write("\t \t    },\r\n");
      out.write("    \t    fail: function(error) {\r\n");
      out.write("    \t        alert(\"에러1\"+JSON.stringify(error));\r\n");
      out.write("    \t    }\r\n");
      out.write("    \t});\r\n");
      out.write(" \t\r\n");
      out.write("//    \t\tKakao.Auth.authorize({\r\n");
      out.write("// \t\t\tredirectUri: 'http://localhost:9000/member/index.np?kakaoNick='+kakaoNick\r\n");
      out.write("// \t\t\tredirectUri: 'http://localhost:8000/member/index.np'\r\n");
      out.write("// \t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t},\r\n");
      out.write("   \t  \tfail: function(err) {\r\n");
      out.write("   \t  \t\talert(\"에러2\"+JSON.stringify(err));//카카오개발자홈피에 등록이 되지 않았을때 자주 나타남\r\n");
      out.write("   \t  \t\r\n");
      out.write("   \t  \t}\r\n");
      out.write("    });\r\n");
      out.write("   \r\n");
      out.write("//   \talert(\"ajax test\");\t\r\n");
      out.write("// \t$.ajax({\r\n");
      out.write("// \t\turl:'../a.jsp?s_name='+kakaoNick\r\n");
      out.write("//        ,success:function(data){\r\n");
      out.write("// //     \t   alert(\"data:\"+data);\r\n");
      out.write("//     \t   $(\"#d_test\").text(data);\r\n");
      out.write("//        }\r\n");
      out.write("// \t});\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<!-- =============================== 카카오 로그인 ================================================== -->\r\n");
      out.write("<!-- =============================== 카카오 로그아웃 ================================================== -->\r\n");
      out.write("<!-- <a href=\"http://developers.kakao.com/logout\"></a> -->\r\n");
      out.write("\r\n");
      out.write("<!-- =============================== 카카오 로그아웃 ================================================== -->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("<br>\r\n");
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td style=\"padding-top: 12%\">\r\n");
      out.write("\t\t\t");
      out.write("<footer class=\"footer\">\r\n");
      out.write("  <div class=\"footer__addr\">\r\n");
      out.write("    <h2>Contact</h2>\r\n");
      out.write("    \r\n");
      out.write("      <a class=\"footer__btn\" href=\"mailto:example@gmail.com\">Email Us</a>\r\n");
      out.write("    </address>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  <ul class=\"footer__nav\">\r\n");
      out.write("    \r\n");
      out.write("    <li class=\"nav__item nav__item--extra\">\r\n");
      out.write("      <h2 class=\"nav__title\">Team members</h2>\r\n");
      out.write("      \r\n");
      out.write("      <ul class=\"nav__ul nav__ul--extra\">\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">오성근</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">박한규</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">정주호</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">안준헌</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">이해민</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("         <li>\r\n");
      out.write("          <a href=\"#\">양재화</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">최호연</a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    \r\n");
      out.write("    <li class=\"nav__item\">\r\n");
      out.write("      <h2 class=\"nav__title\">KOSMO</h2>\r\n");
      out.write("      \r\n");
      out.write("      <ul class=\"nav__ul\">\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">Privacy Policy</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">Terms of Use</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">Sitemap</a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("  </ul>\r\n");
      out.write("  \r\n");
      out.write("  <div class=\"legal\">\r\n");
      out.write("    <p>&copy; 2021 Something. All rights reserved.</p>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"legal__links\">\r\n");
      out.write("      <span>Made with <span class=\"heart\">♥</span> NullPointer</span>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</footer>");
      out.write("</td>\r\n");
      out.write("\t</tr>\t\r\n");
      out.write("</table>\r\n");
      out.write("</body>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
