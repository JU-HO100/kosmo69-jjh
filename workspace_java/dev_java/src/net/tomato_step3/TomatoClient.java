package net.tomato_step3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TomatoClient extends JFrame implements ActionListener  {
	//선언부
	/*기본창*/
	ObjectOutputStream oos 	 	= null;
	ObjectInputStream ois 	 	= null;
	Socket 		socket 			= null;
	JPanel		jp_first	 	= new JPanel();
	JPanel		jp_first_south	= new JPanel();
	JPanel		jp_secand	 	= new JPanel();
	JPanel		jp_secand_south	= new JPanel();
	JLabel   	jlb_nickname 	= new JLabel("닉네임");
	JButton 	jbtn_in 	 	= new JButton("전송");
	JButton		jbtn_one	 	= new JButton("1:1대화");
	JButton		jbtn_change  	= new JButton("대화명 변경"); 	
	JButton		jbtn_ticon	 	= new JButton("이모티콘"); 
	JButton		jbtn_color	 	= new JButton("글자색"); 
	JButton		jbtn_logout	 	= new JButton("로그아웃"); 
	JButton		jbtn_exit	 	= new JButton("종료");
	String cols[] = {"닉네임"};
	String date[][] = new String [0][1];
	DefaultTableModel dtm 		= new DefaultTableModel(date,cols);
	JTable			jtb 		= new JTable(dtm);
	Image 			back 		= getToolkit().getImage("C:\\workspace_java\\dev_java\\src\\net\\tomato_step3\\st.jpg");// .=내가 바라보는곳을 경로
//	Image 			back 		= getToolkit().getImage("src\\net\\tomato\\step3\\st.jpg");
//	Image 			back 		= getToolkit().getImage("src\\net\\tomato_step3\\st.jpg");
	JTextField		jtf_msg  	= new JTextField();
	JTextArea 		jta_display = new JTextArea(10,30);
	/*닉네임 입력 받아서 담기*/
	String 		nickName 		= null;
	/////////////////////////배경화면
		public void paint(Graphics g) {
			g.drawImage(back, 0, 0, this);
			//스크롤바 움직일때 사진도 같이 움직이는것을 방지하기
			Point p = jsp_log.getViewport().getViewPosition();
			g.drawImage(back, p.x, p.y, this);//
			paintComponents(g);//슈퍼클래스의 메소드를 호출
		}
	
	JScrollPane 	jsp_log  	= new JScrollPane(jta_display
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JScrollPane 	jsp_log2  	= new JScrollPane(jtb
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	/*대화창*/
//	JPanel 		jp_conv1 	= new JPanel();
//	JTextField	jtf_con 	= new JTextField();
//	JTextArea 	jta_con 	= new JTextArea(10,30);
//	JButton		jbtn_con	= new JButton("전송");
//	JButton		jbtn_ticon1 = new JButton("ㆅ");
	/*디폴트 생성자는 JVM이 제공해줄 수도 있지만 파라미터가 있는 생성자는 제공이 안된다.*/
	public TomatoClient() {}
	public TomatoClient(String nickName) {
		this.nickName = nickName;
	}
	
	//화면처리
	public void initDisplay() {
		/*사용자로 부터 닉네임 입력 받기*/
//		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		jta_display.setOpaque(false);
		jta_display.setEditable(false);
		jta_display.setLineWrap(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbtn_in.addActionListener(this);
		jbtn_one.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_ticon.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jtf_msg.addActionListener(this);
		/*패널1에 들어갈것들*/
		this.setLayout(new GridLayout(1,2,2,2));
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_log);
		jta_display.setEditable(false);
		this.add("Center",jp_first);
		/*패널1에 남쪽*/
		this.add("East",jp_secand);
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_in);
		jp_first.add("South",jp_first_south);
		/*패널2에 들어갈것들*/
		jp_secand.setLayout(new BorderLayout());
		jp_secand.add("Center",jsp_log2);
		jp_secand.add("South",jp_secand_south);
		jbtn_one.setBackground(new Color(255,215,0));
		jbtn_one.setForeground(new Color(0,0,0));
		jbtn_change.setBackground(new Color(255,0,255));
		jbtn_change.setForeground(new Color(0,0,0));
		jbtn_ticon.setBackground(new Color(255,255,0));
		jbtn_ticon.setForeground(new Color(0,0,0));
		jbtn_color.setBackground(new Color(0,206,209));
		jbtn_color.setForeground(new Color(0,0,0));
		jbtn_logout.setBackground(new Color(220,220,220));
		jbtn_logout.setForeground(new Color(0,0,0));
		jbtn_exit.setBackground(new Color(105,105,105));
		jbtn_exit.setForeground(new Color(0,0,0));
		/*패널2에 남쪽*/
		jp_secand_south.setLayout(new GridLayout(3,2,2,2));
		jp_secand_south.add(jbtn_one);
		jp_secand_south.add(jbtn_change);
		jp_secand_south.add(jbtn_ticon);
		jp_secand_south.add(jbtn_color);
		jp_secand_south.add(jbtn_logout);
		jp_secand_south.add(jbtn_exit);
		//패널 위치
		this.setTitle(nickName+"클라이언트");
		this.setSize(800, 550);
		this.setLocation(550,280);
		this.setVisible(true);
	}
	public void init() {
		try {
			/*소켓 인스턴스화 하기*/
			socket = new Socket("192.168.0.38",5000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			/*서버에게 내가 입장한 사실을 알림.*/
			oos.writeObject(Protocol.LOGIN+"#"+nickName);
			/*서버에서 말을 한 말을 듣기 위해 준비*/
			TomatoClientThread tct = new TomatoClientThread(this);
			tct.start();
		} catch (Exception e) {
			System.out.println("접속"+e.getMessage());
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		if(obj  == jbtn_one) {
			int row = jtb.getSelectedRow();
			if(row == -1) {//상대를 선택하지 않았을 때
				JOptionPane.showMessageDialog
				(this, "대화상대를 선택해주세요.", "info", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else {//상대를 선택했을 때
				String name = (String)dtm.getValueAt(row, 0);//타입이 달라 캐스팅 연산자를 앞에다 붙여줘야한다.
				//내가 나안테 귓속말하기는 차단시켜 주세요. - 요구사항
				//if문에서 중단시킬때는 return 예약어를 사용
				//for문에서 중단시킬때는 break;
				//while문에서 전체 블럭을 탈출 할때는 라벨을 사용
				if(nickName.equals(name)) {//내가 나를 선택했을 때
					JOptionPane.showMessageDialog
					(this, "다른상대를 선택해주세요.", "info", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				//이제 다른 사람을 선택했을때 그 다음엔 뭘 하지?
				String msg1 = JOptionPane.showInputDialog("메세지를 입력하세요.");
				try {
					oos.writeObject(Protocol.WHISPER+"#"+nickName+"#"+name+"#"+msg1);//상대가 알수 있도록 name를 붙였다.
				} catch (Exception e2) {
					//문제가 터졌을때 힌트를 알기 위해
					e2.printStackTrace();
				}/////////////////////////end of try-catch
			}/////////////////////////////end of else
			//선택한 상대를 초기화 하기
			jtb.clearSelection();
		}/////////////////////////////////end of 1:1대화
		else if(obj  == jbtn_change) {
			//변경할 대화명 입력받기
			String afterName = JOptionPane.showInputDialog("변경할 이름을 입력하세요.");
//			int row = jtb.getSelectedRow();
//			String name = (String)dtm.getValueAt(row, 0);
			//대화명이 널이거나 문자열의 길이가 얼마인지 체크하기 - 유효성 체크하기
			if(afterName == null || afterName.trim().length() < 1) {
				JOptionPane.showMessageDialog
				(this, "변경할 대화명을 입력하세요.", "info", JOptionPane.INFORMATION_MESSAGE);
				return;//actionPerformed 탈출
			}
			//대화명이 변경된 사실을 광고하기
//			String msg1 = JOptionPane.showInputDialog("대화명이 변경되었습니다.");
			try {
				oos.writeObject(Protocol.CHANGE
								+"#"+nickName//dtm에 들어가는 내용이므로 주석처리하면 테이블의 내용이 바뀌지 않는다.
								+"#"+afterName//dtm에 들어가는 내용이므로 주석처리하면 테이블의 내용이 바뀌지 않는다.
								+"#"+nickName+"님의 대화명이 "+afterName+"으로 변경되었습니다.");//상대가 알수 있도록 name를 붙였다.
			} catch (Exception e2) {
				//문제가 터졌을때 힌트를 알기 위해
				e2.printStackTrace();
			}/////////////////////////end of try-catch
		}///////////////////////////////end of 대화명 변경
		else if(obj == jbtn_exit) {
			try {
				oos.writeObject(Protocol.EXIT+"#"+nickName+"님이 퇴장하였습니다.");
				System.exit(0);
			} catch(Exception e2) {
				System.out.println(e2.toString());
			}///////////////////////////end of try-catch 
		}///////////////////////////////end of 종료
		/*1.actionperforemd(BC)--> 2.run() : BCT --> 3.run() BCT */
		else if(obj == jtf_msg || obj == jbtn_in) {
			try {
				oos.writeObject(Protocol.MULTI+"#"+nickName+"#"+msg);
//				tct.sleep(500);
				jtf_msg.setText("");
			} catch (Exception e2) {
				System.out.println(e2.toString());
			}///////end of try catch 
		}///////////end of if
		}///////////////////////////키보드의 엔터를 쓸수 있게하는 메소드
	//메인 메소드
	public static void main(String[] args) {
		TomatoClient tc = new TomatoClient();
		/*실행 순서를 잘 생각해야 한다. 순서를 반대로 실행한다면 사용자가 이름을 입력하기도 전에 입장을 하여 null값이 나온다.*/
//		tc.initDisplay();
//		tc.init(); 
	}
}
