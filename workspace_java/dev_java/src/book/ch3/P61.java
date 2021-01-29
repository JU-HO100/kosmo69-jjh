package book.ch3;

public class P61 {
	/*
	 * 5장
	 * 변수앞:상수
	 * 메소드 앞:메소드 오버라이딩을 못하게 된다.
	 * 클래스 앞:자녀클래스를 가질 수 없다. 
	 */
	public static void main(String[] args) {
		int i = 5;
		i = 7;
		final double PI = 3.14;
		//PI = 4.14;상수로 선언된 변수의 값은 재정의 가 불가하다.
		System.out.println("i==> "+i);
		System.out.println("PI==> "+PI);

	}

}
