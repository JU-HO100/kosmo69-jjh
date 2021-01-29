package net.tomato_step4;

import java.awt.Color;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChatClientThread extends Thread {
		ChatClient cc = null;
		String path = "C:\\workspace_java\\dev_java\\src\\imgs\\";
		PictureMessage pm = new PictureMessage();
		MessageRoom wr = null;
	public ChatClientThread(ChatClient cc) {
		this.cc = cc;
	}
	public ChatClientThread(MessageRoom wr) {
		this.wr = wr;
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
				msg = (String)cc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(msg != null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());
				}
			switch(protocol) {
			////////////////////////////////1:1 대화창///////////////////////////////
				case Protocol.WHISPER:{
					String nickName = st.nextToken();//내 닉네임
					String otherName = st.nextToken();//상대의 닉네임
					String message = st.nextToken();//내가 보낼 메세지
					 try {
		                  cc.sd_display.insertString(cc.sd_display.getLength()
		                		  					,nickName+"님이"+otherName+"님에게"+message+"\n"
		                		  					, new SimpleAttributeSet());
		               } catch (Exception e) {
		                  System.out.println(e.toString());
		               }
					 cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				/////////////////////////////1:1 대화창///////////////////////////////
				/////////////////////////////대화명 변경///////////////////////////////
				case Protocol.CHANGE:{
					String nickName = st.nextToken();//현제 닉네임
					String afterName = st.nextToken();//바꿀 닉네임
					String message = st.nextToken();//닉네임 바꾼것을 보낼 메세지
//					cc.sd_display.insertString(cc.sd_display.getLength(), nickName+"\n", new SimpleAttributeSet());
					//테이블에 출력된 대화명도 바꾸어 주어야한다.
					for(int i=0;i<cc.dtm.getRowCount();i++) {//tomatoClient에 있는 dtm(테이블)의 row를 카운터한다.
						//대화명 변경전에 현재 테이블에서 가져온 대화명을 받는다.
						String cname = (String)cc.dtm.getValueAt(i, 0);
						//row가 계속 바뀌어야하기 때문에 i를 row값으로 썻다.
						if(nickName.equals(cname)) {
							cc.dtm.setValueAt(afterName, i, 0);//받는건 set
							break;
						}
					}//////////////////////////end of for////////////////////////////////
					//커서 이동이 자동으로 처리되도록 하기 위해서 추가된 코드
					 try {
	                     cc.sd_display.insertString(cc.sd_display.getLength()
	                                          ,message+"\n"
	                                          ,new SimpleAttributeSet());
	                  } catch (Exception e) {
	                     System.out.println(e.toString());
	                  }
					 cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
					//채팅창의 타이틀 바에 적힌 이름 변경처리
					 if(nickName.equals(cc.nickName)) {
	                     cc.setTitle(afterName+"님의 대화창");
	                     //전역변수에 바뀐 대화명으로 초기화해주기 .
	                     cc.nickName = afterName;
					 }
				}break;
				/////////////////////////////대화명 변경//////////////////////////////
				//////////////////////////////로그인창//////////////////////////////
				/*case Protocol.LOGIN:{
					String nickName = st.nextToken();
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
													,nickName+"님이 입장하였습니다.\n"
													, new SimpleAttributeSet());
					} catch (Exception e) {
						System.out.println(e.toString());
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
					Vector<String> v = new Vector<>();
					v.add(nickName);//위치를 알아야한다.
					cc.dtm.addRow(v);
				}break;*/
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
//		               JOptionPane.showMessageDialog(cc, "imgChoice:i"+imgChoice);
		               MutableAttributeSet sas2 = new SimpleAttributeSet();
		               if(!imgChoice.equals("default")) {//1.gif, 2.gif, 6.gif
		            	   int i = 0;
		            	   for(i=0;i<cc.pm.imgNames.length;i++) {
		            		  if(cc.pm.imgNames[i].equals(imgChoice)) {
//		            			  JOptionPane.showMessageDialog(cc, "여기:"+path+cc.pm.imgNames[i]); //안타고 있다
		            			  StyleConstants.setIcon(sas2
		            					  				,new ImageIcon(path+cc.pm.imgNames[i]));
		            			  try {
									cc.sd_display.insertString(cc.sd_display.getLength()
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
		                  cc.sd_display.insertString(cc.sd_display.getLength()
		                		  						,"[ "+nickName+" ] : "+message+"\n"
		                		  						, sas);
		               } catch (Exception e) {
		                  System.out.println(e.toString());
		               }
		             //커서 이동이 자동으로 처리되도록 추가된 코드
						cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				//////////////////////////단체대화창/////////////////////////////
		               }
				}break;
				/*case Protocol.EXIT:{
					String nickName = st.nextToken();
					String message = st.nextToken();
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
													,"[ "+nickName+" ] : "+message+"\n"
													,new SimpleAttributeSet());
					} catch (Exception e) {
						cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
					}
					for(int i=0;i<cc.dtm.getRowCount();i++) {
						String n = (String)cc.dtm.getValueAt(i, 0);
						if(n.equals(nickName)) {
							cc.dtm.removeRow(i);//인트
						}
					}
				}break;//무한반복 방지*/
				}
			} catch (Exception e) {
				System.out.println("ChatClientThread===>"+e.toString());
			}
			
		 }
		}
}
