package design.di;

public class Y {
	X x = null;
	public Y(X x) {
		this.x = x;
	}

	public void methodY() {
		System.out.println("Y 호출");
	}
}
