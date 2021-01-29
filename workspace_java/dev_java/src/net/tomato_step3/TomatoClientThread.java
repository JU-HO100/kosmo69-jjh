package net.tomato_step3;

import java.util.StringTokenizer;
import java.util.Vector;

public class TomatoClientThread extends Thread {
		TomatoClient tc = null;
	public TomatoClientThread(TomatoClient tc) {
		this.tc = tc;
	}
	@Override
	public void run() {
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg = "";
				msg = (String)tc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(msg != null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());
				}
			switch(protocol) {
				case Protocol.WHISPER:{
					String nickName = st.nextToken();//내 닉네임
					String otherName = st.nextToken();//상대의 닉네임
					String message = st.nextToken();//내가 보낼 메세지
					//메세지
					tc.jta_display.append(nickName+"님이"+otherName+"에게"+message+"\n");//내가 1:1대화로 상대방에게 보내는 메세지
					//커서 이동이 자동으로 처리되도록 추가된 코드
					tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
				}break;
				case Protocol.CHANGE:{
					String nickName = st.nextToken();//현제 닉네임
					String afterName = st.nextToken();//바꿀 닉네임
					String message = st.nextToken();//닉네임 바꾼것을 보낼 메세지
					//테이블에 출력된 대화명도 바꾸어 주어야한다.
					for(int i=0;i<tc.dtm.getRowCount();i++) {//tomatoClient에 있는 dtm(테이블)의 row를 카운터한다.
						//대화명 변경전에 현재 테이블에서 가져온 대화명을 받는다.
						String cname = (String)tc.dtm.getValueAt(i, 0);
						//row가 계속 바뀌어야하기 때문에 i를 row값으로 썻다.
						if(nickName.equals(cname)) {
							tc.dtm.setValueAt(afterName, i, 0);//받는건 set
							break;
						}
					}
					//메세지
					tc.jta_display.append(message+"\n");//서버쓰레드에서 이미 토큰값으로 해놨기 때문에 메세지만 써도 된다.
					//커서 이동이 자동으로 처리되도록 추가된 코드
					tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
					//채팅창의 타이틀 바에 적힌 이름을 변경
					if(nickName.equals(tc.nickName)) {
						tc.setTitle(afterName+"님의 대화창");
						tc.nickName = afterName;
					}
				}break;
				case Protocol.LOGIN:{
					String nickName = st.nextToken();
					tc.jta_display.append(nickName+"님이 입장하였습니다.\n");
					tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
					Vector<String> v = new Vector<>();
					v.add(nickName);/*위치를 알아야한다.*/
					tc.dtm.addRow(v);
				}break;
				case Protocol.MULTI:{
					String nickName = st.nextToken();
					String message = st.nextToken();
					tc.jta_display.append("["+nickName+"]"+message+"\n");
					//커서 이동이 자동으로 처리되도록 추가된 코드
					tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
				}
				case Protocol.EXIT:{
					String nickName = st.nextToken();
					String message = st.nextToken();
					tc.jta_display.append(nickName+"님이 퇴장하였습니다."+"\n");
					tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
					for(int i=0;i<tc.dtm.getRowCount();i++) {
						String n = (String)tc.dtm.getValueAt(i, 0);
						if(n.equals(nickName)) {
							tc.dtm.removeRow(i);//인트
						}
					}
				}break;//무한반복 방지
				}
			} catch (Exception e) {
				System.out.println("TomatoClientThread===>"+e.toString());
			} 
		}
	}
}
