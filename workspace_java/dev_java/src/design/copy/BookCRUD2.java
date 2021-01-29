package design.copy;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import design.book.BookManager;
import design.book.BookVO;

public class BookCRUD2 extends JDialog implements ActionListener{//팝업창을 띄운다.
		  JLabel       jlb_name 	= new JLabel("책제목");
		  JTextField    jtf_name    = new JTextField(30);
		  JLabel       jlb_author 	= new JLabel("저자");
		  JTextField    jtf_author  = new JTextField(40);
		  JLabel       jlb_publish  = new JLabel("출판사");
		  JTextField   jtf_publish  = new JTextField(50);
		  JLabel       jlb_info 	= new JLabel("도서소개");
		  JTextArea    jta_info 	= new JTextArea(8,25);
		  JButton      jbtn_file 	= new JButton("파일찾기");
		  JTextField    jtf_file 	= new JTextField(35);
		  JLabel      jlb_img    	= new JLabel("이미지");
		  JPanel jp_center 		 	= new JPanel();
		  JPanel jp_south  		 	= new JPanel();
		  JButton jbtn_save    	 	= new JButton("저장");
		  JButton jbtn_close   	 	= new JButton("닫기");
		  JScrollPane jsp 			= new JScrollPane(jp_center);
		  JScrollPane jsp_info 		= new JScrollPane(jta_info);
		  JFileChooser jfc 			= new JFileChooser();
		  Container cont 			= this.getContentPane();
		  String title 			 	= null;
		  static BookManager bm 	= null;
		  BookVO bVO 				= null;
		  
//		  BookCRUD bCRUD 			= new BookCRUD();
		  
