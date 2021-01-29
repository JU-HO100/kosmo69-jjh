package net.tomato_step2;

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

import com.util.DBConnectionMgr;
import com.vo.MemberShip;


public class Login extends JFrame implements ActionListener {
		//선언
//		JScrollPane jsp_c 		= new JScrollPane();
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
		BandClient bc 			= null;
		BandMemberShip	bms		= null;
		BandDAO		bdao 		= new BandDAO();
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
			String nickName = bdao.procLogin(jtf_id.getText(),jtf_pw.getText());
			
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
					BandDAO bdao = new BandDAO();
					bdao.procLogin(mem_id, mem_pw);
					this.dispose();
					
					//스프링 프레임워크 장착 - 전자정부프레임워크 - Daven, AnyFrame
					//게임이면 엔진 - 개발 속도가 빨라진다. - 재사용성이 증가한다. - 확장성이 좋아진다.
					//그래서 다른 회사에 이직해서 재사용하면 
					//생성자 호출하기 -중요-
					//파라미터로 무엇을 넘기나요.? - 공유 - 유지(세션과 쿠키)
					bc = new BandClient(nickName);
					bc.initDisplay();
					bc.init();
				}
			}
				else if(obj == jbtn_signup) {
					bms = new BandMemberShip();
//					bms.initDisplay();
			}
			
				
				
			
			
				
		}
}
