package design.di;

public class Main {
	public int y=10;
	A a = null;//NullPointerException발생
	public void m3() {
		System.out.println("A method() 호출 성공");
//디폴트 생성자는 JVM이 제공해 줄 수 있지만 실제로 선언되어 있지 않더라도 해준다.
//그러나 파라미터가 있는 생성자는 예측이 불가능함으로 제공 할 수 없다.
//this를 사용할 경우 인스턴스화 문장이 포함된 클래스가 주입되는 것이다. --중요함--
		a = new A(this);//A클래스 안에 생성자가 있어야한다.
		a.method();
	}
	public static void main(String[] args) {
		//내안에 있는 메소드라 하더라도 static안에서 호출할땐 인스턴스화 해야한다.
		Main main = new Main();
		main.m3();
	}

}
