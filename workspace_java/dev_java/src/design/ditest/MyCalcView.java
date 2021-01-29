package design.ditest;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalcView extends JFrame {
	public JTextField jtf 		= new JTextField(40);
	public JPanel  jp_c   		= new JPanel();
	public JPanel  jp_e   		= new JPanel();
	public JPanel  jp_s   		= new JPanel();
	public JButton jbtnpoint  	= new JButton(".");
	public JButton jbtn0  		= new JButton("0");
	public JButton jbtn1  		= new JButton("1");
	public JButton jbtn2  		= new JButton("2");
	public JButton jbtn3  		= new JButton("3");
	public JButton jbtn4  		= new JButton("4");
	public JButton jbtn5  		= new JButton("5");
	public JButton jbtn6  		= new JButton("6");
	public JButton jbtn7  		= new JButton("7");
	public JButton jbtn8  		= new JButton("8");
	public JButton jbtn9  		= new JButton("9");
	public JButton jbtnc  		= new JButton("C");
	public JButton jbtnplus  	= new JButton("+");
	public JButton jbtnminus  	= new JButton("-");
	public JButton jbtnsquare  	= new JButton("*");
	public JButton jbtnpdivide  = new JButton("/");
	public JButton jbtnequal  	= new JButton("=");
	MyCalcEventHandler myCalcHandler = new MyCalcEventHandler(this);
	MyCalcLogic mcl = new MyCalcLogic();
	public MyCalcView() {
		initDisplay();
	}
	public JButton setButton() {
		return jbtn7;
	}
	public void initDisplay() {
		//이벤트
		jbtnpoint.addActionListener(myCalcHandler);
		jbtn1.addActionListener(myCalcHandler);
		jbtn2.addActionListener(myCalcHandler);
		jbtn3.addActionListener(myCalcHandler);
		jbtn4.addActionListener(myCalcHandler);
		jbtn5.addActionListener(myCalcHandler);
		jbtn6.addActionListener(myCalcHandler);
		jbtn7.addActionListener(myCalcHandler);
		jbtn8.addActionListener(myCalcHandler);
		jbtn9.addActionListener(myCalcHandler);
		jbtn0.addActionListener(myCalcHandler);
		jbtnc.addActionListener(myCalcHandler);
		jbtnplus.addActionListener(myCalcHandler);
		jbtnminus.addActionListener(myCalcHandler);
		jbtnsquare.addActionListener(myCalcHandler);
		jbtnpdivide.addActionListener(myCalcHandler);
		jbtnequal.addActionListener(myCalcHandler);
		//버튼분할
		jp_c.setLayout(new GridLayout(3,4));
		jp_e.setLayout(new GridLayout(5,1));
		//버튼
		jp_e.add(jbtnc);
		jp_c.add(jbtn1);
		jp_c.add(jbtn2);
		jp_c.add(jbtn3);
		jp_c.add(jbtn4);
		jp_c.add(jbtn5);
		jp_c.add(jbtn6);
		jp_c.add(jbtn7);
		jp_c.add(jbtn8);
		jp_c.add(jbtn9);
		jp_c.add(jbtn0);
		jp_c.add(jbtnpoint);
		jp_c.add(jbtnequal);
		jp_e.add(jbtnpdivide);
		jp_e.add(jbtnsquare);
		jp_e.add(jbtnminus);
		jp_e.add(jbtnplus);
		//패널및 텍스트필드
		this.add("North", jtf);
		this.add("Center",jp_c);
//		this.add("South",jp_s);
		this.add("East",jp_e);
		this.setTitle("전자계산기");
		this.setSize(500, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MyCalcView mcv = new MyCalcView();
//		mcv.initDisplay();
	}

}
