package sokettest;

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

public class TestServer extends JFrame implements Runnable, ActionListener {
	//선언부
	/*사용자가 접속할 수 있도록 서버를 먼저 가동시킨다.*/
	ServerSocket 	server  = null;
	/*서버에 접속해온 사용자 소켓 정보를 담을 소켓을 선언한다.*/
	JPanel		  jp_north	= new JPanel();
	JPanel		  jp_north2	= new JPanel();
	JLabel		  jlb_port	= new JLabel("포트번호");
	JTextField	  jtf_port	= new JTextField("5000");//값을 입력 안하면 텍스트필드가 조그마하게 보인다.
	JButton		 jbtn_start = new JButton("서버오픈");
	JButton		 jbtn_dowun = new JButton("서버종료");
	Socket 			client  = null;
	JTextArea 		jta_log = new JTextArea(10,30);
	JScrollPane 	jsp 	= new JScrollPane(jta_log
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	TestServerThread bst 	= null;
	List<TestServerThread> globalList = null;/*유저의 정보를 담을 주머니 -globalList-*/
	// ↑ @주소번지는 갖고 있지만 실체는 없는 상태
	Font f = new Font("휴먼매직체",Font.BOLD,16);
	int g_port = 0;
	//생성자
	public TestServer() {}
	//화면
	public void initDisplay() {
		jtf_port.setHorizontalAlignment(JTextField.RIGHT);//텍스트 필드의 글을 오른쪽으로 정렬해줌
		jbtn_start.addActionListener(this);
		jbtn_dowun.addActionListener(this);
		jp_north.setLayout(new GridLayout());
		jp_north.setLayout(new BorderLayout());
		jta_log.setBackground(Color.GRAY);
		jta_log.setFont(f);
		jp_north.add("West",jlb_port);
		jp_north.add("Center",jtf_port);
		jp_north2.add(jbtn_start);
		jp_north2.add(jbtn_dowun);
		this.add("North",jp_north);
		jp_north.add("East",jp_north2);
		this.add("Center",jsp);
		this.setTitle("서버 로그창-step3");
		this.setSize(700, 400);
		this.setLocation(500,100);
		this.setVisible(true);
	}
	/*서버소켓과 클라이언트측 소켓을 연결*/
	@Override
	public void run() {
		globalList = new Vector<>();//여기서 실제 메모리가 할당이 되는 순간 -현재는 0인 상태 - 메모리는 할당 되었으나 아무도 없는 상태. 
		boolean isStop = false;
		try {
			/*서버소켓 객체 생성하기*/
			server = new ServerSocket(g_port);
//			System.out.println("Server Ready ....\n");
			jta_log.append("Server Ready ....\n");
			while(!isStop) {
			/*서버에 접속해온 클라이언트 소켓에 대한 정보 받아내기*/
			//43번에서 대기상태에 빠짐으로 run메소드를 먼저 호출할 경우 화면을 볼 기회를 영원히 못 가질수도 있다.	
				client =server.accept();
				jta_log.append("접속한 사람===>"+client);
				System.out.println("접속한 유저"+client);
				System.out.println("접속한 유저"+client.getInetAddress());
				/* run메소드 호출 하기전에 사용자가 접속했다는 메세지를 먼저 인식해야한다.*/
				bst = new TestServerThread(this);//44번이 여길 지나가는 순간 값이 결정된다.
				bst.start(); /*왜 들어가 있을까?*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//메인메소드
	public static void main(String[] args) {
		TestServer ts = new TestServer();//싱글톤
//		Thread th = new Thread(ts);
		//dead lock상태에 빠지지 않기 위해서는 run메소드 호출전에 화면을 먼저 호출해야 한다.
		ts.initDisplay();//스레드가 2개라서 스레드가 따로따로 일해서 화면호출 위치는 상관이 없다.
		
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
//					TomatoServer ts = new TomatoServer();//싱글톤 - 다시 인스턴스화를 하면 안된다.
					Thread th = new Thread(this);
					th.start();
				} catch (NumberFormatException e2) {
					System.out.println("서버오픈 실패"+e2.toString());
				}
			}////////////////end of try-catch
		}////////////////////end of 서버오픈
	}////////////////////////end of actionPerformed
}
