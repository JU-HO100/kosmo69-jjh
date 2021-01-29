package design.test;
//추상 클래스 - 단독으로는 인스턴스화를 할 수 없다.
//반드시 구현체 클래스가 있어야 한다.
//그러나 일반 메소드도 가질 수 있다.
//그래서 인터페이스가 더 추상적이다.
public abstract class Duck {
	FlyBehavior flyBehavior = null;
	QuackBehavior quackBehavior = null;
	public void methodA() {
		flyBehavior.fly();
	}
	public void methodB() {
		quackBehavior.quack();
	}/*
	public void methodC() {
		
	}*/
	public void display() {
		System.out.println("나는 오리 입니다.");
	}
	//추상 메소드이다.
	//인터페이스에서는 abstract를 생략할수 있지만 - 왜냐하면 모두 다 추상메소드만 오니까.
	//그런데 추상클래스는 일반메소드(display)도 같이 공존하니깐 구분할수 있어야한다.
	public abstract void swimming();//abstract를 붙여 추상메소드를 표시한다.
}
