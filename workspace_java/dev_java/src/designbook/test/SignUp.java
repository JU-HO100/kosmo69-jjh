package designbook.test;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUp extends JDialog{
	JPanel jp_south = new JPanel();
	JPanel jp_center = new JPanel();
	JButton jbtn_ins = new JButton("등록");
	JButton jbtn_close = new JButton("닫기");
	JButton jbtn_conf = new JButton("중복확인");
	JLabel jlb_id = new JLabel("아이디");
	JLabel jlb_pw = new JLabel("비밀번호");
	JLabel jlb_name = new JLabel("이름");
	JLabel jlb_hp = new JLabel("H.P");
	
	JTextField jtf_id = new JTextField();
	JTextField jtf_pw = new JTextField();
	JTextField jtf_name = new JTextField();
	JTextField jtf_hp = new JTextField();
	
	SignEvent se = new SignEvent(this); //회원가입페이지 이벤트연결
	LoginEvent le = null;
	


	public SignUp(LoginEvent loginEvent) {
		this.le = loginEvent;
	}
	public SignUp() {
		initDisplay();
	}


	public void initDisplay(){
	jbtn_conf.addActionListener(se);
	jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
	jp_center.setLayout(null);
	jp_south.add(jbtn_ins);
	jp_south.add(jbtn_close);
    jp_center.add(jlb_id);
    jp_center.add(jlb_pw);
    jp_center.add(jlb_name);
    jp_center.add(jlb_hp);
    jp_center.add(jtf_id);
    jp_center.add(jtf_pw);
    jp_center.add(jtf_name);
    jp_center.add(jtf_hp);
    Font f = new Font("휴면매직체",Font.BOLD,17);
    jlb_id.setBounds(50, 50, 70, 30);
	jlb_id.setFont(f);
	jtf_id.setBounds(150,55,100,25);
	
	jbtn_conf.setBounds(280, 55, 90, 25);
	jp_center.add(jbtn_conf);

	jlb_pw.setBounds(50, 90, 70, 40);
	jlb_pw.setFont(f);
	jtf_pw.setBounds(150,100,100,25);
    jlb_name.setBounds(50, 130, 70, 40);
	jlb_name.setFont(f);
	jtf_name.setBounds(150,140,100,25);

    jlb_hp.setBounds(50, 170, 70, 40);
	jlb_hp.setFont(f);
	jtf_hp.setBounds(150,180,100,25);
	
	jbtn_close.addActionListener(se);
	jbtn_ins.addActionListener(se);
	
	this.add("Center",jp_center);
	this.add("South", jp_south);
	this.setSize(400, 500);
	this.setTitle("회원가입");
	this.setVisible(true);
	}
}
