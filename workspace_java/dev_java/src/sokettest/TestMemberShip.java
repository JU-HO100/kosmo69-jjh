package sokettest;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TestMemberShip extends JDialog implements ActionListener {
	//선언부
	JPanel jp_s 			= new JPanel();
	JPanel jp_c 			= new JPanel();
	JButton jbtn_ins 		= new JButton("확인");
	JButton jbtn_close 		= new JButton("닫기");
	JButton jbtn_select 	= new JButton("찾기");
	JButton jbtn_maching 	= new JButton("중복검사");
	JLabel jlb_id 	  		= new JLabel("아이디");
	JLabel jlb_pw 	  		= new JLabel("비밀번호");
	JLabel jlb_memname 	  	= new JLabel("이름");
	JLabel jlb_nicname 	  	= new JLabel("닉네임");
	JLabel jlb_gender 	  	= new JLabel("성별");
	JLabel jlb_zipcode 	 	= new JLabel("우편번호");
	JLabel jlb_address 	 	= new JLabel("주소");
	JTextField jtf_id 		= new JTextField(10);
	JPasswordField jpf_pw 	= new JPasswordField("");
	JTextField jtf_nicname 	= new JTextField(10);
	String[] genderList = {"남자","여자"};
	JComboBox jcb_gender	= new JComboBox(genderList);
	JTextField jtf_memname 	= new JTextField(30);
	public JTextField jtf_zipcode 	= new JTextField();
	public JTextField jtf_address 	= new JTextField();
	JSeparator js 			= new JSeparator();
	JScrollPane jsp 		= null;
	Font f 					= new Font("휴먼매직체",Font.BOLD,20);
	ZipCodeSearch zcs 		= new ZipCodeSearch();
	

	//생성자
	public TestMemberShip() {
	}
	
	//화면처리부
	public void initDisplay() {
		jbtn_select.addActionListener(this);
		jbtn_maching.addActionListener(this);
		jp_s.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_c.setLayout(null);
		jlb_id.setBounds(30, 60, 80, 30);
		jlb_id.setFont(f);
		jlb_pw.setBounds(30, 100, 80, 30);
		jlb_pw.setFont(f);
		jlb_memname.setBounds(30, 220, 80, 30);
		jlb_memname.setFont(f);
		jlb_nicname.setBounds(30, 140, 80, 30);
		jp_c.add(jlb_nicname);		
		jlb_nicname.setFont(f);
		jlb_gender.setBounds(30, 180, 80, 30);
		jlb_gender.setFont(f);
		jlb_zipcode.setBounds(30, 260, 80, 30);
		jlb_zipcode.setFont(f);
		jlb_address.setBounds(30, 300, 80, 30);
		jlb_address.setFont(f);
		jtf_id.setBounds(130, 60, 130, 30);
		jbtn_maching.setBounds(270, 60, 100, 30);
		jpf_pw.setBounds(130, 100, 130, 30);
		jtf_nicname.setBounds(130,140, 150, 30);
		jcb_gender.setBounds(130, 180, 130, 30);
		jcb_gender.setFont(new Font("굴림",1,14));
		jtf_memname.setBounds(130, 220, 130, 30);
		jtf_zipcode.setBounds(130, 260, 130, 30);
		jbtn_select.setBounds(280, 260, 80, 30);
		jtf_address.setBounds(130, 300, 200, 30);
		jp_c.add(jlb_id);
		jp_c.add(jlb_pw);		
		jp_c.add(jlb_zipcode);				
		jp_c.add(jlb_gender);				
		jp_c.add(jlb_memname);				
		jp_c.add(jlb_address);				
		jp_c.add(jtf_id);				
		jp_c.add(jpf_pw);				
		jp_c.add(jtf_nicname);				
		jp_c.add(jcb_gender);				
		jp_c.add(jtf_memname);				
		jp_c.add(jtf_zipcode);				
		jp_c.add(jtf_address);		
		
		jp_s.add(jbtn_ins);
		jp_s.add(jbtn_close);
		jp_c.add(jbtn_select);
		jp_c.add(jbtn_maching);
		this.add("South",jp_s);
		jsp = new JScrollPane(jp_c);
		this.add("Center",jp_c);
		this.setTitle("회원가입");
		this.setSize(400,500);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_select) {
			zcs.initDisplay();
		}
		
	}

}


