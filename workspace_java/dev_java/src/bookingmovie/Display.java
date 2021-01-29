package bookingmovie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

import bookingmovie.PayDAO;




public class Display extends JFrame{
					//선언부
// Start //
/////////////////////////////////////////////////// W S /////////////////////////////////////////////////
		PayDAO pd 			= new PayDAO(this);
		MovieDAO md 		= new MovieDAO(this);
		MovieEvent me 		= new MovieEvent(this);
/////////////////////////////////////////////////// W S /////////////////////////////////////////////////
		
					//생성부
/////////////////////////////////////////////////// W S /////////////////////////////////////////////////
		public Display() {}
		public Display(MovieEvent me) {
			this.me = me;
			}
		public Display(MovieDAO md) {
			this.md = md;
			}
		JFrame jfl = null;//로그인 프레임
		JFrame mjf =  new JFrame();
		JFrame jf = null;//가입화면 프레임
		JFrame jf1 = null;//영화선택프레임
		JFrame jf3  = new JFrame();
		JFrame pjf = null;// 결재정보 프레임
/////////////////////////////////////////////////// W S /////////////////////////////////////////////////
		public void clearjf() {
			 Component[] jfList = getComponents();
	    	 for(Component jf : jfList) {
	    		 if(jf instanceof JFrame) {
	    			 remove(jf);
	    		 }
	    	 }
		}
// Start //
/////////////////////////////////////////////////// 이 미 지 /////////////////////////////////////////////////
	   String imgPath 	    = "c:\\workspace_java\\dev_java\\src\\movieteam\\";
	   ImageIcon iicon 	    = new ImageIcon(imgPath+"");
	   String imgPathbg ="src\\bookingmovie\\";
		ImageIcon msicon = new ImageIcon(imgPathbg+"mselect.png");
		ImageIcon logicon = new ImageIcon(imgPathbg+"login2.png");
		ImageIcon seaticon = new ImageIcon(imgPathbg+"seatselect.png");
		
		ImageIcon poster1 = new ImageIcon("c:\\\\workspace_java\\\\dev_java\\\\src\\\\bookingmovie\\\\p1.jpg"); 
		Image im1 = poster1.getImage();
		Image cim1 = im1.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		ImageIcon micon1 = new ImageIcon(cim1);
		
		ImageIcon poster2 = new ImageIcon("c:\\\\workspace_java\\\\dev_java\\\\src\\\\bookingmovie\\\\p2.jpg"); 
		Image im2 = poster2.getImage();
		Image cim2 = im2.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		ImageIcon micon2 = new ImageIcon(cim2);
		
		ImageIcon poster3 = new ImageIcon("c:\\\\workspace_java\\\\dev_java\\\\src\\\\bookingmovie\\\\p3.jpg"); 
		Image im3 = poster3.getImage();
		Image cim3 = im3.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		ImageIcon micon3 = new ImageIcon(cim3);
		
		
		
		JLabel jlb_poster = null;
		//JLabel jlb_poster = new JLabel(icon2);
/////////////////////////////////////////////////// 이 미 지 /////////////////////////////////////////////////
/////////////////////////////////////////////////// 배경이미지 /////////////////////////////////////////////////
		class MyPicture0 extends JPanel{
			public void paintComponent (Graphics g) {
				g.drawImage(logicon.getImage(), 0, -100, null);
				setOpaque(false);
				super.paintComponent(g);
				
			}
		}
		
		class MyPicture1 extends JPanel{
		public void paintComponent (Graphics g) {
			g.drawImage(logicon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		
		}
	}
	class MyPicture2 extends JPanel{
		public void paintComponent (Graphics g) {
			g.drawImage(msicon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		
		}
	}
	class MyPicture3 extends JPanel{
		public void paintComponent (Graphics g) {
			g.drawImage(seaticon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		
		}
	}
/////////////////////////////////////////////////// 배경이미지 /////////////////////////////////////////////////   
	
//	Start //
/////////////////////////////////////////////////// 로 그 인 화 면 /////////////////////////////////////////////////
	   JPanel jp_center     	= new JPanel();
	   JPanel jp_south	    	= new JPanel();
	   JPanel jp_east 	    	= new JPanel();
	   JPanel jp_west 	    	= new JPanel();
	   JPanel jp_north 	    	= new JPanel();
	   JLabel jlb_id  	    	= new JLabel("I D");
	   JTextField id_t 	    	= new JTextField(50);
	   JLabel jlb_pw 	    	= new JLabel("P W");
	   JPasswordField pw_t 	    = new JPasswordField(50);
	   JButton jbtn_login   	= new JButton("로그인");
	   JButton jbtn_join   		= new JButton("회원가입");
	   JButton jbtn_close1 		= new JButton("닫기");
	   Font loginf 					= new Font("휴먼매직체",Font.BOLD,18);
	   Font loging 					= new Font("맑은고딕체",Font.BOLD,15);
/////////////////////////////////////////////////// 로 그 인 화 면 /////////////////////////////////////////////////
// Start //
/////////////////////////////////////////////////// 가 입 화 면 /////////////////////////////////////////////////
	    
