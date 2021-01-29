package design.test;

import design.test.Outter.Inner;

class Outter{
	public void come() {
		
	}
	//내부 클래스 라고 한다.
	//내부 클래스 임으로 반드시 외부 클래스 인스턴스화를 먼저 해야만 접근이 가능하다.
	//외부 클래스의 멘버변수를 사용가능하다.
	class Inner{//클래스 안에 클래스가 올수 있다.
		Inner i = null;
		public void go() {
			System.out.println("go 호출 성공");
		}
	}
}



public class OutterTest {

	public static void main(String[] args) {
		Outter ott = new Outter();
		ott.come();
		Inner inn = ott.new Inner();
		inn.go();
	}

}
