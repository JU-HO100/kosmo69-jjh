package design.ditest;
//클래스 쪼개기 연습 - 생성자 활용하기
public class Main {
	public int y=10;
	A a = null;//NullPointerException발생
	public void m3() {
		System.out.println("Main m3() 호출 성공");
//		a = new A(this);//NullPointerException발생
//디폴트 생성자는 JVM이 제공해 줄 수 있지만 실제로 선언되어 있지 않더라도 해줌.
//그러나 파라미터가 있는 생성자는 예측이 불가하므로 제공 할 수 없음.
//this를 사용할 경우 인스턴스화 문장이 포함된 클래스가 주입되는 것임.-중요함.		
		a = new A(this);//NullPointerException발생
		a.method();
	}
	public static void main(String[] args) {
		//내안에 있는 메소드라 하더라도 static안에서 호출할땐 인스턴스화
		Main main = new Main();
		main.m3();
	}

}
