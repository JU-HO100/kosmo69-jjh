package Team;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import bookingmovie2.MovieEvent;
import bookingmovie2.PayDAO;

public class Pay extends JDialog {
	//선언
	JFrame jf = new JFrame();
	JFrame jf2 = new JFrame();
	JPanel jp_c = new JPanel();
	JPanel jp_c2 = new JPanel();
	JPanel jp_s = new JPanel();
	JPanel jp_s2 = new JPanel();
	JLabel jlb_num = new JLabel("예매번호");
	JLabel jlb_movie = new JLabel("영화제목");
	JLabel jlb_day = new JLabel("날짜|시간");
	JLabel jlb_seat = new JLabel("좌석번호");
	JLabel jlb_pay = new JLabel("결제금액");
	JLabel jlb_way = new JLabel("결제방법");
	JButton jbtn_in = new JButton("확인");
	JTextArea jta_num = new JTextArea();
	JTextArea jta_movie = new JTextArea();
	JTextArea jta_day = new JTextArea();
	JTextArea jta_seat = new JTextArea();
	JTextArea jta_pay = new JTextArea();
	JButton jbtn_cance = new JButton("취소");
	JButton jbtn_close = new JButton("닫기");
	String pay[] = {"결제방법","카드","핸드폰","무통장입금"};
	Font f = new Font("휴먼매직체",Font.BOLD,18);
	Font g = new Font("휴먼매직체",Font.BOLD,16);
	JComboBox jcb_pay = new JComboBox(pay);
	PayDAO pDAO = new PayDAO(this);
	MovieEvent me = null;
	
	
	
	//생성
	public Pay() {
	}
	
	public Pay(MovieEvent movieEvent) {
		this.me = movieEvent;
	}

	//결제화면
	public void initDisplay() {
		jbtn_in.addActionListener(me);
		jbtn_cance.addActionListener(me);
		//라벨
		jp_c.setLayout(null);
		jlb_num.setBounds(20, 20, 70, 40);
		jlb_num.setFont(f);
		jlb_movie.setBounds(20, 70, 70, 40);
		jlb_movie.setFont(f);
		jlb_day.setBounds(20, 120, 80, 40);
		jlb_day.setFont(f);
		jlb_seat.setBounds(20, 170, 70, 40);
		jlb_seat.setFont(f);
		jlb_pay.setBounds(20, 220, 70, 40);
		jlb_pay.setFont(f);
		jlb_way.setBounds(20, 270, 70, 40);
		jlb_way.setFont(f);
		jcb_pay.setBounds(120,280,200,20);
		//받아온 결제정보
		jta_num.setBounds(130, 20, 150, 30);
		jta_num.setFont(g);
		jta_movie.setBounds(130, 70, 150, 30);
		jta_movie.setFont(g);
		jta_day.setBounds(130, 120, 150, 30);
		jta_day.setFont(g);
		jta_seat.setBounds(130, 170, 150, 30);
		jta_seat.setFont(g);
		jta_pay.setBounds(130, 220, 150, 30);
		jta_pay.setFont(g);
		
		
		
		//텍스트 에어리어 자동 줄 바꿈
        jta_seat.setColumns(10);
        jta_seat.setRows(1);
        jta_seat.setLineWrap(true);//꽉차면 다음줄로 가게 해줌.
        jta_seat.setWrapStyleWord(true);
        //텍스트 에어리어 자동 줄 바꿈
        
        //텍스트 에어리어 입력 방지
        jta_num.setEditable(false);
        jta_movie.setEditable(false);
        jta_day.setEditable(false);
        jta_pay.setEditable(false);
        //텍스트 에어리어 입력 방지
		//라벨
		jp_c.add(jlb_num);
		jp_c.add(jlb_movie);
		jp_c.add(jlb_day);
		jp_c.add(jlb_seat);
		jp_c.add(jlb_pay);
		jp_c.add(jlb_way);
		jp_c.add(jta_num);
		jp_c.add(jta_movie);
		jp_c.add(jta_day);
		jp_c.add(jta_seat);
		jp_c.add(jta_pay);
		//결제 방법
		jp_c.add(jcb_pay);
		//버튼 주입
		jp_s.add(jbtn_in);
		jp_s.add(jbtn_cance);
		//패널 , 타이틀
		jf.add("Center",jp_c);
		jf.add("South",jp_s);
		jf.setTitle("결제화면");
		jf.setSize(380,400);
		jf.setVisible(true);
	}
	public void clear() {
		jbtn_close.addActionListener(me);
		jp_c2.setLayout(null);
		//라벨
		jlb_num.setBounds(20, 20, 70, 40);
		jlb_num.setFont(f);
		jlb_movie.setBounds(20, 70, 70, 40);
		jlb_movie.setFont(f);
		jlb_day.setBounds(20, 120, 80, 40);
		jlb_day.setFont(f);
		jlb_seat.setBounds(20, 170, 70, 40);
		jlb_seat.setFont(f);
		jlb_pay.setBounds(20, 220, 70, 40);
		jlb_pay.setFont(f);
		//받아온 결제 정보
		jta_num.setBounds(130, 20, 150, 30);
		jta_num.setFont(g);
		jta_movie.setBounds(130, 70, 150, 30);
		jta_movie.setFont(g);
		jta_day.setBounds(130, 120, 150, 30);
		jta_day.setFont(g);
		jta_seat.setBounds(100, 170, 210, 30);
		jta_seat.setFont(g);
		jta_pay.setBounds(130, 220, 150, 30);
		jta_pay.setFont(g);
		//버튼위치
//		jbtn_close.setBounds(300,20,70,30);
		
		//텍스트 에어리어 입력 방지
        jta_num.setEditable(false);
        jta_movie.setEditable(false);
        jta_day.setEditable(false);
        jta_pay.setEditable(false);
        //텍스트 에어리어 입력 방지
		
		//라벨
		jp_c2.add(jlb_num);
		jp_c2.add(jlb_movie);
		jp_c2.add(jlb_day);
		jp_c2.add(jlb_seat);
		jp_c2.add(jlb_pay);
		//텍스트에리어
		jp_c2.add(jta_num);
		jp_c2.add(jta_movie);
		jp_c2.add(jta_day);
		jp_c2.add(jta_seat);
		jp_c2.add(jta_pay);
		//버튼
		jp_s2.add(jbtn_close);	
		//패널,테이블
		jf2.add("Center",jp_c2);
		jf2.add("South",jp_s2);
		jf2.setTitle("예매 내역");
		jf2.setSize(350,350);
		jf2.setVisible(true);
	}
	
	
	
	//메인 메소드
//	public static void main(String[] args) {
//		Pay p = new Pay();
//		p.initDisplay();
////		p.clear();
//	}


}
