package Study_d;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameView extends JFrame {
	JScrollPane jspLine = null;
	JPanel jp_center 	= new JPanel();
	JPanel jp_south  	= new JPanel();
	JPanel jp_north  	= new JPanel();
	JMenuBar jmb		= new JMenuBar();
	JMenu jm_menu 		= new JMenu("메뉴");
	JMenuItem jmi_new 	= new JMenuItem("새게임");
	JMenuItem jmi_dap 	= new JMenuItem("답");
	JMenuItem jmi_exit 	= new JMenuItem("나가기");
	JButton jbtn_login  = new JButton("로그인");
	JButton jbtn_new 	= new JButton("새게임");
	JButton jbtn_dap 	= new JButton("답");
	JButton jbtn_exit 	= new JButton("나가기");
	JTextArea jta		= new JTextArea();
	JTextField jtf_id 	= new JTextField();
	JTextField jtf_pw 	= new JTextField();
	JLabel jlb_id 	    = new JLabel("ID");
	JLabel jlb_pw 	    = new JLabel("PW");
	
	
public GameView() {
}

public void initDisplay() {
	System.out.println("호출");
	JFrame jf = new JFrame();
	jp_center = new JPanel();
	jp_south  = new JPanel();
	jp_north  = new JPanel();	
	jp_center.setLayout(null);//FlowLayout이다-null-뭉갠다
	jlb_id.setBounds(20, 20, 50, 20);
	jtf_id.setBounds(70, 20, 100, 20);
	jlb_pw.setBounds(50, 20, 50, 20);
	jtf_pw.setBounds(100, 20, 100, 20);
	jp_center.add("Center",jlb_id);
	jp_center.add("Center",jtf_id);
	jp_center.add("Center",jlb_pw);
	jp_center.add("Center",jtf_pw);
	jspLine   = new JScrollPane(jp_center);
	
	jmb.add(jm_menu);
	jm_menu.add(jmi_new);
	jm_menu.add(jmi_dap);
	jm_menu.add(jmi_exit);
	this.setTitle("로그인");
	jf.add("Center",jp_center);	
	jf.add("South",jp_south);	
	jf.add("North",jp_north);	
	this.setJMenuBar(jmb);
	this.setSize(400,300);
	this.setVisible(true);
	
	
	
	
}
}
