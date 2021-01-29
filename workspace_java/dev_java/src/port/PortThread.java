package port;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PortThread extends Thread {
	PortServer ts = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	Socket client = null;
	String timeStr = null;
	
	public PortThread () {
	}
	public PortThread(PortServer ts) {//객체 주입
		this.ts = ts;
		this.client = ts.socket;
		timeStr = ts.pushTime();
		try {
			oos = new ObjectOutputStream(client.getOutputStream());//말하기 - 서버에 말하기 위해 마이크 설치한 것이다. 
			ois = new ObjectInputStream(client.getInputStream());//듣기 - 서버에서 한말을 듣기 위해 스피커 설치한 것이다.
			for (PortThread tst:ts.globalList) {//개선된 for문 - 전체 조회 할때 쓴다. -가진 것 다 보여줘
				
			}
			ts.globalList.add(this);
			this.broadCasting(timeStr);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	//현재 입장해 있는 모든 친구들에게 모두 메시지를 전송하고 싶어요.
	public void broadCasting(String msg) {
		for(PortThread tst:ts.globalList) {
			try {
				oos.writeObject(msg);
			} catch (Exception e) {//현재 서버에 입장한 클라이언트 스레드 추가하기
				e.printStackTrace();//stack영역에 쌓여 있는 에러 메시지 모두 출력해준다.
			}
			}
		}
	//run메소드에는 뭘 써야 하지?
	@Override
	public void run() {
		System.out.println("TimeServerThread run 호출 성공");
	
	}

}