	   	JPanel jp_join 			= new JPanel();
		JButton jbtn_ins 		= new JButton("확인");
		JButton jbtn_joinclose 		= new JButton("닫기");
		JButton jbtn_maching 	= new JButton("중복검사");
		JLabel jlb_joinid 	  		= new JLabel("아이디");
		JLabel jlb_joinpw 	  		= new JLabel("비밀번호");
		JLabel jlb_memname 	  	= new JLabel("이름");
		JLabel jlb_phone 	 	= new JLabel("전화번호");
		JTextField jtf_joinid 		= new JTextField(10);
		JPasswordField jpf_joinpw 	= new JPasswordField("");
		JTextField jtf_memname 	= new JTextField(30);
		JTextField jtf_phone 	= new JTextField();
		JSeparator js 			= new JSeparator();
		JScrollPane jsp 		= null;
		Font joinf 					= new Font("휴먼매직체",Font.BOLD,20);
// Start //
/////////////////////////////////////////////////// 영 화 선 택 화 면 /////////////////////////////////////////////////
	   JButton jbtn_info1   = new JButton("상세정보");
	   JButton jbtn_info2   = new JButton("상세정보");
	   JButton jbtn_info3   = new JButton("상세정보");
	   JButton jbtn_pay1    = new JButton("예    매");
	   JButton jbtn_pay2    = new JButton("예    매");
	   JButton jbtn_pay3    = new JButton("예    매");
	   JButton jbtn_x1 	    = new JButton("x");
	   JButton jbtn_x2 	    = new JButton("x");
	   JButton jbtn_x3 	    = new JButton("x");
	   JLabel jlb_mv1   	= new JLabel();
	   JLabel jlb_mv2   	= new JLabel();
	   JLabel jlb_mv3  	 	= new JLabel();
	   JTextArea jta 		= new JTextArea();
	   JScrollPane jsp_m = new JScrollPane(jta
			   ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			   ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
			   );
	   
/////////////////////////////////////////////////// 영 화 선 택 화 면 /////////////////////////////////////////////////

// Start //
/////////////////////////////////////////////////// 좌 석 선 택 화 면 /////////////////////////////////////////////////
	   JTextField jtf_date  = new JTextField();
	   JPanel jp_center2    = new JPanel();
	   JLabel jlb_s 	    = new JLabel("스크린");
	   JButton jbtn_back 	  = new JButton("뒤로가기");
	   JButton jbtn_home 	  = new JButton("홈화면");
	   JButton jbtn_pay 	  = new JButton("다음");
	   JCheckBox[][] seat = new JCheckBox[5][6];
	    Font f 			  	= new Font("휴면매직체",Font.BOLD, 5);

	    
	    /////////////////////////////////////////////////// 좌 석 선 택 화 면 /////////////////////////////////////////////////
	    // Start // 
		JButton mjbtn_next = new JButton("다음");
		JLabel jlb_screen = new JLabel("스 크 린", SwingConstants.CENTER);
		JLabel jlb_info = new JLabel("한번에 최대 4좌석까지 선택가능합니다.", SwingConstants.CENTER);
		
		JPanel p1 = new JPanel();
		ArrayList<String> seatinfo = null;
		Object obj = null;
		
