package function.fist;

import book.ch2.Sonata;

public class FunctionExam1 {
	//선언부
	
	
	
	//생성자 - 리턴타입이 없다.(중요한 특징) - 외적으로 볼때 생성자와 메소드를 구분할수 있다.
	public FunctionExam1() {
	
		
	}
	void methodA() {
		//이 안에서 결정된 값을 외부에서 활용할 수 없다.	 - 반환값이 없기 때문에
		//그런데 꼭 하고 싶다면 전역변수에 담아주면 다른 메소드 영역에서도 사용할수 있다. - 유지가능
		//메소드는 스택에 담기므로 사라진다. - 유지불가
	}
	//아래의 경우 void와는 다르게 호출된 결과를 재사용할 수 있다.
	//다른 함수, 다른 클래스에서 사용할수 있다 (인스턴스화)
	int methodB() {
		return 10;//이 반환값을 메소드C에서 받고싶다면
	}
	//레벨 3
	Sonata methodC() { //클래스가 public 이라면 다른 클래스에서도 접근할수 있다 
		
		return new Sonata();
	}
	//같은 이름의 메소드가 2개 있다. 이경우
	//메소드 오버로딩 - 무조건 파라미터의 갯수가 다르거나 타입이 달라야 한다.
	private Sonata methodC(int i) {
		Sonata herCar = new Sonata();
		return herCar; //반환값을 이렇게 쓸수도 있다. 
//		return null;
	}
	//메인메소드 - 가능하면 main메소드는 슬림하게...
	public static void main(String[] args) {
		FunctionExam1 fe = new FunctionExam1();
		int i = fe.methodB();//i=10
		Sonata myCar = fe.methodC(i);//실전에서 많이 쓴다.
		//출력해 보기 전에 반드시 출력 값을 예측 해볼것.
		myCar.speed = myCar.speed + 100;//인스턴스화
		System.out.println(myCar.speed); //패키지가 달라서 접근이 불가능하다. -이경우 접근제한자를 풀려면 public로 바꿔야한다.
		//메소드 C에서 생성된 소나타의 속도는 50으로 변경해 주세요.
		Sonata himCar = fe.methodC();//메소드 C의 클래스를 인트선스화
		himCar.speed = 50;
		System.out.println(himCar.speed);
	}

}
