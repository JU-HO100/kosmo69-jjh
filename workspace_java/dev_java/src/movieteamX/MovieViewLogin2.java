package movieteamX;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MovieViewLogin2 extends JFrame  {
	//선언
	JPanel jp_c 	  		= new JPanel();
//	JPanel jp_s		  		= new JPanel();
	JLabel jlb_id 	  		= new JLabel("아이디");
	JLabel jlb_pw 	  		= new JLabel("비밀번호");
	JTextField jtf_id 		= new JTextField("test");
	JPasswordField jpf_pw 	= new JPasswordField("123");
	JButton jbtn_login 		= new JButton("로그인");
	JButton jbtn_signup 	= new JButton("회원가입");
	JButton jbtn_exit   	= new JButton("나가기");
	Font f 					= new Font("궁서체",Font.BOLD,16);
//	MovieSignup ms 			= new MovieSignup();
//	MovieEvent me 			= new MovieEvent(this);	
//	MovieEvent2 me2 		= new MovieEvent2();	
	ImageIcon post = new ImageIcon("C:\\workspace_java\\dev_java\\src\\movieteam\\cgv.PNG");
	Image bg1 = post.getImage();
	Image bg2 = bg1.getScaledInstance(450, 400, Image.SCALE_SMOOTH);
	ImageIcon imgpost = new ImageIcon(bg2);
	JLabel jlb_pc = new JLabel(imgpost);
	
	//생성
	public MovieViewLogin2() {
	}
	
	public void initDisplay() {
		//버튼 이벤트 처리
		jp_c.setLayout(null);
//		jbtn_login.addActionListener(me2);
//		jbtn_signup.addActionListener(me2);
//		jbtn_exit.addActionListener(me2);
		jlb_id.setBounds(110, 170, 100, 30);
		jtf_id.setBounds(180, 170, 100, 30);
		jlb_id.setFont(f);//id폰트
		jlb_pw.setBounds(100, 210, 100, 30);
		jpf_pw.setBounds(180, 210, 100, 30);
		jlb_pw.setFont(f);//pw폰트
		jbtn_login.setBounds(100, 260, 100, 30);
		jbtn_signup.setBounds(230, 260, 100, 30);
		jbtn_exit.setBounds(330, 310, 80, 30);
		//아이디와 비밀번호 
		jp_c.add(jlb_id);
		jp_c.add(jtf_id);
		jp_c.add(jlb_pw);
		jp_c.add(jpf_pw);
//		jp_c.add(jlb_pic);
		//버튼 위치
		jp_c.add(jbtn_login);
		jp_c.add(jbtn_signup);
		jp_c.add(jbtn_exit);
		jp_c.add(jlb_pc);
		jlb_pc.setBounds(0, -50, 450, 400);
		//테이블/사이즈
		this.add("Center",jp_c);
		this.setTitle("로그인");
		this.setSize(450,400);
		this.setLocation(800,250);
		this.setVisible(true);
		
	}/*
	public static void main(String[] args) {
		MovieViewLogin2 mvl2 = new MovieViewLogin2();
		mvl2.initDisplay();
	}*/
	
}
