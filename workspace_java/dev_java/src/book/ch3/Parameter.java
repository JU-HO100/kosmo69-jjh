package book.ch3;

public class Parameter {
	//Parameter p2 = new Parameter();
	//값에 의한 호출입니다.
	//그래서 지변 x에 10담기고, 지변 y에 20담긴다.
	void methodA(int x, int y) {//x=10, y=20
		System.out.println("methodA호출 성공");
		//p2.methodA(1,2);
		System.out.println(x+y);
	}
	//메소드 선언할 때 반환 타입을 결정할 수 있다.
	//리턴타입이 있는 경우 실행문 맨 마지막에 반드시 return이라는 예약어를
	//써 주어야 한다.
	//이때 리턴 다음에는 값이나 혹은 변수 명이 올 수 있다.
	//단 변수의 타입이 리턴 타입과 반드시 일치해야 한다.
	double methodB(double d1, double d2) {
		double hap= 0.0;
		hap = d1+d2;
		return hap;
	//	return d1+d2;
	}
//
	public static void main(String[] args) {
		//RAM영역에 Parameter1클래스를 로딩하기
		//p1은 지변이다.
		Parameter p1 = new Parameter();
//		double hap = p1.methodA(10,  20);
//		double hap2 = p1.methodA(10,  20);
	}

}


//(리턴 타입이 필요할 때)A라는 메소드의 처리 결과가 메소드B에서 재 사용하고 싶을때 리턴 타입을 사용할 것
//리턴타입이 void인 경우 print 메소드에 사용할수 없다.