package net.tomato_step4;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChatClientThreadver2 extends Thread {
		ChatClientver2 ccv = null;
		String path = "C:\\workspace_java\\dev_java\\src\\imgs\\";
		PictureMessage pm = new PictureMessage();
	public ChatClientThreadver2(ChatClientver2 ccv) {
		this.ccv = ccv;
	}
	public SimpleAttributeSet makeAttribute(String style[]) {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		//폰트컬러
		sas.addAttribute(StyleConstants.CharacterConstants.Foreground, new Color(Integer.parseInt(style[0])));
		//폰트타입
		switch (style[1]) {
		case "Font.ITALIC":
			sas.addAttribute(StyleConstants.CharacterConstants.Italic, true);
			break;
		case "Font.BOLD":
			sas.addAttribute(StyleConstants.CharacterConstants.Bold, true);
			break;
		}
		//폰트 사이즈
		sas.addAttribute(StyleConstants.CharacterConstants.FontSize, Integer.parseInt(style[2]));
		return sas;
	}
	public void run() {
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg = "";
				msg = (String)ccv.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(msg != null) {
					st = new StringTokenizer(msg,Protocol.seperator);
					protocol = Integer.parseInt(st.nextToken());
				}
			switch(protocol) {
				case Protocol.WAIT:{
					System.out.println("감지");
					String nickName = st.nextToken();
					String state 	= st.nextToken();//대기 또는 방이름을 갖는 변수.
					Vector<String> v_nick = new Vector<String>();
					v_nick.add(nickName);
					v_nick.add(state);
					ccv.wr.dtm_wait.addRow(v_nick);
					//테이블 목록이 늘어날 때 자동으로 스크롤바 이동하기 구현
					ccv.wr.jsp_wait.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar jsb = (JScrollBar)e.getSource();
							jsb.setValue(jsb.getMaximum());
						}
					});
				}break;
				case Protocol.ROOM_CREATE:{
					String title = st.nextToken();
					String currentNum = st.nextToken();
					Vector<String> roomTitle = new Vector<>();
					roomTitle.add(title);
					roomTitle.add(currentNum);
					ccv.wr.dtm_room.addRow(roomTitle);
					ccv.wr.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar jsb_room = (JScrollBar)e.getSource();
							jsb_room.setValue(jsb_room.getMaximum());
						}
					});
					
				}break;
				////////////////////////////[ end of 대화방 생성 ]//////////////////////////////////
				/////////////////////////////[ 대화방 목록 ]//////////////////////////////////
				case Protocol.ROOM_LIST:{
					String title = st.nextToken();
					String currentNum = st.nextToken();
					Vector<String> roomTitle = new Vector<>();
					roomTitle.add(title);
					roomTitle.add(currentNum);
					ccv.wr.dtm_room.addRow(roomTitle);
					ccv.wr.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar jsb_room = (JScrollBar)e.getSource();
							jsb_room.setValue(jsb_room.getMaximum());
						}
					});
				}break;
				////////////////////////////////[ end of 대화방 목록 ]///////////////////////////////////					
				////////////////////////////[ 대화방 입장 ]//////////////////////////////////
				//220|방이름|현재원수|내닉네임|홍길동#이순신#ㅓ
				case Protocol.ROOM_IN:{
					String roomTitle = st.nextToken();
					String current 	 = st.nextToken();
					String nickName  = st.nextToken();
					String names[] 	 = new String[Integer.parseInt(current)];
					StringTokenizer st_name = null;
					
					//방인원수를 갱신해야 한다.
					for(int i=0;i<ccv.wr.jtb_room.getRowCount();i++) {
						if(roomTitle.equals((String)ccv.wr.dtm_room.getValueAt(i, 0))) {//getValueAt = Object타입
							ccv.wr.dtm_room.setValueAt(current, i, 1);
						}
					}
					//대기실의 대기라고 되어있는 상태값을 방이름으로 변경처리 하기
					for(int i=0;i<ccv.wr.jtb_wait.getRowCount();i++) {
						if(nickName.equals((String)ccv.wr.dtm_wait.getValueAt(i, 0))) {//getValueAt = Object타입
							ccv.wr.dtm_wait.setValueAt(nickName, i, 1);
							break;
						}
					}
					//방 입장하기를 누른 사람만 화면을 이동(MessageRoom)처리 합니다
					if(ccv.nickName.equals(nickName)) {//
						ccv.jtp.setSelectedIndex(1);
						ccv.mr.jtf_message.requestFocus();//커서를 자동으로 이동시켜줌.
						for(int x=0;x<ccv.wr.jtb_wait.getRowCount();x++) {
							if(roomTitle.equals(ccv.wr.dtm_wait.getValueAt(x, 1))) {
								String imsi[] = {(String)ccv.wr.dtm_wait.getValueAt(x, 0)};
								ccv.mr.dtm_room.addRow(imsi);
							}
						}
					}
					
				}break;
				//서버를 이용해서 보낼때 #연산자는 한 묶음을 뜻한다. & ||연산자는 묶음을 쪼개는 것을 뜻한다.
				/////////////////////////////[ end of 대화방 입장 ]//////////////////////////////////

				/////////////////////////////////////[대화방 입장한사람 리스트 ]//////////////////////
				case Protocol.ROOM_INlIST:{
					String roomtitle = st.nextToken();
					String currentNum = st.nextToken();
					String nickName = st.nextToken();
					Vector<String> v_room = new Vector<>();
					v_room.add(nickName);
					ccv.wr.dtm_room.addRow(v_room);
				}break;
				/////////////////////////////////////[ end of 대화방 입장한사람 리스트 ]//////////////////////
				////////////////////////////////1:1 대화창/////////////////////////////////////////////
	/*			case Protocol.WHISPER:{
					String nickName = st.nextToken();//내 닉네임
					String otherName = st.nextToken();//상대의 닉네임
					String message = st.nextToken();//내가 보낼 메세지
					 try {
						 ccv.sd_display.insertString(ccv.sd_display.getLength()
		                		  					,nickName+"님이"+otherName+"님에게"+message+"\n"
		                		  					, new SimpleAttributeSet());
		               } catch (Exception e) {
		                  System.out.println(e.toString());
		               }
					 ccv.jtp_display.setCaretPosition(ccv.sd_display.getLength());
				}break;
				/////////////////////////////1:1 대화창///////////////////////////////
				/////////////////////////////대화명 변경///////////////////////////////
				case Protocol.CHANGE:{
					String nickName = st.nextToken();//현제 닉네임
					String afterName = st.nextToken();//바꿀 닉네임
					String message = st.nextToken();//닉네임 바꾼것을 보낼 메세지
					ccv.sd_display.insertString(cc.sd_display.getLength(), nickName+"\n", new SimpleAttributeSet());
					테이블에 출력된 대화명도 바꾸어 주어야한다.
					for(int i=0;i<ccv.dtm.getRowCount();i++) {//tomatoClient에 있는 dtm(테이블)의 row를 카운터한다.
						//대화명 변경전에 현재 테이블에서 가져온 대화명을 받는다.
						String cname = (String)ccv.dtm.getValueAt(i, 0);
						//row가 계속 바뀌어야하기 때문에 i를 row값으로 썻다.
						if(nickName.equals(cname)) {
							ccv.dtm.setValueAt(afterName, i, 0);//받는건 set
							break;
						}
					}//////////////////////////end of for////////////////////////////////
					//커서 이동이 자동으로 처리되도록 하기 위해서 추가된 코드
					 try {
						 ccv.sd_display.insertString(ccv.sd_display.getLength()
	                                          ,message+"\n"
	                                          ,new SimpleAttributeSet());
	                  } catch (Exception e) {
	                     System.out.println(e.toString());
	                  }
					 ccv.jtp_display.setCaretPosition(ccv.sd_display.getLength());
					//채팅창의 타이틀 바에 적힌 이름 변경처리
					 if(nickName.equals(ccv.nickName)) {
						 ccv.setTitle(afterName+"님의 대화창");
	                     //전역변수에 바뀐 대화명으로 초기화해주기 .
						 ccv.nickName = afterName;
					 }
				}break;
				/////////////////////////////대화명 변경//////////////////////////////
				//////////////////////////////로그인창//////////////////////////////
//				case Protocol.LOGIN:{
//					String nickName = st.nextToken();
//					try {
//						ccv.sd_display.insertString(ccv.sd_display.getLength()
//													,nickName+"님이 입장하였습니다.\n"
//													, new SimpleAttributeSet());
//					} catch (Exception e) {
//						System.out.println(e.toString());
//					}
//					ccv.jtp_display.setCaretPosition(ccv.sd_display.getLength());
//					Vector<String> v = new Vector<>();
//					v.add(nickName);위치를 알아야한다.
//					ccv.dtm.addRow(v);
//				}break;
				
				///////////////////////////////로그인창/////////////////////////
				///////////////////////////////단체대화창///////////////////////////////
				case Protocol.MULTI:{
		               String nickName = st.nextToken();
		               String message = st.nextToken();
		               String fontColor = st.nextToken();
		               String fontStyle = st.nextToken();
		               String fontSize = st.nextToken();
		               String styles[] = new String[3];
		               styles[0] = fontColor;
		               styles[1] = fontStyle;
		               styles[2] = fontSize;
		               String imgChoice = st.nextToken();
		               //힌트를 볼수 있는 코드를 다양하게 구사해 보세요. - 문제해결능력
		               JOptionPane.showMessageDialog(cc, "imgChoice:i"+imgChoice);
		               MutableAttributeSet sas2 = new SimpleAttributeSet();
		               if(!imgChoice.equals("default")) {//1.gif, 2.gif, 6.gif
		            	   int i = 0;
		            	   for(i=0;i<ccv.pm.imgNames.length;i++) {
		            		  if(ccv.pm.imgNames[i].equals(imgChoice)) {
//		            			  JOptionPane.showMessageDialog(cc, "여기:"+path+cc.pm.imgNames[i]); //안타고 있다
		            			  StyleConstants.setIcon(sas2
		            					  				,new ImageIcon(path+ccv.pm.imgNames[i]));
		            			  try {
		            				  ccv.sd_display.insertString(ccv.sd_display.getLength()
																, "\n"
																, sas2);
								} catch (Exception e) {
									System.out.println(e.toString());
								}///////////////////////end of try-catch
		            		  }/////////////////////////end of if
		            	   }////////////////////////////end of for
		               }////////////////////////////////end of if
		               SimpleAttributeSet sas = makeAttribute(styles);
		               if(!msg.equals("이모티콘")) {
		               try {
		            	   ccv.sd_display.insertString(ccv.sd_display.getLength()
		                		  						,"[ "+nickName+" ] : "+message+"\n"
		                		  						, sas);
		               } catch (Exception e) {
		                  System.out.println(e.toString());
		               }
		             //커서 이동이 자동으로 처리되도록 추가된 코드
		               ccv.jtp_display.setCaretPosition(ccv.sd_display.getLength());
				//////////////////////////단체대화창/////////////////////////////
		               }
				}break;
//				case Protocol.EXIT:{
//					String nickName = st.nextToken();
//					String message = st.nextToken();
//					try {
//						ccv.sd_display.insertString(ccv.sd_display.getLength()
//													,"[ "+nickName+" ] : "+message+"\n"
//													,new SimpleAttributeSet());
//					} catch (Exception e) {
//						ccv.jtp_display.setCaretPosition(ccv.sd_display.getLength());
//					}
//					for(int i=0;i<ccv.dtm.getRowCount();i++) {
//						String n = (String)ccv.dtm.getValueAt(i, 0);
//						if(n.equals(nickName)) {
//							ccv.dtm.removeRow(i);//인트
//						}
//					}
//				}break;//무한반복 방지 */
				}
			} catch (Exception e) {
				System.out.println("ChatClientThread===>"+e.toString());
				e.printStackTrace();//히스토리를 찍어주는 메소드
			}
			
		 }
		}
}
