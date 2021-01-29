package teammovie;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Team.MovieEvent;

public class MovieViewMeun extends JDialog {
	//선언
	JPanel jp_c 		= new JPanel();
	JPanel jp_s 		= new JPanel();
	JPanel jp_n 		= new JPanel();
	JPanel jp_w 		= new JPanel();
	JMenu jm_mv  		= new JMenu("영화");
	JMenu jm_rv  		= new JMenu("예매");
	JMenu jm_mt  		= new JMenu("극장");

	JButton jbtn_exit   = new JButton("나가기");
	JMenuBar jmb 		= new JMenuBar();
	JButton jbtn_mv = new JButton("영화");
//	JButton jbtn_mt = new JButton("극장");
	JButton jbtn_re = new JButton("예약");
//	JButton jbtn_tt = new JButton("시간표");
	JSeparator jsl		= new JSeparator();
	MovieEvent me 		= new MovieEvent(this);
	MovieLogic ml 		= new MovieLogic();

	JLabel jlb_id 	  	= new JLabel("아이디");
	JLabel jlb_pw 	  	= new JLabel("비밀번호");
	JTextField jtf_id 	= new JTextField();
	JTextField jtf_pw 	= new JTextField();

	
	//생성
	public MovieViewMeun() {
	}
	public void initDisplay() {
		//이벤트 처리
		jbtn_mv.addActionListener(me);
//		jbtn_mt.addActionListener(me);
		jbtn_re.addActionListener(me);
//		jbtn_tt.addActionListener(me);
		jbtn_exit.addActionListener(me);	
		//버튼
		jp_s.add("South",jbtn_mv);
//		jp_s.add("South",jbtn_mt);
		jp_s.add("South",jbtn_re);
//		jp_s.add("South",jbtn_tt);
		jp_s.setLayout(new GridLayout(0,2));

		//테이블 및 판넬
		this.setJMenuBar(jmb);
		this.add("Center",jp_c);
		this.add("South",jp_s);
		this.setTitle("Movietheater");
		this.setSize(400,400);
		this.setVisible(true);
	}	
	
}
