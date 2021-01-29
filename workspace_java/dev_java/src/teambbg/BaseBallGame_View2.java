package teambbg;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

	public class BaseBallGame_View2 extends JFrame {
//		Main2 m = new Main2(this);
		BaseBallGame_View2 bbg = new BaseBallGame_View2();
		JMenu jm_file 	      = new JMenu("파일");
		JMenuItem jmi_new 	  = new JMenuItem("새게임");
		JMenuItem jmi_dap 	  = new JMenuItem("답");
		JMenuItem jmi_clear   = new JMenuItem("지우기");
		JMenuItem jmi_exit 	  = new JMenuItem("나가기");
		JPanel jp_center 	  = new JPanel();
		JPanel jp_south 	  = new JPanel();
		JPanel jp_east 	 	  = new JPanel();
		JMenuBar jmb 		  = new JMenuBar();
		JToolBar jtb 	 	  = new JToolBar();
		JTextArea jta_display = new JTextArea();
		JTextField jtf_user	  = new JTextField();
		JScrollPane jsp  	  = new JScrollPane();
		JButton jbtn_new   	  = new JButton("새게임");
		JButton jbtn_dap      = new JButton("답");
		JButton jbtn_clear    = new JButton("지우기");
		JButton jbtn_exit     = new JButton("나가기");
		JScrollPane jsp_display = new JScrollPane(jta_display
        		, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public void	initDisplay() {
		System.out.println("호출 성공");
//		jtf_user.addActionListener(this);
		JFrame jf = new JFrame();
		//화면
		jf.add("Center",jp_center);		
		jf.add("South",jp_south);
		jf.add("East",jp_east);
		jf.setLayout(new BorderLayout(20,20));
		jf.setJMenuBar(jmb);
		jp_center.setLayout(new BorderLayout());
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_user);
		jta_display.setLineWrap(true);
		//오른쪽 메뉴바
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		jp_east.setLayout(new GridLayout(4, 1));
		//왼쪽상단 메뉴바
		jmb.add(jm_file);
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_clear);
		jm_file.add(jmi_exit);		
		//화면 타이틀|사이즈
		jf.setTitle("야구 숫자 게임 Team");
		jf.setSize(500, 400);
		jf.setVisible(true);
	
	
	}
}
