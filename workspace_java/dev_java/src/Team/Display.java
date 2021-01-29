package Team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Display extends JFrame {
	//선언부
	//Start //
	/////////////////////////////////////////////////// W S /////////////////////////////////////////////////
	MovieDAO md 		= new MovieDAO(this);
	MovieEvent me 		= new MovieEvent(this);
	/////////////////////////////////////////////////// W S /////////////////////////////////////////////////

	//생성부
	/////////////////////////////////////////////////// W S /////////////////////////////////////////////////
	public Display() {
	}
	public Display(MovieEvent me) {
		this.me = me;
	}
	public Display(MovieDAO md) {
		this.md = md;
	}	
	/////////////////////////////////////////////////// W S /////////////////////////////////////////////////

	//Start //
	/////////////////////////////////////////////////// 이 미 지 /////////////////////////////////////////////////
	String imgPath 	    = "C:\\workspace_java\\dev_java\\src\\movieteam\\";
	ImageIcon iicon 	    = new ImageIcon(imgPath+"");
	/////////////////////////////////////////////////// 이 미 지 /////////////////////////////////////////////////
	
	//Start //
	/////////////////////////////////////////////////// 로 그 인 화 면 /////////////////////////////////////////////////
	JPanel jp_center    	= new JPanel();
	JPanel jp_south	    	= new JPanel();
	JPanel jp_east 	   		= new JPanel();
	JPanel jp_west 	   		= new JPanel();
	JPanel jp_north 	 	= new JPanel();
	JLabel jlb_id  	   		= new JLabel("I D");
	JTextField id_t 		= new JTextField(50);
	JLabel jlb_pw 	    	= new JLabel("P W");
	JPasswordField jpf_pw 	= new JPasswordField(50);
	JButton jbtn_login   	= new JButton("로그인");
	JButton jbtn_join   	= new JButton("회원가입");
	JButton jbtn_close 		= new JButton("닫기");
	/////////////////////////////////////////////////// 로 그 인 화 면 /////////////////////////////////////////////////
	//Start //
	/////////////////////////////////////////////////// 가 입 화 면 /////////////////////////////////////////////////
	JFrame jf 					= null;
	JPanel jp_join 				= new JPanel();
	JButton jbtn_ins 			= new JButton("확인");
	JButton jbtn_joinclose 		= new JButton("닫기");
	JButton jbtn_maching 		= new JButton("중복검사");
	JLabel jlb_joinid 	  		= new JLabel("아이디");
	JLabel jlb_joinpw 	  		= new JLabel("비밀번호");
	JLabel jlb_memname 	  		= new JLabel("이름");
	JLabel jlb_phone 	 		= new JLabel("전화번호");
	JTextField jtf_joinid 		= new JTextField(10);
	JPasswordField jpf_joinpw 	= new JPasswordField("");
	JTextField jtf_memname 		= new JTextField(30);
	JTextField jtf_phone 		= new JTextField();
	JSeparator js 				= new JSeparator();
	JScrollPane jsp 			= null;
	Font joinf 					= new Font("휴먼매직체",Font.BOLD,20);
	//Start //
	/////////////////////////////////////////////////// 영 화 선 택 화 면 /////////////////////////////////////////////////
	JButton jbtn_info1   = new JButton("상세정보");
	JButton jbtn_info2   = new JButton("상세정보");
	JButton jbtn_info3   = new JButton("상세정보");
	JButton jbtn_pay1    = new JButton("예    매");
	JButton jbtn_pay2    = new JButton("예    매");
	JButton jbtn_pay3    = new JButton("예    매");
	JButton jbtn_x1 	 = new JButton("x");
	JButton jbtn_x2 	 = new JButton("x");
	JButton jbtn_x3 	 = new JButton("x");
	JLabel jlb_mv1   	 = new JLabel();
	JLabel jlb_mv2   	 = new JLabel();
	JLabel jlb_mv3  	 = new JLabel();
	JTextArea jta 		 = new JTextArea();
	JScrollPane jsp_m 	 = new JScrollPane(jta
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
			);

/////////////////////////////////////////////////// 영 화 선 택 화 면 /////////////////////////////////////////////////

	//Start //
/////////////////////////////////////////////////// 좌 석 선 택 화 면 /////////////////////////////////////////////////
	JTextField jtf_date 	 = new JTextField();
	JPanel jp_center2   	 = new JPanel();
	JLabel jlb_s 	    	 = new JLabel("스크린");
	JButton jbtn_back 	  	 = new JButton("뒤로가기");
	JButton jbtn_home 	 	 = new JButton("홈화면");
	JButton jbtn_pay 	 	 = new JButton("다음");
	
	Font f 			  		 = new Font("휴면매직체",Font.BOLD, 5);
	/////////////////////////////////////////////////// 좌 석 선 택 화 면 /////////////////////////////////////////////////
	// Start // 
	JPanel mjp_center 	= new JPanel();
	JPanel mjp_east 	= new JPanel();
	JPanel mjp_north 	= new JPanel();
	JPanel mjp_north_t 	= new JPanel();
	JPanel mjp_north_s 	= new JPanel();
	
	JTextField mjtf 	= new JTextField(30);
	JButton mjbtn_ins 	= new JButton("입력");
	JButton mjbtn_scr 	= new JButton("스크린");
	JButton mjbtn_next 	= new JButton("다음");
	JPanel p1 			= new JPanel();
	ArrayList<String> seatinfo = new ArrayList<>();
	ArrayList<Integer> seatrow = new ArrayList<>(); 
	ArrayList<Integer> seatcol = new ArrayList<>(); 
	Object obj = null;
	
	String[] name = {"A", "B", "C", "D", "E"};
	JCheckBox[][] seat = new JCheckBox[5][6];
	
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
	
	class MyPicture extends JPanel{
		public void paintComponent (Graphics g) {
			g.drawImage(iicon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);

		}
	}
///////////////////////////////////////////////// 영 화 시 간 /////////////////////////////////////////////////
	String sch = null;
	JLabel label_poster = new JLabel();
	//JPanel jp_north = new JPanel();
	//JPanel jp_south = new JPanel();
	JButton jb_p = new JButton("다음");
	String day[] = {"전체","2020-09-11","2020-09-12"};
	Vector<String> v = new Vector<>();
	String cols[] = {"날짜","시간"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm_sche = new DefaultTableModel(data, cols);
	JTable jtb_sche = new JTable(dtm_sche);
	JScrollPane jsp_sche = new JScrollPane(jtb_sche, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JComboBox jcb_day = new JComboBox();
	ResultSet rs = null;
	String[] sche=null;
	///////////////////////////////////////////////// 영 화 시 간 /////////////////////////////////////////////////

		// initDisplay
	//////////////////////로그인 화면 /////////////////////////////////////////////////
	public void loginDisplay() {
		ImageIcon p1 = new ImageIcon("C:\\workspace_java\\dev_java\\src\\Team\\j.jpg"); 
		Image im = p1.getImage();
		Image cim = im.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(cim);
		JLabel label_poster = new JLabel(icon2);
		setContentPane(new MyPicture());
		jbtn_login.addActionListener(me);
		jbtn_join.addActionListener(me);
		jbtn_close.addActionListener(me);
		
		this.setLayout(null);
		jlb_id.setBounds(70, 100, 50, 20);
		jlb_id.setForeground(new Color(212,212,212));
		id_t.setBounds(130, 100, 195, 20);
		jlb_pw.setBounds(70, 130, 60, 20);
		jlb_pw.setForeground(new Color(212,212,212));
		jpf_pw.setBounds(130, 130, 195, 20);
		label_poster.setBounds(0, -80, 400, 400);
		jbtn_login.setBounds(220, 180, 100, 20);
		jbtn_join.setBounds(100, 180, 100, 20);
		jbtn_close.setBounds(220, 210, 100, 20);
			
		this.add(jlb_id);
		this.add(id_t);
		this.add(jlb_pw);
		this.add(jpf_pw);
		this.add(jbtn_login);
		this.add(jbtn_join);
		this.add(jbtn_close);
		this.add(label_poster);

		this.setTitle("KOSMO 영화예매");
		this.setLocation(700,330);
		this.setSize(400,300);
		this.setVisible(true);
		setResizable(false);
		this.add("Center",jp_center);   
	}
	//////////////////////가입화면 /////////////////////////////////////////////////
	public void joinDisplay() {
		jf = new JFrame();
		jbtn_maching.addActionListener(me);
		jbtn_ins.addActionListener(me);
		jbtn_joinclose.addActionListener(me);		

		this.setLayout(null);
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

		jbtn_ins.setBounds(160, 220, 100, 30);
		jbtn_joinclose.setBounds(270, 220, 100, 30);

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
	jf.setTitle("회원가입");
	jf.setSize(450,300);
	jf.setVisible(true);

	}
//////////////////////영화선택창 /////////////////////////////////////////////////
	public void MovieSelect() {
		setContentPane(new MyPicture());

		ImageIcon	p1 			= new ImageIcon("C:\\workspace_java\\dev_java\\src\\Team\\p1.jpg"); 
		Image 		im 			= p1.getImage();
		Image 		cim 		= im.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		ImageIcon 	icon2 		= new ImageIcon(cim);
		JLabel 		jlb_mv1 	= new JLabel(icon2);

		ImageIcon 	p2 			= new ImageIcon("C:\\workspace_java\\dev_java\\src\\Team\\p2.jpg"); 
		Image 		im2 		= p2.getImage();
		Image 		cim2 		= im2.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		ImageIcon 	icon3 		= new ImageIcon(cim2);
		JLabel 		jlb_mv2 	= new JLabel(icon3);

		ImageIcon 	p3 			= new ImageIcon("C:\\workspace_java\\dev_java\\src\\Team\\p3.jpg"); 
		Image 		im3 		= p3.getImage();
		Image 		cim3 		= im3.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		ImageIcon 	icon4 		= new ImageIcon(cim3);
		JLabel 		jlb_mv3 	= new JLabel(icon4);

		this.setLayout(null);

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

		//텍스트 에어리어 자동 줄 바꿈
		jta.setColumns(10);
		jta.setRows(1);
		jta.setLineWrap(true);//꽉차면 다음줄로 가게 해줌.
		jta.setWrapStyleWord(true);
		//텍스트 에어리어 자동 줄 바꿈

		//텍스트 에어리어 입력 방지
		jta.setEditable(false);
		//텍스트 에어리어 입력 방지

		this.add(jsp_m);
		this.add(jlb_mv1);
		this.add(jlb_mv2);
		this.add(jlb_mv3);
		jlb_mv1.setBounds(70, 50, 300, 400);
		jlb_mv2.setBounds(470, 50, 300, 400);
		jlb_mv3.setBounds(870, 50, 300, 400);


		this.setSize(1250,600);
		this.setLocation(410,220);
		this.setVisible(true);
		jbtn_x1.setVisible(false);
		jbtn_x2.setVisible(false);
		jbtn_x3.setVisible(false);
		setResizable(false);
		this.add("Center", jp_center);


	}
	
	//////////////////////영화날짜, 시간 선택 /////////////////////////////////////////////////
	public void initDisplay3() {
		ImageIcon p1 = new ImageIcon("C:\\Users\\kosmo_29\\Desktop\\영화예매\\p1.jpg"); 
		Image im = p1.getImage();
		Image cim = im.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(cim);
		JLabel label_poster = new JLabel(icon2);
		jf = new JFrame();

		sche = md.getSCHList();
		jcb_day = new JComboBox(md.getSCHList());
		jcb_day.addItemListener(me);
		jb_p.requestFocus();
		jb_p.addActionListener(me);
		jtb_sche.addMouseListener(me);
		for(int x=0;x<day.length;x++){
			v.add(day[x]);
		}

		jf.setLayout(null);
		jf.add(label_poster);
		jf.add("West",jcb_day);
		jcb_day.setBounds(0, 20, 780, 20);
		jf.add("East",jb_p);
		jb_p.setBounds(650, 550, 100, 20);
		label_poster.setBounds(20, 100, 300, 400);
		jf.add("Center",jsp_sche);
		jsp_sche.setBounds(400, 100, 350, 400);
		jf.setTitle("영화예매정보");
		jf.setSize(800,650);
		jf.setVisible(true);
		setResizable(false);
	}
//////////////////////////좌석선택화면/////////////////////////////

	public void initDisplay4(String s_code) {
		JFrame mjf = new JFrame();
		// mdao = new MovieDAO();
		p1.setLayout(new GridLayout(5,6));
		p1.setPreferredSize(new Dimension(350,310));

		mdao.getSeatInfoList(s_code);

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
		mjp_north.setLayout(new BorderLayout());
		mjp_north_t.add("Center",mjtf);
		mjp_north_t.add("East",mjbtn_ins);
		mjp_north_s.add("Center",mjbtn_scr);
		mjp_north.add("North",mjp_north_t);
		mjp_north.add("South",mjp_north_s);


		this.setLayout(new BorderLayout());

		mjp_center.add("Center",p1);
		mjf.add("North",mjp_north);
		mjf.add("Center",mjp_center);
		mjf.add("South",mjbtn_next);
		mjf.setSize(600,500);
		mjf.setVisible(true);
	}
//////////////////////////////////좌석선택화면 끝////////////////////////////////
	//Start //  
/////////////////////////////////////////////////// 메 인 /////////////////////////////////////////////////
	public static void main(String[] args) {
		Display d = new Display();
		d.loginDisplay();
		//d.MovieSelect();
	}
/////////////////////////////////////////////////// 메 인 /////////////////////////////////////////////////

}
