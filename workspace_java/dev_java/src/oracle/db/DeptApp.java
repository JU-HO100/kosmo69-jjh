package oracle.db;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nickname.DeptVO;
/* 생성자 안에서도 메소드 호출이 가능하다.
 * 변수선언도 가능하다.
 * 내안에 있는 메소드를 호출함으로 인스턴스화는 필요없다.
 * 생성자 앞에는 static이 없다.
 * non-static에서 non-static 접근이 가능하고
 * static에서 non-static은 반드시 "인스턴스화"를 해야한다.
 */
public class DeptApp extends JFrame implements ActionListener, MouseListener {
	JMenuBar jmb = new JMenuBar();
	JMenu	jm_db = new JMenu("오라클 연계");
	JMenuItem jmi_con     	= new JMenuItem("오라클연결");
	JMenuItem jmi_ins     	= new JMenuItem("등록");	
	JMenuItem jmi_sel     	= new JMenuItem("조회");
	JMenuItem jmi_upd     	= new JMenuItem("수정");	
	JMenuItem jmi_del     	= new JMenuItem("삭제");	
	JMenuItem jmi_exit 	  	= new JMenuItem("나가기");
	//양식, 폼을 그려주는 클래스이다.
	JTable 	  jt_dept    	= null;
	//JTable에 스크롤바를 붙여 줄 속지이다.
	JScrollPane jsp_dept  	= null;
	String     cols[]     	= {"부서번호","부서명","지역"};//1차 배열일때는 for문을 1개만 쓰지만 2차 배열일때는 for문을 2개 쓴다(for문 안에 for문을 쓰는것)
	String     data[][]   	= new String[0][3];
	DefaultTableModel dtm 	= null;
	DBConnectionMgr dbMgr   = new DBConnectionMgr();
	Connection    	  con   = null;//오라클 서버와 연결하는 객체이다.
	PreparedStatement pstmt = null;//오라클 서버에 셀렉트문을 가져가고 요청한후 결과를 받아오는 역할이다.
	ResultSet         rs    = null;//조회할때만 쓴다  -오라클에 살고 있는 일꾼이 있다. 옵티마이저
	public DeptApp() {
		iniDisplay();
	} 
	public void iniDisplay() {
		System.out.println("initDisplay 호출 성공");
		jt_dept.addMouseListener(this);
		dtm      = new DefaultTableModel(data,cols);
		jt_dept  = new JTable(dtm);
		jsp_dept = new JScrollPane(jt_dept
								  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
								  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jmi_sel.addActionListener(this);//actionPerformed
		jm_db.add(jmi_con);
		jm_db.add(jmi_ins);
		jm_db.add(jmi_sel);
		jm_db.add(jmi_upd);
		jm_db.add(jmi_del);
		jm_db.add(jmi_exit);
		jmb.add(jm_db);
		this.add("Center",jsp_dept);
		this.setJMenuBar(jmb);
		this.setSize(450, 320);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		 new DeptApp();
		
	}
	@Override
	//여기서
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();//문자열 라벨 가져오기
		//너 조회 버튼 누른거야?
		if("조회".equals(label)) {
			System.out.println("조회 버튼 클릭 성공!!");
			//String은 원본이 바뀌지 않는다.
		//	StringBuffer sql2 = new StringBuffer();
			String sql2 = "SELECT deptno, dname, loc FROM dept";
				   sql2 += " WHERE deptno >=?";
				   sql2 += " OR loc LIKE ?||%";//사용자에게 듣고 적어야할 경우는 ?를 쓴다
			StringBuilder sql = new StringBuilder();
			sql.append( "SELECT deptno, dname, loc FROM dept" );
			sql.append( " WHERE deptno >=?    				" );
			sql.append( " OR loc LIKE ?||%					" );//사용자에게 듣고 적어야할 경우는 ?를 쓴다
			try {
				con   = dbMgr.getConnection();//순서가 차례대로 해야 한다. con -> pstmt -> rs
				pstmt = con.prepareStatement(sql.toString());//메모리에 로딩 성공  SELECT를 오라클에 요청하기 위해 사용 | 인터페이스에서 한다.
				pstmt.setInt(1, 30);
				pstmt.setString(2, "N%");
				rs    = pstmt.executeQuery();//오라클에 요청한 값을 응답 받기 위함 | 커서를 움직이기 위해 사용
				DeptVO dvo    = null;
	//			DeptVO[] dvos = new DeptVO[4];//몇건이 있는지 알수 없으니까 일단 null로 해두었다가 생성해야 한다.
				DeptVO[] dvos = null;
				Vector rv = new Vector();//몇건이 있는지는 오라클에게 물어봐야 하니까 물어본 결과를 그때 그때 기억(메모)해 두어야 한다.
										 //오라클에 있는 것을 벡터에 담으려고 이곳에 넣은 것이다.
				int i=0;				 
				while(rs.next()) {	
					dvo = new DeptVO();
					System.out.println(rs.getInt("deptno")
								  +","+rs.getString("dname")
								  +","+rs.getString("loc"));
					dvo.setDeptno(rs.getInt("deptno"));
					dvo.setDname(rs.getString("dname"));
					dvo.setLoc(rs.getString("loc"));					
					dvos[i] = dvo;
					rv.add(dvo);//오라클에서 얻어낸 정보를 그때 그때 기억하는 문장이다.
					i = i+1;
				}
				dvos = new DeptVO[rv.size()];//이제는 결정할 수 있겠는데 왜냐하면 Vector의 size()를 호출하면 로우수를 알수있다.
											 //rv."size"는 벡터의 방 개수를 결정한다
				rv.copyInto(dvos);//Vector에 담긴 정보를 객체 배열에 똑같이 복사해 주세요.
				//화면에 출력 하기           //
				for(int j=0;j<dvos.length;j++) { 
			//	for(int j=0;j<4;j++) {
					DeptVO rdvo = dvos[j];
					System.out.println(rdvo.getDeptno()
							+","+rdvo.getDname()
							+","+rdvo.getLoc());
					Vector oneRow = new Vector<>();
					oneRow.add(rdvo.getDeptno());
					oneRow.add(rdvo.getDname());
					oneRow.add(rdvo.getLoc());
					/*
					oneRow.add(10);
					oneRow.add("ACCOUNTING");
					oneRow.add("서울");
					*/
					dtm.addRow(oneRow);
				}
		 } catch (SQLException e2) {//오라클의 에러를 잡아준다 (예외처리)
			 System.out.println("e2 Exception:"+e2.toString());
		 }/////////////////////end of try
	  }////////////////////////end of if
	}
	//여기까지
	//마우스의 추상 메소드이기 때문에 밑에 메소드들이 1개라도 없다면 에러가 일어난다.
	@Override
	public void mouseClicked(MouseEvent me) {
		System.out.println("mouseClicked호출");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()>=2) {
			//너 더블 클릭 했니?
			System.out.println("더블 클릭 한거야");
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		
	}


