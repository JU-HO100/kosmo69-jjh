package game.baseball;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
/*
 * 이벤트 처리 3단계
 * 1.JTextField가 지원하는 이벤트 처리 담당 class를 implements한다.
 * 2.1번에서 추가된 이벤트 처리 담당 class가 선언하고 있는 actionPerformde메소드를 재저의 해야한다.(안하면 문법에러가 난다)
 * 3.이벤트 소스(이벤트 처리 대상 클래스의 주소번지)와 이벤트 처리를 담당하는 class를 연결하기. 
 */
public class BaseBallGame2 implements ActionListener {     
	JFrame jf = new JFrame();
	//중앙에 들어갈 속지 선언
	JPanel jp_center = new JPanel();
	//글꼴에 대한 스타일과 글자 크기를 정해준다. -인스턴스화를 통해서, 그 값들은 생성자의 파라미터로 결정된다.
	//세자리 숫자를 입력 후 엔터를 쳤을때 사용자가 입력한 숫자와 숫자를 맞추기 위한 힌트문을
	//출력해줄 화면이다.
	//동쪽에 들어갈 속지 생성하기
	JPanel jp_east       = new JPanel();
	JMenuItem jmi = new JMenuItem();
	Font f = new Font("Thoma",Font.BOLD,16);
	//  \\C:\\workspace_java\\dev_java\\src\\game\\baseball\\
	String imgPath = "C:\\workspace_java\\dev_java\\src\\game\\baseball\\";
//	ImageIcon bg = new ImageIcon(imgPath+"images4.jpg");
	Image img = jf.getToolkit().getImage(imgPath+"images4.jpg");
//이미지 버튼을 만드는데 필요한 클래스 선언하기
	//////////////이미지
	////////////////////////메뉴 바 추가//////////////////////////////
	JButton   jbtn_inew  = new JButton();
	JMenuBar  jmb        = new JMenuBar();
	JMenu     jm_file    = new JMenu("파일");
	JMenuItem jmi_new    = new JMenuItem("새파일");
	JMenuItem jmi_dap    = new JMenuItem("정답");
	JMenuItem jmi_clear  = new JMenuItem("지우기");
	JMenuItem jmi_exit   = new JMenuItem("닫기");
	JMenu     jm_info    = new JMenu("도움말");
	JMenuItem jmi_detail = new JMenuItem("야구숫자게임이란?");
	JMenuItem jmi_create = new JMenuItem("만든사람");
	JToolBar  toolBar    = new JToolBar();
	////////////////////////메뉴 바 닫기//////////////////////////////
	JScrollPane jsp_display = null;
	JTextArea  jta_display  = null;
	JTextField jtf_user     = new JTextField();
	//새게임, 정답, 지우기, 나가기 버튼 추가하기
	JButton    jbtn_new     = new JButton("새게임");
	JButton    jbtn_dap     = new JButton("정답");
	JButton    jbtn_clear   = new JButton("지우기");
	JButton    jbtn_exit    = new JButton("나가기");
	int my[] = new int[3];
	int com[] = new int[3];
	int cnt = 0;//++cnt 힌트 문장에서 순번을 출력하는 변수
	//int cnt = 1;//cnt++ 시작은 1부터 시작이므로 cnt=1일때 cnt 앞에 ++를 붙이면 2부터 시작한다.
	//세자리 임의의 숫자를 채번하는 메소드 구현하기
	
	/* 배경 이미지 구현 
	class BgPanel extends JPanel{
		public void paintComponent(Graphics g) {
			g.drawImage(bg.getImage(), 0,0,null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	*/

	public void ranCom() {
		com[0] =(int)(Math.random()*10);
		do {
			com[1] =(int)(Math.random()*10);
		}while(com[0]==com[1]);
		do {
			com[2] =(int)(Math.random()*10);
		}while(com[1]==com[2]||com[0]==com[2]);
	}
	//사용자가 입력한 값을 판정하는 메소드를 구현해 봅시다.
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

