package scjp.method;

class A{
	public byte getNumber() {
		return 1;
	}
	public short getNumber(int x) {//메소드 오버라이딩(타입이 같다) 조건을 만족 하였다. 합법. 변수 이름은 중요하지 않다.
		return 2;
	}
	public short getNumber(double x) {//메소드 오버로딩(타입이 다르다) 조건을 만족 하였다. 합법.
		return 2;
	}
}

class B extends A{
/*	public short getNumber() {
		return 2;
*/	
		public short getNumber(int i) {//오버라이딩 = 파라미터의 타입이 같다. -상속관계에 있다.
			return 22;
	}
		public short getNumber(int i,boolean x) {//
			return 2;
		}
}

public class Q1 {
	
	public static void main(String[] args) {
		A a = new A();
		a.getNumber();
		a.getNumber(3.14);
		a.getNumber(5.0);
		a = null;
		a = new B();
		a.getNumber();
		a.getNumber(5.14);
		System.out.println(a.getNumber(7));
		//아빠 타입으로 선언된 변수가 설령 아들 클래스를 생성했다 하더라도 아빠에 선언된 메소드만 호출 가능하다.
		//그렇다면 아빠와 아들 모두에 선언된 메소드 중에서 누가 호출 될까요?
//		a.getNumber(5,false);
		B b = new B();
		b.getNumber(4, true);//
		
		
	}

}
