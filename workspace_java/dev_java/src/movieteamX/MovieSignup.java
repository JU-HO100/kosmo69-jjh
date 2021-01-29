package movieteamX;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import Team.MovieDAO;
import Team.MovieEvent;

public class MovieSignup extends JDialog{
	//선언부
	JPanel jp_s 			= new JPanel();
	JPanel jp_c 			= new JPanel();
	JButton jbtn_ins 		= new JButton("확인");
	JButton jbtn_close 		= new JButton("닫기");
//	JButton jbtn_select 	= new JButton("찾기");
	JButton jbtn_maching 	= new JButton("중복검사");
	JLabel jlb_id 	  		= new JLabel("아이디");
	JLabel jlb_pw 	  		= new JLabel("비밀번호");
//	JLabel jlb_nicname 	  	= new JLabel("닉네임");
//	JLabel jlb_gender 	  	= new JLabel("성별");
	JLabel jlb_memname 	  	= new JLabel("이름");
	JLabel jlb_zipcode 	 	= new JLabel("전화번호");
//	JLabel jlb_address 	 	= new JLabel("주소");
	JLabel jlb_address2		= null;
	JTextField jtf_id 		= new JTextField(10);
	JPasswordField jpf_pw 	= new JPasswordField("");
//	JTextField jtf_nicname 	= new JTextField(10);
//	JTextField jtf_gender 	= new JTextField(10);
//	String[] genderList = {"남자","여자"};
//	JComboBox jcb_gender	= new JComboBox(genderList);
	JTextField jtf_memname 	= new JTextField(30);
	JTextField jtf_zipcode 	= new JTextField();
//	JTextField jtf_address 	= new JTextField();
	JSeparator js 			= new JSeparator();
	JScrollPane jsp 		= null;
	Font f 					= new Font("휴먼매직체",Font.BOLD,20);
//	ZipCodeSearch 	 zcs 	= new ZipCodeSearch();
	MovieEvent me 			= new MovieEvent(this);
	
	
	MovieDAO md = null;
	//생성자
	public MovieSignup() {
	}
	public MovieSignup(MovieDAO md) {
		this.md = md;
	}
	
	//화면처리부
	public void initDisplay() {
		jlb_address2 = new JLabel();
//		jbtn_select.addActionListener(me);
		jbtn_maching.addActionListener(me);
		jbtn_ins.addActionListener(me);
		jbtn_close.addActionListener(me);		
		
		jp_s.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_c.setLayout(null);
		jlb_id.setBounds(30, 60, 80, 30);
		jlb_id.setFont(f);
		jlb_pw.setBounds(30, 100, 80, 30);
		jlb_pw.setFont(f);
//		jlb_nicname.setBounds(30, 140, 80, 30);
//		
//		jp_c.add(jlb_nicname);		
//		jlb_nicname.setFont(f);
//		jlb_gender.setBounds(30, 180, 80, 30);
//		jlb_gender.setFont(f);
		jlb_memname.setBounds(30, 220, 80, 30);
		jlb_memname.setFont(f);
		jlb_zipcode.setBounds(30, 260, 80, 30);
		jlb_zipcode.setFont(f);
//		jlb_address.setBounds(30, 300, 80, 30);
//		jlb_address.setFont(f);
		
		
		jtf_id.setBounds(130, 60, 130, 30);
		jbtn_maching.setBounds(270, 60, 100, 30);
		jpf_pw.setBounds(130, 100, 130, 30);
//		jtf_nicname.setBounds(130,140, 150, 30);
//		jcb_gender.setBounds(130, 180, 130, 30);
//		jcb_gender.setFont(new Font("굴림",1,14));
		jtf_memname.setBounds(130, 220, 130, 30);
		jtf_zipcode.setBounds(130, 260, 130, 30);
//		jbtn_select.setBounds(280, 260, 80, 30);
//		jtf_address.setBounds(130, 300, 200, 30);
		
		jp_c.add(jlb_id);
		jp_c.add(jlb_pw);		
		jp_c.add(jlb_zipcode);				
//		jp_c.add(jlb_gender);				
		jp_c.add(jlb_memname);				
//		jp_c.add(jlb_address);				
		jp_c.add(jtf_id);				
		jp_c.add(jpf_pw);				
//		jp_c.add(jtf_nicname);				
//		jp_c.add(jcb_gender);				
		jp_c.add(jtf_memname);				
		jp_c.add(jtf_zipcode);				
//		jp_c.add(jtf_address);		
		
		jp_s.add(jbtn_ins);
		jp_s.add(jbtn_close);
//		jp_c.add(jbtn_select);
		jp_c.add(jbtn_maching);
		jsp = new JScrollPane(jp_c);
		this.add("South",jp_s);
		this.add("Center",jp_c);
		this.setTitle("회원가입");
		this.setSize(450,500);
		this.setVisible(true);
		
	}
}
