package book.ch5;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main1 extends JFrame implements ActionListener { //9번 implements ActionListener 추가 후 Main1 add
	//선언부 - 전역변수
	JButton jbtn_south  = null;//6번 
	JButton jbtn_north  = null;//6번 
	JButton jbtn_east   = null;//6번 
	JButton jbtn_west   = null;//6번 
	JButton jbtn_center = null;//6번 
	JTextField jtf 		= null;//13번
	Container cont = this.getContentPane();//11번
	

	//생성자 - 리턴타입이 없어야 생성자이다. - 파라미터는 가질수있다(여러개 가능)
	//메소드 오버로딩의 규칙을 준수한다 - 하는 역할은 전역변수의 초기화를 담당한다.
	public Main1() {//디폴트 생성자 -생성자의 제1 역할은 초기화 이다. //2번
		jbtn_south  = new JButton("남쪽 (버튼)");//6번
//		jbtn_north  = new JButton("북쪽 (버튼)");
		jbtn_east   = new JButton("동쪽 (버튼)");
		jbtn_west   = new JButton("서쪽 (버튼)");
		jbtn_center = new JButton("중앙 (버튼)");
		
		initDisplay();//4번 //내안에 있는 '메소드' , '생성자' , '전역변수'는 '인스턴스화' 없이도 '호출'할수 있다.
	}
	//화면처리부 - 
	public void initDisplay() { //1번
		
		jbtn_south. addActionListener(this);//8번
//		jbtn_north. addActionListener(this);
		jbtn_east.  addActionListener(this);
		jbtn_west.  addActionListener(this);
//		jbtn_center.addActionListener(this);
		this.add("South",jbtn_south);//7번
//		this.add("North",jbtn_north);//7번
		this.add("East",jbtn_east);//7번
		this.add("West",jbtn_west);//7번
		this.add("Center",jbtn_center);//7번
		this.setSize(500,400);//5번
		this.setVisible(true);//5번	
	}
	//메인메소드
	public static void main(String[] args) {
		//생성자 호출하기
		//여기에 인스턴스화를 하면 지역변수의 성격을 갖게 되므로 외부 클래스에서 사용불가하다.
		new Main1();//생성자 호출//3번
		
	}
	//CallBack 메소드 - 감지가 됬을때 JBM이 자동으로 호출 된다. 
	@Override
	public void actionPerformed(ActionEvent e) { //10번
		Object obj = e.getSource();//10번		
		if(obj == jbtn_west) {
			if(jbtn_center!=null) {
				cont.remove(jbtn_center);	
			}
			if(jbtn_east!=null) {
				cont.remove(jbtn_east);				
			}
			if(jbtn_north!=null) {
				cont.remove(jbtn_north);
			}
			if(jbtn_south!=null) {
				cont.remove(jbtn_south);
			}
			if(jtf!=null) {
				cont.remove(jtf);
			}
			cont.revalidate();
		}
		
		else if(obj == jtf) {//JTextField와 주소번지가 같은지 비교한다. //14번
			System.out.println("==========");
			String msg = jtf.getText();//사용자가 입력한 문자열을 읽어온다. null포인트 에러 때문에 주석처리하였다. //14번 
			if("서쪽".equals("")) {
				jbtn_north  = new JButton("서쪽 (버튼)");
				cont.add("West",jbtn_west); //15번
				cont.revalidate();
		}else {
			JOptionPane.showMessageDialog(this, "북쪽을 입력");
			jtf.setText("북쪽");
			return;
		}
			if("동쪽".equals(msg)) {
				jbtn_east  = new JButton("동쪽 (버튼)");
				cont.add("East",jbtn_east); //15번
				cont.revalidate();
		}else {
			JOptionPane.showMessageDialog(this, "동쪽을 입력");
			jtf.setText("동쪽");
			return;
		}
			if("서쪽".equals(msg)) {
				jbtn_west  = new JButton("서쪽 (버튼)");
				cont.add("West",jbtn_west); //15번
				cont.revalidate();
		}else {
			JOptionPane.showMessageDialog(this, "동쪽을 입력");
			jtf.setText("동쪽");
			return;
		}
			if("중앙".equals(msg)) {
				jbtn_center  = new JButton("중앙 (버튼)");
				cont.add("Center",jbtn_center); //15번
				cont.revalidate();
		}else {
			JOptionPane.showMessageDialog(this, "동쪽을 입력");
			jtf.setText("동쪽");
			return;
		}
		}
	else if(obj == jbtn_west) {//10번
//			System.out.println("남쪽버튼 클릭");
			jbtn_west.setText("서쪽");
			//java에서는 삭제했다고 해서 즉시 없어지는게 아니다.
			//일단 Candidate상태로 뺀다.(넌 쓰레기 값이다. -곧 청소하겠다 & 사라진다.)
			cont.remove(jbtn_south);//삭제할 화면 //11번
			cont.remove(jbtn_center);
			cont.remove(jbtn_east);
			jbtn_west = null;//12번 
//			System.out.println("남쪽(버튼) : "+jbtn_south);//12번
			//위치 - 끼워들 위치
			jtf = new JTextField();//13번
//보통은 initDisplay에서 이벤트 핸들러와 연결을 해왔다.
//그런대 오늘은 이벤트가 발동해야 인스턴스화가 완성된다. new
//따라서 이벤트 처리 메소드인 actionPerformed에서 이벤트가 일어나는 그 위치로
//옴겨주어야 한다. (null포인트 에러)
			jtf.addActionListener(this);//13번
			cont.add("South",jtf);
			cont.revalidate();//11번
			
		}
		
	}
	
}
