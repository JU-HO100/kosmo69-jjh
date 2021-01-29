package design.book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//public class BookManager extends JFrame implements ActionListener{
public class BookManager extends JFrame{
	static BookManager bm = null;
	String cols[] = {"도서번호","도서명","저자","출판사"};//테이블의 헤더 설정
	String data[][] = new String[0][4];//json처리-오라클처리결과 반영
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	JMenuBar jmb 		= new JMenuBar();
	JMenu    jm_edit 	= new JMenu("Edit");
	JMenuItem jmi_ins   = new JMenuItem("입력");
	JMenuItem jmi_upd	= new JMenuItem("수정");
	JMenuItem jmi_del	= new JMenuItem("삭제");
	JMenuItem jmi_det	= new JMenuItem("상세보기");
	JSeparator js1		= new JSeparator();
	JMenuItem jmi_exit	= new JMenuItem("나가기");
	JLabel    jlb_time =  new JLabel("현재 시간",JLabel.CENTER);
	//생성자는 디폴트 생성자를 제외하고는 무조건 개발자가 추가로 작성한다.
	BookManagerEventHandler handler = new BookManagerEventHandler(this);
	BookCRUD bookCRUD = new BookCRUD();
	public BookManager(){
		
	}
	//전체 데이터 갱신하기
	public void refreshData() {
		//조회나 혹은 입력 후에 해당 메소드가 연속해서 호출될 수 있으므로 기존에 처리된 결과 화면을 초기화 해야 할것.
		//이미 테이블에 보여지는 데이터가 있는 경우 모두 삭제
		while(dtm.getRowCount() > 0) {
			dtm.removeRow(0);//이런 부분들이 html, 안드로이드   web, app에서 활용|응용
		}
		List<BookVO> bList = handler.getBookList();
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
	public void initDisplay() {
		//insert here
		//이벤트 소스와 이벤트 처리 핸들러 클래스를 매칭하기
		jmi_ins.addActionListener(handler);//this는 BookManager 이 클래스 안에 actionPerformed가 있어야 한다.
		jmi_upd.addActionListener(handler);//this는 BookManager 이 클래스 안에 actionPerformed가 있어야 한다.
		jmi_del.addActionListener(handler);//정보 삭제하기
		jmi_det.addActionListener(handler);//상세보기 메뉴아이템을 클릭
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_del);
		jm_edit.add(jmi_det);
		jm_edit.add(js1);
		jm_edit.add(jmi_exit);
		jmb.add(jm_edit);
		//TimeClient tc = new TimeClient(jlb_time);
		//tc.start();//콜백 메소드인 run()이 자동 호출
		this.add("Center",jsp);
		this.add("South",jlb_time);
		this.setJMenuBar(jmb);
		this.setTitle("도서관리 시스템 Ver1.0");
		this.setSize(700, 450);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		bm = new BookManager();
		bm.initDisplay();
		bm.refreshData();
	}
	//어노테이션-오버라이드:부모가 선언한 메소드를 재정의하는것.
	/*
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * }
	 */

}
