package design.copy;

import java.util.List;
import java.util.Vector;
import java.util.logging.Handler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import book.ch8.TimeClient;

public class BookManager extends JFrame {
	//선언부
	static BookManager bm = null;
	
	String cols[] = {"도서번호","도서명","저자","출판사"};/*테이블의 헤더 설정*/
	String data[][] =  new String[0][4];/*json처리 - 오라클처리결과 반영*/
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable jtb 			= new JTable(dtm);
	JScrollPane jsp 	= new JScrollPane(jtb);
	JTextField jtf_name = new JTextField();
	String title 		= null;
	JFrame jf 		   	= new JFrame();//j프레임 생성
	JPanel jp_c		   	= new JPanel();//중앙 패널(속지)
	JPanel jp_w 	   	= new JPanel();//왼쪽 패널(속지)
	JMenuBar jmb 	   	= new JMenuBar();//메뉴바
//	JButton jbtn_ins   	= new JButton("입력");//입력 버튼
//	JButton jbtn_upd   	= new JButton("수정");//수정 버튼
//	JButton jbtn_det   	= new JButton("상세보기");//상세보기 버튼
//	JButton jbtn_exit  	= new JButton("나가기");//나가기 버튼
	JMenu jm_edit 	   	= new JMenu("Edit");//edit 메뉴
	JMenuItem jmi_ins  	= new JMenuItem("입력");//입력 메뉴아이템
	JMenuItem jmi_upd  	= new JMenuItem("수정");//수정 메뉴아이템
	JMenuItem jmi_det  	= new JMenuItem("상세보기");//상세보기 메뉴아이템
	JMenuItem jmi_exit 	= new JMenuItem("나가기");//나가기 메뉴아이템
	JSeparator jsl 	   	= new JSeparator();//텍스트 사이의 선 생성
	JLabel jlb_time    	= new JLabel("현재 시간",JLabel.CENTER);
	//생성자는 디폴트 생성자를 제외하고는 무조건 개발자가 추가로 작성한다.
	BookManagerEventHandler bmeh = new BookManagerEventHandler(this);//bmdh(북매니져 이벤트핸들러)를 호출 및 선언
	BookCRUD bookCRUD 	= new BookCRUD();//bookcrud(북매니저 로직)을 호출 및 선언
//	BookCRUD2 bookCRUD 	= new BookCRUD2();//bookcrud(북매니저 로직)을 호출 및 선언
	BookVO bVO 			= null;
	
	//디폴트 생성자
	public BookManager() {
	}
	/*전체 데이터 갱신하기*/
	public void refreshData() {
		//조회나 혹은 입력 후에 해당 메소드가 연속해서 호출될 수 있으므로 기존에 처리된 결과 화면을 초기화 해야 할것.
		//이미 테이블에 보여지는 데이터가 있는 경우 모두 삭제
		while(dtm.getRowCount() > 0) {
			dtm.removeRow(0);//이런 부분들이 html, 안드로이드   web, app에서 활용|응용
		}
		List<BookVO> bList = bmeh.getBookList();
		if(bList!=null && bList.size() > 0) {
			for(int i=0;i<bList.size();i++) {
				Vector oneRow = new Vector();
				BookVO bVO = bList.get(i);
				oneRow.add(0, bVO.getB_no());
				oneRow.add(1, bVO.getB_name());
				oneRow.add(2, bVO.getAuthor());
				oneRow.add(3, bVO.getPublish());
				dtm.addRow(oneRow);
			}
		}else {
			JOptionPane.showMessageDialog(this, "데이터가 없습니다.","Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	//화면 생성
	public void initDisplay() {
		//이벤트 소스와 이벤트 처리 핸들러 클래스를 매칭하기
		jmi_ins.addActionListener(bmeh);
		jmi_upd.addActionListener(bmeh);
		jmi_det.addActionListener(bmeh);
		jmi_exit.addActionListener(bmeh);
		//버튼 이벤트 처리
//		jbtn_ins.addActionListener(bmeh);
//		jbtn_upd.addActionListener(bmeh);
//		jbtn_det.addActionListener(bmeh);
//		jbtn_exit.addActionListener(bmeh);
		//메뉴에 붙일 아이템
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_det);
		jm_edit.add(jsl);
		jm_edit.add(jmi_exit);	
		jmb.add(jm_edit);
//		TimeClient tc = new TimeClient(jlb_time);
//		tc.start();//콜백 메소드인 run() 자동 호출
		
		//메뉴바 및 타이틀과 사이즈 
		this.add("Center",jsp);
		this.add("South",jlb_time);
		this.setJMenuBar(jmb);
		this.setTitle("도서관리 시스템 Ver1.0");
		this.setSize(500,450);
		this.setVisible(true);
	}
	//메인 메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);//화면 구버전
		bm = new BookManager();//인스턴스화
		bm.initDisplay();//initDisplay 호출
		bm.refreshData();

	}	
	//어노테이션 - 오버라이드: 부모가 선언한 메소드를 재정의 하는것.
	
	
	/*
	 *수정은 마지막에 update로 끝나지만 상세보기는 select만 하고 끝난다.
	 */
	
	public void set(String title, BookVO bVO) {
		this.title = title;
		if(bVO !=null) {
			setName(bVO.getB_name());//*중 요*
		}
	}
	public void setName(String b_name) {
		jtf_name.setText("파이썬");
	}
	public String getName() {
		return jtf_name.getText();
	}
	
}
