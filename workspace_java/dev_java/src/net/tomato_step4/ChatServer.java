package net.tomato_step4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements Runnable, ActionListener {
	//선언부
	/*서버에 접속해온 사용자 소켓 정보를 담을 소켓을 선언한다.*/
	JPanel		  jp_north	= new JPanel();
	JPanel		  jp_north2	= new JPanel();
	JLabel		  jlb_port	= new JLabel("포트번호");
	JTextField	  jtf_port	= new JTextField("5000");//값을 입력 안하면 텍스트필드가 조그마하게 보인다.
	JButton		 jbtn_start = new JButton("서버오픈");
	JButton		 jbtn_dowun = new JButton("서버종료");
	Socket 			client  = null;
	List<Room>	roomList 	= null;
	/*사용자가 접속할 수 있도록 서버를 먼저 가동시킨다.*/
	ServerSocket 	server  = null;
//	ChatServerThread cst 	= null;
	List<ChatServerThread> globalList = null;/*유저의 정보를 담을 주머니 -globalList-*/
	// ↑ @주소번지는 갖고 있지만 실체는 없는 상태
	JTextArea 		jta_log = new JTextArea(10,30);
	JScrollPane 	jsp 	= new JScrollPane(jta_log
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	Font f = new Font("휴먼매직체",Font.BOLD,16);
	int g_port = 0;
	//화면
	public void initDisplay() {
		jbtn_start.addActionListener(this);
		jbtn_dowun.addActionListener(this);
		jtf_port.setHorizontalAlignment(JTextField.RIGHT);//텍스트 필드의 글을 오른쪽으로 정렬해줌
		jta_log.setBackground(Color.GRAY);
		jp_north.setLayout(new GridLayout());
		jp_north.setLayout(new BorderLayout());
		jta_log.setFont(f);
		jp_north.add("West",jlb_port);
		jp_north.add("Center",jtf_port);
		jp_north2.add(jbtn_start);
		jp_north2.add(jbtn_dowun);
		this.add("North",jp_north);
		jp_north.add("East",jp_north2);
		this.add("Center",jsp);
		this.setTitle("서버 로그창-step3");
		this.setSize(500, 400);
		this.setLocation(500,100);
		this.setVisible(true);
	}
	/*서버소켓과 클라이언트측 소켓을 연결*/
	@Override
	public void run() {
		//여러사람이 여러개의 톡방을 개설할 수 있음으로 이 정보들을 유지하기 위해서는 Vector가 필요함. 방을 만들때 마다 추가
		roomList = new Vector<Room>();
		globalList = new Vector<ChatServerThread>();//여기서 실제 메모리가 할당이 되는 순간 -현재는 0인 상태 - 메모리는 할당 되었으나 아무도 없는 상태. 
		boolean isStop = false;
		//예외발생 가능성이 있는 코드에 대해서는 반드시(무조건) 예외처리 할 것.
		//ex) java.io, java.net, Thread, 오라클 서버와 연계, 톰캣(web 서버), 클라우드 서비스제공
		try {
			/*서버소켓 객체 생성하기*/
			server = new ServerSocket(g_port);//서버측의 포트 번호 도 변수로 처리해본다.
//			System.out.println("Server Ready ....\n");
			jta_log.append("Server Ready ....\n");
			while(!isStop) {//이 구간이 무한루프 구간임 - 대기상태에 빠지게 됨.
			/*서버에 접속해온 클라이언트 소켓에 대한 정보 받아내기*/
			//43번에서 대기상태에 빠짐으로 run메소드를 먼저 호출할 경우 화면을 볼 기회를 영원히 못 가질수도 있다.	
				client =server.accept();//사용자가 접속해 오지 않으면 절대로 다음으로 진행이 안된다.
				jta_log.append("접속한 사람===>"+client+"\n");
//				System.out.println("접속한 유저"+client);
//				System.out.println("접속한 유저"+client.getInetAddress());
				/* run메소드 호출 하기전에 사용자가 접속했다는 메세지를 먼저 인식해야한다.*/
				//접속이 성공하면 스레드 생성하기 - 왜냐하면 서버측에서는 사용자 개인마다 별개로 동작 시킴.
				//무조건 스레드를 할당해야 한다. - 그래야 조작이 가능하다. Vector<ChatServerThread> - 스레드는 사용자 스레드라고 생각하게 됨
				ChatServerThread cst = new ChatServerThread(this);//44번이 여길 지나가는 순간 값이 결정된다.
				cst.start();//이 코드가 주석이면 어떤 일이 일어날까? 
				//이 코드가 주석이면 로그인은 되지만 그 뒤에 run메소드가 실행이 안된다.
				//왜냐하면 로그인에 대한 처리는 ChatServerThread의 생성자안에서 이루어 지기 때문이다.
			}////////////////////////end of while
		} catch (Exception e) {
			e.printStackTrace();
		}///////////////////////////end of try-catch
	}
	
	//메인메소드
	public static void main(String[] args) {
		ChatServer cs = new ChatServer();//싱글톤
//		Thread th = new Thread(ts);
		//dead lock상태에 빠지지 않기 위해서는 run메소드 호출전에 화면을 먼저 호출해야 한다.
		cs.initDisplay();//스레드가 2개라서 스레드가 따로따로 일해서 화면호출 위치는 상관이 없다.
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String port = jtf_port.getText();
		if(obj == jbtn_dowun) {
			
			System.exit(0);
		}//서버 종료
		else if(obj == jbtn_start) {
			if("".equals(jtf_port.getText())) {//
				JOptionPane.showMessageDialog(this,"포트번호를 입력해주세요","INFO", JOptionPane.INFORMATION_MESSAGE);
			return;
			}
			else {
				try {
					g_port = Integer.parseInt(port);
//					TomatoServer cs = new TomatoServer();//싱글톤 - 다시 인스턴스화를 하면 안된다.
					Thread th = new Thread(this);
					th.start();
				} catch (NumberFormatException e2) {
					System.out.println("서버오픈 실패"+e2.toString());
				}
			}////////////////end of try-catch
		}////////////////////end of 서버오픈
	}////////////////////////end of actionPerformed
}
