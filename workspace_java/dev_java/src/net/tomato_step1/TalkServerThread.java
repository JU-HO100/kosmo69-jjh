package net.tomato_step1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
	TalkServer ts = null;
	/*TalkServer에 접속해온 클라이언트 소켓 정보를 담기 위해 선언했다.*/
	Socket client = null;
	ObjectOutputStream oos = null;/*쓰기 처리시 Object단위로 쓸 수 있는 기능을 지원함. oos.writeObject()*/
	ObjectInputStream ois = null;/*읽기 처리시 Object단위로 읽을 수 있는 기능을 지원함. ois.readObject()*/
	String nickName = null;/*접속해온 클라이언트마다 대화명이 달라야한다. 그래서 별도의 초기명이 있어야한다.*/
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		/*TalkServer에서 생성된 소켓이 필요함.*/
		this.client = ts.client;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			/*사용자가 보내온 정보를 읽기*/
			String msg = (String)ois.readObject();
			/*서버측 로그창에 출력해 두자(어디까지 왔니?,어디서 끊어졌니?)*/
			ts.jta_log.append(msg+"\n");/*줄바꾸기위해 "\n"을 붙였다.*/
			/*넘어오는 정보는 100#닉네임*/
			System.out.println("222"+msg);
			StringTokenizer st = new StringTokenizer(msg,"#");
			/*첫번째는 skip하고 두번째를 담기*/
			st.nextToken();
			nickName = st.nextToken();/*닉네임 이 담긴다.*/
			/*내가 입장하기 전에 입장한 사람들의 메세지를 처리
			 * 내가 가장 처음에 입장한 경우에는 아래 코드가 실행 안됨.*/
			System.out.println("333");
			for(TalkServerThread tst:ts.globalList) {
				this.send(100+"#"+tst.nickName);/*여기서 닉네임을 쏴줌 - 다른사람이 올때까지 아무값도 없다.*/
			}
			ts.globalList.add(this);/*나 자신의 스레드를 추가*/
			/*내가 입장한 후의 사람들 메세지 처리*/
			this.broadCasting(msg); /*여기서 List에 담긴다.*/
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	/*현재 입장해 있는 친구들 모두에게 메세지 전송하기 구현*/
	public void broadCasting(String msg) {/*클라이언트에게 들은것을 쓰레드에게 말한다?*/
		/*서버에 접속해온 클라이언트에 대한 정보를 입장이 일어날때마다 추가하는 코드가 필요함. -어디에? 어떻게? globalList.add(this)*/
		for(TalkServerThread tst : ts.globalList) {/*접속자의 숫자만큼 인스턴스화를 한다.*/
			tst.send(msg);/*나 자신에게 쏴주는 값 - 서버에서*/
		}
	}
	/* 실제로 메시지 쓰기 호출하기
	    *************************************************************************
	    * 파라미터로 받은 메시지를 읽어서 소켓에 쓰기 처리함.
	    * 한사람에게만 전송할 때는 send메소드를 활용하고 여러사람에게 전송할 땐 brodCasting으로 처리함.
	    * @param msg
	    ***************************************************************************/
	   public void send(String msg) {
	      try {
	         oos.writeObject(msg);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   @Override
		public void run() {//콜백 메소드
			System.out.println("T.S.T run 호출 성공");
		}
}
