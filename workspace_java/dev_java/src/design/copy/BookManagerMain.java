package design.copy;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class BookManagerMain extends JFrame {
	//선언부
	JPanel jp_center   = new JPanel();
	JPanel jp_north    = new JPanel();
	JPanel jp_south    = new JPanel();
	JMenu jm 		   = new JMenu("메뉴");//파라미터 자리에  문자열을 않으면 보이지 않는다.
	JMenuBar jmb 	   = new JMenuBar();
	JMenuItem jmi_sel  = new JMenuItem("찾기");
	JMenuItem jmi_clear  = new JMenuItem("지우기");
	JMenuItem jmi_exit = new JMenuItem("닫기");
	JSeparator jst	   = new JSeparator();
	
	
	//생성부
	public BookManagerMain() {
	}
	public void initDisplay() {
		
		jm.add(jmi_sel);
		jm.add(jmi_clear);
		jm.add(jst);
		jm.add(jmi_exit);
		jmb.add(jm);
		this.setJMenuBar(jmb);
		this.setTitle("목록");
		this.setSize(500,400);
		this.setVisible(true);
		
	}
	
	//메인 메소드
	public static void main(String[] args) {
		BookManagerMain bmm = new BookManagerMain();
		bmm.initDisplay();
		
	}

}
