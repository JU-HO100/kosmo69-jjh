<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.net.*" %>    
<%
   String b_file = request.getParameter("bs_file");
   String fname = b_file;
   out.print("b_file: 8->euc"+b_file);      
   out.print("<br>");      
   String filePath = "C://workspace_sts3//spring3_1//src//main//webapp//pds//"; // 절대경로.   
   File file = new File(filePath,b_file.trim());
    String mimeType = getServletContext().getMimeType(file.toString());
   if(mimeType == null){//마임타입 - 브라우저가 알고있지않는 것은 다운로드 된다.
      response.setContentType("application/octet-stream");
   }
   String downName = null;
   if(request.getHeader("user-agent").indexOf("MSIE")==-1){
      downName = new String(b_file.getBytes("UTF-8"),"8859_1");
   }else{
      downName = new String(b_file.getBytes("EUC-KR"),"8859_1");
   }
      response.setHeader("Content-Disposition", "attachment;filename="+downName);
    FileInputStream fis = new FileInputStream(file);
   ServletOutputStream sos = response.getOutputStream();
   try{
      byte b[] = new byte[1024*10];
      int data = 0;
      while((data=(fis.read(b,0,b.length)))!=-1){
         sos.write(b,0,data);
      }
      sos.flush();      
   }catch(Exception e){
      out.print(e.toString());
   }finally{
      if(sos != null) sos.close();
      if(fis != null) fis.close();
   }

%>  
  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>다운로드</title>
</head>
<body>

</body>
</html>