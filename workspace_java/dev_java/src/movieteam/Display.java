package movieteam;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Display extends JFrame {
//	 implements ActionListener
	//선언부
	   String imgPath 	    = "C:\\workspace_java\\dev_java\\src\\movieteam\\";
	   ImageIcon iicon 	    = new ImageIcon(imgPath+"");
	   JPanel jp_center     = new JPanel();
	   JPanel jp_south	    = new JPanel();
	   JPanel jp_east 	    = new JPanel();
	   JPanel jp_west 	    = new JPanel();
	   JPanel jp_north 	    = new JPanel();
	   JLabel jlb_id  	    = new JLabel("I D");
	   JTextField id_t 	    = new JTextField(50);
	   JLabel jlb_pw 	    = new JLabel("P W");
	   JTextField pw_t 	    = new JTextField(50);
	   JButton jbtn_login   = new JButton("로그인");
	   JButton jbtn_info1   = new JButton("영화정보1");
	   JButton jbtn_info2   = new JButton("영화정보2");
	   JButton jbtn_info3   = new JButton("영화정보3");
	   JButton jbtn_pay1    = new JButton("영화결제1");
	   JButton jbtn_pay2    = new JButton("영화결제2");
	   JButton jbtn_pay3    = new JButton("영화결제3");
	   JButton jbtn_x1 	    = new JButton("x");
	   JButton jbtn_x2 	    = new JButton("x");
	   JButton jbtn_x3 	    = new JButton("x");
	   JLabel jlb_mv1   	= new JLabel();
	   JLabel jlb_mv2   	= new JLabel();
	   JLabel jlb_mv3  	 	= new JLabel();
	   JTextArea jta 		= new JTextArea();
	   JTextField jtf_date  = new JTextField();
	   JPanel jp_center2    = new JPanel();
	   JLabel jlb_s 	    = new JLabel("스크린");
	   JButton jbtn_back 	  = new JButton("뒤로가기");
//	   JButton jbtn_home 	  = new JButton("홈화면");
	   JButton jbtn_pay 	  = new JButton("결제");
	   JScrollPane jsp_zipcode = new JScrollPane(jbtn_pay, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
	         ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    Font f 			  	= new Font("휴면매직체",Font.BOLD, 5);
	    //인스턴스화
//	    MovieViewLogin ml = new MovieViewLogin(this);
//	    MovieEvent me = new MovieEvent(this);
	    MovieEvent me = null;
	    DisplayEvent de = new DisplayEvent(this);
	    
	    
	////////////////////////////////////////메뉴바//////////////////////////////////////////
	      JMenuBar jmb 		= new JMenuBar();
	      JMenu menu 		= new JMenu("메뉴");
	      JMenuItem jmi_home = new JMenuItem("홈");
	      JMenuItem jmi_back = new JMenuItem("뒤로");
	      JMenuItem jmi_logout = new JMenuItem("로그아웃");
	      JMenuItem jmi_exit = new JMenuItem("나가기");
	      JMenuItem jmi_movie = new JMenuItem("상영영화");
	      JMenu jm_help = new JMenu("도움말 (H)");
	      JMenuItem jmi_producer = new JMenuItem("제작자");

	   class MyPicture extends JPanel{
	         public void paintComponent (Graphics g) {
	            g.drawImage(iicon.getImage(), 0, 0, null);
	            setOpaque(false);
	            super.paintComponent(g);
	            
	         }
	      }
	      //생성부
	      public Display() {
	      }
	      public Display(MovieEvent movieEveint) {
	    	  this.me = movieEveint;
	      }


		public void initDisplay() {//영화선택창
	         setContentPane(new MyPicture());
	         
	         ImageIcon p1 = new ImageIcon("C:\\workspace_java\\dev_java\\src\\movieteam\\s1.jpg"); 
	         Image im = p1.getImage();
	         Image cim = im.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
	         ImageIcon icon2 = new ImageIcon(cim);
	         JLabel jlb_mv1 = new JLabel(icon2);
	   
	         ImageIcon p2 = new ImageIcon("C:\\workspace_java\\dev_java\\src\\movieteam\\s2.jpg"); 
	         Image im2 = p2.getImage();
	         Image cim2 = im2.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
	         ImageIcon icon3 = new ImageIcon(cim2);
	         JLabel jlb_mv2 = new JLabel(icon3);
	         
	         ImageIcon p3 = new ImageIcon("C:\\workspace_java\\dev_java\\src\\movieteam\\s3.jpg"); 
	         Image im3 = p3.getImage();
	         Image cim3 = im3.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
	         ImageIcon icon4 = new ImageIcon(cim3);
	         JLabel jlb_mv3 = new JLabel(icon4);

	         this.setLayout(null);
	            
	         jbtn_info1.addActionListener(de);
	         jbtn_info2.addActionListener(de);
	         jbtn_info3.addActionListener(de);
	         jbtn_info3.addActionListener(de);
	         jbtn_pay1.addActionListener(de);
	         jbtn_pay2.addActionListener(de);
	         jbtn_pay3.addActionListener(de);
	         jbtn_x1.addActionListener(de);
	         jbtn_x2.addActionListener(de);
	         jbtn_x3.addActionListener(de);
	         
	         jbtn_info1.setBounds(100, 500, 100, 20);
	         jbtn_pay1.setBounds(250, 500, 100, 20);
	         jbtn_info2.setBounds(500, 500, 100, 20);
	         jbtn_pay2.setBounds(650, 500, 100, 20);
	         jbtn_info3.setBounds(900, 500, 100, 20);
	         jbtn_pay3.setBounds(1050, 500, 100, 20);
	         jbtn_x1.setBounds(350,50,40,20);
	         jbtn_x2.setBounds(750,50,40,20);
	         jbtn_x3.setBounds(1050,50,40,20);
	         
	         this.add(jbtn_x1);
	         this.add(jbtn_x2);
	         this.add(jbtn_x3);
	         this.add(jbtn_info1);
	         this.add(jbtn_pay1);
	         this.add(jbtn_info2);
	         this.add(jbtn_pay2);
	         this.add(jbtn_info3);
	         this.add(jbtn_pay3);
	         this.add(jta);
	         this.add(jlb_mv1);
	         this.add(jlb_mv2);
	         this.add(jlb_mv3);
	         jlb_mv1.setBounds(70, 50, 300, 400);
	         jlb_mv2.setBounds(470, 50, 300, 400);
	         jlb_mv3.setBounds(870, 50, 300, 400);
	         
	         
	         
	         this.setSize(1250,600);
	         this.setLocation(370,180);
	         this.setVisible(true);
	         jbtn_x1.setVisible(false);
	         jbtn_x2.setVisible(false);
	         jbtn_x3.setVisible(false);
	         setResizable(false);
	         this.add("Center",jp_center);
	      

	      }
//	      public void initDisplay3() {//영화예매창1(시간)
//	         
//	         
//	         jbtn_home.addActionListener(this);
//	         jbtn_back.addActionListener(de);
//	         jbtn_pay.addActionListener(de);
//	         jp_south.setLayout(null);
//	         jp_north.add(jlb_s);
//	         jp_south.add("Center", jbtn_pay);
//	         jp_south.add("East", jbtn_home);
//	         jp_south.add("East", jbtn_back);
//	         
//	         jbtn_back.setBounds(500, 300, 50, 20);
//	         jbtn_home.setBounds(500, 200, 100, 20);
//	         jbtn_pay.setBounds(500,100 , 100, 20);
//	         
//	         this.add("North",jp_north);   
//	         this.add("South",jp_south);   
//	         this.setSize(1200,600);
//	         this.setVisible(true);
//	         setResizable(false);
//	      }
//	    
	      //메인
	      public static void main(String[] args) {
	    	  Display d = new Display();
	    	  d.initDisplay();
	      }
}
