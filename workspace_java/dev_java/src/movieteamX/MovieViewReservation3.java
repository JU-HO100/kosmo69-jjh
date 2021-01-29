package movieteamX;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import movieteam.MovieEvent;

public class MovieViewReservation3 extends JFrame {
	//선언부
		JPanel jp_c3 		= new JPanel();
		Font f 				= new Font("그림동화체",Font.BOLD,14);
		JLabel jl_31 = new JLabel("알라딘 5관");
		JLabel jl_32 = new JLabel("알라딘 6관");
		JButton jbtn_mv5t1 	= new JButton("07:00");	
		JButton jbtn_mv5t2 	= new JButton("09:50");
		JButton jbtn_mv5t3 	= new JButton("12:40");
		JButton jbtn_mv5t4 	= new JButton("15:30");
		JButton jbtn_mv5t5 	= new JButton("18:20");
		JButton jbtn_mv5t6 	= new JButton("21:10");
		JButton jbtn_mv6t1 	= new JButton("06:20");
		JButton jbtn_mv6t2 	= new JButton("09:10");
		JButton jbtn_mv6t3 	= new JButton("12:00");
		JButton jbtn_mv6t4 	= new JButton("14:50");
		JButton jbtn_mv6t5 	= new JButton("17:40");
		JButton jbtn_mv6t6 	= new JButton("20:30");
		JButton jbtn_in 	= new JButton("예매하기");
		JButton jbtn_out 	= new JButton("취소하기");
		JButton jbtn_1 		= new JButton("다만 악에서 구하소서");
		JButton jbtn_2 		= new JButton("강철비2");	
		JButton jbtn_3 		= new JButton("알라딘");	
		JTextArea jta 		= new JTextArea();
		JLabel jlb_mv3 		= new JLabel("영화3");
		MovieEvent me 		= new MovieEvent(this);
	
	public MovieViewReservation3() {
		
	}
	
	public void initDisplay() {
		jp_c3.setLayout(null);
		//이벤트
		jbtn_mv5t1.addActionListener(me);
		jbtn_mv5t2.addActionListener(me);
		jbtn_mv5t3.addActionListener(me);
		jbtn_mv5t4.addActionListener(me);
		jbtn_mv5t5.addActionListener(me);
		jbtn_mv5t6.addActionListener(me);
		jbtn_mv6t1.addActionListener(me);
		jbtn_mv6t2.addActionListener(me);
		jbtn_mv6t3.addActionListener(me);
		jbtn_mv6t4.addActionListener(me);
		jbtn_mv6t5.addActionListener(me);
		jbtn_mv6t6.addActionListener(me);
		jbtn_in.addActionListener(me);
		jbtn_out.addActionListener(me);
		jbtn_1.addActionListener(me);
		jbtn_2.addActionListener(me);
		jbtn_3.addActionListener(me);
		
		//라벨
		jl_31.setBounds(60,30,200,30);
		jl_32.setBounds(60,85,200,30);
		jl_31.setFont(f);
		jl_32.setFont(f);
		//버튼위치
		jbtn_mv5t1.setBounds(200, 25, 70, 40);
		jbtn_mv5t2.setBounds(290, 25, 70, 40);
		jbtn_mv5t3.setBounds(380, 25, 70, 40);
		jbtn_mv5t4.setBounds(470, 25, 70, 40);
		jbtn_mv5t5.setBounds(560, 25, 70, 40);
		jbtn_mv5t6.setBounds(650, 25, 70, 40);
		jbtn_mv6t1.setBounds(200, 80, 70, 40);
		jbtn_mv6t2.setBounds(290, 80, 70, 40);
		jbtn_mv6t3.setBounds(380, 80, 70, 40);
		jbtn_mv6t4.setBounds(470, 80, 70, 40);
		jbtn_mv6t5.setBounds(560, 80, 70, 40);
		jbtn_mv6t6.setBounds(650, 80, 70, 40);
		jbtn_in.setBounds	(560, 150, 90, 30);
		jbtn_out.setBounds	(670, 150, 90, 30);
		jbtn_1.setBounds	(30, 150, 180, 30);
		jbtn_2.setBounds	(240, 150, 90, 30);
		jbtn_3.setBounds	(350, 150, 90, 30);
		
		//라벨주입
		this.add(jl_31);
		this.add(jl_32);
		//버튼주입
		this.add(jbtn_mv5t1);
		this.add(jbtn_mv5t2);
		this.add(jbtn_mv5t3);
		this.add(jbtn_mv5t4);
		this.add(jbtn_mv5t5);
		this.add(jbtn_mv5t6);
		this.add(jbtn_mv6t1);
		this.add(jbtn_mv6t2);
		this.add(jbtn_mv6t3);
		this.add(jbtn_mv6t4);
		this.add(jbtn_mv6t5);
		this.add(jbtn_mv6t6);
		this.add(jbtn_in);
		this.add(jbtn_out);
		this.add(jbtn_1);
		this.add(jbtn_2);
		this.add(jbtn_3);
		jbtn_1.setBackground(new Color(140,140,140));
		jbtn_1.setForeground(new Color(0,0,0));
		jbtn_2.setBackground(new Color(140,140,140));
		jbtn_2.setForeground(new Color(0,0,0));
		jbtn_3.setBackground(new Color(135,206,235));
		jbtn_3.setForeground(new Color(0,0,0));
		jbtn_in.setBackground(new Color(245,245,220));
		jbtn_in.setForeground(new Color(0,0,0));
		jbtn_out.setBackground(new Color(140,140,140));
		jbtn_out.setForeground(new Color(0,0,0));
		//화면
		this.add("Center",jp_c3);
		//테이블
		this.setTitle("예매");
		this.setSize(800,250);
		this.setLocation(500,280);
		this.setVisible(true);
	}	
	/*
	public static void main(String[] args) {
		MovieViewReservation3 mvr3 = new MovieViewReservation3();
		mvr3.initDisplay();
	}*/
	
}
