package design.book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class BookManagerEventHandler implements ActionListener {
	BookManager bm = null;//주의사항:절대로 new하면 안됨-왜냐하면 복제본이 만들어지는 거니까...
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();//싱글톤 패턴-디자인패턴
	Connection 			con = null;//물리적 거리가 있는 서버와 연결
	PreparedStatement 	pstmt = null;//SQL문 전달자
	CallableStatement cstmt = null;//프로시저를 오라클 서버에 요청시 사용해야 할 인터페이스
	OracleCallableStatement ocstmt = null;//ojdbc6.jar 즉 오라클측에서 제공하는 API
	ResultSet 			rs = null;//커서 조작
	//BookManager bm = new BookManager();
	public BookManagerEventHandler(BookManager bm) {
		this.bm = bm;
	}
//디폴트 생성자는 자동으로 생성해주지만 생성자가 하나라도 정의 되어 있는경우 제외
	public BookManagerEventHandler() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();//입력|수정|상세보기
		System.out.println("label===>"+label);
		if("입력".equals(label)) {
			System.out.println("입력을 선택한거니?");	
			bm.bookCRUD.dispose();
			bm.bookCRUD.setTitle("입력");
			bm.bookCRUD.set("입력", null, bm, true);
			bm.bookCRUD.setVisible(true);
			
		}
		else if("수정".equals(label)) {
			System.out.println("수정을 원해?");	
			BookVO rbVO = new BookVO();
			bm.bookCRUD.dispose();
			int pb_no = 0;
			int indexs[] = bm.jtb.getSelectedRows();
			/*만일 한개도 선택하지 않으면*/
			if(indexs.length==0) {
				JOptionPane.showMessageDialog(bm, "수정할 로우를 선택하세요.");
				return;
			}
			else {
				if(indexs.length>1) {
					JOptionPane.showMessageDialog(bm, "1개 로우만 선택하세요.");
					return;
				}
				else {
				/*여기서 초기값 0을 선택한 로우의 b_no값으로 변경처리해야함.*/
				for(int i=0;i<indexs.length;i++) {
				//아래 코드 중에서 어떤 코드를 최종 선택해야 할까요?
					pb_no = indexs[0];//선택한 로우의 순번이 담겨요. 그런데 where절에는 어떤 값이 들어가야 할까요?
					//where b_no = 도서번호가 들어가야 해요. 그런데 index[0]는 도서번호가 아니에요.
					//도서 번호를 가지고 있는 객체는 DefaultTableModel입니다.
					pb_no = Integer.parseInt(bm.dtm.getValueAt(pb_no, 0).toString());
				}
				if(pb_no==1) {
					bm.refreshData();
				}
			}
			rbVO = getBookDetail(pb_no);//초기값0
			rbVO.setB_no(pb_no);
			bm.bookCRUD.set("수정", rbVO, bm, true);
			bm.bookCRUD.setVisible(true);
		}
	}
		else if("삭제".equals(label)) {
			System.out.println("삭제하기");
			bm.bookCRUD.dispose();
			int status = 0;
			int indexs[] = bm.jtb.getSelectedRows();
			/*만일 한개도 선택하지 않으면*/
			if(indexs.length==0) {
				JOptionPane.showMessageDialog(bm, "삭제할 로우를 선택하세요.");
				return;
			}
			else {
				/*여기서 초기값 0을 선택한 로우의 b_no값으로 변경처리해야함.*/
				for(int i=0;i<bm.dtm.getRowCount();i++) {
					if(bm.jtb.isRowSelected(i)) {
						/*테이블에서 선택된 로우의 글 번호 가져오기*/
						Integer b_no = (Integer)bm.dtm.getValueAt(i, 0);
						status = bookDelete(b_no);//초기값0
				}
			}
			if(status==1) {
				bm.refreshData();
			}
		}
	}	
		else if("상세보기".equals(label)) {
			System.out.println("상세보기 선택했어?");	
//			BookVO rbVO = new BookVO();
			bm.bookCRUD.dispose();
			BookVO rbVO = null;
			int pb_no = 0;
			int indexs[] = bm.jtb.getSelectedRows();
			/*만일 한개도 선택하지 않으면*/
			if(indexs.length==0) {
				JOptionPane.showMessageDialog(bm, "상세보기할 로우를 선택하세요.");
				return;
			}
			else {
				if(indexs.length>1) {
					JOptionPane.showMessageDialog(bm, "1개 로우만 선택하세요.");
					return;
				}
				else {
				/*여기서 초기값 0을 선택한 로우의 b_no값으로 변경처리해야함.*/
				for(int i=0;i<indexs.length;i++) {
				//아래 코드 중에서 어떤 코드를 최종 선택해야 할까요?
					pb_no = indexs[0];//선택한 로우의 순번이 담겨요. 그런데 where절에는 어떤 값이 들어가야 할까요?
					//where b_no = 도서번호가 들어가야 해요. 그런데 index[0]는 도서번호가 아니에요.
					//도서 번호를 가지고 있는 객체는 DefaultTableModel입니다.
					pb_no = Integer.parseInt(bm.dtm.getValueAt(pb_no, 0).toString());
				}
				if(pb_no==1) {
					bm.refreshData();
				}
			}
			rbVO = getBookDetail(pb_no);//초기값0
			rbVO.setB_no(pb_no);
			JOptionPane.showMessageDialog(bm, "조회된 결과:"+rbVO);
			bm.bookCRUD.set("상세보기", rbVO, bm, false);
			bm.bookCRUD.setVisible(true);
		}
		}
	}
	private int bookDelete(Integer b_no) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM book2020 ");
			sql.append(" WHERE  b_no = ?	 ");
			 con = dbMgr.getConnection();
	            //?가 있으므로 먼저 쿼리문을 스캔해야 함.
	            pstmt = con.prepareStatement(sql.toString());
	            pstmt.setInt(1, b_no);
	            result = pstmt.executeUpdate();
	            /*삭제 여부 출력하기*/
	            System.out.println("result :"+result);
		}catch(SQLException se) {    
			System.out.println("[[query]]"+sql.toString());
		}catch(Exception e) {    
			e.printStackTrace();
		}
		return result;
	}
	///////////////////////[[정보 수정하기]]/////////////////////
	//새로운 도서 정보 등록하기 구현
		public int bookUpDate(BookVO pbVO) {
			int result = 0;
			StringBuilder sql = new StringBuilder();
			try {
				sql.append("UPDATE book2020  ");
				sql.append(" SET  b_name  = ?");
				sql.append(" 	 ,author  = ?");
				sql.append(" 	 ,publish = ?");
				sql.append(" 	 ,b_info  = ?");
				sql.append(" WHERE 	 b_no = ?");
	            con = dbMgr.getConnection();
	            //?가 있으므로 먼저 쿼리문을 스캔해야 함.
	            pstmt= con.prepareStatement(sql.toString());
	            int i=1;
	            pstmt.setString(i++,pbVO.getB_name());
	            pstmt.setString(i++,pbVO.getAuthor());
	            pstmt.setString(i++,pbVO.getPublish());
	            pstmt.setString(i++,pbVO.getB_info());
	            pstmt.setInt   (i++,pbVO.getB_no());
	            result = pstmt.executeUpdate();
			} catch (SQLException se) {
				System.out.println(se.toString());
			} catch(Exception e) {
				System.out.println(e.toString());
			}
			return result;
		}
	/////////////////////[[정보 수정하기]]///////////////////////
	//새로운 도서 정보 등록하기 구현
	public int bookInsert(BookVO pbVO) {
		System.out.println("0");
		int result = 0;
		StringBuilder sql = new StringBuilder();
		System.out.println("1");
		try {
			sql.append("INSERT INTO book2020   				  ");
			sql.append("  SELECT seq_book_no.nextval,?,?,?,?,?");
            sql.append("   FROM dual	 					  ");
            con = dbMgr.getConnection();
            System.out.println("2");
            /*?가 있음으로 먼저 쿼리문을 스캔해야 한다.*/
            pstmt= con.prepareStatement(sql.toString());
            int i=1;/*배열은  0번이 시작 이지만 쿼리문은 1번이 시작이다*/
            pstmt.setString(i++,pbVO.getB_name());
            pstmt.setString(i++,pbVO.getAuthor());
            pstmt.setString(i++,pbVO.getPublish());
            pstmt.setString(i++,pbVO.getB_info());
            pstmt.setString(i++,pbVO.getB_img());
            result = pstmt.executeUpdate();
            System.out.println("3");
		} catch (SQLException se) {
			System.out.println(se.toString());
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	public List<BookVO> getBookList() {
		StringBuilder sql = new StringBuilder();
		List<BookVO> bList = new ArrayList<>();
		sql.append("SELECT b_no, b_name, author, b_info, publish, b_img FROM book2020");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			BookVO bVO = null;
			while(rs.next()) {
				bVO = new BookVO();
				bVO.setB_no(rs.getInt("b_no"));
				bVO.setB_name(rs.getString("b_name"));
				bVO.setAuthor(rs.getString("author"));
				bVO.setPublish(rs.getString("publish"));
				bVO.setB_info(rs.getString("b_info"));
				bVO.setB_img(rs.getString("b_img"));
				bList.add(bVO);
			}
		} catch (SQLException se) {//이 그물에 걸리는 예외는 모두 toad에서 잡히는 에러
			System.out.println("[[query]]"+sql.toString());
		} catch (Exception e) {//그 나머지 모두 다 걸림.
			e.printStackTrace();//stack영역에 쌓여 있는 에러 메시지의 이력을 라인번호와 함께 출력해줘요.
		}
		return bList;
	}
	public BookVO getBookDetail(int b_no) {
		StringBuilder sql = new StringBuilder();
		BookVO bVO = null;//NullPoninterException 발동할 수 있다.
//		BookVO bVO = new BookVO();
		sql.append("SELECT b_no, b_name, author, b_info ,publish, b_img FROM book2020");
		sql.append(" WHERE b_no=? ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bVO = new BookVO();
				bVO.setB_no(rs.getInt("b_no"));
				bVO.setB_name(rs.getString("b_name"));
				bVO.setAuthor(rs.getString("author"));
				bVO.setPublish(rs.getString("publish"));
				bVO.setB_info(rs.getString("b_info"));
				bVO.setB_img(rs.getString("b_img"));

			}
		} catch (SQLException se) {/*이 그물에 걸리는 예외는 모두 toad에서 잡히는 에러*/
			System.out.println("[[query]]"+sql.toString());
		} catch (Exception e) {/*그 나머지 모두 다 걸린다.*/
			e.printStackTrace();/*스택 영역에 쌓여있는 에러 메세지의 이력을 라인번호와 함께 출력해 준다.*/
		}
		return bVO;
	}
	public List<BookVO> procBookList() {
		StringBuilder sql = new StringBuilder();
		List<BookVO> bList = new ArrayList<>();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call procBookList(?)}");
			//cstmt = con.prepareCall("{call proc_login2(?,?,?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			//cstmt.registerOutParameter(2, JDBCType.VARCHAR);
			//cstmt.registerOutParameter(3, JDBCType.VARCHAR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet cursor = ocstmt.getCursor(1);
			BookVO bVO = null;
			while(cursor.next()) {
				bVO = new BookVO();
				bVO.setB_no(cursor.getInt("b_no"));
				bVO.setB_name(cursor.getString("b_name"));
				bVO.setAuthor(cursor.getString("author"));
				bVO.setPublish(cursor.getString("publish"));
				bVO.setB_info(cursor.getString("b_info"));
				bVO.setB_img(cursor.getString("b_img"));
				bList.add(bVO);
			}
		} catch (SQLException se) {//이 그물에 걸리는 예외는 모두 toad에서 잡히는 에러
			System.out.println("[[query]]"+sql.toString());
		} catch (Exception e) {//그 나머지 모두 다 걸림.
			e.printStackTrace();//stack영역에 쌓여 있는 에러 메시지의 이력을 라인번호와 함께 출력해줘요.
		}
		return bList;
	}

}
