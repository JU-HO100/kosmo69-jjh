package design.test;

public class DuckSimulation {
//선언부와 생성부의 이름이 다르면 다형성(폴리모피즘)을 기대할수 있다.ㄴ
//*다형성*이란 같은 이름의 메소드를 호출했는대 결과가 서로 다르다.
//*다형성*의 전제 조건은 선언부 타입과 생성부 타입이 *무조건 다를 때* 기대할 수 있다.
//*재사용성을 높이는 코딩 방법*으로 중요하다.
	public static void main(String[] args) {
		//추상클래스도 구현체 클래스가 있어야 만 할 것이다.
//		Duck myDuck = new Duck();//추상클래스라서 안된다.
//		FlyBehavior flyBehavior = new FlyBehavior();//
		Duck myDuck  = new MallardDuck();
		myDuck.methodA();//flyBehavior.fly();
		myDuck.methodB();
	//	myDuck.methodC();
		Duck 	herDuck = new WoodDuck();
		herDuck.methodA();
		herDuck.swimming();
		Duck  himDuck = new RubberDuck();
		himDuck.methodA();
		himDuck.swimming();		
		//	myDuck.fly();
	}

}
