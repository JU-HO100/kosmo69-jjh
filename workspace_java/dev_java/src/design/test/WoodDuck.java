package design.test;

public class WoodDuck extends Duck {
	public WoodDuck() {
		flyBehavior = new FlyNoWay();
		flyBehavior.fly();
	}
	@Override
	public void swimming() {
		System.out.println("나는 물에 가라 앉습니다.");
		
	}

}
