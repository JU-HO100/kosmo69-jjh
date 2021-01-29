package net.tomato_step4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.JDBCType;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class ChatClient extends JFrame implements ActionListener  {
	//선언부
	//이모티콘 화면 추가에 필요한 객체 주입하기.
	//인스턴스화는 2가지 방법으로 할수 있다.
	//A a = null;  a = new A(); 장점 - 중간에 값을 바꿀수 있다.
	//단점 - NullPointerException을 얻어맞을 수 있다. -시점의 문제를 조심하자.(인스턴스화의 시점) 
	//main() - new 생성자 호출 -> initDisplay(); <-이 과정에서 다른 곳을 거쳐간다.
	//String s = null; int length = s.length();length=문자열의 길이를 반환한다. -현재 s값이 null이다
	//A a = new A(); 장점 - 한번 인스턴스화가 되면 계속 유지된다. 단점 - 중간에 바뀌면 반영이 되지 않는다. 
	PictureMessage pm = new PictureMessage();//객체 주입 - dependency injection 디펜더시 인젝션
	/*기본창*/
	ObjectOutputStream oos 	 	= null;
	ObjectInputStream ois 	 	= null;
	Socket 		socket 			= null;
	JPanel		jp_first	 	= new JPanel();
	JPanel		jp_first_south	= new JPanel();
	JPanel		jp_secand	 	= new JPanel();
	JPanel		jp_secand_south	= new JPanel();
	JButton 	jbtn_in 	 	= new JButton("전송");
	JLabel   	jlb_nickname 	= new JLabel("닉네임");
	JButton		jbtn_one	 	= new JButton("1:1대화");
	JButton		jbtn_change  	= new JButton("대화명 변경"); 	
	JButton		jbtn_style	 	= new JButton("폰트 스타일"); 
	JButton		jbtn_fcolor	 	= new JButton("글자색"); 
	JButton		jbtn_blank	 	= new JButton("미정"); 
	JButton		jbtn_ticon	 	= new JButton("이모티콘"); 
	JButton		jbtn_logout	 	= new JButton("로그아웃"); 
	JButton		jbtn_exit	 	= new JButton("종료");
	JLabel 		jlb_size 		= new JLabel("폰트크기");
	JTextField 	jtf_size 		= null;
	JButton 	jbtn_bold		= null;
	JButton 	jbtn_italic 	= null;
	String		fontColor		= "0";
	String 		fontStyle 		= "Font.PLAIN";
	int fontSize = 16;
	
	String cols[] = {"닉네임"};
	String date[][] = new String [0][1];
	DefaultTableModel dtm 		= new DefaultTableModel(date,cols);
	JTable			jtb 		= new JTable(dtm);
	Image 			back 		= getToolkit().getImage("src\\net\\tomato\\step3\\back.jpg");// .=내가 바라보는곳을 경로
	StyledDocument sd_display = new DefaultStyledDocument(new StyleContext());
	JTextField		jtf_msg  	= new JTextField();
	/*닉네임 입력 받아서 담기*/
	String 		nickName 		= null;
	//글자색을 부분변경가능, 배경색도 변경, 이모티콘도 추가, 글씨도 그린다.
	JTextPane 		jtp_display = new JTextPane(sd_display);
	JScrollPane 	jsp_log  	= new JScrollPane(jtp_display
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JScrollPane 	jsp_log2  	= new JScrollPane(jtb
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	Login lg	= null;
	/*디폴트 생성자는 JVM이 제공해줄 수도 있지만 파라미터가 있는 생성자는 제공이 안된다.*/
	public ChatClient() {}
	public ChatClient(String nickName) {
		this.nickName = nickName;
	}
	
	public ChatClient(Login login) {
		this.lg = login;
	}
	//화면처리
	public void initDisplay() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		/*사용자로 부터 닉네임 입력 받기*/
//		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		
		//어플리케이션 닫을 때 프로세서 종료처리
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbtn_in.addActionListener(this);
		jbtn_one.addActionListener(this);
		jbtn_style.addActionListener(this);
		jbtn_fcolor.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_ticon.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jtf_msg.addActionListener(this);
		/*패널1에 들어갈것들*/
		this.setLayout(new GridLayout(1,2,2,2));
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_log);
		jtp_display.setEditable(false);
		this.add("Center",jp_first);
		/*패널1에 남쪽*/
		this.add("East",jp_secand);
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_in);
		jp_first.add("South",jp_first_south);
		/*패널2에 들어갈것들*/
		jp_secand.setLayout(new BorderLayout());
		jp_secand.add("Center",jsp_log2);
		jp_secand.add("South",jp_secand_south);
		//패널2 버튼 색
		jbtn_one.setBackground(new Color(255,215,0));
		jbtn_one.setForeground(new Color(0,0,0));
		jbtn_change.setBackground(new Color(255,0,255));
		jbtn_change.setForeground(new Color(0,0,0));
		jbtn_ticon.setBackground(new Color(255,255,0));
		jbtn_ticon.setForeground(new Color(0,0,0));
		jbtn_style.setBackground(new Color(0,206,209));
		jbtn_style.setForeground(new Color(0,0,0));
		jbtn_fcolor.setBackground(new Color(0,80,160));
		jbtn_fcolor.setForeground(new Color(0,0,0));
		jbtn_blank.setBackground(new Color(0,150,130));
		jbtn_blank.setForeground(new Color(0,0,0));
		jbtn_logout.setBackground(new Color(220,220,220));
		jbtn_logout.setForeground(new Color(0,0,0));
		jbtn_exit.setBackground(new Color(105,105,105));
		jbtn_exit.setForeground(new Color(0,0,0));
		/*패널2에 남쪽*/
		jp_secand_south.setLayout(new GridLayout(4,2,2,2));
		jp_secand_south.add(jbtn_one);
		jp_secand_south.add(jbtn_change);
		jp_secand_south.add(jbtn_fcolor);
		jp_secand_south.add(jbtn_blank);
		jp_secand_south.add(jbtn_ticon);
		jp_secand_south.add(jbtn_style);
		jp_secand_south.add(jbtn_logout);
		jp_secand_south.add(jbtn_exit);
		//패널 위치
		this.setTitle(nickName+"클라이언트");
		this.setSize(800, 550);
		this.setLocation(550,280);
		this.setVisible(true);
	}
	public void init() {
		try {
			/*소켓 인스턴스화 하기*/
			socket = new Socket("192.168.0.38",5000);//ChatServer -> Socket.accept(); 이후에 생성(ChatClient)
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			/*서버에게 내가 입장한 사실을 알림.*/
			//oos.writeObject(Protocol.LOGIN+"#"+nickName);
			/*서버에서 말을 한 말을 듣기 위해 준비*/
			ChatClientThread cct = new ChatClientThread(this);
			cct.start();
		} catch (Exception e) {
			System.out.println("접속"+e.getMessage());
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		if(obj == jbtn_ticon) {
//			pm.initDisplay();
			pm.setVisible(true);
		}
		else if(obj == jbtn_fcolor) {
			JDialog jdl_fcolor = new JDialog();//새로운창 띄우기
			final JColorChooser jcc = new JColorChooser();//
			ColorSelectionModel model = jcc.getSelectionModel();
			//내부클래스, 익명클래스 이다.
			ChangeListener listener = new ChangeListener() {//색상이 바꼈을 때 서버 쪽으로 보내기 위해 - 인터페이스 - 클릭만해도 바뀐다.
				@Override
				public void stateChanged(ChangeEvent sc) {
					Color nfgColor = jcc.getColor();
					fontColor = String.valueOf(nfgColor.getRGB());
				}
			};
			model.addChangeListener(listener);
			jdl_fcolor.add(jcc);
			jdl_fcolor.setTitle("글자색변경");
			
			jdl_fcolor.setSize(600,500);
			jdl_fcolor.setVisible(true);
		}
		
		else if(obj == jbtn_style) {
			JDialog jdl_style = new JDialog();
			jtf_size 		= new JTextField("12");
			jbtn_bold		= new JButton("굵은글씨");
			jbtn_italic 	= new JButton("이탤릭");
//			jlb_size 		= new JLabel("폰트크기");
			
			jbtn_bold.addActionListener(this);
			jbtn_italic.addActionListener(this);
			jtf_size.addActionListener(this);
			
			jdl_style.setLayout(new GridLayout(1,4));
			jdl_style.add(jlb_size);
			jdl_style.add(jtf_size);
			jdl_style.add(jbtn_bold);
			jdl_style.add(jbtn_italic);
			jdl_style.setTitle("폰트스타일 조정");
			jdl_style.setSize(400, 80);
			jdl_style.setVisible(true);
		}
		else if(obj == jbtn_bold) {
			fontStyle = "Font.BOLD";
			System.out.println("bold");
		}
		else if(obj == jbtn_italic) {
			fontStyle = "Font.ITALIC";
			System.out.println("italic");
		}
		else if(obj == jtf_size) {
			fontSize = Integer.parseInt(jtf_size.getText());
		}
		else if(obj  == jbtn_change) {
			//변경할 대화명 입력받기
			String afterName = JOptionPane.showInputDialog("변경할 이름을 입력하세요.");
//			int row = jtb.getSelectedRow();
//			String name = (String)dtm.getValueAt(row, 0);
			//대화명이 널이거나 문자열의 길이가 얼마인지 체크하기 - 유효성 체크하기
			if(afterName == null || afterName.trim().length() < 1) {
				JOptionPane.showMessageDialog
				(this, "변경할 대화명을 입력하세요.", "info", JOptionPane.INFORMATION_MESSAGE);
				return;//actionPerformed 탈출
			}
			//대화명이 변경된 사실을 광고하기
//			String msg1 = JOptionPane.showInputDialog("대화명이 변경되었습니다.");
			try {
				oos.writeObject(Protocol.CHANGE
								+"#"+nickName//dtm에 들어가는 내용이므로 주석처리하면 테이블의 내용이 바뀌지 않는다.
								+"#"+afterName//dtm에 들어가는 내용이므로 주석처리하면 테이블의 내용이 바뀌지 않는다.
								+"#"+nickName+"님의 대화명이 "+afterName+"으로 변경되었습니다.");//상대가 알수 있도록 name를 붙였다.
			} catch (Exception e2) {
				//문제가 터졌을때 힌트를 알기 위해
				e2.printStackTrace();
			}/////////////////////////end of try-catch
		}///////////////////////////////end of 대화명 변경
		
		else if(obj  == jbtn_one) {
			int row = jtb.getSelectedRow();
			if(row == -1) {//상대를 선택하지 않았을 때
				JOptionPane.showMessageDialog
				(this, "대화상대를 선택해주세요.", "info", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		else {//상대를 선택했을 때
			String name = (String)dtm.getValueAt(row, 0);//타입이 달라 캐스팅 연산자를 앞에다 붙여줘야한다.
			//내가 나안테 귓속말하기는 차단시켜 주세요. - 요구사항
			//if문에서 중단시킬때는 return 예약어를 사용
			//for문에서 중단시킬때는 break;
			//while문에서 전체 블럭을 탈출 할때는 라벨을 사용
			if(nickName.equals(name)) {//내가 나를 선택했을 때
				JOptionPane.showMessageDialog
				(this, "다른상대를 선택해주세요.", "info", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			//이제 다른 사람을 선택했을때 그 다음엔 뭘 하지?
			String msg1 = JOptionPane.showInputDialog("메세지를 입력하세요.");
			try {
				oos.writeObject(Protocol.WHISPER+"#"+nickName+"#"+name+"#"+msg1);//상대가 알수 있도록 name를 붙였다.
			} catch (Exception e2) {
				//문제가 터졌을때 힌트를 알기 위해
				e2.printStackTrace();
			}/////////////////////////end of try-catch
		}/////////////////////////////end of else
		//선택한 상대를 초기화 하기
		jtb.clearSelection();
		/*1.actionperforemd(BC)--> 2.run() : BCT --> 3.run() BCT */
		}/////////////////////////////////end of 1:1대화		
		else if(obj == jbtn_exit) {
			try {
				//oos.writeObject(Protocol.EXIT+"#"+nickName);
				System.exit(0);
			} catch(Exception e2) {
				System.out.println(e2.toString());
			}///////////////////////////end of try-catch 
		}///////////////////////////////end of 종료		
		else if(obj == jtf_msg || obj == jbtn_in) {
			//깔때기 - 2 jtf_msg.getText()-> null이 아니라 ""입니다. 빈문자열
			if(msg == null|| msg.length()==0) {//메세지가 입력되지 않았는지 확인
				msg="이모티콘";
			}
			try {
				oos.writeObject(Protocol.MULTI
								+"#"+nickName
								+"#"+msg
								+"#"+fontColor
								+"#"+fontStyle
								+"#"+fontSize
								+"#"+pm.imgChoice);
				jtf_msg.setText("");
			} catch (Exception e2) {
				System.out.println(e2.toString());
			}///////end of try catch 
		}///////////end of if
		}///////////////////////////키보드의 엔터를 쓸수 있게하는 메소드

}