		  public BookCRUD2() {
			  jbtn_file.addActionListener(this); 
			  jbtn_save.addActionListener(this); 
			  jbtn_close.addActionListener(this); 
			  initDisplay();
	}
		  /*수정하기와 상세보기 처리시에는 오라클 서버를 먼저 경유하므로 rbVO가 null이 아님.
		   *set메소드의 파라미터로 넘어온 값을 이용하여 화면을 초기화 한다.*/
		  public void setValue(BookVO rbVO) {
			  /*사용자가 입력을 선택한 경우을 위한 화면 설정 -모든 값을 빈 문자열로 셋팅*/
			  if(bVO == null) {
				  setName("");
				  setAuthour("");
				  setpublish("");
				  setInfo("");
			  }
			  /*상세조회 혹은 수정시는 파라미터로 받은 값으로 셋팅을 한다.*/
			  else {
				  setName(rbVO.getB_name());
				  setAuthour(rbVO.getAuthor());
				  setpublish(rbVO.getPublish());
				  setInfo(rbVO.getB_info());
				  
			  }
		  }
		    @Override
		      public void actionPerformed(ActionEvent ae) {
		    	jfc.setCurrentDirectory(new File("C:\\workspace_java\\dev_java\\src")); 
		         Object obj = ae.getSource();
		         if(obj == jbtn_save) {
		        	 //입력일 때
		        	 /*this.getTiTle() 타이틀로 확인하는 방법*/
		        	 if(bVO == null) {
		        		 BookVO pbVO = new BookVO();
		        		 pbVO.setB_name(getName());
		        		 pbVO.setAuthor(getAuthor());
		        		 pbVO.setPublish(getpublish());
		        		 pbVO.setB_info(getInfo());
//		        		 pbVO.setB_IMG(get);
		        		 int result = 0;
		        		 result = bm.bmeh.bookInsert(pbVO);
		        		 System.out.println("result:"+result);
		        		 this.dispose();
		        		 if(result==1) {
		        		 bm.refreshData();
		        		 }
		        	 }
		        	 //수정일 때
		        	 else if(bVO != null) {
		        		 
		        	 }
		        	 
		         }
		         if(obj == jbtn_close) {
		        	 this.dispose();
		         }
		         
		         if(obj == jbtn_file) {//너 파일 찾기 버튼 누른거야?
		            //insert here - 파일 찾기 다이얼로그 창 호출하기
		            
		            //열기 대화상자를 오픈한다.
		            int inRet = jfc.showOpenDialog(BookCRUD2.this);
		            //yes 혹은 ok버튼이 눌린 거야
		            if(inRet == JFileChooser.APPROVE_OPTION) {
		               //파일 여는 처리를 수행한다. - 항상 예외상황이 발생할 수 있으므로 try..catch해주어야 함.
		               try {
		                  System.out.println("선택했을 경우....");
		                  //읽어들이기 용 String 객체 선언
		                  String strLine = null;
		                  //FileChooser로 선택된 파일을 File객체에 대입
		                  File myFile = jfc.getSelectedFile();
		                  //선택된 파일의 절대경로를 지정하여 BufferedReader객체를 작성
		                  BufferedReader br = new BufferedReader(
		                        new FileReader(myFile.getAbsolutePath()));
		                  System.out.println(myFile.getAbsolutePath());
		                  //insert here - JLabel에 도서이미지 출력하기
		                  jtf_file.setText(myFile.getAbsolutePath());
		                  //이미지 미리보기 시작 처리
		                  ImageIcon originIcon = new ImageIcon(myFile.getAbsolutePath());
		                  //ImageIcon에서 Image를 추출하기
		                  Image originImg = originIcon.getImage();
		                  //추출된 이미지의 크기를 조절하여 새로운 Image객체 생성
		                  Image changeImg = originImg.getScaledInstance(300, 380, Image.SCALE_SMOOTH);
		                  //새로운 Image로 ImageIcon객체를 생성
		                  ImageIcon icon = new ImageIcon(changeImg);
		                  jlb_img.setIcon(icon);
		                  //revalidate는 새 구성 요소가 추가되거나 이전 요소가 제거되면 컨테이너에서 호출됨.
		                  //이 호출은 레이아웃 관리자에게 새 구성 요소 목록을 기반으로 재설정하도록 지시하는 명령임.
		                  cont.revalidate();
		               } catch (Exception e2) {
		                  // TODO: handle exception
		               }
		            }            
		            ///////////////////////////////////////
		         }///////////////////////////////end of jbtn_file
		      }///////////////////////////////////end of actionPerformed
	//부모창에서 결정된 내용들을 팝업창에서 사용하기 위한 메소드 선언하기
	public void set(String title, BookVO bVO, BookManager bm, boolean enable) {
			  JOptionPane.showMessageDialog(this, "title:"+title);
			  this.setTitle(title);
			  this.bVO = bVO;/*상세보기와 수정하기의 경우 1건을 먼저 조회해야 한다. */
			  setValue(bVO);//여기서 화면에 대한 초기화에 필요한 메소드를 호출하게 된다.
			  this.bm = bm;/*수정과 입력이 성공 하였을 경우 팝업창은 닫아주고 부모창은 새로고침 처리한다. 
			  				- 따라서 부모의 주소번지가 필요하다. */
			  this.setTitle(title);
			  this.setEditable(enable);
		  }
		  public void setEditable(boolean e) {
			  jtf_name.setEditable(e);
			  jtf_author.setEditable(e);
			  jtf_publish.setEditable(e);
			  jta_info.setEditable(e);
			  jtf_name.setText("");
			  
		  }
	public void initDisplay() { 
	      jta_info.setLineWrap(true);
	      jp_center.setLayout(null);
	      jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
	      jp_south.add(jbtn_save);
	      jp_south.add(jbtn_close);
	      jlb_name.setBounds(20, 20, 100, 20);
	      jtf_name.setBounds(120, 20, 300, 20);
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
	      jp_center.add(jlb_name);
	      jp_center.add(jtf_name);
	      jp_center.add(jlb_author);
	      jp_center.add(jtf_author);
	      jp_center.add(jlb_publish);
	      jp_center.add(jtf_publish);
	      jp_center.add(jlb_info);
	      jp_center.add(jsp_info);
	      jp_center.add(jbtn_file);
	      jp_center.add(jtf_file);
	      jp_center.add(jlb_img);
	      jp_south.add(jbtn_save);
	      jp_south.add(jbtn_close);
	      this.add("South",jp_south);
	      this.add("Center",jsp);
	      this.add("Center",jp_center);
		  this.setLocation(750,200);
		  this.setSize(500, 720);
		  
//	      this.setVisible(true);
	}
	/*화면에 대한 setter와 getter 처리하기*/
	public void setName(String b_name) {jtf_name.setText(b_name);}
	public String getName() {return jtf_name.getText();}
	public void setAuthour(String b_author) {jtf_author.setText(b_author);}
	public String getAuthor() {return jtf_name.getText();}
	public void setInfo(String b_info) {jtf_author.setText(b_info);}
	public String getInfo() {return jtf_name.getText();}
	public void setpublish(String b_publish) {jtf_author.setText(b_publish);}
	public String getpublish() {return jtf_name.getText();}
	//메인메소드
//	public static void main(String args[]) {		 
//		new BookCRUD().initDisplay();
//		
//		
//	}


}
