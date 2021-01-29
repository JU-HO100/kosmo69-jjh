package net.tomato_step1;

import java.awt.BorderLayout;
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

public class TalkClient extends JFrame implements ActionListener  {
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
	JButton		jbtn_exit	 	= new JButton("종료");
	String cols[] = {"닉네임"};
	String date[][] = new String [0][1];
	DefaultTableModel dtm = new DefaultTableModel(date,cols);
	JTable			jtb 		= new JTable(dtm);
	JTextField		jtf_log  	= new JTextField();
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
	
	//화면처리
	public void initDisplay() {
		/*사용자로 부터 닉네임 입력 받기*/
		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		jbtn_in.addActionListener(this);
		jbtn_conv1.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_ticon.addActionListener(this);
		jbtn_exit.addActionListener(this);
		
		/*패널1에 들어갈것들*/
		this.setLayout(new GridLayout(1,2,2,2));
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jta_log);
		jta_log.setEditable(false);
		this.add("Center",jp_first);
		/*패널1에 남쪽*/
		this.add("East",jp_secand);
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center",jtf_log);
		jp_first_south.add("East",jbtn_in);
		jp_first.add("South",jp_first_south);
		/*패널2에 들어갈것들*/
		jp_secand.setLayout(new BorderLayout());
		jp_secand.add("Center",jsp_log2);
		jp_secand.add("South",jp_secand_south);
		/*패널2에 남쪽*/
		jp_secand_south.setLayout(new GridLayout(2,2,2,2));
		jp_secand_south.add(jbtn_conv1);
		jp_secand_south.add(jbtn_change);
		jp_secand_south.add(jbtn_ticon);
		jp_secand_south.add(jbtn_exit);
		//패널 위치
		this.setTitle("클라이언트");
		this.setSize(800, 550);
		this.setVisible(true);
	}
	public void init() {
		try {
			/*소켓 인스턴스화 하기*/
			socket = new Socket("192.168.0.38",4000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			/*서버에게 내가 입장한 사실을 알림.*/
			oos.writeObject(100+"#"+nickName);
		} catch (Exception e) {
			System.out.println("접속"+e.getMessage());
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_in) {
			jta_log.append(jtf_log.getText());
			jtf_log.setText("");
			System.out.println("입력");
		}
		else if(obj == jbtn_conv1) {
			System.out.println("대화창");
			this.setVisible(false);
		}
		else if(obj == jbtn_change) {
			System.out.println("대화명 변경");
		}
		else if(obj == jbtn_ticon) {
			System.out.println("이모티콘창");
		}
		else if(obj == jbtn_exit) {
			System.out.println("빠이~");
			System.exit(0);
		}
		}
	//메인 메소드
	public static void main(String[] args) {
		TalkClient tc = new TalkClient();
		/*실행 순서를 잘 생각해야 한다. 순서를 반대로 실행한다면 사용자가 이름을 입력하기도 전에 입장을 하여 null값이 나온다.*/
		tc.initDisplay();
		tc.init(); 
	}
}
