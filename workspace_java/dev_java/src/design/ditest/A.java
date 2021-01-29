package design.ditest;

public class A {
	public int x=1;
	//절대로 해서는 안되는 것에 대해 설명(이유에 대해서)할 수 있어야 합니다.
	Main main = null;//여기서 new Main()하면 원본이 아니라 복제본이 되는 것임.
	public A(Main main) {
		this.main = main;
	}
	//디폴트 생성자는 언제 호출 되나요?
	public A() {
		
	}
	public void method() {
		System.out.println("A method() 호출 성공");
		//만일 디폴트 생성자가 호출될 경우 아래 17번라인에서 NullPointerException이 발동함.
		//객체가 언제 생성되고 언제까지 유지되는 지를 꼭 점검해 보세요.
		System.out.println("Main클래스에 선언된 전역변수 y는 "+main.y);
	}
}
