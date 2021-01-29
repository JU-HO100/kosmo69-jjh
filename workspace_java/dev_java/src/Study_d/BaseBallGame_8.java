package Study_d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

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

public class BaseBallGame_8 {
	JFrame jf = new JFrame();
	JPanel  jp_c = new JPanel();//중앙
	JPanel  jp_e = new JPanel();//동쪽
	JMenuBar jmb = new JMenuBar();//메뉴바 생성
	JToolBar jtb = new JToolBar();//툴바 생성
	JMenu   jm_file 	 	= new JMenu("메뉴");//메뉴파일 생성
	JButton jbt			 	= new JButton();//버튼생성
	JButton jbt_new  	 	= new JButton("새게임");//버튼에 새게임 생성
	JButton jbt_dap  	 	= new JButton("답");//버튼에 답 생성
	JButton jbt_clear    	= new JButton("지우기");//버튼에 지우기 생성
	JButton jbt_exit     	= new JButton("나가기");//버튼에 나가기 생성
	JMenuItem jmi_new 	 	= new JMenuItem("새게임");//메뉴에 새게임 생성
	JMenuItem jmi_dap 	 	= new JMenuItem("답");//메뉴에 답 생성
	JMenuItem jmi_clear  	= new JMenuItem("지우기");//메뉴에 지우기 생성
	JMenuItem jmi_exit 	 	= new JMenuItem("나가기");//메뉴에 나가기 생성
	JTextField  jtf_user 	= new JTextField();
//	JTextArea   jta_display = null();
//	JScrollPane jsp_display = null();

	public void initDisplay() {
//		jta_display = new JTextArea() {
		System.out.println("initDisplay 호출 성공");	
		JFrame  jf	 = new JFrame();
		jp_c.setBackground(Color.white);
		jp_e.setBackground(Color.yellow);
		jf.add		  ("중앙",jp_c);
		jf.add		  ("동쪽",jp_e);
		jmb.add		  (jm_file);
		jp_e.add	  (jbt_new);	
		jp_e.add	  (jbt_dap);	
		jp_e.add	  (jbt_clear);		
		jp_e.add	  (jbt_exit);	
		jp_c.setLayout(new BorderLayout());
		jf.setTitle   ("야구게임Test");
		jf.setSize	  (500,400);
		jf.setVisible (true);
		jf.setLayout  (new BorderLayout(20,20));
		jf.setJMenuBar(jmb);
		jmi_new.add   ("새게임",jmi_new);
		jmi_dap.add   ("답",jmi_dap);
		jmi_clear.add ("지우기",jmi_clear);
		jmi_exit.add  ("나가기",jmi_exit);
		jm_file.add	  (jbt_new);
		jm_file.add	  (jbt_dap);
		jm_file.add	  (jbt_clear);
		jm_file.add	  (jbt_exit);
		jbt_new.setBackground(new Color(50,180,100));
		jbt_new.setForeground(new Color(212,212,212));
		jbt_dap.setBackground(new Color(150,150,150));
		jbt_dap.setForeground(new Color(212,212,212));
		jbt_clear.setBackground(new Color(30,90,90));
		jbt_clear.setForeground(new Color(212,212,212));
		jbt_exit.setBackground(new Color(80,100,130));
		jbt_exit.setForeground(new Color(212,212,212));
	
	
	
	
	
		
	}
	public static void main(String[] args) {
		BaseBallGame_8 bbg8 = new BaseBallGame_8();
		bbg8.initDisplay();
//		System.out.println();
		
		
	}
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("actionPerformed 호출성공");
//			String label = e.getActionCommand();
	}
	
}
