package com.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//톰캣서버를 여는 순간 servers에 있는 server.xml을 거치게 된다
//그 다음에는 WEB-INF에 있는 web.xml을 실행하게됨
//web에 <servlet>태그가 있다 내가 servlet을 사용한다면 무조건 실행되는 태그내용이다
//web.xml을 참조하면서 볼것
// <servlet> 부터시작 <servlet-mapping>이 두번째
//<servlet>에서는 servelt의 이름을 정해주고 파일의 위치를 정한다
//<servlet-mapping>에서는 위에서 정한이름의 servlet을 실행할때 URL을 정한다
//urlpattern안에 들어온 xxx.do가 지금 이 파일을 실행하게되면 url의 가장 뒷쪽에 보일것이다

public class printJson2 extends HttpServlet {
	  //내가 필요한거
	   //mybatis를 이용해서 연결할거니까 sqlsessionfactory, session 이 필요하다
	   //mybatis를 이용하지 않앗다면 PrepareStatement, Connection을 사용했을것 
	   //그리고 자바에는 요청과 응답기능이 없기때문에 서블릿을 활용할거다 서블릿을 상속받는다
	   //서블릿에서 활용할수 있는 메소드는 doget과 dopost뿐이다 일단 활용할 방법은 do get이다 get방식
	   //그 doget메소드는 파라미터로 요청과 응답을받는다
	   
	   //Configuration.xml을 호출해서 사용하기 위해 선언한 변수 Configuration는 오라클의 접속하는 내용을 담고있다
	   String resource = "com.util/Configuration.xml";
	   SqlSessionFactory sqlMapper = null; //오라클과 자바를 연결해주는 친구 
	   Logger logger = Logger.getLogger(printJson2.class);
	   
	   public void doGet(HttpServletRequest req, HttpServletResponse res)
	      throws ServletException, IOException { //만약 서블릿익셉션이나 IO익셉션이 일어난다면 이것을 실행하는 클래스에서 해결하도록오류를 던진다
	      //뿌려줄꺼다(쓸꺼다) 응답하는 내용을 가져와서
	      PrintWriter out = res.getWriter();
	      //말그대로 임시용 선언 나중에 Json파일의 내용을 String형식으로 출력할때 사용한다
	      String imsi=null; 
	      res.setContentType("application/json; charset=UTF-8");
	      //일꾼역할 옵티마이저같은  요청과 응답을 오락가락하게 해준다
	      List<Map<String,Object>> empList = null;
	      //애초에 조회해오고 싶은 방법은 map형식이니 그에 대한 키값과 내용을 받아오기 위한 Map 
	      SqlSession session = null; 
	      //그 맵들을 묶음으로 가져오기위한 List
	      
	      
	      //서버연결을 시작할거니까 try catch문을 쓸꺼다 서버연결 내용은 디폴트가 try catch다
	      try {
	         
	         //싱글톤으로 오라클에 접속해서 정보를 읽어오기 위한 Reader
	         Reader reader = Resources.getResourceAsReader(resource);
	         //물리적으로 자바와 오라클을 이어주는 연결통로를 만든다 그 후에 읽어온다 해당 ID(develpment3)에 관련된 정보를
	         sqlMapper= new SqlSessionFactoryBuilder().build(reader,"develpment");
	         //loger는 기본적으로 정보를 확인하기위해 쓴다 여기서는 문제 발생시에 문제를 더 정확하게 확인하기 위해 사용하는것 제대로 나오는지 뭔지 여튼 시발
	         logger.info("sqlMapper = "+sqlMapper);
	         //연결통로(SqlSessionFactory)가 열림/요청과 응답을 옮겨주는 Session이  오라클과 자바를 오고갈수있게되었다  
	         session = sqlMapper.openSession();
	         logger.info("session = "+session);
	         Map<String,Object> target = new HashMap<>();
	         //emp.xml의 getEmpList를 가져온다/getEmpList의 내용은 조회하는 내용임/ 그 조회해온것을 empList에 주입한다
	         //selectList는 내가 가져오는 내용의 타입에 따라 변화한다 지금은 Map타입이기때문에 selectList로 가져온것
	         //그 외에 selectOne같은 것들이 있다
	         empList = session.selectList("getEmpList",target);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         //세션의 갯수는 한정되어있다 사용자가 사용을 마치게되면 무조건 꺼서 그 자리를 반납받아야 다음사람이 사용가능하다
	         //그렇기때문에 finally(반드시) 꺼야한다
	         session.close();
	      }
	      if(empList==null) { //만약 조회해온 내용이 아무것도 없거나 알수없다면
	         //empList를 인스턴스화해서 nullPointException을 피하도록한다 그 외의 의미는 없다
	         empList = new ArrayList<>();
	         
	      }else {
	         //가져온정보(empList)를 Json파일로 변환하기 위한준비
	         Gson g = new Gson();
	         //아까만든 String타입의 imsi에 가져온정보(empList)를 모두 주입한다 toJson이 헷갈리면 toString생각하면됨
	         imsi = g.toJson(empList);
	         //아까 선언한 PrintWriter다 sys println out이 아니다 / 뿌려준다 String타입으로 변환된 json파일의 내용전부를
	         out.print(imsi);
	      }
	      
	   }

}
