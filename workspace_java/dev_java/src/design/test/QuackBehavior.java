package design.test;
/*
 * 추상 클래스와 인터페이스의 공통점은? - 모두 단독으로는 인스턴스화는 불가능하다.
 * 반드시 구현체 클래스가 있어야 한다.
 */
public interface QuackBehavior {//인터페이스는 추상 메소드 밖에 쓰질 못한다.
	public void quack();//추상 메소드
	//abstract
}
