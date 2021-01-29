package movieteamX;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import movieteam.MovieEvent;

public class MovieViewReservation2 extends JFrame {
		//선언부
		JPanel jp_c2 		= new JPanel();
		Font f 				= new Font("그림동화체",Font.BOLD,14);
		JLabel jl_21 = new JLabel("강철비2 3관");
		JLabel jl_22 = new JLabel("강철비2 4관");
		JButton jbtn_mv3t1 	= new JButton("06:20");	
		JButton jbtn_mv3t2 	= new JButton("08:10");
		JButton jbtn_mv3t3 	= new JButton("11:40");
		JButton jbtn_mv3t4 	= new JButton("14:00");
		JButton jbtn_mv3t5 	= new JButton("17:10");
		JButton jbtn_mv3t6 	= new JButton("20:30");
		JButton jbtn_mv4t1 	= new JButton("06:20");
		JButton jbtn_mv4t2 	= new JButton("09:10");
		JButton jbtn_mv4t3 	= new JButton("12:00");
		JButton jbtn_mv4t4 	= new JButton("14:50");
		JButton jbtn_mv4t5 	= new JButton("17:40");
		JButton jbtn_mv4t6 	= new JButton("20:30");
		JButton jbtn_in 	= new JButton("예매하기");
		JButton jbtn_out 	= new JButton("취소하기");
		JButton jbtn_1 		= new JButton("다만 악에서 구하소서");
		JButton jbtn_2 		= new JButton("강철비2");	
		JButton jbtn_3 		= new JButton("알라딘");	
		
		JTextArea jta 		= new JTextArea();
		JLabel jlb_mv2 		= new JLabel("영화2");
		MovieEvent me 		= new MovieEvent(this);
	
	
	public void MovieViewReservation2() {
		
	}
	
	public void initDisplay() {
		jp_c2.setLayout(null);
		//이벤트
		jbtn_mv3t1.addActionListener(me);
		jbtn_mv3t2.addActionListener(me);
		jbtn_mv3t3.addActionListener(me);
		jbtn_mv3t4.addActionListener(me);
		jbtn_mv3t5.addActionListener(me);
		jbtn_mv3t6.addActionListener(me);
		jbtn_mv4t1.addActionListener(me);
		jbtn_mv4t2.addActionListener(me);
		jbtn_mv4t3.addActionListener(me);
		jbtn_mv4t4.addActionListener(me);
		jbtn_mv4t5.addActionListener(me);
		jbtn_in.addActionListener(me);
		jbtn_out.addActionListener(me);
		jbtn_1.addActionListener(me);
		jbtn_2.addActionListener(me);
		jbtn_3.addActionListener(me);
		
		//라벨
		jl_21.setBounds(60,30,200,30);
		jl_22.setBounds(60,85,200,30);
		jl_21.setFont(f);
		jl_22.setFont(f);
		//버튼위치
		jbtn_mv3t1.setBounds(200, 25, 70, 40);
		jbtn_mv3t2.setBounds(290, 25, 70, 40);
		jbtn_mv3t3.setBounds(380, 25, 70, 40);
		jbtn_mv3t4.setBounds(470, 25, 70, 40);
		jbtn_mv3t5.setBounds(560, 25, 70, 40);
		jbtn_mv3t6.setBounds(650, 25, 70, 40);
		jbtn_mv4t1.setBounds(200, 80, 70, 40);
		jbtn_mv4t2.setBounds(290, 80, 70, 40);
		jbtn_mv4t3.setBounds(380, 80, 70, 40);
		jbtn_mv4t4.setBounds(470, 80, 70, 40);
		jbtn_mv4t5.setBounds(560, 80, 70, 40);
		jbtn_mv4t6.setBounds(650, 80, 70, 40);
		jbtn_in.setBounds	(560, 150, 90, 30);
		jbtn_out.setBounds	(670, 150, 90, 30);
		jbtn_1.setBounds	(30, 150, 180, 30);
		jbtn_2.setBounds	(240, 150, 90, 30);
		jbtn_3.setBounds	(350, 150, 90, 30);
		jbtn_1.setBackground(new Color(140,140,140));
		jbtn_1.setForeground(new Color(0,0,0));
		jbtn_2.setBackground(new Color(135,206,235));
		jbtn_2.setForeground(new Color(0,0,0));
		jbtn_3.setBackground(new Color(140,140,140));
		jbtn_3.setForeground(new Color(0,0,0));
		jbtn_in.setBackground(new Color(245,245,220));
		jbtn_in.setForeground(new Color(0,0,0));
		jbtn_out.setBackground(new Color(140,140,140));
		jbtn_out.setForeground(new Color(0,0,0));
		//라벨주입
		this.add(jl_21);
		this.add(jl_22);
		//버튼
		this.add(jbtn_mv3t1);
		this.add(jbtn_mv3t2);
		this.add(jbtn_mv3t3);
		this.add(jbtn_mv3t4);
		this.add(jbtn_mv3t5);
		this.add(jbtn_mv3t6);
		this.add(jbtn_mv4t1);
		this.add(jbtn_mv4t2);
		this.add(jbtn_mv4t3);
		this.add(jbtn_mv4t4);
		this.add(jbtn_mv4t5);
		this.add(jbtn_mv4t6);
		this.add(jbtn_in);
		this.add(jbtn_out);
		this.add(jbtn_1);
		this.add(jbtn_2);
		this.add(jbtn_3);
		//화면
		this.add("Center",jp_c2);
		//테이블
		this.setTitle("예매");
		this.setSize(800,250);
		this.setLocation(500,280);
		this.setVisible(true);

	}
	/*
	public static void main(String[] args) {
		MovieViewReservation2 mvr2 = new MovieViewReservation2();
		mvr2.initDisplay();
	}*/
}
