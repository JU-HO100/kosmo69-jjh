package game.baseball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * 이벤트 처리 3단계
 * 1.JTextField가 지원하는 이벤트 처리 담당 class를 implements한다.
 * 2.1번에서 추가된 이벤트 처리 담당 class가 선언하고 있는 actionPerformde메소드를 재저의 해야한다.(안하면 문법에러가 난다)
 * 3.이벤트 소스(이벤트 처리 대상 클래스의 주소번지)와 이벤트 처리를 담당하는 class를 연결하기. 
 */
public class BaseBallGame implements ActionListener {
	//중앙에 들어갈 속지 선언
	JPanel jp_center = new JPanel();
	//세자리 숫자를 입력 후 엔터를 쳤을때 사용자가 입력한 숫자와 숫자를 맞추기 위한 힌트문을
	//출력해줄 화면이다.
	JMenuBar jmb = new JMenuBar();//메뉴바
	JMenuItem jmi = new JMenuItem();//메뉴 아이템
	JTextArea jta_display = new JTextArea();//화면에 나오는 값
	JTextField jtf_user = new JTextField();//유저가 입력한 값
	JScrollPane jsp_display = new JScrollPane(jta_display
                                    		, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                                , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//글꼬로가 글꼴에 대한 스타일과 글자 크기를 정해준다. -인스턴스화를 통해서, 그 값들은 생성자의 파라미터로 결정된다.
	Font f = new Font("Thoma",Font.BOLD,16);
	//동쪽에 들어갈 속지 생성하기
	JPanel jp_east       = new JPanel();
	////////////////////////메뉴 바 추가//////////////////////////////
	JMenu    jm_file     = new JMenu("파일");
	JMenuItem jmi_new    = new JMenuItem("새파일");
	JMenuItem jmi_dap    = new JMenuItem("정답");
	JMenuItem jmi_clear  = new JMenuItem("지우기");
	JMenuItem jmi_exit   = new JMenuItem("닫기");
	JMenu    jm_info     = new JMenu("도움말");
	JMenuItem jmi_detail = new JMenuItem("야구숫자게임이란?");
	JMenuItem jmi_create = new JMenuItem("만든사람");
	//나기기 버튼이나 나가기 메뉴 아이템을 선택(클릭)했을 때 호출되는 메소드를 구현한다
	////////////////////////메뉴 바 닫기//////////////////////////////
	//새게임, 정답, 지우기, 나가기 버튼 추가하기
	JButton jbtn_new   = new JButton("새게임");
	JButton jbtn_dap   = new JButton("정답");
	JButton jbtn_clear = new JButton("지우기");
	JButton jbtn_exit  = new JButton("나가기");
	public void exit( ) {
		System.exit(0);
	}
	//화면을 그려주는 메소드 선언
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		//이벤트 소스와 이벤트 처리 class를 매핑하는 코드 추가
		jtf_user.addActionListener(this);//여기서 this는 자기자신 class를 가리킨다. 
		 								 // -BaseBallGame:내안에 actionPerformed가 있어야한다
		/////////////////////////메뉴 바 추가////////////////////////////
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
		/////////////////////////메뉴 바 추가 ///////////////////////////////
	//	jbtn_new.setBackground(new Color(50,180,100));//버튼 배경색 바꾸기
	//	jbtn_new.setForeground(new Color(212,212,212));//버튼색 바꾸기
	//	jbtn_dap.setBackground(new Color(7,84,170));
		jbtn_dap.setForeground(new Color(212,212,212));
	//	jbtn_clear.setBackground(new Color(54,54,54));
	//	jbtn_clear.setForeground(new Color(212,212,212));
	//	jbtn_exit.setBackground(new Color(90,9,9));
	//	jbtn_exit.setForeground(new Color(212,212,212));
		jp_east.setLayout(new GridLayout(4,1));
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);	
		jp_east.add(jbtn_clear);		
		jp_east.add(jbtn_exit);		
		jta_display.setFont(f);
	//	jta_display.setBackground(new Color(255,255,200));
	//	jta_display.setForeground(new Color(64,108,216));
		JFrame jf = new JFrame();
		jf.setJMenuBar(jmb);
	//	jtf_user.setBackground(new Color(255,255,200));
	//	jp_center.setBackground(Color.RED);
	//	jp_east.setBackground(Color.black);
		jp_center.setLayout(new BorderLayout());
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_user);
		jta_display.setLineWrap(true);
		jf.setLayout(new BorderLayout(20,20));
		jf.add("Center",jp_center);
		jf.add("East",jp_east);
		jf.setTitle("야구 숫자 게임 Ver1.0");
		jf.setSize(400, 300);
		jf.setVisible(true);
		jf.setJMenuBar(jmb);
	}
	public static void main(String[] args) {
		BaseBallGame bbGame = new BaseBallGame();
		bbGame.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jtf_user) {
			jta_display.append(jtf_user.getText()+"\n");
			jtf_user.setText("");
			
		}
		
	}

}
