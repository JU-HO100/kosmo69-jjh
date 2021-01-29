package design.di;

public class A {
	Main main = null;
	public int x=1;
	
	public A(Main main) {
		this.main = main;
	}
	public A() {

	}
	public void method() {
		System.out.println("A method() 호출 성공");
		//만일 디폴트 생성자가 호출될 경우에는 아래 17번 라인에서 NullPointerException이 발생한다.
		//객체가 언제 생성되고 유지되는지를 꼭 점검해야한다.
		System.out.println("Main클래스에 선언된 적연변수 y는 "+main.y);
	}
}
