package designbook.test2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
public class TestLoginView extends JFrame  {

	JPanel jp_center = new JPanel();
	JLabel jlb_id = new JLabel("ID");
	JLabel jlb_pw = new JLabel("PW");
	JTextField jtf_id = new JTextField();
	JPasswordField jtf_pw = new JPasswordField();
	JButton jbtn_login = new JButton("로그인");
	JButton jbtn_exit = new JButton("나가기");
	JButton jbtn_sign = new JButton("회원가입");
	
	ClientManager cm = new ClientManager(this);
	LoginEvent le = new LoginEvent(this);


public void initDisplay() {
	this.add("Center",jp_center);
	jp_center.setLayout(null);
	jbtn_login.addActionListener(le);
	jbtn_exit.addActionListener(le);
	jbtn_sign.addActionListener(le);
	jp_center.add(jbtn_login);
	jp_center.add(jbtn_sign);
	jp_center.add(jbtn_exit);
	jp_center.add(jlb_id);
	jp_center.add(jlb_pw);
	jp_center.add(jtf_id);
	jp_center.add(jtf_pw);
	
	jlb_id.setBounds(214, 270, 40, 40);
	jtf_id.setBounds(240, 277, 120, 25);
	
	jlb_pw.setBounds(210, 300, 40, 40);
	jtf_pw.setBounds(240, 307, 120, 25);
	
	jbtn_exit.setBounds(500, 420, 73, 30);
	jbtn_login.setBounds(200, 420, 73, 30);
	jbtn_sign.setBounds(300, 420, 90, 30);
	this.setTitle("도서관리 시스템");
	this.setSize(600, 500);
	this.setVisible(true);
}
public static void main(String[] args) {
	TestLoginView tl = new TestLoginView();
	tl.initDisplay();
}
}
