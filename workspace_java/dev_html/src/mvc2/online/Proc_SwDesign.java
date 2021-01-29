package mvc2.online;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.DBConnectionMgr;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
/*
 * SELECT문 파싱한다. parsing-문법체크
 * DBMS가 실행계획을 세운다.
 * 실행계획을 옵티마이저에게 넘긴다.
 * open....cursor.....fetch(1개 row씩 읽어서 메모리에 올리는과정)...close
 * 
 */
public class Proc_SwDesign {
	Connection 				con 	= null;
	CallableStatement 		cstmt 	= null;
	OracleCallableStatement ocstmt 	= null;
	DBConnectionMgr 		dbMgr 	= null;
	ResultSet				cursor 	= null;
	public Proc_SwDesign() {
		dbMgr = DBConnectionMgr.getInstance();//결합도를 낮추는 코드의 첫단추
		con = dbMgr.getConnection();
	}
	public List<Map<String,Object>> refcursorTest() {
		List<Map<String,Object>> sdList = null;
		try {
			cstmt = con.prepareCall("{call proc_swdesign(?)}");//프로시저 호출
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			cursor = ocstmt.getCursor(1);
			Map<String,Object> rmap = null;
			sdList = new ArrayList<>();
			while(cursor.next()) {
				rmap = new HashMap<>();
				rmap.put("d_no", 	 cursor.getInt(1));
				rmap.put("sub_cd", 	 cursor.getInt(2));
				rmap.put("question", cursor.getString(3));
				rmap.put("answer1",  cursor.getString(4));
				rmap.put("answer2",  cursor.getString(5));
				rmap.put("answer3",  cursor.getString(6));
				rmap.put("answer4",  cursor.getString(7));
				rmap.put("d_point",  cursor.getInt(8));
				rmap.put("dap", 	 cursor.getInt(9));
				sdList.add(rmap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdList;
	}
	public static void main(String[] args) {
		Proc_SwDesign psd = new Proc_SwDesign();
		List<Map<String,Object>> sdList = psd.refcursorTest();
		for(Map<String,Object> map:sdList) {
			for(int i=0;i<map.size();i++) {
				Object keys[] = map.keySet().toArray();
				String key = (String)keys[i];
				System.out.println(map.get(key));
			}
			System.out.println();
		}
	}
}
