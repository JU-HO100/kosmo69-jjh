package design.test;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		flyBehavior.fly();
		
	}
	@Override
	public void swimming() {
		System.out.println("나는 물에 뜹니다");
	}

}
