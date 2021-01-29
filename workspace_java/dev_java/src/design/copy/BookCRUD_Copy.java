package design.copy;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import design.book.BookVO;

public class BookCRUD_Copy extends JDialog implements ActionListener {
		 JLabel       jlb_title 	 = new JLabel("책제목");
		 JTextField    jtf_title   = new JTextField(30);
		 JLabel       jlb_author 	 = new JLabel("저자");
		 JTextField    jtf_author  = new JTextField(40);
		 JLabel       jlb_publish  = new JLabel("출판사");
		 JTextField   jtf_publish  = new JTextField(50);
		 JLabel       jlb_info 	 = new JLabel("도서소개");
		 JTextArea    jta_info 	 = new JTextArea(8,25);
		 JButton      jbtn_file 	 = new JButton("파일찾기");
		 JTextField    jtf_file 	 = new JTextField(35);
		 JLabel      jlb_img    	 = new JLabel("이미지");
		 JPanel jp_center 		 = new JPanel();
		 JPanel jp_south  		 = new JPanel();
		 JButton jbtn_save    	 = new JButton("저장");
		 JButton jbtn_close   	 = new JButton("닫기");
		 JScrollPane jsp 			 = new JScrollPane(jp_center);
		 JScrollPane jsp_info 	 = new JScrollPane(jta_info);
		 String title 			 = null;
		 BookVO bVO 				 = null;
		 BookCRUD2 bCRUD 			 = null;
		 JFileChooser jfc 		 = new JFileChooser();
	   
	public void initDisplay() { 
		jbtn_file.addActionListener(this);
	    jta_info.setLineWrap(true);
	    jp_center.setLayout(null);
	    jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
	    jp_south.add(jbtn_save);
	    jp_south.add(jbtn_close);
	    jlb_title.setBounds(20, 20, 100, 20);
	    jtf_title.setBounds(120, 20, 300, 20);
	    jlb_author.setBounds(20, 45, 100, 20);
	    jtf_author.setBounds(120, 45, 150, 20);
	    jlb_publish.setBounds(20, 70, 100, 20);
	    jtf_publish.setBounds(120, 70, 200, 20);
	    jlb_info.setBounds(20, 95, 100, 20);
	    jsp_info.setBounds(120, 95, 300, 120);
	    jbtn_file.setBounds(20, 220, 90, 20);
	    jtf_file.setBounds(120, 220, 300, 20);
	    jlb_img.setBorder(BorderFactory.createEtchedBorder());
	    jlb_img.setBounds(120, 245, 300, 380);
	    //jlb_img.setIcon(new ImageIcon(path+"1.jpg"));
	    jp_center.add(jlb_title);
	    jp_center.add(jtf_title);
	    jp_center.add(jlb_author);
	    jp_center.add(jtf_author);
	    jp_center.add(jlb_publish);
	    jp_center.add(jtf_publish);
	    jp_center.add(jlb_info);
	    jp_center.add(jsp_info);
	    jp_center.add(jbtn_file);
	    jp_center.add(jtf_file);
	    jp_center.add(jlb_img);
	    this.add("Center",jsp);
	    this.add("South",jp_south);
	    this.setSize(500, 720);
	    this.setLocation(750,200);
	    this.setTitle("너가 갖고 싶은 도끼가 이 금도끼냐"); //외부에서 바꿔야 한다.
	    this.setVisible(true);
	}
	/*화면에 대한 setter와 getter 처리하기*/
	public void setTitle(String b_name) {jtf_title.setText(b_name);}
	public String getTitle() {return jtf_title.getText();}
	public void setAuthour(String b_author) {jtf_author.setText(b_author);}
	public String getAuthor() {return jtf_title.getText();}
	public void setInfo(String b_info) {jtf_author.setText(b_info);}
	public String getInfo() {return jtf_title.getText();}
	public void setpublish(String b_publish) {jtf_author.setText(b_publish);}
	public String getpublish() {return jtf_title.getText();}
	//메인메소드
	public static void main(String args[]) {
		new BookCRUD_Copy().initDisplay();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_file) {
			/*열기 대화상자 오픈*/
			int inRet = jfc.showOpenDialog(BookCRUD_Copy.this);
			/*yes 혹은 ok이 버튼이 눌린거야.*/
			if(inRet == JFileChooser.APPROVE_OPTION) {
				/*파일 여는 처리를 수행한다. - 항상 예외상황이 발생할 수 있음으로 try..catch해주어야함.*/
				try {
					System.out.println("선택했을경우..");
					/*읽어들이기 용 String 객체 선언*/
					String strLine = null;
					/*FileChooser로 선택된 파일을 File객체에 대입*/
					File myFile = jfc.getSelectedFile();
					/*선택된 파일의 절대경로를 지정하여 BufferedReader객체를 작성*/
					BufferedReader br = new BufferedReader(
										new FileReader(myFile.getAbsolutePath()));
					System.out.println(myFile.getAbsolutePath());
				} catch (Exception e2) {
					
				}
			}
		
		
		}
	}

}
