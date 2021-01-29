package net.tomato_step4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.text.SimpleAttributeSet;

public class ChatServerThread extends Thread {
	ChatServer cs = null;
	/*ChatServer에 접속해온 클라이언트 소켓 정보를 담기 위해 선언했다.*/
	Socket client = null;
	PictureMessage pm = new PictureMessage();
	ObjectOutputStream oos = null;/*쓰기 처리시 Object단위로 쓸 수 있는 기능을 지원함. oos.writeObject()*/
	ObjectInputStream ois = null;/*읽기 처리시 Object단위로 읽을 수 있는 기능을 지원함. ois.readObject()*/
	String nickName = null;/*접속해온 클라이언트마다 대화명이 달라야한다. 그래서 별도의 초기명이 있어야한다.*/
//	ChatServerThread cst = new ChatServerThread();
//	cst = new ChatServerThread();
//	cst = new ChatServerThread();
	//현재 인원수 정보 담기
	int g_current = 0;
	//현재 방정보 담기
	String g_title = null;
	//클래스 쪼개기 - 클래스 설계 - 객체 주입법 - 생성자 이해 및 활용 능력 확장
	public ChatServerThread(ChatServer cs) {//객체 주입 - 원본 - 싱글톤 //생성자 안에서 도대체 무슨일을 하는 걸까요?
		//단톡방 생성시 사용할 벡터<스레드>에 추가하기 							 //-입장한 사실을 방송으로 내보내 주는 일	
		this.cs = cs;											 
		/*TalkServer에서 생성된 소켓이 필요함.*/
		this.client = cs.client;//소켓을 동기화
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			//사용자가 보내온 정보를 읽기
			//로그인된 내용을 듣고 있다.
			String msg = (String)ois.readObject();//듣기 100#test
			/*서버측 로그창에 출력해 두자(어디까지 왔니?,어디서 끊어졌니?)*/
			cs.jta_log.append(msg+"\n");/*줄바꾸기위해 "\n"을 붙였다.*/
			//로그 메세지가 출력될 때 출력되는 문자열의 길이를 계산해서 스크롤바 위치를 자동 갱신처리 해준다.
//			cs.jta_log.setCaretPosition(cs.jta_log.getDocument().getLength());
			/*넘어오는 정보는 100#닉네임*/
			//클라이언트측의 방송을 내보내기 위한 사전 작업이다.
			//전역변수 nickName에 로그인 한 사람의 대화명 관리하기.
			StringTokenizer st = null;
			if(msg != null) {
				st = new StringTokenizer(msg, Protocol.seperator);//이름이 바뀌어도 일괄처리 할 수 있다.
			}
			if(st.hasMoreElements()) {//
				st.nextToken();
				nickName = st.nextToken();
				g_title = st.nextToken();
//				g_current = st.nextToken(); //타입이 맞지 않는다.
			}
//			StringTokenizer st = new StringTokenizer(msg,"#");//100 자르고 다음 닉네임 읽고
			/*첫번째는 skip하고 두번째를 담기*/
//			st.nextToken();//스킵(skip) - 100 - 다음커서에 있는 값 을 꺼내주세요.
			//하나씩 썰어주세요.
//			nickName = st.nextToken();/*닉네임 이 담긴다.*/
			//클라이언트가 접속할 때 마다 닉네임이 달라진다.
			/*내가 입장하기 전에 입장한 사람들의 메세지를 처리
			 * 내가 가장 처음에 입장한 경우에는 아래 코드가 실행 안됨.*/
			//단톡방 개설시 해야할 작업1. Room.java 클래스 설계하기. **중요
	         for (ChatServerThread cst:cs.globalList) {
	             String currentName = cst.nickName;
	             String currentState = cst.g_title;
	             this.send(Protocol.WAIT
	                   +Protocol.seperator+currentName
	                   +Protocol.seperator+currentState
	                   );//this.nickName
	          System.out.println("방목록 관리 : "+cs.roomList.size());
	          }
	          //ROOM_LIST 처리 - 이 코드는 3단계 까지는 필요없던 부분이다.
	          //현재 방정보가 없다면 필요없는 코드(있으나 마나한 코드)
	          for( int i = 0; i<cs.roomList.size(); i++ ) {
	             Room room = cs.roomList.get(i);
	             String title = room.title;
	             g_title = title;
	             int current = 0;
	             if( room.userList != null && room.userList.size() != 0 ) {
	                current = room.userList.size();
	             }
	             g_current = current;
	             this.send(Protocol.ROOM_LIST
	                   +Protocol.seperator+g_title
	                   +Protocol.seperator+g_current
	                   );
	          }
//			for(ChatServerThread cst:cs.globalList) {
//				
//				//this.send(Protocol.LOGIN+"#"+cst.nickName);/*여기서 닉네임을 쏴줌 - 다른사람이 올때까지 값이 없다.*/
//			}//<this=현제 들어온 사람><cst=이미 들어와있는 사람>
			//nickName을 전역변수로 해야되는 이유 - 클라이언트가 접속할 때 마다 초기화를 해야하며
			//접속한 클라이언트를 다른 곳에서 호출해야 하기 때문에 지변이 아닌 전변으로 썼다.
			//왜 생성자에서 추가하는 거니? ChatServerThread로
			//--왜 add한 후에 broadCasting를 하는 걸까요? add를 하기 전과 후의 차이는 뭘까요?
			//broadCasting을 add하기 전에 하면 내가 전송한 메세지는 다른 사람에게는 가지만 나안테는 메세지가 오지 않는다.
			//add에 this는 현재 입장해 있는 나 자신 그러니깐 다음에 해야 된다.
			//서버가 관여하려면 인터셉트를 할 수 있는 순간이 필요하다. - 간섭해야 한다.
			cs.globalList.add(this);/*나 자신의 스레드를 추가*/
			/*내가 입장한 후의 사람들 메세지 처리*/
			this.broadCasting(msg); /*여기서 List에 담긴다.*/
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	/*현재 입장해 있는 친구들 모두에게 메세지 전송하기 구현*/
	public void broadCasting(String msg) {/*클라이언트에게 들은것을 쓰레드에게 말한다?*/
		//브로드 캐스팅이 있을때 메세지가 있어야하고 그 메세지가 여러사람에게 가야 한다.
		//cst의 주소번지가 계속 바뀐다고 생각해야 한다.
		/*서버에 접속해온 클라이언트에 대한 정보를 입장이 일어날때마다 추가하는 코드가 필요함. -어디에? 어떻게? globalList.add(this)*/
		//클라이언트가 접속해올때 마다 ChatServerThread가 새로 인스턴스화 된다.
		//새로운 사람이 접속할 때 경유하는 클래스를 적어봅시다.
		//ChatServer.java가 먼저 실행이 되고 -> ServerSocket를 만나고-> 사용자가 접속해오면 -> socket.accept()로 이동
		//-> 사용자 정보 수집이 된다. -> 사용자 정보를 가지고 뭐하지? -> socket를 활용하여 oos, ois를 생성해야한다.
		//ois(듣기),oos(말하기) -> 말하기와 듣기를 하기 위해선 반드시 socket이 객체가 생성된 상태여야 한다.
		//socket.getOutputStream(), socket.getInputStream()
		//말하기는 어디서 해야하나요? - broadCasting
		//듣기는 어디서 해야 하나요? - run에서 해야 된다.
	   for(ChatServerThread cst:cs.globalList) {//여러 사람에게 가야 함.
		   cst.send(msg);
	      }
//		for(ChatServerThread cst : cs.globalList) {/*접속자의 숫자만큼 인스턴스화를 한다.*/
//			String currentName = cst.nickName;
//			String currentState = cst.g_title;
////			cst.send(msg);/*나 자신에게 쏴주는 값 - 서버에서*/
//			this.send(Protocol.WAIT
//					+Protocol.seperator+currentName
//					+Protocol.seperator+currentState
//					);
//		}
//		System.out.println("방목록 관리: "+cs.roomList.size());
//		//RoomList처리 - 이 코드는 3단계 까지는 필요없던 부분이다.
//		//현재 방정보가 없다면 필요없는 코드(있으나 마나 함)
//		for(int i=0;i<cs.roomList.size();i++) {
//			Room room = cs.roomList.get(i);
//			String title = room.title;
//			g_title = title;
//			int current = 0;
//			if(room.userList!=null && room.userList.size() !=0) {
//				current = room.userList.size();
//			}
//			g_current = current;
//			this.send(Protocol.ROOM_LIST
//					+Protocol.seperator+g_title
//					+Protocol.seperator+g_current
//					);
//			
//		}
	}
	 // 실제로 메시지 쓰기 호출하기 - broadCasting(말하기)과 send(듣는 것을 말하기)는 커플이다. ex) try-chat
	   /**************************************************************************
	    * 파라미터로 받은 메시지를 읽어서 소켓에 쓰기 처리함.
	    * 한사람에게만 전송할 때는 send메소드를 활용하고 여러사람에게 전송할 땐 brodCasting으로 처리함.
	    * @param msg
	    ***************************************************************************/
	   public void send(String msg) {
	      try {
	         oos.writeObject(msg);//들은것을 말하는 것이다. 언제 최초 실행되는 건가요?
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   //톡방에 있는 사람들에게만 전달 하기
	   public void roomCasting(String msg, String roomTitle) {
		   for(int i=0;i<cs.roomList.size();i++) {//title의(방) 정보를 찾고
			   Room room = cs.roomList.get(i);/*중요*/ //1 번째
			   if(roomTitle.equals(room.getTitle())) {//방정보를 비교한 후 방정보가 내가 찾는것이라면 내가 원하는 유저는 어떻게 찾는가?
				   for(int j=0;j<room.userList.size();j++) {//그 방에 있는 사람(스레드)들에게 메세지를 보내자 //
					   ChatServerThread cst = room.userList.get(j);	/*중요*/ //2번째
					   try {
						cst.send(msg);
					} catch (Exception e) {
						e.printStackTrace();//예외 메세지를 관리하는 스택영역의 메세지들을 모두 출력해줌 - 디버깅을 위해
					}
				   }
			   }
		   }
	   }///////////////////////////////end of roomCasting
	   
	   //run메소드는 언제 호출 되나요? - 클라이언트가 요청했을 때
	   //어디서 호출이 되나요? - ChatServer에 클라이언트 소켓이 생성되었을 때
	   //왜 호출 되는걸까요? - 클라이언트 누군가가 말을 했을때 
	   //어떻게 호출 되는 걸까요? - 
		public void run() {//콜백 메소드 //듣는 코드는 몇번째 라인에서 시작되나요?
//			System.out.println("T.S.T run 호출 성공");
			boolean isStop = false;//boolean을 쓴 이유는 언제든지 멈출 수 있게 하려고
			String msg = null;
			try {//run_start ==> 라벨 = 나가는 기능
				run_start:
				while(!isStop) {
					msg = (String)ois.readObject();//이자리에서 듣기 코드가 시작된다.
					cs.jta_log.append(msg+"\n");
					StringTokenizer st = null;//StringTokenizer는 왜 선언과 생성을 분리 해야 하나요?
					int protocol = 0;
					/* # = nextToken()
					 * 100#닉네임 - 입장하는 사람 - nextToken() 1번
					 * 200#누가#무슨말 - nextToken() 2번
					 * 300#현재대화명#변경대화명#바뀐내용 메세지 처리 - nextToken() 3번
					 */
					if(msg != null) {//100## 이렇게해도 망한다.
						st = new StringTokenizer(msg, Protocol.seperator);
						protocol = Integer.parseInt(st.nextToken());
					}////////////end of if
				switch(protocol) {
					case Protocol.WAIT: {
						String nickName = st.nextToken();
						String state = st.nextToken();
						this.broadCasting(Protocol.WAIT
								+Protocol.seperator+nickName
								+Protocol.seperator+state);
					}
					case Protocol.ROOM_CREATE:{
						String roomTitle = st.nextToken();//방제목
						String currentNum = st.nextToken();//현재인원수
						//Room 반영
						Room room = new Room(roomTitle, Integer.parseInt(currentNum));
						//roomList 추가하기
						cs.roomList.add(room);
						//메세지를 방송 내보내기
						this.broadCasting(Protocol.ROOM_CREATE
										+Protocol.seperator+roomTitle
										+Protocol.seperator+currentNum);
						
					}break;
					////////////////////////////////[ end of 대화방 생성 ] /////////////////////////////////////
					////////////////////////////////[ 대화방 생성 ]////////////////////////////////////////////
					case Protocol.ROOM_IN:{
						//클라이언트에서 전송된 메세지 읽어오기
						String nickName = st.nextToken();//닉네임
						String roomTitle = st.nextToken();
						for(int i=0;i<cs.roomList.size();i++) {
							Room roomIN = cs.roomList.get(i);
							if(roomTitle.equals(roomIN.title)) {
								g_title = roomTitle;
								g_current = roomIN.current+1;
								//아래코드가 없으면 인원수가 업데이트가 되지 않는다.
								roomIN.setCurrent(g_current);
								roomIN.userList.add(this);
								roomIN.nameList.add(nickName);
							}
							for(int j=0;j<cs.roomList.size();j++) {
								Room room = cs.roomList.get(j);
								String title = room.title;
								g_title = title;
								int current = 0;
								if(room.userList!=null && room.userList.size()!=0) {
									current = room.userList.size();
								}
								for(int x=0;x<room.nameList.size();x++) {//ROOM_INLIST반영
									//내가 아닌 다른 이름 중 방 이름이 같은 경우만 클라이언트로 전송함.
									if(!nickName.equals(room.nameList.get(x))) {//방이름이 같은 경우에만 클라이언트에 전송
										if(roomTitle.equals(room.title)) {//방이름이 같은 경우에만 전송
											ChatServerThread cst = room.userList.get(x);
											broadCasting(Protocol.ROOM_IN
													+Protocol.seperator+g_title
													+Protocol.seperator+current
													+Protocol.seperator+this.nickName);
										}
									}
								}
							}
							broadCasting(Protocol.ROOM_IN
									+Protocol.seperator+g_title
									+Protocol.seperator+g_current
									+Protocol.seperator+this.nickName);
						}
					}break;
					case Protocol.ROOM_LIST:{
						String roomTitle = st.nextToken();//방제목
						String currentNum = st.nextToken();//현재인원수
						//Room 반영
						Room room = new Room(roomTitle, Integer.parseInt(currentNum));
						//roomList 추가하기
						cs.roomList.add(room);
						//메세지를 방송 내보내기
						this.broadCasting(Protocol.ROOM_LIST
										+Protocol.seperator+roomTitle
										+Protocol.seperator+currentNum);
						
					}break;
					////////////////////////////[ end of 방 리스트 ]//////////////////////////////
//					case Protocol.ROOM_INlIST:{
//						String roomtitle = st.nextToken();
//						String currentNum = st.nextToken();
//						String nickName = st.nextToken();
//						Vector<String> v_room = new Vector<>();
//						v_room.add(nickName);
//						cs.
//						
//						
//					}break;
					////////////////////////////[  1 : 1 대화 ]///////////////////////////////
					case Protocol.WHISPER:{//1:1대화
						//메세지를 보내는 사람
						String nickName = st.nextToken();//커서처럼 위치정보가 바뀜으로 다음정보가 대기
						//메세지를 받는 사람
						String otherName = st.nextToken();
						//메세지 처리
						String message = st.nextToken();
//						broadCasting(Protocol.WHISPER+"#"+nickName+"#"+message);
						//벡터에서 그 사람을 찾아야 함.
						for(ChatServerThread cst:cs.globalList) {
							//상대 이름과 벡터안에 있는 스레드 중에서 대화명이 같은지 비교한다.
							//같다면 상대방이 맞다 - 다르면 다른 사람이다.
							if(otherName.equals(cst.nickName)) {
								cst.send(Protocol.WHISPER+"#"+nickName+"#"+otherName+"#"+message);//상대에게 보낼때는 cst 서버쓰레드
								break;//for 탈출
							}
						}
						//나 자신에게도 메세지를 전송하기
						this.send(Protocol.WHISPER+"#"+nickName+"#"+otherName+"#"+message);//나에게 보낼때는 this
					}break;
//					case Protocol.CHANGE:{//현재 대화방에 있는 사람에게 모두에게 통보
//						//현제 닉네임
//						String nickName = st.nextToken();
//						//바꿀 닉네임
//						String afterName = st.nextToken();
//						//메세지 처리
//						String message = st.nextToken();
//						//서버측에서 관리하고 있는 대화명도 변경처리 하기.
//						this.nickName = afterName;
//						broadCasting(Protocol.CHANGE
//								+"#"+nickName
//								+"#"+afterName
//								+"#"+message);
//					}
					case Protocol.MULTI:{//단체대화
						String nickName = st.nextToken();
						String message = st.nextToken();
						String fontColor = st.nextToken();
						String fontStyle = st.nextToken();
						String fontSize = st.nextToken();
						String imgChoice = "";//defulter가 이미 있어서 if문을 쓰지 않아도 된다.
						if(st.hasMoreTokens()) {
							imgChoice = st.nextToken();
						}
						broadCasting(Protocol.MULTI
									+"#"+nickName
									+"#"+message
									+"#"+fontColor
									+"#"+fontStyle
									+"#"+fontSize
									+"#"+imgChoice);
						System.out.println("imgChoice="+imgChoice);
					}break;
					/*case Protocol.EXIT:{//종료하기
						String nickName = st.nextToken();
						cs.globalList.remove(this);
						broadCasting(Protocol.EXIT+"#"+nickName);
					}break run_start;*/
//						System.out.print("protocol"+protocol);
					}
				}////////////////end of while
			} catch (Exception e) {
				System.out.println("Excepton ====>"+e.toString());
			}//////////////end of try catch
			
	   }/////////////////////end of run	
}