		String[] name = {"A", "B", "C", "D", "E"};
		
		
		//String s_code = null;
		MovieSeatDAO mdao = new MovieSeatDAO();
 
/////////////////////////////////////////////////// 메 뉴 바 /////////////////////////////////////////////////
	  JMenuBar jmb 		= new JMenuBar();
	  JMenu menu 		= new JMenu("메뉴");
	  JMenuItem jmi_home = new JMenuItem("홈");
	  JMenuItem jmi_back = new JMenuItem("뒤로");
	  JMenuItem jmi_logout = new JMenuItem("로그아웃");
	  JMenuItem jmi_exit = new JMenuItem("나가기");
	  JMenuItem jmi_movie = new JMenuItem("상영영화");
	  JMenu jm_help = new JMenu("도움말 (H)");
	  JMenuItem jmi_producer = new JMenuItem("제작자");
/////////////////////////////////////////////////// 메 뉴 바 /////////////////////////////////////////////////
/////////////////////////////////////////////////// 배경이미지 /////////////////////////////////////////////////
	   class MyPicture extends JPanel{
	         public void paintComponent (Graphics g, ImageIcon iicon) {
	            g.drawImage(iicon.getImage(), 0, 0, null);
	            setOpaque(false);
	            super.paintComponent(g);
	            
	         }
	      }
/////////////////////////////////////////////////// 배경이미지 /////////////////////////////////////////////////
///////////////////////////////////////////////// 영 화 시 간 /////////////////////////////////////////////////
		String sch = null;
		JLabel label_poster = new JLabel();
		//JPanel jp_north = new JPanel();
		//JPanel jp_south = new JPanel();
		JButton jb_p = new JButton("다음");
		String day[] = {"전체","2020-09-11","2020-09-12"};
		Vector<String> v = new Vector<>();
		String cols[] = {"날짜","시간","잔여좌석"};
		String data[][] = new String[0][3];
		DefaultTableModel dtm_sche = new DefaultTableModel(data, cols);
		JTable jtb_sche = new JTable(dtm_sche);
//		JTable jtb_sche = null;
		JScrollPane jsp_sche = new JScrollPane(jtb_sche, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
	              ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JComboBox jcb_day = null;
		ResultSet rs = null;
		String[] sche=null;
///////////////////////////////////////////////// 영 화 시 간 /////////////////////////////////////////////////
///////////////////////////////////결제 화면창 선언////////////////////////////////////////////////		
		JFrame jf_pay =  new JFrame();
		JFrame jf2 = new JFrame();
		JPanel jp_cp = new JPanel();
		JPanel jp_c2p = new JPanel();
		JPanel jp_sp = new JPanel();
		JPanel jp_s2p = new JPanel();
		JLabel jlb_num = new JLabel("예매번호");
		JLabel jlb_movie = new JLabel("영화제목");
		JLabel jlb_day = new JLabel("날짜|시간");
		JLabel jlb_seat = new JLabel("좌석번호");
		JLabel jlb_pay = new JLabel("결제금액");
		JLabel jlb_way = new JLabel("결제방법");
		JButton jbtn_in = new JButton("확인");
		JTextArea jta_num = new JTextArea();
		JTextArea jta_movie = new JTextArea();
		JTextArea jta_day = new JTextArea();
		JTextArea jta_seat = new JTextArea();
		JTextArea jta_pay = new JTextArea();
		JTextArea jta_way = new JTextArea();
		JButton jbtn_cance = new JButton("취소");
		JButton jbtn_pclose = new JButton("닫기");
		String pay[] = {"결제방법","카드","핸드폰","무통장입금"};
		Font pf = new Font("휴먼매직체",Font.BOLD,16);
		Font g = new Font("휴먼매직체",Font.BOLD,14);
		JComboBox jcb_pay = new JComboBox(pay);
		Vector<String> vp = new Vector<>();
		String pcols[] = {"예매번호","영화제목","날짜|시간","좌석번호"};
		String pdata[][] = new String[5][0];
		DefaultTableModel dtm_pay = new DefaultTableModel(data, cols);
		JTable jtb_pay = new JTable(dtm_pay);

//////////////////////////////////결제 화면창 선언/////////////////////////////////////////////////			   
		// initDisplay
////////////////////// 로그인 화면 /////////////////////////////////////////////////
	   	public void loginDisplay() {
	   		 jfl = new JFrame();
	   		 jfl.setContentPane(new MyPicture0());
	         jbtn_login.addActionListener(me);
	         jbtn_join.addActionListener(me);
	         jbtn_close1.addActionListener(me);
//	         jlb_id.setOpaque(true);
//	         jlb_id.setBackground(Color.BLACK);
//	         jlb_id.setForeground(Color.yellow);
	         jfl.setLayout(null);
	         //라벨
	         jlb_id.setBounds(70, 240, 50, 30);
	         jlb_id.setFont(joinf);
	         jlb_id.setForeground(new Color(0,0,205));
	         id_t.setBounds(130, 240, 195, 30);
	         id_t.setBackground(new Color(240,230,130));
	         id_t.setForeground(new Color(0,0,0));
	         id_t.setFont(joinf);
	         jlb_pw.setBounds(70, 290, 60, 30);
	         jlb_pw.setFont(joinf);
	         jlb_pw.setForeground(new Color(0,0,205));
	         pw_t.setBounds(130, 290, 195, 30);
	         pw_t.setBackground(new Color(240,230,130));
	         
	         //버튼 & 버튼배경,라벨 색변경
	         //로그인버튼
	         jbtn_login.setBounds(220, 350, 100, 30);
	         jbtn_login.setBackground(new Color(245,222,179));
	         jbtn_login.setForeground(new Color(0,0,0));
	         jbtn_login.setFont(loginf);
	         //회원가입버튼
	         jbtn_join.setBounds(100, 350, 100, 30);
	         jbtn_join.setBackground(new Color(245,222,179));
	         jbtn_join.setForeground(new Color(0,0,0));
	         jbtn_join.setFont(loginf);
	         //닫기 버튼
	         jbtn_close1.setBounds(220, 385, 100, 30);
	         jbtn_close1.setBackground(new Color(245,222,179));
	         jbtn_close1.setForeground(new Color(0,0,0));
	         jbtn_close1.setFont(loginf);
	         
	         jfl.add(jlb_id);
	         jfl.add(id_t);
	         jfl.add(jlb_pw);
	         jfl.add(pw_t);
	         jfl.add(jbtn_login);
	         jfl.add(jbtn_join);
	         jfl.add(jbtn_close1);
	         
	         jfl.setTitle("KOSMO 영화예매");
	         jfl.setLocation(700,300);
	         jfl.setSize(400,500);
	         jfl.setVisible(true);
	         setResizable(false);
	         jfl.add("Center",jp_center);   
	      }
////////////////////// 가입화면 /////////////////////////////////////////////////
		public void joinDisplay() {
			jf = new JFrame();
			
			jbtn_maching.addActionListener(me);
			jbtn_ins.addActionListener(me);
			jbtn_joinclose.addActionListener(me);		
			
			jf.setLayout(null);
			jlb_joinid.setBounds(30, 20, 80, 30);
			jlb_joinid.setFont(joinf);
			jlb_joinpw.setBounds(30, 60, 80, 30);
			jlb_joinpw.setFont(joinf);
			jlb_memname.setBounds(30, 100, 80, 30);
			jlb_memname.setFont(joinf);
			jlb_phone.setBounds(30, 140, 80, 30);
			jlb_phone.setFont(joinf);
			
			jtf_joinid.setBounds(130, 20, 130, 30);
			jpf_joinpw.setBounds(130, 60, 130, 30);
			jtf_memname.setBounds(130, 100, 130, 30);
			jtf_phone.setBounds(130, 140, 130, 30);
			
			jbtn_maching.setBounds(270, 20, 100, 30);
			jbtn_maching.setBackground(new Color(255,255,255));
			jbtn_maching.setForeground(new Color(0,0,0));
			jbtn_maching.setFont(loginf);
			jbtn_ins.setBounds(160, 200, 100, 30);
			jbtn_ins.setBackground(new Color(255,255,255));
			jbtn_ins.setForeground(new Color(0,0,0));
			jbtn_ins.setFont(loginf);
			jbtn_joinclose.setBounds(270, 200, 100, 30);
			jbtn_joinclose.setBackground(new Color(255,255,255));
			jbtn_joinclose.setForeground(new Color(0,0,0));
			jbtn_joinclose.setFont(loginf);
			
			jf.add(jlb_joinid);
			jf.add(jlb_joinpw);		
			jf.add(jlb_phone);				
			jf.add(jlb_memname);				
			jf.add(jtf_joinid);				
			jf.add(jpf_joinpw);				
			jf.add(jtf_memname);				
			jf.add(jtf_phone);
			
			jf.add(jbtn_ins);
			jf.add(jbtn_joinclose);
			jf.add(jbtn_maching);
			jf.add(jp_join);
			jf.add("Center", jp_join);
			jf.setLocation(700,300);
			jf.setTitle("회원가입");
			jf.setSize(400,280);
			jf.setVisible(true);
			
		}
////////////////////// 영화선택창 /////////////////////////////////////////////////
		  
			public void MovieSelect() {
		    	jf1 = new JFrame();
		        jf1.setContentPane(new MyPicture2());
		        
		        ImageIcon p1 = new ImageIcon("C:\\workspace_java\\dev_java\\src\\bookingmovie\\p1.jpg"); 
		        Image im = p1.getImage();
		        Image cim = im.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		        ImageIcon icon2 = new ImageIcon(cim);
		        JLabel jlb_mv1 = new JLabel(icon2);
		   
		        ImageIcon p2 = new ImageIcon("C:\\workspace_java\\dev_java\\src\\bookingmovie\\p2.jpg"); 
		        Image im2 = p2.getImage();
		        Image cim2 = im2.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		        ImageIcon icon3 = new ImageIcon(cim2);
		        JLabel jlb_mv2 = new JLabel(icon3);
		         
		        ImageIcon p3 = new ImageIcon("C:\\workspace_java\\dev_java\\src\\bookingmovie\\p3.jpg"); 
		        Image im3 = p3.getImage();
		        Image cim3 = im3.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		        ImageIcon icon4 = new ImageIcon(cim3);
		        JLabel jlb_mv3 = new JLabel(icon4);

		        jf1.setLayout(null);
		            
		        jbtn_info1.addActionListener(me);
		        jbtn_info2.addActionListener(me);
		        jbtn_info3.addActionListener(me);
		        jbtn_info3.addActionListener(me);
		        jbtn_pay1.addActionListener(me);
		        jbtn_pay2.addActionListener(me);
		        jbtn_pay3.addActionListener(me);
		        jbtn_x1.addActionListener(me);
		        jbtn_x2.addActionListener(me);
		        jbtn_x3.addActionListener(me);
		         
		        jbtn_info1.setBounds(100, 500, 100, 40);
		        jbtn_info1.setBackground(new Color(255,248,220));
		        jbtn_info1.setForeground(new Color(0,0,0));
		        jbtn_info1.setFont(loging);
		        jbtn_pay1.setBounds(250, 500, 100, 40);
		        jbtn_pay1.setBackground(new Color(255,248,220));
		        jbtn_pay1.setForeground(new Color(0,0,0));
		        jbtn_pay1.setFont(loging);
		        jbtn_info2.setBounds(500, 500, 100, 40);
		        jbtn_info2.setBackground(new Color(255,248,220));
		        jbtn_info2.setForeground(new Color(0,0,0));
		        jbtn_info2.setFont(loging);
		        jbtn_pay2.setBounds(650, 500, 100, 40);
		        jbtn_pay2.setBackground(new Color(255,248,220));
		        jbtn_pay2.setForeground(new Color(0,0,0));
		        jbtn_pay2.setFont(loging);
		        jbtn_info3.setBounds(900, 500, 100, 40);
		        jbtn_info3.setBackground(new Color(255,248,220));
		        jbtn_info3.setForeground(new Color(0,0,0));
		        jbtn_info3.setFont(loging);
		        jbtn_pay3.setBounds(1050, 500, 100, 40);
		        jbtn_pay3.setBackground(new Color(255,248,220));
		        jbtn_pay3.setForeground(new Color(0,0,0));
		        jbtn_pay3.setFont(loging);
		        jbtn_x1.setBounds(350,50,40,20);
		        jbtn_x2.setBounds(750,50,40,20);
		        jbtn_x3.setBounds(1050,50,40,20);
		         
		        jf1.add(jbtn_x1);
		        jf1.add(jbtn_x2);
		        jf1.add(jbtn_x3);
		        jf1.add(jbtn_info1);
		        jf1.add(jbtn_pay1);
		        jf1.add(jbtn_info2);
		        jf1.add(jbtn_pay2);
		        jf1.add(jbtn_info3);
		        jf1.add(jbtn_pay3);
		        
		         //텍스트 에어리어 자동 줄 바꿈
		        jta.setColumns(10);
		        jta.setRows(1);
		        jta.setLineWrap(true);//꽉차면 다음줄로 가게 해줌.
		        jta.setWrapStyleWord(true);
		        //텍스트 에어리어 자동 줄 바꿈
		        
		        //텍스트 에어리어 입력 방지
		        jta.setEditable(false);
		        //텍스트 에어리어 입력 방지
		        
		        jf1.add(jsp_m);
		        jf1.add(jlb_mv1);
		        jf1.add(jlb_mv2);
		        jf1.add(jlb_mv3);
		        jlb_mv1.setBounds(70, 50, 300, 400);
		        jlb_mv2.setBounds(470, 50, 300, 400);
		        jlb_mv3.setBounds(870, 50, 300, 400);
		         

		        jf1.setSize(1250,600);
		        jf1.setLocationRelativeTo(null);
		        jf1.setVisible(true);
		        jbtn_x1.setVisible(false);
		        jbtn_x2.setVisible(false);
		        jbtn_x3.setVisible(false);
		        setResizable(false);
		        jf1.add("Center", jp_center);
		      }
////////////////////// 영화날짜, 시간 선택 /////////////////////////////////////////////////
		      public void initDisplay3() {
					
//			  		ImageIcon p1 = new ImageIcon("C:\\Users\\kosmo_29\\Desktop\\영화예매\\p1.jpg"); 
//					Image im = p1.getImage();
//					Image cim = im.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
//					ImageIcon icon2 = new ImageIcon(cim);
//					JLabel label_poster = new JLabel(icon2);
					jf3.setContentPane(new MyPicture3());
					sche = md.getSCHList();
					jcb_day = new JComboBox(sche);
					jcb_day.addItemListener(me);
					jb_p.requestFocus();
				    jb_p.addActionListener(me);
				    jtb_sche.addMouseListener(me);
					for(int x=0;x<day.length;x++){
						v.add(day[x]);
					}
				
					jf3.setLayout(null);
					jf3.add("West",jcb_day);
					jcb_day.setBounds(0, 20, 780, 20);
					jf3.add("East",jb_p);
					jb_p.setBounds(650, 550, 100, 40);
					jb_p.setBackground(new Color(255,255,255));
					jb_p.setForeground(new Color(0,0,0));
					jb_p.setFont(loginf);
					jf3.add(label_poster);
					label_poster.setBounds(40, 100, 300, 400);
					jf3.add("Center",jsp_sche);
				    jsp_sche.setBounds(400, 100, 350, 400);
				    jf3.setTitle("영화예매정보");
				    jf3.setSize(800,650);
				    jf3.setLocationRelativeTo(null);
				    jf3.setVisible(true);
					setResizable(false);
				}
//////////////////////////좌석선택화면/////////////////////////////
		      public void initDisplay4(String s_code) {
			    	 Component[] cList = p1.getComponents();
			    	 for(Component c : cList) {
			    		 if(c instanceof JCheckBox) {
			    			 p1.remove(c);
			    		 }
			    	 }
			    	 p1.revalidate();
			    	 p1.repaint();
			    	 clearjf();
			    	  Font f = new Font("돋움",Font.BOLD,30);
			  		
			  		mjf.setContentPane(new MyPicture3());
			  		p1.setLayout(new GridLayout(5,6));
			  		p1.setPreferredSize(new Dimension(350,310));
			  		System.out.println(s_code);
			  		seat = null;
			  		seat = new JCheckBox[5][6];
			  		
			  		mdao.getSeatInfoList(s_code);
			  		//for(String temp : mdao.savedseat) {
			  		//	System.out.println(temp);
			  		//}
			  		
			  		String[][] savedseat1 = new String[5][6];
			  		int x =0;
			  		
			  		for(int y=0;y<5;y++)
			  			for(int z=0;z<6;z++) {
			  				savedseat1[y][z]=mdao.savedseat.get(x);
			  				//System.out.println(savedseat1[y][z]);
			  				x++;
			  				}
			  		for(int j=0;j<5;j++) {
			  			for(int i=0; i<6;i++) {
			  			   if(savedseat1[j][i]==null) {
			  				   seat[j][i] = new JCheckBox(name[j]+(i+1),false);
			  				   
			  			   }
			  			   else{
			  				   seat[j][i] = new JCheckBox(name[j]+" "+(i+1),false);
			  				   seat[j][i].setEnabled(false);
			  				   seat[j][i].setBackground(Color.DARK_GRAY);
			  				   seat[j][i].setOpaque(true);
			  			   }
			  			   seat[j][i].setBorderPainted(true); 
			  			   p1.add(seat[j][i]); 
			  		}
			  		}
			  		
			  		mjbtn_next.addActionListener(me);		
			  		
			  		
			  		
			  		mjf.setLayout(null);
			  		jlb_info.setOpaque(true);
			  		jlb_info.setForeground(Color.YELLOW);
			  		jlb_info.setBackground(Color.DARK_GRAY);
			  		jlb_screen.setOpaque(true);
			  		jlb_screen.setFont(f);
			  		jlb_screen.setForeground(Color.YELLOW);
			  		jlb_screen.setBackground(Color.DARK_GRAY);
			  		jlb_screen.setBounds(350, 80, 500, 40);
			  		jlb_info.setBounds(100, 10, 600, 30);
			  		p1.setBounds(400, 150, 400, 330);
			  		label_poster.setBounds(30, 150, 300, 400);
			  		mjbtn_next.setBounds(600, 550, 100, 40);
			  		mjbtn_next.setBackground(new Color(255,255,255));
			  		mjbtn_next.setForeground(new Color(0,0,0));
			  		mjbtn_next.setFont(loginf);
			  		
			  		mjf.add(label_poster);
			  		mjf.add(p1);
			  		mjf.add(jlb_screen);
			  		mjf.add(jlb_info);
			  		mjf.add(mjbtn_next);
			  		mjf.setTitle("좌석선택");
			  		mjf.setLocation(500,220);
			  		mjf.setSize(900,650);
			  		mjf.setVisible(true);
			  	}
//////////////////////////////////좌석선택화면 끝////////////////////////////////
///////////////////////////////결제 화면창/////////////////////////////////////	    
			     public void Pay() {
			    	 clearjf();
					
					
			    	 jbtn_in.addActionListener(me);
					jbtn_cance.addActionListener(me);
					
					//pd.getpayInfo(T_BOOKNUM, M_CODE, M_TIME, SEAT1, SEAT2, SEAT3, SEAT4);
					
					
					
					
					//라벨
					jp_cp.setLayout(null);
					jlb_num.setBounds(20, 20, 70, 40);
					jlb_num.setFont(pf);
					jlb_movie.setBounds(20, 70, 70, 40);
					jlb_movie.setFont(pf);
					jlb_day.setBounds(20, 120, 80, 40);
					jlb_day.setFont(pf);
					jlb_seat.setBounds(20, 170, 70, 40);
					jlb_seat.setFont(pf);
					jlb_pay.setBounds(20, 220, 70, 40);
					jlb_pay.setFont(pf);
					jlb_way.setBounds(20, 270, 70, 40);
					jlb_way.setFont(pf);
					jcb_pay.setBounds(120,280,200,20);
					//받아온 결제정보
					jta_num.setBounds(130, 20, 150, 40);
					jta_num.setFont(pf);
					jta_movie.setBounds(130, 70, 150, 40);
					jta_movie.setFont(pf);
					jta_day.setBounds(130, 120, 200, 25);
					jta_day.setFont(pf);
					jta_seat.setBounds(130, 170, 200, 25);
					jta_seat.setFont(pf);
					jta_pay.setBounds(130, 220, 150, 40);
					jta_pay.setFont(pf);
					
					
					
					//텍스트 에어리어 자동 줄 바꿈
					jta_seat.setColumns(10);
					jta_seat.setRows(1);
					jta_seat.setLineWrap(true);//꽉차면 다음줄로 가게 해줌.
					jta_seat.setWrapStyleWord(true);
					//텍스트 에어리어 자동 줄 바꿈
					
					//텍스트 에어리어 입력 방지
					jta_num.setEditable(false);
					jta_movie.setEditable(false);
					jta_day.setEditable(false);
					jta_pay.setEditable(false);
					//텍스트 에어리어 입력 방지
					//라벨
					jp_cp.add(jlb_num);
					jp_cp.add(jlb_movie);
					jp_cp.add(jlb_day);
					jp_cp.add(jlb_seat);
					jp_cp.add(jlb_pay);
					jp_cp.add(jlb_way);
					jp_cp.add(jta_num);
					jp_cp.add(jta_movie);
					jp_cp.add(jta_day);
					jp_cp.add(jta_seat);
					jp_cp.add(jta_pay);
					//결제 방법
					jp_cp.add(jcb_pay);
					//버튼 주입
					jp_sp.add(jbtn_in);
					jbtn_in.setBackground(new Color(255,255,255));
					jbtn_in.setForeground(new Color(0,0,0));
					jbtn_in.setFont(loginf);
					jp_sp.add(jbtn_cance);
					jbtn_cance.setBackground(new Color(255,255,255));
					jbtn_cance.setForeground(new Color(0,0,0));
					jbtn_cance.setFont(loginf);
					//패널 , 타이틀
					jf_pay.add("Center",jp_cp);
					jf_pay.add("South",jp_sp);
					jf_pay.setTitle("결제화면");
					jf_pay.setSize(450,450);
					jf_pay.setLocationRelativeTo(null);
					jf_pay.setVisible(true);
					}
	///////////////////////////////결제 화면창//////////////////////////////////////	
	///////////////////////////////최종 화면///////////////////////////////////////
			 	public void clear() {
					clearjf();
					jbtn_pclose.addActionListener(me);
					jp_c2p.setLayout(null);
					//라벨
					jlb_num.setBounds(30, 20, 120, 40);
					jlb_num.setFont(pf);
					jlb_movie.setBounds(30, 70, 120, 40);
					jlb_movie.setFont(pf);
					jlb_day.setBounds(30, 120, 120, 40);
					jlb_day.setFont(pf);
					jlb_seat.setBounds(30, 170, 120, 40);
					jlb_seat.setFont(pf);
					jlb_pay.setBounds(30, 220, 120, 40);
					jlb_pay.setFont(pf);
					jlb_way.setBounds(30, 270, 120, 40);
					jlb_way.setFont(pf);
					//받아온 결제 정보
					jta_num.setBounds(150, 20, 150, 40);
					jta_num.setFont(pf);
					jta_movie.setBounds(150, 70, 150, 40);
					jta_movie.setFont(pf);
					jta_day.setBounds(150, 120, 200, 40);
					jta_day.setFont(pf);
					jta_seat.setBounds(150, 170, 210, 40);
					jta_seat.setFont(pf);
					jta_pay.setBounds(150, 220, 150, 40);
					jta_pay.setFont(pf);
					jta_way.setBounds(150, 270, 150, 40);
					jta_way.setFont(pf);
					//버튼위치
					//jbtn_close.setBounds(300,20,70,30);
					
					//텍스트 에어리어 입력 방지
					jta_num.setEditable(false);
					jta_movie.setEditable(false);
					jta_day.setEditable(false);
					jta_pay.setEditable(false);
					//텍스트 에어리어 입력 방지
					
					//라벨
					jp_c2p.add(jlb_num);
					jp_c2p.add(jlb_movie);
					jp_c2p.add(jlb_day);
					jp_c2p.add(jlb_seat);
					jp_c2p.add(jlb_pay);
					jp_c2p.add(jlb_way);
					//텍스트에리어
					jp_c2p.add(jta_num);
					jp_c2p.add(jta_movie);
					jp_c2p.add(jta_day);
					jp_c2p.add(jta_seat);
					jp_c2p.add(jta_pay);
					jp_c2p.add(jta_way);
					//버튼
					jp_s2p.add(jbtn_pclose);
					jbtn_pclose.setBackground(new Color(255,255,255));
					jbtn_pclose.setForeground(new Color(0,0,0));
					jbtn_pclose.setFont(loginf);
					//패널,테이블
					jf2.add("Center",jp_c2p);
					jf2.add("South",jp_s2p);
					jf2.setTitle("예매 내역");
					jf2.setLocationRelativeTo(null);
					jf2.setSize(380,400);
					jf2.setVisible(true);
				}
///////////////////////////////최종 화면///////////////////////////////////////
// Start //  
/////////////////////////////////////////////////// 메 인 /////////////////////////////////////////////////
	      public static void main(String[] args) {
	    	  Display d = new Display();
	    	  d.loginDisplay();
	    	 
	      }
/////////////////////////////////////////////////// 메 인 /////////////////////////////////////////////////
	}