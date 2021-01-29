package movieteam;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Display3 extends JFrame {
			JPanel jp_c 			= new JPanel();
			JPanel jp_n 			= new JPanel();
			JPanel jp_s 			= new JPanel();
			JLabel jlb_s 	    	= new JLabel("스크린");
			JButton jbtn_back 		= new JButton("뒤로가기");
//			JButton jbtn_home 		= new JButton("홈화면");
			JButton jbtn_pay 		= new JButton("결제");
			JScrollPane jsp_zipcode = new JScrollPane(jbtn_pay, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
													,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			Font f 			  		= new Font("휴면매직체",Font.BOLD, 5);
	    //인스턴스화
			DisplayEvent de 		= null;
	
	public Display3() {
		
	}

	public Display3(DisplayEvent displayEvent) {
		this.de = displayEvent;
	}

	public void initDisplay() {//영화예매창1(시간)
//         	jbtn_home.addActionListener(this);
         	jbtn_back.addActionListener(de);
         	jbtn_pay.addActionListener(de);
          	//jp_south.setLayout(null);
          	jp_n.add(jsp_zipcode);
          	jp_s.add("Center", jbtn_pay);
//          	jp_s.add("East", jbtn_home);
          	jp_s.add("East", jbtn_back);
          	
          	jbtn_back.setBounds(500, 300, 50, 20);
//          	jbtn_home.setBounds(500, 200, 100, 20);
          	jbtn_pay.setBounds(500,100 , 100, 20);
          	
          	this.add("North",jp_n);   
          	this.add("South",jp_s);   
          	this.setSize(1200,600);
          	this.setVisible(true);
          	this.setLocation(370,180);
          	setResizable(false);
       }
//	public static void main(String[] agrs) {
//		Display3 d3 = new Display3();
//		d3.initDisplay();
//	}
}
