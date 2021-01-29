package book.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Main2 extends JFrame implements ActionListener {
	//메뉴
			JMenu jm_file 	        = new JMenu("파일");
			JMenuBar jmb 		    = new JMenuBar();
			JMenuItem jmi 	  	    = new JMenuItem();
			JMenuItem jmi_new 	    = new JMenuItem("새게임");
			JMenuItem jmi_dap 	    = new JMenuItem("답");
			JMenuItem jmi_clear     = new JMenuItem("지우기");
			JMenuItem jmi_exit 	    = new JMenuItem("나가기");
			//패널
			JPanel jp_center 	    = new JPanel();
			JPanel jp_south 	    = new JPanel();
			JPanel jp_east 	 	    = new JPanel();
			//툴박스
			JToolBar jtb 	 	    = new JToolBar();
			//텍스트
			JTextArea jta_display   = new JTextArea();
			JTextField jtf_user	    = new JTextField();
			//버튼
			JButton jbtn   	  	    = new JButton();
			JButton jbtn_new   	    = new JButton("새게임");
			JButton jbtn_dap        = new JButton("답");
			JButton jbtn_clear      = new JButton("지우기");
			JButton jbtn_exit       = new JButton("나가기");
			//스크롤
			JScrollPane jsp  	    = new JScrollPane();
			JScrollPane jsp_display = new JScrollPane(jta_display
	        		, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
	                , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			int my[] = new int[3];
			int com[] = new int[3];
			int cnt = 0;
			
public void ranCom() {
	com[0] =(int)(Math.random()*10);
	do {
		com[1] =(int)(Math.random()*10);
	}while(com[0]==com[1]);
	do {
		com[2] =(int)(Math.random()*10);
	}while(com[1]==com[2]||com[0]==com[2]);
}
public String account(String user) {
	//사용자가 jtf_user에 입력한 숫자는 보기에는 숫자 처럼 보여도 내용은 문자열로
	//인식을 합니다. 그래서 형전환을 한후 my[]배열에 담아야 합니다.
	//문자열 "000"을 숫자로 담을 변수 선언
	int temp    =0;
	int strike  =0;//힌트로 사용될 스트라이크를 담을 변수 선언
	int ball    =0;//볼을 담을 변수 선언
	//strike와ball을 지역변수로 해야 하는건 매 회차 마다 값이 변해야 하기 때문이다.
	try { //예외처리/ 유저가 약속되지 않은 문자를 사용 됬을때 stop을 하지 않고 뒤의 코드를 진행할수 있게 해준다. 
		temp = Integer.parseInt(user);
	} catch (NumberFormatException e) { //유저가 지정되지 않은 문자를 사용했을때 잡아서 리턴값을 표시한다.
		return "숫자만 입력하세요.";
	}
	
	my[0] = temp/100;
	my[1] = (temp%100)/10;
	my[2] = temp%10;
	JOptionPane.showMessageDialog(null , my[0]+""+my[1]+""+my[2]);
	for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			if(my[i]==com[j]) {//너 안에 내가 가진 숫자가 있는거야?
				if(i==j) {//그러면 자리까지도 일치하는 거니?
					strike++;
				}
				else {	
					ball++;
				}	
			}
		}
	}
	if(strike==3) {
		return "축하합니다. 정답입니다!!!";
	}
	return strike+"스 "+ball+"볼";
}
public void	initDisplay() {
	jsp_display = new JScrollPane(jta_display);
	jtb.add(jbtn);
	System.out.println("호출 성공");
//			jtf_user.addActionListener(this);
	JFrame jf = new JFrame();
	jbtn_exit.addActionListener(this);//-BaseBallGame:내안에 actionPerformed가 있어야한다
	jbtn_new.addActionListener(this);
	jbtn_dap.addActionListener(this);
	jbtn_clear.addActionListener(this);
	jmi_exit.addActionListener(this);
	jtf_user.addActionListener(this);
	//화면
	jf.add("Center",jp_center);		
	jf.add("South",jp_south);
	jf.add("East",jp_east);
	jf.setJMenuBar(jmb);
	jp_center.setLayout(new BorderLayout());
	jp_center.setBackground(Color.white);
	jp_east.setBackground(Color.black);
	jp_center.add("Center",jsp_display);
	jp_center.add("South",jtf_user);
	jta_display.setLineWrap(true);
	//버튼 및 버튼배경 색
	jbtn_new.setBackground(new Color(173,255,47));
	jbtn_new.setForeground(new Color(0,0,0));
	jbtn_dap.setBackground(new Color(218,165,32));
	jbtn_dap.setForeground(new Color(0,0,0));
	jbtn_clear.setBackground(new Color(24,255,255));
	jbtn_clear.setForeground(new Color(0,0,0));
	jbtn_exit.setBackground(new Color(220,220,220));
	jbtn_exit.setForeground(new Color(0,0,0));
	//오른쪽 메뉴바
	jp_east.add(jbtn_new);
	jp_east.add(jbtn_dap);
	jp_east.add(jbtn_clear);
	jp_east.add(jbtn_exit);
	jp_east.setLayout(new GridLayout(4, 1));
	//왼쪽상단 메뉴바
	jmb.add(jm_file);
	jm_file.add(jmi_new);
	jm_file.add(jmi_dap);
	jm_file.add(jmi_clear);
	jm_file.add(jmi_exit);		
	//화면 타이틀|사이즈
	jf.setTitle("야구 숫자 게임 Team");
	jf.setSize(500, 400);
	jf.setVisible(true);
	
}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Main2 m = new Main2();
		m.initDisplay();
		m.ranCom();
	}
	@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("actionPerformed 호출 성공");
			String label = e.getActionCommand();
			System.out.println("너가 누른 버튼의 문자열은"+label+"입니다.");
			Object obj = e.getSource();//이벤트소스의 주소번지를 담아줌.
			//너 나가기 버튼이니?
			if("나가기".equals(label)) {
				System.exit(0);//exit 메소드 호출하기
			}

			else if(e.getSource()==jtf_user) {
					jta_display.append(++cnt+"회차."+jtf_user.getText()+":"+account(jtf_user.getText())+"\n");
					jtf_user.setText("");	
			}/////////입력하고 엔터 쳤을 때
			else if(obj==jbtn_dap) {
				jta_display.append("정답은"+com[0]+com[1]+com[2]+"\n");
			}
			else if(obj==jbtn_new) {
				cnt = 0;
				ranCom();
				jta_display.append("");
				jtf_user.setText("");
				//포커스를 jtf_user에
				jtf_user.requestFocus();
			}
			else if(obj==jbtn_clear) {
				jta_display.append("");
				jtf_user.setText("");
			}
}
}
