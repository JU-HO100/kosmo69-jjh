package net.tomato_step4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class PictureMessage extends JDialog implements ActionListener{
	//선언
	JPanel jp = new JPanel();
	GridLayout gl = new GridLayout(2,3,3,3);
	ImageIcon imgs[] = new ImageIcon[6];
	JButton jbtn_0 = new JButton(); 
	JButton jbtn_1 = new JButton();
	JButton jbtn_2 = new JButton();
	JButton jbtn_3 = new JButton();
	JButton jbtn_4 = new JButton();
	JButton jbtn_5 = new JButton();
	String imgNames[] = {
						"1.png","2.png","3.png"
						,"4.png","5.png","6.png"
						};
	JButton jbtns[] = {
						jbtn_0,jbtn_1,jbtn_2
						,jbtn_3,jbtn_4,jbtn_5
					  };
	String imgChoice = "default";
	String path = "C:\\workspace_java\\dev_java\\src\\imgs\\";
	
	//생성자
	public PictureMessage() {
		//생성자 안에서 화면처리하기
		initDisplay();
	}
	//화면그리기
	public void initDisplay() {
		jp.setLayout(gl);
		for(int i=0;i<jbtns.length;i++) {//버튼 6개에 대한 배열처리 연습
			imgs[i] = new ImageIcon(path+imgNames[i]);
			jbtns[i].setIcon(imgs[i]);
			jp.add(jbtns[i]);
			jbtns[i].addActionListener(this);
		}
		this.add("Center",jp);
		this.setTitle("이모티콘");
		this.setSize(360,270);
		this.setVisible(false);
	}
	//메인메소드
	public static void main(String[] args) {
//		PictureMessage pm = new PictureMessage();
		new PictureMessage();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 감지되었을 때 호출된다. - 콜백메소드. ajax, 안드로이드
		Object obj = ae.getSource();
//		if(obj == jbtn_0) {
//			imgChoice ="???";
//			System.out.println("선택한 이모티콘===>"+imgChoice);
//		}
		this.imgChoice = path;
		if(obj == jbtn_0) {
			imgChoice = "1.png";
			System.out.println("선택한 이모티콘===>"+imgChoice);
		}
		else if(obj == jbtn_1) {
			imgChoice ="2.png";
			System.out.println("선택한 이모티콘===>"+imgChoice);
		}
		else if(obj == jbtn_2) {
			imgChoice ="3.png";
			System.out.println("선택한 이모티콘===>"+imgChoice);
		}
		else if(obj == jbtn_3) {
			imgChoice ="4.png";
			System.out.println("선택한 이모티콘===>"+imgChoice);
		}
		else if(obj == jbtn_4) {
			imgChoice ="5.png";
			System.out.println("선택한 이모티콘===>"+imgChoice);
		}
		else if(obj == jbtn_5) {
			imgChoice ="6.png";
			System.out.println("선택한 이모티콘===>"+imgChoice);
			
		}
	}

}
