package book.ch8;

public class CarSimulation {

	public static void main(String[] args) {
		Car myCar = new Pried();
		//부모 클래스가 같을 뿐 아반떼와 프라이드는 관계 없다. 
		//아래와 같이 인스턴스화 할수 없다.
		//Avante herCar = new Pried();
		Pried himCar = new Pried();
//		myCar = himCar;
//		himCar = (Pried)myCar;//강제 형전환 -캐스팅 연산자로 인해 주소번지가 Pried로 바뀌었다.
		
//		myCar.initDisplay();
		himCar.speedUp();
		System.out.println("myCar.speed+"+myCar.speed); // 12번의 형전환을 했을경우 himCar의 주소번지를 가진다.
		System.out.println("himCar.speed+"+himCar.speed);
//		myCar.speedUP();
		//설계는 안하더라도 활용은 가능해야 한다.
	}

}
