package book.ch8;

public abstract class Car {
	int  speed;
	int wheelNum;
	public Car() {
		System.out.println("Car 디폴트 생성자 입니다.");
		
	}
	public abstract void initDisplay();//추상 메소드  자녀클래스의 메소드가 호출이 되기전에 부모 클래스의 메소드가 호출이 된다. 오버라이딩
	public void stop() {
		if(speed>0) speed = 0;
		
	}
}
