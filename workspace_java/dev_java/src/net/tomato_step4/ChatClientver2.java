package net.tomato_step4;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ChatClientver2 extends JFrame {
	/*기본창*/
	JTabbedPane jtp				= new JTabbedPane();
	MessageRoom	mr				= new MessageRoom(this);
	WaitRoom	wr				= new WaitRoom(this);
	String 		nickName		= null;
	JPanel		jp_first	 	= new JPanel();
	JPanel		jp_secand	 	= new JPanel();
	JPanel		jp_secand_south	= new JPanel();
	JButton		jbtn_produce	= new JButton("대화방생성");
	JButton		jbtn_in	  		= new JButton("대화방입장"); 	
	JButton		jbtn_out	 	= new JButton("대화방나가기"); 
	JButton		jbtn_exit	 	= new JButton("종료");
	Loginver2 	lg				= null;
	Socket				socket	= null;
	ObjectOutputStream	oos		= null;
//	ObjectOutputStream	oos		= new ObjectOutputStream(socket.getOutputStream());
//여기서 new를 하면 위의 socket이 null이기 때문에 nullpoint를 만난다.
	ObjectInputStream	ois		= null;

	//스탭의 각 단계마다 차이를 잘 생각해보자.

	//생성자
	public ChatClientver2() {}
	
	public ChatClientver2(Loginver2 lg) {
		System.out.println("11");
		this.lg = lg;
		this.nickName = lg.nickName;//전역변수  초기화 - 로그인 성공 후에 확인한 이름 유지
		try {
			initDisplay();//화면 처리부
			connect_process();//소켓 연결(인스턴스화 new Socket("IP",port)) - 환경설정(oos , ois)
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	//1단계 소스에서는 TalkClient의 init메소드의 내용과 동일하다.
	//접속이 성공하면 처리
	public void connect_process() {
		//님의 대화창
		this.setTitle(nickName + "님의 대화창");
		//oos, ois 생성
		try {//문제가 일어날 수 있는 코드들은 try-catch 안에 둔다.
			socket 	= new Socket("192.168.0.38",5000);
			oos		= new ObjectOutputStream(socket.getOutputStream());
			ois		= new ObjectInputStream(socket.getInputStream());
			//방정보 초기화
			Room room = new Room();
			room.setTitle("스마트 웹모바일 엔지니어과정54기");
			room.setCurrent(10);
			room.setState("대기");
			oos.writeObject(Protocol.WAIT
							+Protocol.seperator+nickName
							+Protocol.seperator+room.getState()
							);
			//ChatClientThread처리 - 스레드 실행
			ChatClientThreadver2 ccv = new ChatClientThreadver2(this);
			ccv.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//화면 처리
	public void initDisplay() {
		//JFrame의 디폴트 레이아웃 뭉개기 - BorderLayout - null
		this.getContentPane().setLayout(null);//레이아웃을 뭉갠다.
		jtp.addTab("대기실", wr);//0 배열과 비슷하게 0번부터 시작한다. 예외로 1번부터 시작하는 경우도 있다.
		this.getContentPane().setBackground(new Color(0,255,255));
		jtp.addTab("대화방", mr);//1
		jtp.setFont(new Font("휴먼매칙체",Font.BOLD,16));
		jtp.setBounds(5, 4, 630, 530);
		this.getContentPane().add(jtp,null);
		this.setSize(660, 585);
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		ChatClientver2 ccv = new ChatClientver2();
//		ccv.initDisplay();
//		
//	}
}
