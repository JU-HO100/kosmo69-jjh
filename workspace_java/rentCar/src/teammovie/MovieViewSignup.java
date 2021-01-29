package teammovie;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MovieViewSignup extends JDialog {
	//선언부
	JFrame jf 				= new JFrame();
	JPanel jp_c 			= new JPanel();
	JPanel jp_s 			= new JPanel();
	JTextField jtf_id 		= new JTextField();
	JTextField jtf_pw 		= new JTextField();
	JTextField jtf_name 	= new JTextField();
	JTextField jtf_zipcode 	= new JTextField();
	JTextField jtf_address 	= new JTextField();
	JTextField jtf_pn 		= new JTextField();
	JLabel jlb_singup 		= new JLabel("회원가입 ");
	JLabel jlb_id 			= new JLabel("아이디");
	JLabel jlb_pw 			= new JLabel("패스워드");
	JLabel jlb_name 		= new JLabel("이름");
	JLabel jlb_zipcode 		= new JLabel("우편번호");
	JLabel jlb_address 		= new JLabel("주소");
	JLabel jlb_pn 			= new JLabel("핸드폰번호");
	JButton jbtn_search 	= new JButton("중복검사");
	JButton jbtn_search2 	= new JButton("주소찾기");
	JButton jbtn_ok 		= new JButton("확인");
	JButton jbtn_exit 		= new JButton("돌아가기");
	
	//생성부
	public MovieViewSignup() {
	}

	public void initDisplay() {
		jbtn_search.addActionListener(mv);
		jbtn_search2.addActionListener(mv);
		jbtn_ok.addActionListener(mv);
		jbtn_exit.addActionListener(mv);
		jp_c.setLayout(null);
		jlb_singup.setBounds(50, 20, 100, 20);
		jlb_id.setBounds(50, 50, 120, 20);
		jtf_id.setBounds(120, 50, 120, 20);
		jlb_pw.setBounds(50, 80, 120, 20);
		jtf_pw.setBounds(120, 80, 120, 20);
		jlb_name.setBounds(50, 110, 120, 20);
		jtf_name.setBounds(120, 110, 120, 20);
		jlb_zipcode.setBounds(50, 140, 140, 20);
		jtf_zipcode.setBounds(120, 140, 140, 20);
		jlb_address.setBounds(50, 170, 250, 20);
		jtf_address.setBounds(120, 170, 250, 20);
		jlb_pn.setBounds(50, 200, 120, 20);
		jtf_pn.setBounds(120, 200, 120, 20);
		jbtn_search.setBounds(250, 50, 90, 20);
		jbtn_search2.setBounds(280, 140, 90, 20);
		jp_c.add(jlb_singup);
		jp_c.add(jtf_id);
		jp_c.add(jlb_id);
		jp_c.add(jtf_pw);
		jp_c.add(jlb_pw);
		jp_c.add(jtf_name);
		jp_c.add(jlb_name);
		jp_c.add(jtf_zipcode);
		jp_c.add(jlb_zipcode);
		jp_c.add(jtf_address);
		jp_c.add(jlb_address);
		jp_c.add(jtf_pn);
		jp_c.add(jlb_pn);
		jp_c.add(jbtn_search);
		jp_c.add(jbtn_search2);
		jp_s.add(jbtn_ok);
		jp_s.add(jbtn_exit);

		jf.add("South",jp_s);
		jf.add("Center",jp_c);
		jf.setTitle("회원가입");
		jf.setSize(450, 380);
		jf.setLocation(800,250);
		jf.setVisible(true);
	}
/*	public static void main(String[] args) {
		MovieViewSignup mvs = new MovieViewSignup();
		mvs.initDisplay();
	}
	*/
}
