package net.tomato_step2;

import java.util.StringTokenizer;
import java.util.Vector;

public class BandClientThread extends Thread {
		BandClient bc = null;
	public BandClientThread(BandClient bc) {
		this.bc = bc;
	}
	@Override
	public void run() {
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg = "";
				msg = (String)bc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(msg != null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				case 100:{
					String nickName = st.nextToken();
					bc.jta_log.append(nickName+"님이 입장하였습니다.\n");
					Vector<String> v = new Vector<>();
					v.add(nickName);/*위치를 알아야한다.*/
					bc.dtm.addRow(v);
				}break;
				case 200:{
					String nickName = st.nextToken();
					String message = st.nextToken();
					bc.jta_log.append("["+nickName+"]"+message+"\n");
				}
				case 500:{
					String nickName = st.nextToken();
					String message = st.nextToken();
					bc.jta_log.append(nickName+"님이 퇴장하였습니다."+"\n");
					for(int i=0;i<bc.dtm.getRowCount();i++) {
						String n = (String)bc.dtm.getValueAt(i, 0);
						if(n.equals(nickName)) {
							bc.dtm.removeRow(i);//인트
						}
					}
				}break;//무한반복 방지
				}
			} catch (Exception e) {
				
			} 
		}
	}
}
