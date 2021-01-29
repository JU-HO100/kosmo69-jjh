package book.ch8;

import java.util.List;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TimeServer2 extends JFrame implements Runnable {
	ServerSocket server = null;
	public Socket socket 	= null;
	List<TimeServerThread> globalList = null;
	JTextArea jta 	= new JTextArea();
	JScrollPane jsp = new JScrollPane(jta,
									JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
									JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public TimeServer2() {
	}
	
	@Override
	public void run() {//call back 메소드 start() -> run()
		globalList = new ArrayList<>();
		boolean isStop = false;
		try {
			//3000번이라는 방을 개방해 놓는다
			server = new ServerSocket(3000);
			jta.append("Server Readdy ...........\n");
			while(!isStop) {
				//방에 들어온 사람의 정보를 받는다.
				socket = server.accept();
				//방에 들어온 사람의 정보를 표현해준다.
				jta.append("Client INFO"+socket.getInetAddress());
				TimeServerThread tst = new TimeServerThread(this);
			}///////////사용자를 기다리는 구간
			
		}catch (Exception e) {
		}/////////end of try.catch
	}/////////////end of run
	//현재 시간을 제공하는 메소드 선언 - 삼항연산자
	public String pushTime() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (hour < 10 ? "0"+hour : ""+hour)
				+":"+(min < 10 ? "0"+min : ""+min)
				+":"+(sec < 10 ? "0"+sec : ""+sec);
	}

	public void initDisplay() {
		
		jta.setEditable(false);
		this.add("Center",jsp);	
		this.setTitle("TimeTest");
		this.setSize(400, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		TimeServer2 ts2 = new TimeServer2();
		ts2.initDisplay();
		Thread th = new Thread(ts2);
		System.out.println("현재 스레드 이름:"+Thread.currentThread().getName());
		th.start();//run이 호출된다.
		
	}
}
