package designbook.test2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TestSearchView extends JDialog {
	
	
	String cols[] = {"도서번호","도서명","저자","출판사","내용"}; 
	String data[][] = new String[0][cols.length];
	DefaultTableModel dtm_bookcode = new DefaultTableModel(data,cols);
	JTable jt_bookcode= new JTable(dtm_bookcode);
	JScrollPane jsp_bookcode = new JScrollPane(jt_bookcode,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JTextField jtf_search = new JTextField();
	JButton jbtn_search = new JButton("검색");
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	
//	ClientManager cm = new ClientManager(this);
//	SearchEvent se = new SearchEvent(this);
	LoginEvent le = null;
//	SignEvent signe = null;
	//BookManager bm = new BookManager(this);
	
	public TestSearchView(LoginEvent loginEvent) {
		this.le = loginEvent;
	}
//	public TestSearchView(SignEvent signEvent) {
//		this.signe = signEvent;
//	}
	void initDisplay() {
//		jbtn_search.addActionListener(se);
//		jt_bookcode.addMouseListener(se);
		this.add("Center",jp_center);
		this.add("North",jp_north);
		jp_north.setLayout(new BorderLayout());
		jp_center.setLayout(new BorderLayout());
		jt_bookcode.setLayout(new FlowLayout());
		
		jp_center.add("Center",jsp_bookcode);
		jp_north.add("Center",jtf_search);
		jp_north.add("East",jbtn_search);

		this.setVisible(true);
		this.setSize(800, 600);
	}
}
/*	if(le.lv.jtf_id.getText()==null) {
			a=signe.su.jtf_id.getText();
			return;
		}else 
			a= le.lv.jtf_id.getText();
*///		}
		//로그인 이벤트가 처리완료 되었을 때 그 결과를 받아와서 처리를 해야 한다.

//	public static void main(String[] args) {
//		SearchView sv = new SearchView();
//		sv.initDisplay();
//	}
 

