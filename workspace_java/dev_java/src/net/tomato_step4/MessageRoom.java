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
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class MessageRoom extends JPanel implements ActionListener{
	//선언부
	ChatClientver2 ccv = null;
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
	JButton		jbtn_fcolor	 	= new JButton("글자색"); 
	JButton		jbtn_ticon	 	= new JButton("이모티콘"); 
	JButton		jbtn_x	 		= new JButton(""); 
	JButton		jbtn_exit	 	= new JButton("종료");
	JTextField 	jtf_message		= new JTextField(20);
	JTextArea	jta_text		= new JTextArea();
	

	String cols2[] = {"대화명"};
	String data2[][] = new String [0][1];
	DefaultTableModel dtm_room = new DefaultTableModel(data2,cols2);
	JTable jtb_room = new JTable(dtm_room);
	JScrollPane jsp_room = new JScrollPane(jtb_room
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTableHeader jth_room = jtb_room.getTableHeader();
	
	//생성자
	public MessageRoom() {}
	public MessageRoom(ChatClientver2 ccv) {
		this.ccv = ccv;
		initDisplay();
		
	}

	//화면처리
	public void initDisplay() {
		this.setLayout(new GridLayout(1,2));
		jbtn_in.addActionListener(this);
		jbtn_one.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_fcolor.addActionListener(this);
		jbtn_ticon.addActionListener(this);
		jbtn_exit.addActionListener(this);
		
		
		//first패널에 들어갈것
		//first패널
		this.add(jp_first);
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jta_text);
		jta_text.setEditable(false);//텍스트 얼리기
		jp_first.add("South",jp_first_south);
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center",jtf_message);
		jp_first_south.add("East",jbtn_in);
		//second패널에 들어갈것
		//second패널
		this.add(jp_secand);
		jp_secand.setBackground(Color.PINK);
		jp_secand.setLayout(new BorderLayout());
		jp_secand.add("Center",jsp_room);
		jp_secand.add("South",jp_secand_south);
		//버튼 
		jp_secand.add("South",jp_secand_south);
		jp_secand_south.setLayout(new GridLayout(3,2));
		jp_secand_south.add(jbtn_one);
		jp_secand_south.add(jbtn_change);
		jp_secand_south.add(jbtn_fcolor);
		jp_secand_south.add(jbtn_ticon);
		jp_secand_south.add(jbtn_x);
		jp_secand_south.add(jbtn_exit);		
		this.setSize(600, 500);
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		MessageRoom mr = new MessageRoom();
//		mr.initDisplay();
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_in) {
			
		}
		
	}

}
