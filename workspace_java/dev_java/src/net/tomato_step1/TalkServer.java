package net.tomato_step1;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TalkServer extends JFrame implements Runnable {
	//선언부
	/*사용자가 접속할 수 있도록 서버를 먼저 가동시킨다.*/
	ServerSocket 	server  = null;
	/*서버에 접속해온 사용자 소켓 정보를 담을 소켓을 선언한다.*/
	Socket 			client  = null;
	JTextArea 		jta_log = new JTextArea(10,30);
	JScrollPane 	jsp 	= new JScrollPane(jta_log
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	TalkServerThread tst 	= null;
	List<TalkServerThread> globalList = null;/*유저의 정보를 담을 주머니 -globalList-*/
	//생성자
	public TalkServer() {}
	//화면
	public void log() {
		this.add("Center",jsp);
		this.setTitle("서버");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	/*서버소켓과 클라이언트측 소켓을 연결*/
	@Override
	public void run() {
		globalList = new Vector<>();
		boolean isStop = false;
		try {
			/*서버소켓 객체 생성하기*/
			server = new ServerSocket(4000);
			System.out.println("Server Ready ....\n");
			while(!isStop) {
			/*서버에 접속해온 클라이언트 소켓에 대한 정보 받아내기*/
			//43번에서 대기상태에 빠짐으로 run메소드를 먼저 호출할 경우 화면을 볼 기회를 영원히 못 가질수도 있다.	
				client =server.accept();
				jta_log.append("접속한 사람===>"+client);
				System.out.println("접속한 유저"+client);
				System.out.println("접속한 유저"+client.getInetAddress());
				/* run메소드 호출 하기전에 사용자가 접속했다는 메세지를 먼저 인식해야한다.*/
				tst = new TalkServerThread(this);
//				tst.start(); /*왜 들어가 있을까?*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//메인메소드
	public static void main(String[] args) {
		TalkServer ts = new TalkServer();
		Thread th = new Thread(ts);
		//dead lock상태에 빠지지 않기 위해서는 run메소드 호출전에 화면을 먼저 호출해야 한다.
		ts.log();//스레드가 2개라서 스레드가 따로따로 일해서 화면호출 위치는 상관이 없다.
		th.start();
	}
}
