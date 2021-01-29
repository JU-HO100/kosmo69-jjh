package book.ch9;

public abstract class Unit {//abstract가 있기 때문에 추상클래스 이다.
	int x, y;
	public Unit() {
	}
	public Unit(int x, int y) {//전역변수의 초기화
		this.x = x;
		this.y = y;
	}
	abstract void move(int x, int y);
	void stop() {
		System.out.println("현재 위치에 정지");
	}
}
