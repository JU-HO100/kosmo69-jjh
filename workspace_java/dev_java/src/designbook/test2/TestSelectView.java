package designbook.test2;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TestSelectView extends JDialog {
	
	SelectEvent sevent = new SelectEvent(this);

	
	JLabel jlb_picture = new JLabel();
	JButton jbtn_take = new JButton("대출하기");
	JButton jbtn_close = new JButton("나가기");
	JLabel jlb_no = new JLabel("Book No.");
	JLabel jlb_noins = new JLabel();
	JLabel jlb_title = new JLabel("제목 : ");
	JLabel jlb_titleins = new JLabel(); 
	JLabel jlb_story = new JLabel("내용 :");
	JTextArea jta_storyins = new JTextArea();
	JLabel jlb_auth = new JLabel("저자 :");
	JLabel jlb_authins = new JLabel(); 
	Font f = new Font("Thoma",Font.BOLD,14);
	
	JPanel jp_center = new JPanel();

	
		TestSearchEvent searche = null;
	public TestSelectView(TestSearchEvent searchEvent) {
		this.searche = searchEvent;
	}
	public TestSelectView() {
		initDisplay();
	}
	public void initDisplay() {
	
		jbtn_take.addActionListener(sevent);
		jbtn_close.addActionListener(sevent);
		jlb_no.setFont(f);
		jlb_noins.setFont(f);
		jlb_title.setFont(f);
		jlb_titleins.setFont(f);
		jlb_story.setFont(f);
		jta_storyins.setFont(f);
		jlb_auth.setFont(f);
		jlb_authins.setFont(f);
		jbtn_take.setFont(f);
		jbtn_close.setFont(f);
		jp_center.setLayout (null);
		
		jbtn_close.setBounds(150, 325, 80, 30);
		jbtn_take.setBounds(10, 325, 100, 30);
		
		jlb_title.setBounds(240, 40, 60, 35);
		jlb_titleins.setBounds(285, 40, 200, 35);
		jlb_auth.setBounds(240, 68, 60, 35);
		jlb_authins.setBounds(285, 68, 200, 35);
		jlb_story.setBounds(240, 96, 60, 35);
		jta_storyins.setBounds(240, 125, 340, 300);
//		searche.jlb_picture.setBounds(35, 40, 165, 250);
		jlb_no.setBounds(240, 10, 120, 35);
		jlb_noins.setBounds(303, 10, 120, 35);
		
		jp_center.add("Center",jbtn_take);
		jp_center.add(jbtn_close);
		jp_center.add(jlb_no);
		jp_center.add(jlb_noins);
		jp_center.add(jlb_title);
		jp_center.add(jlb_titleins);
		jp_center.add(jlb_auth);
		jp_center.add(jlb_authins);
		jp_center.add(jlb_story);
		jp_center.add(jta_storyins);
		jp_center.add(jlb_picture);
		
	//	for(int i=1; )
	//	jp_center.add(jlb_picture+i);
		
		jbtn_close.addActionListener(sevent);
		jbtn_take.addActionListener(sevent);
		this.add(jp_center);
		this.setVisible(true);
		this.setTitle("도서 대출");
		this.setSize(595, 400);
	}
	public static void main(String[] args) {
		TestSelectView sv = new TestSelectView();
		
	}

}
