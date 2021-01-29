package Ocjp.basic;

import javax.swing.JButton;
import javax.swing.JFrame;
//A is a B이면 B가 아빠 = A가 소나타(a)이고 자동차(B)이다
public class JButtonArray extends JFrame {
	//8번과 9번의 차이점에 대해 말해보시오.
		String labels[] = {"조회","입력","삭제"};//초기화를 했다
		JButton jbtns[] = new JButton[3];//나는 아직 초기화를 하지 않았다.
		//디폴트 생성자 선언하기.
		//디폴트 생성자의 역할은 무엇입니까?
		public JButtonArray() {///////// [[생성자에서 메소드 호출은 가능한가?]] /////////////
		    initDisplay();
		}	
		public JButtonArray(String title) {///////// [[생성자에서 메소드 호출은 가능한가?]] /////////////
			this.setTitle(title);
			initDisplay();
		}	
		public JButtonArray(int height) {///////// [[생성자에서 메소드 호출은 가능한가?]] /////////////
			this.setSize(700,height);
			initDisplay();
		}	
//		public JButtonArray(int width) {///////// [[생성자에서 메소드 호출은 가능한가?]] /////////////
//			this.setSize(500,width);
//			initDisplay();
//		}	
		public void initDisplay() {
			this.setSize(700,500);//나는 어디에 선언된 메소드 일까요? 아빠를 찾아주세요.
			this.setVisible(true);//메소드 호출시 파라미터의 갯수는 반드시 맞춰야 하나요? 아니면 상관없나요?
	}
	public static void main(String[] args) {
		new JButtonArray("생성자에 대해서...");//이것은 생성자를 호출하는 문장임. 그런데 파라미터가 없는 생성자를 호출하는 것임.
		new JButtonArray(10);
	
	}
	
}
