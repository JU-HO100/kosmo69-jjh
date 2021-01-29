package teammovie;




import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MovieLogic2 extends JFrame implements ActionListener{
	JFrame jf = new JFrame();
	
	JPanel jp_center = new JPanel();
	JPanel jp_east = new JPanel();
	JPanel jp_north = new JPanel();
	JPanel jp_north_t = new JPanel();
	JPanel jp_north_s = new JPanel();
	 
	JTextField jtf = new JTextField(30);
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_scr = new JButton("스크린");
	JButton jbtn_next = new JButton("다음");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	ArrayList<String> seatinfo = new ArrayList<>();
	ArrayList<Integer> seatrow = new ArrayList<>(); 
	ArrayList<Integer> seatcol = new ArrayList<>(); 
	
	String[][] a = new String[10][10];//시험용 false true 생성
	String[] name = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	JCheckBox[][] seat = new JCheckBox[10][10];
	
	public void seatval() {
		for(int j=0;j<10;j++) {
			for(int i=0;i<10;i++) {
				int e = (int)(Math.random()*10);
				if(e%2==0)a[j][i] ="false";
				else      a[j][i] ="true";
			}
		}
	}
	public void initDisplay() {
		
		p1.setLayout(new GridLayout(10,10));
		p1.setPreferredSize(new Dimension(500,500));
		
		for(int j=0;j<10;j++) {
			for(int i=0; i<10;i++) {
			   String tof = a[j][i];
			   Boolean bb = Boolean.parseBoolean(tof);
			   Boolean b2 = null;
			   if(bb==true) b2=false;
			   else b2=true;
			   seat[j][i] = new JCheckBox(name[j]+" "+(i+1),bb);
			   seat[j][i].setEnabled(b2);
			   seat[j][i].setBorderPainted(true); 
			   p1.add(seat[j][i]); 
			   seat[j][i].addActionListener(this);
		}
		}
//		p2.setLayout(new GridLayout(10,10));
//		p2.setPreferredSize(new Dimension(250,250));
//		
//		for(int j=0;j<10;j++) {
//		for(int i=0; i<10;i++) {
//			seat[j][i] = new JCheckBox();
//			   
//			   seat[j][i].setBorderPainted(true); 
//			   p2.add(seat[j][i]); 
//		}
//		}
//		p3.setLayout(new GridLayout(10,10));
//		p3.setPreferredSize(new Dimension(250,250));
//		
//		for(int j=0;j<10;j++) {
//		for(int i=0; i<10;i++) {
//			seat[j][i] = new JCheckBox();
//			   
//			   seat[j][i].setBorderPainted(true); 
//			   p3.add(seat[j][i]); 
//		}
//		}
		jbtn_next.addActionListener(this);		
		jp_north.setLayout(new BorderLayout());
		jp_north_t.add("Center",jtf);
		jp_north_t.add("East",jbtn_ins);
		jp_north_s.add("Center",jbtn_scr);
		jp_north.add("North",jp_north_t);
		jp_north.add("South",jp_north_s);
		
		
		this.setLayout(new BorderLayout());
		
		jp_center.add("Center",p1);
		jp_center.add("East",p2);
		jp_center.add("West",p3);
		this.add("North",jp_north);
		this.add("East",jp_center);
		this.add("South",jbtn_next);
		this.setSize(1200,1000);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MovieLogic2 st3 = new MovieLogic2();
		st3.seatval();
		st3.initDisplay();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
				
		if(obj!=jbtn_next) {
			String lable = e.getActionCommand();
			seatinfo.add(lable);
		}
			else if(obj==jbtn_next) {
				for(String temp : seatinfo) {
					int x= 0;
					int y = 0;
					String s[] = temp.split(" ");
					switch(s[0]) {
					case "A": x = 1;
					 break;
					case "B": x = 2;
					 break;
					case "C": x = 3;
					 break;
					case "D": x = 4;
					 break;
					case "E": x = 5;
					 break;
					case "F": x = 6;
					 break;
					case "G": x = 7;
					 break;
					case "H": x = 8;
					 break;
					case "I": x = 9;
					 break;
					case "J": x = 10;
					 break;
					}
					 y = Integer.parseInt(s[1]);
					 seatrow.add(x);
					 seatcol.add(y);
					 System.out.println(x+", "+y);				
			}
		}
	}
}
