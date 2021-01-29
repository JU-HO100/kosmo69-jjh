package net.tomato_step4;

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

public class Login extends JFrame implements ActionListener {
		//선언
		JPanel jp_c 	  		= new JPanel();
		JPanel jp_s	 	  		= new JPanel();
		JLabel jlb_id 	  		= new JLabel("아이디");
		JLabel jlb_pw 	  		= new JLabel("비밀번호");
		JTextField jtf_id 		= new JTextField("test");
		JTextField jtf_pw 		= new JTextField("123");
//		JPasswordField jpf_pw 	= new JPasswordField("123");
//		JButton jbtn_exit   	= new JButton("나가기");
		Font f 					= new Font("휴먼매직체",Font.BOLD,20);
		String imgPath 			= "src\\imgs\\";
		JButton jbtn_login 		= new JButton(new ImageIcon(imgPath+"s2.png"));
		JButton jbtn_signup 	= new JButton(new ImageIcon(imgPath+"s3.png"));
		ImageIcon iicon 		= new ImageIcon(imgPath+"s1.png");
		ImageIcon iicon2 		= new ImageIcon(imgPath+"s2.png");
		ImageIcon iicon3 		= new ImageIcon(imgPath+"s3.png");
		String nickName 		= null;
		ChatClient 	  tc 	= null;
		ChatMemberShip  tms	= null;
		ChatDAO		  tdao 	= new ChatDAO();
		class MyPicture extends JPanel{
			public void paintComponent(Graphics g) {
				g.drawImage(iicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		}
		//생성부
		public Login() {
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
			jtf_pw.setBounds(110, 240, 185, 40);//pw 텍스트 위치
			jlb_pw.setFont(f);//pw폰트
			jbtn_signup.setBounds(45, 285, 120, 40);
			jbtn_login.setBounds(175, 285, 120, 40);
			//아이디와 비밀번호 붙이기
			this.add(jbtn_signup);
			this.add(jbtn_login);
			this.add(jlb_id);//id 라벨
			this.add(jtf_id);//id 텍스트
			this.add(jlb_pw);//pw 라벨
			this.add(jtf_pw);//pw 텍스트
			
			//테이블/사이즈
			this.setTitle("로그인화면");
			this.setSize(350,600);
			this.setLocation(800,250);
			this.setVisible(true);
			
	}
		//메인메소드
		public static void main(String[] args) {
			Login lf = new Login();
			lf.initDisplay();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			nickName = tdao.procLogin(jtf_id.getText(),jtf_pw.getText());
			
			if(obj == jbtn_login) {
				if("아이디가 존재하지 않습니다.".equals(nickName)) {
					JOptionPane.showMessageDialog(this, "아이디를 확인하세요","INFO",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else if("비밀번호가 틀립니다.".equals(nickName)){
					JOptionPane.showMessageDialog(this, "비밀번호를 확인하세요", "WARN", JOptionPane.INFORMATION_MESSAGE);
					
					return;
				}else {
					String mem_id = jtf_id.getText();
					String mem_pw = jtf_pw.getText();
					ChatDAO bdao = new ChatDAO();
					bdao.procLogin(mem_id, mem_pw);
					jtf_id.setText("");
					jtf_pw.setText("");
					this.dispose();
					JOptionPane.showMessageDialog(this, nickName + "님의 접속을 환영합니다."
												,"INFO"
												,JOptionPane.INFORMATION_MESSAGE);
					tc = new ChatClient(this);
					tc.initDisplay();
					tc.init();
				}
			}////////////////////////end of login
				else if(obj == jbtn_signup) {
					tms = new ChatMemberShip();
//					tms.initDisplay();
			}////////////////////////end of signUp
			
				
				
			
			
				
		}
}
