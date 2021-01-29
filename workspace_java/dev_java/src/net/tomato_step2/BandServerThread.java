package net.tomato_step2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;

public class BandServerThread extends Thread {
	BandServer bs = null;
	/*TalkServer에 접속해온 클라이언트 소켓 정보를 담기 위해 선언했다.*/
	Socket client = null;
	ObjectOutputStream oos = null;/*쓰기 처리시 Object단위로 쓸 수 있는 기능을 지원함. oos.writeObject()*/
	ObjectInputStream ois = null;/*읽기 처리시 Object단위로 읽을 수 있는 기능을 지원함. ois.readObject()*/
	String nickName = null;/*접속해온 클라이언트마다 대화명이 달라야한다. 그래서 별도의 초기명이 있어야한다.*/
	public BandServerThread(BandServer bs) {//객체 주입 - 원본 - 싱글톤
		this.bs = bs;
		/*TalkServer에서 생성된 소켓이 필요함.*/
		this.client = bs.client;//소켓을 동기화
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());	
			/*사용자가 보내온 정보를 읽기*/
			String msg = (String)ois.readObject();//듣기 100#test
			/*서버측 로그창에 출력해 두자(어디까지 왔니?,어디서 끊어졌니?)*/
			bs.jta_log.append(msg+"\n");/*줄바꾸기위해 "\n"을 붙였다.*/
			//로그 메세지가 출력될 때 출력되는 문자열의 길이를 계산해서 스크롤바 위치를 자동 갱신처리 해준다.
			bs.jta_log.setCaretPosition(bs.jta_log.getDocument().getLength());
			/*넘어오는 정보는 100#닉네임*/
			StringTokenizer st = new StringTokenizer(msg,"#");
			/*첫번째는 skip하고 두번째를 담기*/
			st.nextToken();//스킵 - 100
			nickName = st.nextToken();/*닉네임 이 담긴다.*/
			/*내가 입장하기 전에 입장한 사람들의 메세지를 처리
			 * 내가 가장 처음에 입장한 경우에는 아래 코드가 실행 안됨.*/
			for(BandServerThread bst:bs.globalList) {
				this.send(100+"#"+bst.nickName);/*여기서 닉네임을 쏴줌 - 다른사람이 올때까지 값이 없다.*/
			}//<this=현제 들어온 애>  <bst=이미 들어와있는 애>
			bs.globalList.add(this);/*나 자신의 스레드를 추가*/
			/*내가 입장한 후의 사람들 메세지 처리*/
			this.broadCasting(msg); /*여기서 List에 담긴다.*/
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	/*현재 입장해 있는 친구들 모두에게 메세지 전송하기 구현*/
	public void broadCasting(String msg) {/*클라이언트에게 들은것을 쓰레드에게 말한다?*/
		/*서버에 접속해온 클라이언트에 대한 정보를 입장이 일어날때마다 추가하는 코드가 필요함. -어디에? 어떻게? globalList.add(this)*/
		for(BandServerThread bst : bs.globalList) {/*접속자의 숫자만큼 인스턴스화를 한다.*/
			bst.send(msg);/*나 자신에게 쏴주는 값 - 서버에서*/
		}
	}
	 // 실제로 메시지 쓰기 호출하기
	   /**************************************************************************
	    * 파라미터로 받은 메시지를 읽어서 소켓에 쓰기 처리함.
	    * 한사람에게만 전송할 때는 send메소드를 활용하고 여러사람에게 전송할 땐 brodCasting으로 처리함.
	    * @param msg
	    ***************************************************************************/
	   public void send(String msg) {
	      try {
	         oos.writeObject(msg);//들은것을 말하는 것이다.
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   @Override
		public void run() {//콜백 메소드
//			System.out.println("T.S.T run 호출 성공");
			boolean isStop = false;//boolean을 쓴 이유는 언제든지 멈출 수 있게 하려고
			String msg = null;
			try {//run_start ==> 라벨 = 나가는 기능
				run_start:
				while(!isStop) {
					msg = (String)ois.readObject();
					bs.jta_log.append(msg+"\n");
					StringTokenizer st = null;
					int protocol = 0;
					if(msg != null) {
						st = new StringTokenizer(msg, "#");
						protocol = Integer.parseInt(st.nextToken());
					}////////////end of if
					switch(protocol) {
					case 200:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						broadCasting(200+"#"+nickName+"#"+message);
					}break;
					case 500:{
						String nickName = st.nextToken();
						bs.globalList.remove(this);
						broadCasting(500+"#"+nickName);
					}break run_start;
//						System.out.print("protocol"+protocol);
					}
				}////////////////end of while
			} catch (Exception e) {
				System.out.println("Excepton ====>"+e.toString());
			}//////////////end of try catch
			
	   }/////////////////////end of run	
}
