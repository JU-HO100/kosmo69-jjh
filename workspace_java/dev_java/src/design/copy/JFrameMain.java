package design.copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JFrameMain extends JFrame implements ActionListener {
	//선언
	JPanel jp_c = new JPanel();
	JTextArea jta = new JTextArea();
	JButton jbtn_change = new JButton("화면 변경");
	JButton jbtn_change2 = new JButton("변경 완료");
	Container cont = this.getContentPane();
	/*JPanel은 기본 레이아웃이 FlowLayout 이다.*/
	//화면처리
	public void initDisplay() {
		jbtn_change.addActionListener(this);
		jbtn_change2.addActionListener(this);
		jp_c.setLayout(new BorderLayout());
		jp_c.add(jta);
//		jp_s.add(jbtn_change);
		
		this.add("Center",jp_c);
		this.add("South",jbtn_change);
		this.setTitle("텍스트");
		this.setSize(400,300);
		this.setVisible(true);
	}
	
	//메인메소드
	public static void main(String[] args) {
		JFrameMain jfm = new JFrameMain();
		jfm.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_change) {
			cont.remove(jp_c);/*컨테이너를 이용하면 패널만 삭제하여 패널위에 있는것들만 삭제된다.*/
			cont.remove(jbtn_change);
		}
		JPanel jp_c2 = new JPanel();
		
		jp_c2.setBackground(Color.ORANGE);
		this.add("South",jbtn_change2);
		this.add("Center",jp_c2);
		cont.revalidate();
		if(obj == jbtn_change2) {
			this.dispose();
		}
	}

}