	//나기기 버튼이나 나가기 메뉴 아이템을 선택(클릭)했을 때 호출되는 메소드를 구현한다
	public void exit() {
		System.out.println("exit호출 성공");
		System.exit(0);
	}
	//화면을 그려주는 메소드 선언
	public void initDisplay() {
		jta_display  = new JTextArea() {
			//배경 이미지 구현
				public void paint(Graphics g) {
				g.drawImage(img, 0, 0, null);
				Point p= jsp_display.getViewport().getViewPosition();
				g.drawImage(img, p.x, p.y, null);
				paintComponent(g);
		
			}
		};
		jsp_display = new JScrollPane(jta_display);
	//	jf.setContentPane(new BgPanel()); // 이미지 만들때 쓴다
		System.out.println("initDisplay 호출 성공");
		//이벤트 소스와 이벤트 처리 class를 매핑하는 코드 추가
	//	EventHandlr ehandler = new EventHandlr();
	//	jtf_User.addActionListener(ehandler);
		//////////////툴바에 들어갈 이미지 버튼 추가하기 /////////////////////
//		jbtn_inew.setIcon(new ImageIcon(imgPath+"b1")) ;
		toolBar.add(jbtn_inew);
		//////////////메뉴바 추가 시작 ///////////////////////
		
		jbtn_exit.addActionListener(this);//-BaseBallGame:내안에 actionPerformed가 있어야한다
		jbtn_new.addActionListener(this);
		jbtn_dap.addActionListener(this);
		jbtn_clear.addActionListener(this);
		jmi_exit.addActionListener(this);
		jtf_user.addActionListener(this);//여기서 this는 자기자신 class를 가리킨다. 
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_clear);
		jm_file.add(jmi_exit);
		jm_info.add(jmi_detail);
		jm_info.add(jmi_create);
		jm_file.setMnemonic('F');
		jm_info.setMnemonic('E');
		jmb.add(jm_file);
		jmb.add(jm_info);
		jbtn_new.setBackground(new Color(173,255,47));//버튼 배경색 바꾸기
		jbtn_new.setForeground(new Color(0,0,0));//버튼색 바꾸기
		jbtn_dap.setBackground(new Color(218,165,32));
		jbtn_dap.setForeground(new Color(0,0,0));
		jbtn_clear.setBackground(new Color(24,255,255));
		jbtn_clear.setForeground(new Color(0,0,0));
		jbtn_exit.setBackground(new Color(220,220,220));
		jbtn_exit.setForeground(new Color(0,0,0));
		jp_east.setLayout(new GridLayout(4,1));
		
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);	
		jp_east.add(jbtn_clear);		
		jp_east.add(jbtn_exit);		
		jta_display.setFont(f);
		jta_display.setBackground(new Color(224,255,255));
		jta_display.setForeground(new Color(0,0,0));
		jtf_user.setBackground(new Color(254,255,255));
		jp_center.setBackground(Color.white);
		jp_east.setBackground(Color.black);
		jp_center.setLayout(new BorderLayout());
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_user);
		jta_display.setLineWrap(true);
		
		jf.setJMenuBar(jmb);
		jf.setLayout(new BorderLayout(20,20));
		jf.add("North",toolBar);
		jf.add("Center",jp_center);
		jf.add("East",jp_east);
		jf.setTitle("야구 숫자 게임 Ver1.0");
		jf.setSize(700,500);
		jf.setVisible(true);
		jf.setJMenuBar(jmb);
	}
	public static void main(String[] args) {
		BaseBallGame2 bbGame = new BaseBallGame2();
		bbGame.initDisplay();
		bbGame.ranCom();//컴퓨터가 채번한 숫자가 채워진다. 채워지기 전에는 000(int)가 채워진다
	}
	//////////jtf_user에 엔터를 쳤을 때, jbtn_exit버튼을 클릭했을때 이벤트 지원하는 인터페이스가 ActionListener이다.
	//ActionListener는 반드시 actionParformed를 재정의 해야 한다.
	//annotation- 부모가 가진 메소드를 재정의 하였다 는 의미이다.
	//callback(콜백)method는 개발자가 호출할 수 없는 메소드로 시스템 레벨에서 필요할 때 자동으로 호출된다.
	//java에 main.method도 일종의 콜백 메소드 이다.
	
	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed 호출 성공");
		String label = e.getActionCommand();
		System.out.println("너가 누른 버튼의 문자열은"+label+"입니다.");
		Object obj = e.getSource();//이벤트소스의 주소번지를 담아줌.
		//너 나가기 버튼이니?
		if("나가기".equals(label)) {
			exit();//exit 메소드 호출하기
		}
		/*
		if(obj==jbtn_exit || obj==jmi_exit) }//여기에 else를 쓰면 실행될 기회를 잃는다.
			exit();
		*/
		
		
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
	}/////////////end of actionPerformed
}
	
