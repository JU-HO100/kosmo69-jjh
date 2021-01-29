package movieteamX;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import movieteam.MovieEvent;

public class MovieViewReservation extends JFrame implements ActionListener {
	//선언부
	MovieViewReservation mvr = null;
	JPanel jp_c1 		= new JPanel();
	Font f 				= new Font("그림동화체",Font.BOLD,14);
	JLabel jlb_11 = new JLabel("다만 악에서 구하소서 1관");
	JLabel jlb_12 = new JLabel("다만 악에서 구하소서 2관");
	JLabel jlb_t  = new JLabel("");
	
	JButton jbtn_mv1t1 	= new JButton("06:50");
	JButton jbtn_mv1t2 	= new JButton("10:00");
	JButton jbtn_mv1t3 	= new JButton("13:10");
	JButton jbtn_mv1t4 	= new JButton("16:20");
	JButton jbtn_mv1t5 	= new JButton("20:00");
	JButton jbtn_mv1t6 	= new JButton("23:00");
	JButton jbtn_mv2t1 	= new JButton("07:30");
	JButton jbtn_mv2t2 	= new JButton("10:40");
	JButton jbtn_mv2t3 	= new JButton("12:50");
	JButton jbtn_mv2t4 	= new JButton("15:10");
	JButton jbtn_mv2t5 	= new JButton("19:30");
	JButton jbtn_mv2t6 	= new JButton("22:20");
	JButton jbtn_in 	= new JButton("예매하기");
	JButton jbtn_out 	= new JButton("취소하기");
//	JButton jbtn_1 		= new JButton("다만 악에서 구하소서");
//	JButton jbtn_2 		= new JButton("강철비2");	
//	JButton jbtn_3 		= new JButton("알라딘");	
	JTextArea jta 		= new JTextArea();
	MovieEvent me 		= new MovieEvent();
	
	//생성부
	public MovieViewReservation() {
		
	}
	//화면처리
	public void initDisplay() {
		jp_c1.setLayout(null);
		//이벤트
		jbtn_mv1t1.addActionListener(me);
		jbtn_mv1t2.addActionListener(me);
		jbtn_mv1t3.addActionListener(me);
		jbtn_mv1t4.addActionListener(me);
		jbtn_mv1t5.addActionListener(me);
		jbtn_mv1t6.addActionListener(me);
		jbtn_mv2t1.addActionListener(me);
		jbtn_mv2t2.addActionListener(me);
		jbtn_mv2t3.addActionListener(me);
		jbtn_mv2t4.addActionListener(me);
		jbtn_mv2t5.addActionListener(me);
		jbtn_mv2t6.addActionListener(me);
//		jbtn_1.addActionListener(me);
//		jbtn_2.addActionListener(me);
//		jbtn_3.addActionListener(me);
		jbtn_in.addActionListener(me);
		jbtn_out.addActionListener(me);
		
		//라벨위치
		jlb_11.setBounds(20,30,200,30);
		jlb_12.setBounds(20,85,200,30);
		jlb_11.setFont(f);
		jlb_12.setFont(f);
		
		//버튼위치
		jbtn_mv1t1.setBounds(230, 25, 70, 40);
		jbtn_mv1t2.setBounds(320, 25, 70, 40);
		jbtn_mv1t3.setBounds(410, 25, 70, 40);
		jbtn_mv1t4.setBounds(500, 25, 70, 40);
		jbtn_mv1t5.setBounds(590, 25, 70, 40);
		jbtn_mv1t6.setBounds(680, 25, 70, 40);
		jbtn_mv2t1.setBounds(230, 80, 70, 40);
		jbtn_mv2t2.setBounds(320, 80, 70, 40);
		jbtn_mv2t3.setBounds(410, 80, 70, 40);
		jbtn_mv2t4.setBounds(500, 80, 70, 40);
		jbtn_mv2t5.setBounds(590, 80, 70, 40);
		jbtn_mv2t6.setBounds(680, 80, 70, 40);
		jbtn_in.setBounds	(560, 190, 90, 30);
		jbtn_out.setBounds	(670, 190, 90, 30);
//		jbtn_1.setBounds	(30, 190, 180, 30);
//		jbtn_2.setBounds	(240, 190, 90, 30);
//		jbtn_3.setBounds	(350, 190, 90, 30);
		jlb_t.setBounds(450, 150, 180, 30);
//		jbtn_1.setBackground(new Color(135,206,235));
//		jbtn_1.setForeground(new Color(0,0,0));
//		jbtn_2.setBackground(new Color(140,140,140));
//		jbtn_2.setForeground(new Color(0,0,0));
//		jbtn_3.setBackground(new Color(140,140,140));
//		jbtn_3.setForeground(new Color(0,0,0));
		jbtn_in.setBackground(new Color(245,245,220));
		jbtn_in.setForeground(new Color(0,0,0));
		jbtn_out.setBackground(new Color(140,140,140));
		jbtn_out.setForeground(new Color(0,0,0));
	
		
		//라벨주입
		this.add(jlb_11);
		this.add(jlb_12);
		this.add(jlb_t);
		//버튼주입
		this.add(jbtn_mv1t1);
		this.add(jbtn_mv1t2);
		this.add(jbtn_mv1t3);
		this.add(jbtn_mv1t4);
		this.add(jbtn_mv1t5);
		this.add(jbtn_mv1t6);
		this.add(jbtn_mv2t1);
		this.add(jbtn_mv2t2);
		this.add(jbtn_mv2t3);
		this.add(jbtn_mv2t4);
		this.add(jbtn_mv2t5);
		this.add(jbtn_mv2t6);
		this.add(jbtn_in);
		this.add(jbtn_out);
//		this.add(jbtn_1);
//		this.add(jbtn_2);
//		this.add(jbtn_3);
		//화면
		this.add("Center",jp_c1);
		//테이블
		this.setTitle("예매");
		this.setSize(800,280);
		this.setLocation(330,130);
		this.setVisible(true);
		}
	
		//화면2
		
		
		

	public static void main(String[] args) {
		MovieViewReservation mvr = new MovieViewReservation();
		mvr.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mvr = new MovieViewReservation();
		String label = e.getActionCommand();
		if("06:50".equals(label)) {
			
		}	
		Object obj = new Object();
		if(obj == jbtn_out) {
		
		}
	}

}
