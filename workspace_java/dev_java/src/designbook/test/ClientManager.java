package designbook.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;


import com.util.DBConnectionMgr;
public class ClientManager {
	//선언
	LoginView lv = null;
	SearchEvent se = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//생성자
	public ClientManager() {
	}
	public ClientManager(LoginView lv) {
		this.lv = lv;
	}
	
	public ClientManager(SearchEvent se) {
		this.se = se;
	}
	
	//'%'||?||'%' 내가 원하는 검색어가 다른 단어의 앞이나 뒤에 있어도 찾아오는 것
	//		?||'%' 내가 원하는 검색어가 다른 단어의 앞에 있을 때 찾아오는 것
	//'%'||? 내가 원하는 검색어가 다른
	//? 그 단어만 있어야 찾아오는것
//	sv.jtf_search.getText() 왜??? 왜가져와야하는데? -> 내가원하는것을 검색하기위해 -> 가져와서 어떻게쓰려고? 테이블에다가 넣을것이다 
	
	
	public List<SearchVO> BookList(String B_NAME) { //조회문을 쓸때 내가 입력한것은 => 조건, 내가 받을거는 조건에 맞는 어떤것들
		List<SearchVO> search = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT B_NO, B_NAME, AUTHOR, PUBLISH, B_INFO FROM BOOK2020 ");
		sql.append("  WHERE B_NAME LIKE '%'||?||'%' ");//내가 쓴 글자가 앞 혹은 뒤 어디에 있든  포함 되어 있으면 가져오겠다.
		try {
			con = dbMgr.getConnection();//물리적으로 떨어진 서버와 연결통로를 만든다.
			pstmt = con.prepareStatement(sql.toString());//
			pstmt.setString(1, B_NAME);
			rs = pstmt.executeQuery();
			SearchVO sVO = null;
			SearchVO[] sVOs = null;
			Vector rv = new Vector<>();
			
			
			while(rs.next()) {
				sVO = new SearchVO();
				sVO.setB_NO(rs.getInt("B_NO"));
				sVO.setB_NAME(rs.getString("B_NAME"));
				sVO.setAUTHOR(rs.getString("AUTHOR"));
				sVO.setPUBLISH(rs.getString("PUBLISH"));
				sVO.setB_INFO(rs.getString("B_INFO"));
				rv.add(sVO);
		
			}
			sVOs = new SearchVO[rv.size()];
			rv.copyInto(sVOs);//copyInto = 왼쪽에 있는 정보를 오른쪽파라미터에 복사해서 넣겠다. 라는 의미이다.
			if(rv.size()>0) {
				while(se.sv.dtm_bookcode.getRowCount()>0) {
					se.sv.dtm_bookcode.removeRow(0);
				}
			}
			for(int j=0;j<sVOs.length;j++) {
				SearchVO rsVO = sVOs[j];
				Vector oneRow = new Vector<>();
				oneRow.add(rsVO.getB_NO());
				oneRow.add(rsVO.getB_NAME());
				oneRow.add(rsVO.getAUTHOR());
				oneRow.add(rsVO.getPUBLISH());
				oneRow.add(rsVO.getB_INFO());
				se.sv.dtm_bookcode.addRow(oneRow);
//				System.out.println("oneRow==>"+oneRow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return search;
	}
//	public static void main(String[] args) {
//		ClientManager cm = new ClientManager();
//		cm.BookList("파이썬");
//	}
	
}
