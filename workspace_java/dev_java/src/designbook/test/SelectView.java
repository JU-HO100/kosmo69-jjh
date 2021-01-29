package designbook.test;

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

public class SelectView extends JDialog {
	
//	SelectEvent sevent = new SelectEvent(this);
	
//	ImageIcon i = new ImageIcon(LoginView.class.getResource("/booksystem/image/1.jpg"));
//	ImageIcon ii2 = new ImageIcon(LoginView.class.getResource("/booksystem/image/2.jpg"));
//	ImageIcon ii3 = new ImageIcon(LoginView.class.getResource("/booksystem/image/3.jpg"));
//	ImageIcon ii4 = new ImageIcon(LoginView.class.getResource("/booksystem/image/4.jpg"));
//	ImageIcon ii5 = new ImageIcon(LoginView.class.getResource("/booksystem/image/5.jpg"));
//	ImageIcon ii6 = new ImageIcon(LoginView.class.getResource("/booksystem/image/6.jpg"));
//	ImageIcon ii7 = new ImageIcon(LoginView.class.getResource("/booksystem/image/7.jpg"));
//	ImageIcon ii8 = new ImageIcon(LoginView.class.getResource("/booksystem/image/8.jpg"));
//	ImageIcon ii9= new ImageIcon(LoginView.class.getResource("/booksystem/image/9.jpg"));
//	ImageIcon ii10= new ImageIcon(LoginView.class.getResource("/booksystem/image/10.jpg"));
//	ImageIcon ii11 = new ImageIcon(LoginView.class.getResource("/booksystem/image/11.jpg"));
//	ImageIcon ii12 = new ImageIcon(LoginView.class.getResource("/booksystem/image/12.jpg"));
//	ImageIcon ii13 = new ImageIcon(LoginView.class.getResource("/booksystem/image/13.jpg"));
//	ImageIcon ii14 = new ImageIcon(LoginView.class.getResource("/booksystem/image/14.jpg"));
//	ImageIcon ii15 = new ImageIcon(LoginView.class.getResource("/booksystem/image/15.jpg"));
//	ImageIcon ii16 = new ImageIcon(LoginView.class.getResource("/booksystem/image/16.jpg"));
//	ImageIcon ii17 = new ImageIcon(LoginView.class.getResource("/booksystem/image/17.jpg"));
//	ImageIcon ii18 = new ImageIcon(LoginView.class.getResource("/booksystem/image/18.jpg"));
//	ImageIcon ii19 = new ImageIcon(LoginView.class.getResource("/booksystem/image/19.jpg"));
//	ImageIcon ii20 = new ImageIcon(LoginView.class.getResource("/booksystem/image/20.jpg"));
//	
//	ImageIcon[] ii= null;
//	for(int a=1; a<21; a++) {
//		ImageIcon ii[a] = new ImageIcon(LoginView.class.getResource("/booksystem/image/" + i +".jpg"));
//	}
//	ImageIcon ii = null;
//	ImageIcon iii = null;
//	ImageIcon ii_1 = new ImageIcon(ii1.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_2 = new ImageIcon(ii2.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_3 = new ImageIcon(ii3.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_4 = new ImageIcon(ii4.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_5 = new ImageIcon(ii5.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_6 = new ImageIcon(ii6.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_7 = new ImageIcon(ii7.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_8 = new ImageIcon(ii8.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_9= new ImageIcon(ii9.getImage().getScaledInstance(165	, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_10= new ImageIcon(ii10.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_11 = new ImageIcon(ii11.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_12 = new ImageIcon(ii12.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_13 = new ImageIcon(ii13.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_14 = new ImageIcon(ii14.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_15 = new ImageIcon(ii15.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_16 = new ImageIcon(ii16.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_17 = new ImageIcon(ii17.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_18 = new ImageIcon(ii18.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_19 = new ImageIcon(ii19.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
//	ImageIcon ii_20 = new ImageIcon(ii20.getImage().getScaledInstance(165, 250, Image.SCALE_SMOOTH));
	
	JLabel jlb_picture = new JLabel();
//	JLabel jlb_picture1 = new JLabel(ii_1);
//	JLabel jlb_picture2 = new JLabel(ii_2);
//	JLabel jlb_picture3 = new JLabel(ii_3);
//	JLabel jlb_picture4 = new JLabel(ii_4);
//	JLabel jlb_picture5 = new JLabel(ii_5);
//	JLabel jlb_picture6 = new JLabel(ii_6);
//	JLabel jlb_picture7 = new JLabel(ii_7);
//	JLabel jlb_picture8 = new JLabel(ii_8);
//	JLabel jlb_picture9 = new JLabel(ii_9);
//	JLabel jlb_picture10 = new JLabel(ii_10);
//	JLabel jlb_picture11 = new JLabel(ii_11);
//	JLabel jlb_picture12 = new JLabel(ii_12);
//	JLabel jlb_picture13 = new JLabel(ii_13);
//	JLabel jlb_picture14 = new JLabel(ii_14);
//	JLabel jlb_picture15 = new JLabel(ii_15);
//	JLabel jlb_picture16 = new JLabel(ii_16);
//	JLabel jlb_picture17 = new JLabel(ii_17);
//	JLabel jlb_picture18 = new JLabel(ii_18);
//	JLabel jlb_picture19 = new JLabel(ii_19);
//	JLabel jlb_picture20 = new JLabel(ii_20);
	
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

	
		SearchEvent searche = null;
	public SelectView(SearchEvent searchEvent) {
		this.searche = searchEvent;
	}
	public SelectView() {
		initDisplay();
	}
	public void initDisplay() {
	
//		jbtn_take.addActionListener(sevent);
//		jbtn_close.addActionListener(sevent);
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
//		
//		jbtn_close.addActionListener(sevent);
//		jbtn_take.addActionListener(sevent);
		this.add(jp_center);
		this.setVisible(true);
		this.setTitle("도서 대출");
		this.setSize(595, 400);
	}
	public static void main(String[] args) {
		SelectView sv = new SelectView();
		
	}

}
