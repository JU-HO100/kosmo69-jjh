package book.ch5;

import javax.swing.JButton;
import javax.swing.JFrame;
//오늘부터는 되도록이면 메인 메소드에 코딩을 하지 않는다.
//한번에 어렵다면 조금씩 부피를 줄여본다.
//생성자는 의존관계를 실제로 표현할 수 있다.(활용할 수 있다.) - 클래스 쪼개기 연습시 꼭 활용해 볼것.
//static은 사용하지 말것.(서버 다운을 유발할 수 있다.)
//while문은 증감연산자 i=i+1; , break;를 꼭 써야한다.(서버 다운을 유발할 수 있다.)
//for문안에 break;을 꼭 써야한다. 
//반드시 무한 루프 방지 코드를 작성할것!

//오버라이드 - 메소드는 재사용성의 첫단추이다.
public class DeptManager extends JFrame {//
	int deptno;//10-30
	JButton jbtn_center = new JButton();
	JButton jbtn_north = new JButton("북쪽");
	JButton jbtn_south = new JButton("남쪽");
	JButton jbtn_east = new JButton("동쪽");
	JButton jbtn_west = new JButton("서쪽");
	
	//역활은 전변에 초기화를 대신 해준다.- 그래서 생략이 가능하다.
	//지변은 초기화를 반드시 해야된다.
	public DeptManager() {//디폴트 생성자는 생략할 수 있다.
		System.out.println("위 디폴트 생성자");//API를 보는 눈을 키워야 한다.
	}
	public DeptManager(int deptno) {//디폴트 생성자는 생략할 수 있다.
		this.deptno = deptno;
		this.deptno = 30;
		System.out.println("아래 디폴트 생성자");
		initDisplay();
	}
	void methodA() {
		System.out.println("methodA에서"+deptno);
		
	}
	//화면 그리기
	public void initDisplay() {//앞으로 화면을 명칭한다 initDisplay
		jbtn_center.setText("중앙");
		this.add("Center",jbtn_center);
		this.add("North",jbtn_north);
		this.add("South",jbtn_south);
		this.add("East",jbtn_east);
		this.add("West",jbtn_west);
		this.setSize(500, 400);
		this.setVisible(true);
	}//오늘 들은 말들을 재현해본다(확인해 본다.)
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new DeptManager(10);
	}

}
