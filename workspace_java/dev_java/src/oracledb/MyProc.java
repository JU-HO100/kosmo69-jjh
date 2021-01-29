package oracledb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.db.DBConnectionMgr;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
/*
 *오라클의 프로시저를 자바코드에서 테스트하긴
 *자바와 오라클 연동시 SQL문을 전달할 수 있는 인터페이스가 있다.
 *1)Statement - DML 처리가능
 *2)PreparedStatement - DML 처리가능
 *3)CallableStatement - PL/SQL 처리가능
 */
public class MyProc {
	/*물리적으로 떨어져 있는 오라클 서버와 연결 통로를 확보할 때 필요한 선언 - 인터페이스이다. -왜냐하면 결정할 수 없으니까.
	 *제품, IP, PORT, SCOTT(ID), TIGER(PW), SID[orcl11]*/
	   Connection con = null;
	/*오라클에서 생성한 객체(프로시저)를 오라클 서버에 전달해줌. 역확 - 인터페이스 - 결정할 수 없다. - 프로시저가 각각 다르다.*/
	   CallableStatement cstmt = null;
	/*자바에서 제공되는 커서는 실제로 오라클에서 제공되는 커서를 조작하는 것이므로 좀 개선된 커서를 사용하기 위해
	 *마치 그래픽카드 최신 드라이버를 설치하듯 새로운 인터페이스 활용
	 *서로 다른 인터페이스를 사용한다는 건 다른 메소드를 호출할 수 있음.*/   
	   OracleCallableStatement ocstmt = null;
	   DBConnectionMgr dbMgr = new DBConnectionMgr();/*재사용성을 높이고 일괄처리가 가능해진다. - 서버이전을 대비함.
	    커서를 활용할 경우 여러개의 row를 받을 수 있음으로 List<DeptVO>를 선택하였다.*/
	   public List<DeptVO> deptList(){
	      List<DeptVO> dList = new ArrayList<>();
	      try {
	         con = dbMgr.getConnection(); 
	         /*오라클 서버에 살고 있는 proc_dept객체를 자바 코드에서 호출하고 싶다면 prepareCall(오라클) 메소드를 호출하세요.*/
	         cstmt = con.prepareCall("{call proc_dept(?)}");
	         /*오라클 프로시저에서는 파라미터와 리턴을 따로 사용하지 않고 모두 파라미터 형태로 사용한다. - 자바에서도 사용가능하다.
	          *원본의 주소번지를 파라미터로 넘겨서 그 파라미터 주소번지를 활용하여 return값을 꺼내는 형태로 지원한다 - 오라클의 특징
	          *오라클에서 제공하는 mode속성이고 IN[사용자가 입력한 값을 받아올때 쓴다], 
	          *						  OUT[사용자가 입력한 조건값으로 조회한 결과를 화면으로 내보낼때 쓴다.], 
	          *						  INOUT(존재하지만 잘 쓰지 않는다 - 멀티로 사용할 때 쓰니까 좋아보이지만......)*/
	         cstmt.registerOutParameter(1, OracleTypes.CURSOR);
	         /*오라클 서버에게 36번 프로시저 호출에대한 처리를 요청하는 메소드이다*/
	         cstmt.execute();
	         ocstmt = (OracleCallableStatement)cstmt;
	         ResultSet rs = ocstmt.getCursor(1);
	         DeptVO dVO = null;
	         while(rs.next()) {
	            dVO = new DeptVO();
	            dVO.setDeptno(rs.getInt("deptno"));
	            dVO.setDname(rs.getString("dname"));
	            dVO.setLoc(rs.getString("loc"));
	            dList.add(dVO);
	         }
	      } catch (Exception e) {
	         System.out.println(e.toString());
	      }
	      return dList;
	   }
	   public static void main(String[] args) {
	      MyProc mp = new MyProc();
	      List<DeptVO> dList = mp.deptList();
	      for(DeptVO rdVO:dList) {
	         System.out.println(rdVO.getDeptno()+", "+rdVO.getDname()+", "+rdVO.getLoc());
	      }
	   }

}
