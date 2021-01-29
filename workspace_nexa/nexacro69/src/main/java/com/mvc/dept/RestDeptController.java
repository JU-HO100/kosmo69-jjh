package com.mvc.dept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import com.nexacro17.xapi.tx.HttpPlatformRequest;   //넥사크로에서 제공하는 요청객체이다.
import com.nexacro17.xapi.tx.HttpPlatformResponse;
import com.nexacro17.xapi.tx.PlatformException;
import com.nexacro17.xapi.tx.PlatformType;

@RestController
@RequestMapping("/nexa/*")
public class RestDeptController {
   Logger logger = Logger.getLogger(RestDeptController.class);
   @Autowired
   DeptLogic deptLogic = null;
   
   //넥사크로는 디폴트가 Post방식이다 
   @PostMapping(value="deptXML.kosmo", produces="text/xml;charset=UTF-8")
   public void deptXML(HttpServletRequest req, HttpServletResponse res) throws PlatformException {
      logger.info("deptXML 호출 성공");
      
      //넥사크로 스크립트에서 스프링을 통해 처리된 결과를 콜백함수를 통해서 받을 수 있는 에러코드의 값이다.
      int nErrorCode = -1;
      String strErrorMsg = "START";
      
      //넥사크로에서 요청 받아오기 
      HttpPlatformRequest nreq = new HttpPlatformRequest(req);
      
      //데이터를 가져오는 메소드 호출
      nreq.receiveData();
      
      //넥사크로에서 제공하는 데이터셋에 담긴 정보를 자바코드에서 읽어 오기위한 선언.
      PlatformData in_ndata = nreq.getData();
      
      //자바에서 조회한 결과를 데이터셋에 담기 위한 객체 생성
      //여기에 생성한 데이터셋을 추가합니다.
      PlatformData out_ndata = new PlatformData();
      
      //넥사크로에서 제공하는 데이터셋을 자바 코드로 제공하는 클래스   (넥사크로에서 사용하는 데이터셋이름을 넣어주는곳)
      DataSet ids_dept = in_ndata.getDataSet("in_dept");   //화면에서 넘어온 데이터 셋을 읽기 위한 코드
      
      //자바를 이용해서 오라클 서버엣 select한 결과를 담을 데이터셋 선언. 화면에 내보내지는것이니까 out의 o를 붙임
      DataSet ods_dept = new DataSet("out_dept");   //select한것을 담을거니까 직접 인스턴스화 해줘야한다.
      
      //데이터셋에 초기화해주기 컬럼생성 - 자바코드로 작업
      ods_dept.addColumn("deptno",   DataTypes.INT,      (short)10);
      ods_dept.addColumn("dname",      DataTypes.STRING,   (short)100);
      ods_dept.addColumn("loc",      DataTypes.STRING,   (short)50);
      
      //DB연동하는 코드
      List<Map<String,Object>> deptList = null;
      deptList = deptLogic.deptList();
      logger.info("deptList >> "+deptList);
      
      
      for(int i=0; i<deptList.size();i++) {
         Map<String,Object> rMap = deptList.get(i);
         //데이터셋에 로우를 추가해 줘야 조회된 결과를 담을 수 있다.
         int row = ods_dept.newRow();
         ods_dept.set(row,   "deptno",   rMap.get("DEPTNO"));
         ods_dept.set(row,   "dname",   rMap.get("DNAME"));
         ods_dept.set(row,   "loc",      rMap.get("LOC"));
      }
      
      //데이터셋을 담기
      out_ndata.addDataSet(ods_dept);
      
      //에러코드 + 메시지 초기화해주기
      nErrorCode = 0;
      strErrorMsg = "DEPT 조회 성공 !";
      
      VariableList varList = out_ndata.getVariableList();
      varList.add("ErrorCode",nErrorCode);
      varList.add("StringErrorMsg",strErrorMsg);
      
      //응답을 해야하니까 
      HttpPlatformResponse pres = new HttpPlatformResponse(res,PlatformType.CONTENT_TYPE_XML,"utf-8");
      pres.setData(out_ndata);
      //전송(마임타입이 xml인 문서)
      pres.sendData();
      
      
   }
   
   @RequestMapping("total.kosmo")
   public String total() {
      return "10";
   }
   
   @RequestMapping(value="getName.kosmo", produces="application/json;charset=UTF-8")
   public String getName() {
      return "한글";
   }
   
   @RequestMapping(value="getDept.kosmo", produces="application/json;charset=UTF-8")
   public String getDept() {
      //DB에서 가져와서 출력해야할 코드
      //DeptDao.java, configure.xml, dept.xml
      //MVC패턴 얹어서 개발 진행.
      //파이썬은 이런 코드가 필요없다. DB연동을 예로 들면 자바의 5분의 1정도로 줄어든다.
      
      List<Map<String,Object>> deptList = new ArrayList<>();
      Map<String,Object> rMap = new HashMap<>();
      rMap.put("deptno",10);
      rMap.put("dname","영업");
      rMap.put("loc","서울");
      deptList.add(rMap);
      
      rMap = new HashMap<>();
      rMap.put("deptno",20);
      rMap.put("dname","개발");
      rMap.put("loc","인천");
      deptList.add(rMap);
      
      Gson g = new Gson();
      String imsi = g.toJson(deptList);
      return imsi;
   }
   
   
   @RequestMapping(value="getDept2.kosmo", produces="text/html;charset=UTF-8")
   public String getDept2() {
      List<Map<String,Object>> deptList = new ArrayList<>();
      Map<String,Object> rMap = new HashMap<>();
      rMap.put("deptno",10);
      rMap.put("dname","영업");
      rMap.put("loc","서울");
      deptList.add(rMap);
      
      rMap = new HashMap<>();
      rMap.put("deptno",20);
      rMap.put("dname","개발");
      rMap.put("loc","인천");
      deptList.add(rMap);
      
      Gson g = new Gson();
      String imsi = g.toJson(deptList);
      return imsi;
   }
   

}