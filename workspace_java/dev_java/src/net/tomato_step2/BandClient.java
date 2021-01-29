package net.tomato_step2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

public class BandClient extends JFrame implements ActionListener  {
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
	JButton		jbtn_conv1	 	= new JButton("1:1대화");
	JButton		jbtn_change  	= new JButton("대화명 변경"); 	
	JButton		jbtn_ticon	 	= new JButton("이모티콘"); 
	JButton		jbtn_color	 	= new JButton("글자색"); 
	JButton		jbtn_logout	 	= new JButton("로그아웃"); 
	JButton		jbtn_exit	 	= new JButton("종료");
	String cols[] = {"닉네임"};
	String date[][] = new String [0][1];
	DefaultTableModel dtm 		= new DefaultTableModel(date,cols);
	JTable			jtb 		= new JTable(dtm);
	JTextField		jtf_msg  	= new JTextField();
	JTextArea 		jta_log  	= new JTextArea(10,30);
	JScrollPane 	jsp_log  	= new JScrollPane(jta_log
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JScrollPane 	jsp_log2  	= new JScrollPane(jtb
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	/*대화창*/
	JPanel 		jp_conv1 	= new JPanel();
	JTextField	jtf_con 	= new JTextField();
	JTextArea 	jta_con 	= new JTextArea(10,30);
	JButton		jbtn_con	= new JButton("전송");
	JButton		jbtn_ticon1 = new JButton("ㆅ");
	/*닉네임 입력 받아서 담기*/
	String 		nickName 		= null;
	/*디폴트 생성자는 JVM이 제공해줄 수도 있지만 파라미터가 있는 생성자는 제공이 안된다.*/
	public BandClient() {}
	public BandClient(String nickName) {//객체를 조립하는대 중요하다. -> 파라미터를 찾는다 -> 초기화(어디서?) -> 어떻게 유지하는가? -> 왜 유지해야 되는가?
		//생성자의 제 1 역할 - 전변의 초기화를 담당한다.
		this.nickName = nickName;
	}
	
	//화면처리
	public void initDisplay() {
		/*사용자로 부터 닉네임 입력 받기*/
//		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbtn_in.addActionListener(this);
		jbtn_conv1.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_ticon.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jtf_msg.addActionListener(this);
		/*패널1에 들어갈것들*/
		this.setLayout(new GridLayout(1,2,2,2));
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jta_log);
		jta_log.setEditable(false);
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
		/*패널2에 남쪽*/
		jp_secand_south.setLayout(new GridLayout(3,2,2,2));
		jp_secand_south.add(jbtn_conv1);
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
			socket = new Socket("192.168.0.38",8007);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			/*서버에게 내가 입장한 사실을 알림.*/
			oos.writeObject(100+"#"+nickName);
			/*서버에서 말을 한 말을 듣기 위해 준비*/
			BandClientThread bct = new BandClientThread(this);
			bct.start();
		} catch (Exception e) {
			System.out.println("접속"+e.getMessage());
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		if(obj == jbtn_exit) {
			try {
				oos.writeObject(500+"#"+nickName);
				System.exit(0);
			} catch(Exception e2) {
				System.out.println(e2.toString());
			} 
		}
		/*1.actionperforemd(BC)--> 2.run() : BCT --> 3.run() BCT */
		else if(obj == jtf_msg || obj == jbtn_in) {
			try {
				oos.writeObject(200+"#"+nickName+"#"+msg);
				jtf_msg.setText("");
			} catch (Exception e2) {
				System.out.println(e2.toString());
			}///////end of try catch 
		}///////////end of if
		}
	//메인 메소드
	public static void main(String[] args) {
		BandClient tc = new BandClient();
		/*실행 순서를 잘 생각해야 한다. 순서를 반대로 실행한다면 사용자가 이름을 입력하기도 전에 입장을 하여 null값이 나온다.*/
//		tc.initDisplay();
//		tc.init(); 
	}
}
