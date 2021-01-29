package designbook.test;

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
public class LoginView extends JFrame  {
	
	ImageIcon post4 = new ImageIcon("C:\\Users\\Kosmo_28\\Desktop\\BackGround.png"); // 강철비2
//  Image bg1 = post4.getImage(); //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
//  Image bg2 = bg1.getScaledInstance(700, 600, Image.SCALE_SMOOTH);
//  ImageIcon imgpost4 = new ImageIcon(bg2);
//	String imgPath = "C:\\workspace_java\\dev_java\\src\\booksystem\\";
	JPanel jp_center = new JPanel();
//	ImageIcon ii = new ImageIcon(LoginView.class.getResource("/booksystem/image/wel.jpg"));
//	ImageIcon ii1 = new ImageIcon(ii.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH));
	JLabel jlb_id = new JLabel("ID");
	JLabel jlb_pw = new JLabel("PW");
	JTextField jtf_id = new JTextField();
	JPasswordField jtf_pw = new JPasswordField();
//	Image b1 = ii.getImage();
//	Image b2 = b1.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
	JButton jbtn_login = new JButton("로그인");
	JButton jbtn_exit = new JButton("나가기"); 
	JButton jbtn_sign = new JButton("회원가입");
//	JLabel jlb_pc = new JLabel(ii1);
	
	ClientManager cm = new ClientManager(this);
	LoginEvent le = new LoginEvent(this);

public LoginView() {
	initDisplay();
}
public void initDisplay() {
	this.add("Center",jp_center);
	jp_center.setLayout(null);
	jbtn_login.addActionListener(le);
	jbtn_exit.addActionListener(le);
	jbtn_sign.addActionListener(le);
//	this.add(jlb_pc);
	jp_center.add(jbtn_login);
	jp_center.add(jbtn_sign);
	jp_center.add(jbtn_exit);
	jp_center.add(jlb_id);
	jp_center.add(jlb_pw);
//	jlb_pc.setIcon(ii1);
	jp_center.add(jtf_id);
	jp_center.add(jtf_pw);
//	jp_center.add(jlb_pc);
	
	jlb_id.setBounds(214, 270, 40, 40);
	jtf_id.setBounds(240, 277, 120, 25);
	
	jlb_pw.setBounds(210, 300, 40, 40);
	jtf_pw.setBounds(240, 307, 120, 25);
	
	jbtn_exit.setBounds(500, 420, 73, 30);
	jbtn_login.setBounds(200, 420, 73, 30);
	jbtn_sign.setBounds(300, 420, 90, 30);
//	jlb_pc.setBounds(0, 0, 600, 500);
	this.setTitle("도서관리 시스템");
	this.setSize(600, 500);
	this.setVisible(true);
	////////////////////////////////////////첫창
}
	public static void main(String[] args) {
		new LoginView();
	}
}
