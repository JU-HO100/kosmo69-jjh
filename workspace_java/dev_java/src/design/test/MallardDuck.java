package design.test;
/*
 * FlyBehavior는 인터페이스 이다.
 * 메소드 선언만 되어있고 바디가 없는 상태이니까
 * 반드시 구현체 클래스가 있어야 활용할 수 있다.
 * 이 세상에 나는(하늘을 날수있는) 동물, 사물들이 많이 있다.
 * 사물이 갖는 공통 분모를 찾기 위해 인터페이스를 설계 한다.
 * 단독으로는 인터페이스화 할 수 없다. - 추상메소드를 가지고 있으니깐.
 * 결정된 메소드가 아니다. - 쓸수 없는 메소드이다
 */
public class MallardDuck extends Duck {
	
	public MallardDuck() {
		flyBehavior = new FlyWithWings();//초기화
		quackBehavior = new Squeak();
	}
	//메소드 재정의
	@Override
	public void swimming() {
		System.out.println("나는 물위에 뜹니다.");
	}
}
