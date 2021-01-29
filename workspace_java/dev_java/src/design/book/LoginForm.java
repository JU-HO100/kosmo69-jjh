package design.book;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.vo.MemberShip;


public class LoginForm extends JFrame implements ActionListener {
		//선언
//		JScrollPane jsp_c 		= new JScrollPane();
		JPanel jp_c 	  		= new JPanel();
		JPanel jp_s	 	  		= new JPanel();
		JLabel jlb_id 	  		= new JLabel("아이디");
		JLabel jlb_pw 	  		= new JLabel("비밀번호");
		JTextField jtf_id 		= new JTextField("test");
		JPasswordField jpf_pw 	= new JPasswordField("123");
//		JButton jbtn_exit   	= new JButton("나가기");
		Font f 					= new Font("휴먼매직체",Font.BOLD,20);
		String imgPath 			= "src\\imgs\\";
		JButton jbtn_login 		= new JButton(new ImageIcon(imgPath+"s2.png"));
		JButton jbtn_signup 	= new JButton(new ImageIcon(imgPath+"s3.png"));
		ImageIcon iicon 		= new ImageIcon(imgPath+"s1.png");
		ImageIcon iicon2 		= new ImageIcon(imgPath+"s2.png");
		ImageIcon iicon3 		= new ImageIcon(imgPath+"s3.png");
		BookManager bookMgr 	= null;
		MemberShip mbS 			= null;

		class MyPicture extends JPanel{
			public void paintComponent(Graphics g) {
				g.drawImage(iicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		}
		
		
		//생성부
	public LoginForm() {
		
	}
		
		//화면처리
		public void initDisplay() {
			setContentPane(new MyPicture());
			//버튼 이벤트 처리
			jbtn_signup.addActionListener(this);
		    jbtn_login.addActionListener(this);
		    
		 	
			//아이디와 비밀번호 위치
			this.setLayout(null);
			jlb_id.setBounds(45, 200, 80, 40);//id 라벨 위치
			jtf_id.setBounds(110, 200, 185, 40);//id 텍스트 위치
			jlb_id.setFont(f);//id폰트
			jlb_pw.setBounds(45, 240, 80, 40);//pw 라벨 위치
			jpf_pw.setBounds(110, 240, 185, 40);//pw 텍스트 위치
			jlb_pw.setFont(f);//pw폰트
			jbtn_signup.setBounds(45, 285, 120, 40);
			jbtn_login.setBounds(175, 285, 120, 40);
			//아이디와 비밀번호 붙이기
			this.add(jbtn_signup);
			this.add(jbtn_login);
			this.add(jlb_id);//id 라벨
			this.add(jtf_id);//id 텍스트
			this.add(jlb_pw);//pw 라벨
			this.add(jpf_pw);//pw 텍스트
			
			//테이블/사이즈
			this.setTitle("도서관리 시스템");
			this.setSize(350,600);
			this.setLocation(800,250);
			this.setVisible(true);
			
	}
		//메인메소드
		public static void main(String[] args) {
			LoginForm lf = new LoginForm();
			lf.initDisplay();
			
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == jbtn_login) {
				if("".equals(jtf_id.getText())) {
					JOptionPane.showMessageDialog(this, "아이디를 확인하세요","INFO",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else {
					this.dispose();
					bookMgr = new BookManager();
					bookMgr.initDisplay();
				}
			}
				else if(obj == jbtn_signup) {
				mbS = new MemberShip();
				mbS.initDisplay();
			}
			
				
				
			
			
				
		}
}
