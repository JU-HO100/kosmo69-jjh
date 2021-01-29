package Study_d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Game_Maker {
	JFrame jf 		  		= new JFrame();
	JPanel jp_c 	  		= new JPanel();
	JPanel jp_e 	  		= new JPanel();
	Font f 					= new Font("Thoma",Font.BOLD,16);
	JMenu jm 		  		= new JMenu();
	JMenu jm_file 	  		= new JMenu();
	JMenuItem jmi 			= new JMenuItem();
	JButton jbtn_new   		= new JButton("새게임");
	JButton jbtn_dap	  		= new JButton("답");
	JButton jbtn_clear 		= new JButton("지우기");
	JButton jbtn_exit  		= new JButton("나가기");
	JMenu jm_new   	  		= new JMenu  ("새게임");
	JMenu jm_dap   	  		= new JMenu  ("답");
	JMenu jm_clear    		= new JMenu  ("지우기");
	JMenu jm_exit  	  		= new JMenu  ("나가기");
	JTextArea jta_display 	= new JTextArea();
	JScrollPane jsp_display	= new JScrollPane(jta_display
    										, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            								, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	void initDisplay() {
		
			jsp_display = new JScrollPane(jta_display);
//			jbt_new.setBackground(new Color(50,180,100));//버튼 배경색 바꾸기
//			jbt_new.setForeground(new Color(212,212,212));//버튼색 바꾸기
//			jbt_dap.setBackground(new Color(7,84,170));
//			jbt_dap.setForeground(new Color(212,212,212));
//			jbt_clear.setBackground(new Color(54,54,54));
//			jbt_clear.setForeground(new Color(212,212,212));
//			jbt_exit.setBackground(new Color(90,9,9));
//			jbt_exit.setForeground(new Color(212,212,212));
			jp_e.setLayout(new GridLayout(4,1));
			jp_c.setBackground(Color.blue);
			jp_e.setBackground(Color.yellow);
			
			jp_e.add(jbtn_new);
			jp_e.add(jbtn_dap);
			jp_e.add(jbtn_clear);
			jp_e.add(jbtn_exit);
			
			jp_c.setLayout(new BorderLayout());
			jm_new.add   ("새게임");
			jm_dap.add   ("답");
			jm_clear.add ("지우기");
			jm_exit.add  ("나가기");
			
			jf.add("Center",jp_c);
			jf.add("East",jp_e);
			jf.setTitle  ("아아");
			jf.setSize   (400,300);
			jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		Game_Maker gm = new Game_Maker();
		gm.initDisplay();
	}
}
