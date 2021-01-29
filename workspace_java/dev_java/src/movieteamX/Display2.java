package movieteamX;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class Display2 extends JFrame implements ActionListener{
   String imgPath 	  = "C:\\workspace_java\\rentCar\\src\\teammovie\\";
   ImageIcon iicon 	  = new ImageIcon(imgPath+"0s.png");
   //선언부
   JPanel jp_center   = new JPanel();
   JPanel jp_south	  = new JPanel();
   JPanel jp_east 	  = new JPanel();
   JPanel jp_west 	  = new JPanel();
   JPanel jp_north 	  = new JPanel();
   JLabel id_lb  	  = new JLabel("I D");
   JTextField id_t 	  = new JTextField(50);
   JLabel pw_lb 	  = new JLabel("P W");
   JTextField pw_t 	  = new JTextField(50);
   JButton enter_b 	  = new JButton("로그인");
   JButton movie1_ib  = new JButton("영화정보1");
   JButton movie2_ib  = new JButton("영화정보2");
   JButton movie3_ib  = new JButton("영화정보3");
   JButton movie1_cb  = new JButton("영화결제1");
   JButton movie2_cb  = new JButton("영화결제2");
   JButton movie3_cb  = new JButton("영화결제3");
   JButton x 		  = new JButton("x");
   JButton x2 		  = new JButton("x");
   JButton x3 		  = new JButton("x");
   JLabel movie1_pl   = new JLabel();
   JLabel movie2_pl   = new JLabel();
   JLabel movie3_pl   = new JLabel();
   JTextArea movie_il = new JTextArea();
   
   
   JTextField date_t  = new JTextField();
   JPanel jp_center2  = new JPanel();
   
   JLabel scr_l 	  = new JLabel("스크린");
   JButton back 	  = new JButton("뒤로가기");
   JButton home 	  = new JButton("홈화면");
   JButton pya_b 	  = new JButton("결제");
   JScrollPane jsp_zipcode = new JScrollPane(pya_b, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
         ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    Font f 			  = new Font("휴면매직체",Font.BOLD, 5);
////////////////////////////////////////메뉴바//////////////////////////////////////////
      JMenuBar jmb = new JMenuBar();
      JMenu menu = new JMenu("메뉴");
      JMenuItem home_m = new JMenuItem("홈");
      JMenuItem back_m = new JMenuItem("뒤로");
      JMenuItem logout_m = new JMenuItem("로그아웃");
      JMenuItem exit_m = new JMenuItem("나가기");
      JMenuItem movie = new JMenuItem("상영영화");
      JMenuItem a = new JMenuItem(" ");
      JMenuItem b = new JMenuItem(" ");
      JMenuItem c = new JMenuItem(" ");
      JMenu jm_help = new JMenu("도움말 (H)");
      JMenuItem producer = new JMenuItem("제작자");
      
      

   class MyPicture extends JPanel{
         public void paintComponent (Graphics g) {
            g.drawImage(iicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
            
         }
      }
      //생성부
      public Display2() {
         
      }
      
      public void initDisplay2() {//영화선택창
         //setContentPane(new MyPicture());
         
         ImageIcon p1 = new ImageIcon("C:\\workspace_java\\rentCar\\src\\teammovie\\s1.jpg"); 
         Image im = p1.getImage();
         Image cim = im.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
         ImageIcon icon2 = new ImageIcon(cim);
         JLabel movie1_pl = new JLabel(icon2);
   
         ImageIcon p2 = new ImageIcon("C:\\workspace_java\\rentCar\\src\\teammovie\\s2.jpg"); 
         Image im2 = p2.getImage();
         Image cim2 = im2.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
         ImageIcon icon3 = new ImageIcon(cim2);
         JLabel movie2_pl = new JLabel(icon3);
         
         ImageIcon p3 = new ImageIcon("C:\\workspace_java\\rentCar\\src\\teammovie\\s3.jpg"); 
         Image im3 = p3.getImage();
         Image cim3 = im3.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
         ImageIcon icon4 = new ImageIcon(cim3);
         JLabel movie3_pl = new JLabel(icon4);

         this.setLayout(null);
            
         movie1_ib.addActionListener(this);
         movie2_ib.addActionListener(this);
         movie3_ib.addActionListener(this);
         movie3_ib.addActionListener(this);
         movie1_cb.addActionListener(this);
         movie2_cb.addActionListener(this);
         movie3_cb.addActionListener(this);
         x.addActionListener(this);
         x2.addActionListener(this);
         x3.addActionListener(this);
         
         movie1_ib.setBounds(100, 500, 100, 20);
         movie1_cb.setBounds(250, 500, 100, 20);
         movie2_ib.setBounds(500, 500, 100, 20);
         movie2_cb.setBounds(650, 500, 100, 20);
         movie3_ib.setBounds(900, 500, 100, 20);
         movie3_cb.setBounds(1050, 500, 100, 20);
         x.setBounds(350,50,40,20);
         x2.setBounds(750,50,40,20);
         
         this.add(x);
         this.add(x2);
         this.add(x3);
         this.add(movie1_ib);
         this.add(movie1_cb);
         this.add(movie2_ib);
         this.add(movie2_cb);
         this.add(movie3_ib);
         this.add(movie3_cb);
         this.add(movie_il);
         this.add(movie1_pl);
         this.add(movie2_pl);
         this.add(movie3_pl);
         movie1_pl.setBounds(70, 50, 300, 400);
         movie2_pl.setBounds(470, 50, 300, 400);
         movie3_pl.setBounds(870, 50, 300, 400);
         
         
         
         this.setSize(1250,600);
      //   this.setLocation(1200,600);
         this.setVisible(true);
         x.setVisible(false);
         x2.setVisible(false);
         setResizable(false);
         this.add("Center",jp_center);
      

      }
      public void initDisplay3() {//영화예매창1(시간)
         
         
         home.addActionListener(this);
         back.addActionListener(this);
         pya_b.addActionListener(this);
         //jp_south.setLayout(null);
         jp_north.add(scr_l);
         jp_south.add("Center", pya_b);
         jp_south.add("East", home);
         jp_south.add("East", back);
         
         back.setBounds(500, 300, 50, 20);
         home.setBounds(500, 200, 100, 20);
         pya_b.setBounds(500,100 , 100, 20);
         
         this.add("North",jp_north);   
         this.add("South",jp_south);   
         this.setSize(1200,600);
         this.setVisible(true);
         setResizable(false);
      }
      public void initDisplay4() {//영화예매창2(좌석정보)
         
         this.setSize(1200,600);
         this.setVisible(true);
         setResizable(false);
      }
      public void initDisplay5() {//발표
         
      }
      
      //메인 메소드
      public static void main(String[] args) {
    	  Display2 d2 = new Display2();
    	  d2.initDisplay2();
      }
      
      ///////////////////////////이벤트처리
      @Override
      public void actionPerformed(ActionEvent e) {
         Display2 d = new Display2();
         Object obj = e.getSource();
         
         if(obj == movie1_ib) {
            System.out.println("호출");
            x.setBounds(320,430,50,20);
            movie_il.setText("");
            movie_il.setBounds(70, 50, 300, 400);
            movie_il.append("태국에서 충격적인 납치사건이 발생하고\n" + 
         " 마지막 청부살인 미션을 끝낸 암살자 인남(황정민)은\n"+
         " 그것이 자신과 관계된 것임을 알게 된다.\n" + 
         " 인남은 곧바로 태국으로 향하고, 조력자 유이(박정민)를 만나\n"+ "사건을 쫓기 시작한다.\n" + 
         " 한편, 자신의 형제가 인남에게 암살당한 것을 알게 된 레이(이정재).\n" + 
         " 무자비한 복수를 계획한 레이는 인남을 추격하기 위해 태국으로 향하는데...\n" + 
         " \n" + 
         " 처절한 암살자 VS 무자비한 추격자\n" + 
         " 멈출 수 없는 두 남자의 지독한 추격이 시작된다!");
            
            movie_il.setVisible(true);            
            x .setVisible(true);
            x2.setVisible(false);
            x3.setVisible(false);
         //   movie1_ib.setVisible(false);
         }else {
        	 movie_il.setVisible(false);
        	 x.setVisible(false);
         }
         if (obj == movie2_ib) {
            x2.setBounds(720,430,50,20);
            movie_il.setText("");
            movie_il.setBounds(470, 50, 300, 400);
            movie_il.setText("남북미 정상회담 중, 북한 내 쿠데타로 세 정상이 납치된다!\n" + 
                  "북미 평화협정 체결을 위한 대한민국 대통령(정우성),\n" + 
                  "북한의 최고지도자인 위원장(유연석)과 미국 대통령(앵거스 맥페이든)간의 남북미 정상회담이\n" + 
                  "북한 원산에서 열린다. 북미 사이 좀처럼 이견이 좁혀지지 않는 가운데,\n" + 
                  "핵무기 포기와 평화체제 수립에 반발하는 북 호위총국장(곽도원)의 쿠데타가 발생하고,\n" + 
                  "납치된 세 정상은 북한 핵잠수함에 인질로 갇힌다. \n" + 
                  "그리고, 좁디 좁은 함장실 안, 예기치 못한 진정한 정상회담이 벌어지게 되는데…\n" + 
                  "\r\n" + 
                  " 동북아시아의 운명이 핵잠수함에 갇혔다!\n" + 
                  " 과연, 남북미 세 지도자는 전쟁 위기를 막을 수 있을 것인가?\n");
         //   movie_il.setVisible(true);
            movie_il.setVisible(true);   
            x2.setVisible(true);
            x.setVisible(false);
            x3.setVisible(false);
            //movie2_pl.setVisible(false);
            //movie3_pl.setVisible(false);
         }
         if (obj == movie3_ib) {
            x3.setBounds(1120,430,50,20);
            movie_il.setText("");
            movie_il.setBounds(870, 50, 300, 400);
            movie_il.setText("머나먼 사막 속 신비의 아그라바 왕국의 시대.\r\n" + 
                  " 좀도둑 ‘알라딘’은 마법사 ‘자파’의 의뢰로 마법 램프를 찾아 나섰다가\r\n" + 
                  " 주인에게 세 가지 소원을 들어주는 지니를 만나게 되고,\r\n" + 
                  " 자스민 공주의 마음을 얻으려다 생각도 못했던 모험에 휘말리게 되는데…");
            movie_il.setVisible(true);
            movie1_pl.setVisible(false);
            x3.setVisible(true);
            x2.setVisible(false);
            x.setVisible(false);
         }
         if(obj == x) {
            movie_il.setVisible(false);
            x.setVisible(false);
         }
         if(obj == x2) {
            movie_il.setVisible(false);
            x2.setVisible(false);
         }
         if(obj == x3) {
            movie_il.setVisible(false);
            x3.setVisible(false);
         }
   /*      if(obj == movie1_cb) {
        	 
        	 mvr.setVisible(true);
        	 movie_il.setVisible(false);
        	 
         }
         if(obj == movie1_cb) {
        	 mvr.initDisplay();
        	 mvr.setVisible(true);
        	 movie_il.setVisible(false);
        	 
         }
         if(obj == movie2_cb) {
        	 mvr2.initDisplay();
        	 mvr2.setVisible(true);
        	 movie_il.setVisible(false);
        	 
         }
         if(obj == movie3_cb) {
        	 mvr3.initDisplay();
        	 mvr3.setVisible(true);
        	 movie_il.setVisible(false);
        	 
         }*/
        
        	 
         
      }
      	
   
	
}
