package design.test;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/*class에 대한 이야기
 * 인스턴스화 할수 있다. (A a = new A(), A a = methodA())
 * 인스턴스 변수를 활용하여 변수사용[전역변수] 및 메소드 호출(활용)을[파라미터, 리턴타입]-메소드 오버로딩 할수 있다.
 * UI부분과 업무처리 부분을 나눈다.
 * 화면과 로직을 분리해야 한다.
 * 2년차 미만의 개발자들의 업무 
 * 화면과 이벤트 처리   - 50% (소통->엄무시작->리턴타입과 파라미터)
 * 업무내용 		- 20% (업무에 대한 복잡도-조인이 거의 없거나 단순 조인문장)
 * DB연동및 업무처리   - 30%
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Exam1 extends JFrame implements ActionListener {
	//선언부 - 주의 선언부에서 메소드 호출이나 값에 대한 재정의는 불가능하다.
	//테이블 추가하기 - 생성버튼이 눌렸을때 생성되야 한다. -아직 값이 정해지지 않았다.
	JTable jtb_list 		   = null;//테이블 양식 만들기
	JScrollPane jsp_list 	   = null;//스크롤바를 생성하기 - JTable
	DefaultTableModel dtm_list = null;//테이블 안에 들어갈 데이터 설정하기
	String 		  		cols[] = {"성명","자바","오라클","HTML","총점","평균","석차"};
	String 			  data[][] = null;
	JPanel jp_center 	 	   = new JPanel();
	JPanel jp_north 	 	   = new JPanel();
	JPanel jp_south 	  	   = new JPanel();
	JPanel jp_east 	 	 	   = new JPanel();
	JPanel jp_west 	 	 	   = new JPanel();
	JButton jbtn_create  	   = new JButton("생성");
	JButton jbtn_account 	   = new JButton("처리");
	JButton jbtn_exit 	 	   = new JButton("종료");
	JTextField jtf_inwon 	   = new JTextField();//화면이 열리자마나 보여져야 하니까 한번에 생성
	int inwon = 0;
	//화면을 갱신할때는 Container를 활용하자
	Container cont = this.getContentPane();
	//생성자
	public Exam1() {
	
	}
	//화면처리부
	public void initDisplay() {
		jbtn_create.addActionListener(this);//버튼을 누르는 이벤트가 있을때 반응(감지)할수 없다.?
		jbtn_account.addActionListener(this);//acionPerformed호출 -사용자가 눌렀을때
		jbtn_exit.addActionListener(this);//acionPerformed호출 -사용자가 눌렀을때
		//속지의 레이아웃을 BorderLayout으로 해야 한다. center에 jtf_inwon을 jbtn_creare를 담기
		//북쪽
		jp_north.setLayout(new BorderLayout());
		jp_north.add("Center", jtf_inwon);
		jp_north.add("East", jbtn_create);
		//남쪽
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT)); 
		jp_south.add("Center",jbtn_account);
		jp_south.add("East",jbtn_exit);
		this.add("North",jp_north);
		this.add("South",jp_south);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	//성적처리 메소드 구현 - 업무처리 - 알고리즘 공부해라
	public void account() {
		System.out.println("성적처리 메소드 호출 성공");
	}
	//메인메소드 = 메인 스레드이다. 라이프사이클 관리 start(생성) service(활동) destroy(끝낸다)
	public static void main(String[] args) {
		//생각해볼 문제:initDisplay()를 메인메소드에서 호출하는 것과 생성자에서 호출하는것
		//사이에는 어떤 차이가 있는 걸까?
		Exam1 e1 = new Exam1();
		e1.initDisplay();
		

	}
	//오버라이드 - 두 클래스가 서로 상속관계 이거나 인터페이스를 구현하는 '구현체 클래스' 이라면
	//		      구현하는 구현체 클래스 이라면반드시 재정의 해야 한다.
	@Override
	public void actionPerformed(ActionEvent e) { //생성자가 없으면 actionPerformed가 호출이 되지 않는다.
//		JButton obj = (JButton)e.getSource();//이렇게 할수도 있지만 반복되는 코드에 쓰면 안된다. (작업량이 늘어남)
		Object obj = e.getSource();//여기에 모든것을 담으려면 상위 클래스가 되어야한다.
		if(obj == jbtn_account) {
			//사용자가 입력한 정보를 수집.
			account();
		}
		else if(obj == jbtn_exit) {
			System.exit(0);//자바가상머신과 어플사이의 연골고리를 끊는다. - 스레드를 반남, 메모리 회수, 다시 사용불가
		}
		else if(obj == jbtn_create) {//너 생성버튼 누른거야?
			System.out.println("생성버튼 호출 성공");
			try {
				inwon = Integer.parseInt(jtf_inwon.getText());
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(this, "숫자만 입력하세요.");
				jtf_inwon.setText("");
				return;//actionPerformed를 빠져나감.
			}
			//
			jtf_inwon.setEnabled(false);
			jbtn_create.setEnabled(false);
			dtm_list = new DefaultTableModel(data,cols);
			jtb_list = new JTable(dtm_list);//디폴트 생성자
			jsp_list = new JScrollPane(jtb_list
            		, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                    , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			cont.add("Center",jsp_list);
			cont.revalidate();
			this.setLocation(100,100);//위치를 잡아줄때 쓰는 좌표값이다.
			this.pack();
		}
	}
}
