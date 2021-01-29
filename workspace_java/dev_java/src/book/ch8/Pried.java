package book.ch8;

public class Pried extends Car {
	public Pried() {
		System.out.println("Pried 디폴트 생성자 입니다.");
	}
	@Override
	public void initDisplay() {
		System.out.println("나는 프라이드 입니다.");
	}
	//형태를 바꾸면 안된다.
	//아빠가 가진 메소드 인지 원형을 어떻게 아는 걸까요?
	public int initDisplay(int i) {//서로 상속관계에 있다 하더라도 메소드 오버로드 규칙은 적용된다.메소드 오버 로딩과 오버 라이딩을 둘다 체크해야한다.
		System.out.println("나는 프라이드 입니다.");
		return 0;
	}
	public void speedUp() {
		speed = speed + 1;//상위클래스(아빠)의 변수는 그냥 쓸수 있다.
		
	}

}
