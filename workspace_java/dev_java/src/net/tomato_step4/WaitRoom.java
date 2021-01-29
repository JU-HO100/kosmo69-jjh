package net.tomato_step4;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import jdk.nashorn.internal.scripts.JO;
/*
 * 왜 이벤트 처리시에는 인터페이스를 구현하는 것으로 설계를 하였나?
 * 버튼은 동일하지만 그 기능은 각각의 디바이스 (아이폰,갤럭시노트,아이패드) 마다 
 * 다르게 동작하도록 조작할 수도 있어야 한다.
 * 상속을 할 경우 필요없는 메소드까지 오버라이딩을 강요 당할 수도 있다.
 * 인터페이스의 경우 상속관계가 아니므로 강제조건들이 없게 된다.
 * 자유롭게 구현할 수 있고 그러면서도 특정한 클래스에 종속적이지 않게 된다.
 * 재사용성을 높이고 이식성을 높이려면 인터페이스를 사용한다.
 * 결합도는 낮아지고 의존성도 낮아져서 독립적으로 사용할 수가 있다.
 * 개발 기간을 단축할 수도 있고 테스트시에도 좀 더 빠르게 해결할 수 있다.
 * 클래스 설계시에 많이 활용되고 개발 4년차 이상 되었을 때 설계를 담당한다. -업무를 알아야 한다.
 * 게임엔진을 설계하거나 프레임워크를 개발할 때에도 이런 추상 클래스나 인터페이스 중심의 설계/개발을 권장하고 있다.
 */

public class WaitRoom extends JPanel implements ActionListener {
	//선언
		ChatClientver2 cc2 = null;
		JPanel jp_first			= new JPanel();
		JPanel jp_second		= new JPanel();
		JPanel jp_second_south	= new JPanel();
		String cols[] = {"대화명","위치"};
		String data[][] = new String [0][2];
		DefaultTableModel dtm_wait = new DefaultTableModel(data,cols);
		JTable jtb_wait = new JTable(dtm_wait);
		JScrollPane jsp_wait = new JScrollPane(jtb_wait
								,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
								,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		String cols2[] = {"대화방이름","접속인원"};
		String data2[][] = new String [0][2];
		DefaultTableModel dtm_room = new DefaultTableModel(data2,cols2);
		JTable jtb_room = new JTable(dtm_room);
		JScrollPane jsp_room = new JScrollPane(jtb_room
								,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
								,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jbtn_create = new JButton("대화방생성");
		JButton jbtn_in 	= new JButton("대화방입장");
		JButton jbtn_out 	= new JButton("대화방나가기");
		JButton jbtn_exit 	= new JButton("종료하기");
		JTableHeader jth_wait = jtb_wait.getTableHeader();
		JTableHeader jth_room = jtb_room.getTableHeader();
		String 	nickName 	= null;
		String 	roomTitle 	= null;
		int		currentNum	= 1;
		Room	room		= null;
		//생성
		public WaitRoom() {}
		//나는 생성자 속에서 다른 클래스와의 조립관계에서 파생 되는 일들을 초기화 하거나 호출 할 수 있나?
		public WaitRoom(ChatClientver2 cc2) {
			this.cc2 = cc2;
			//즉 ChatClientver2가 메모리에 로딩 될때 이 객체도 같이 활성화 되어 있어야 한다.
			initDisplay();
		}
		
		//화면
		public void initDisplay() {
			jbtn_create.addActionListener(this);
			jbtn_in.addActionListener(this);
			jbtn_out.addActionListener(this);
			jbtn_exit.addActionListener(this);
			this.setLayout(new GridLayout(1,2));
			
			//버튼 
			jp_second_south.setLayout(new GridLayout(2,2));
			jp_second_south.add(jbtn_create);
			jp_second_south.add(jbtn_in);
			jp_second_south.add(jbtn_out);
			jp_second_south.add(jbtn_exit);
			
			//first패널
			this.add(jp_first);
			jp_first.setLayout(new BorderLayout());
			jp_first.add("Center",jsp_wait);
			//second패널
			this.add(jp_second);
			jp_second.setLayout(new BorderLayout());
			jp_second.add("South",jp_second_south);
			jp_second.add("Center",jsp_room);
			//화면 생성및 위치
			this.setSize(600, 500);
			this.setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == jbtn_exit) {
				System.exit(0);
			}
			else if(obj == jbtn_in) {
				//어느방으로  갈꺼니?
				int index[] = jtb_room.getSelectedRows();
				if(index.length == 0) {
					JOptionPane.showMessageDialog(cc2, "방을 선택하세요.", "Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(index.length >1) {
					JOptionPane.showMessageDialog(cc2, "1개의 대화방만 선택하세요.", "Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					for(int i=0;i<jtb_room.getRowCount();i++) {
						if(jtb_room.isRowSelected(i)) {
							String roomTitle = (String)dtm_room.getValueAt(i, 0);
							cc2.oos.writeObject(Protocol.ROOM_IN
												+Protocol.seperator+roomTitle
												+Protocol.seperator
												+cc2.nickName);//서버에게 말하기
							
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			else if(obj == jbtn_create) {
				roomTitle = JOptionPane.showInputDialog("대화방 이름을 지어 주세요.");
				if(roomTitle != null) {
					try {
						cc2.oos.writeObject(Protocol.ROOM_CREATE
											+Protocol.seperator+roomTitle
											+Protocol.seperator
											+0);
					} catch (Exception e2) {
						e2.printStackTrace();
					} 
				}
				
			}
			else if(obj == jbtn_out) {
				
			}
			
		}
	
}
