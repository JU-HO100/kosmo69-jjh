package design.test;
/*
 * 인터페이스는 메소드 선언만 할 수 있다. - 바디가 없다.?(if , while , plintln을 사용하지 못한다)
 * 아직 결정할수 없다. 왜냐하면 클래스가 정해지지 않았으니까......
 * 
 */
public interface FlyBehavior {
	public void fly();//플라이 메소드를 선언한 것이다.
	public int methodA();//3개의 메소드 공통점은 바디가 없다.
	public int methodB(int i);//구현체 클래스 이다.
}
