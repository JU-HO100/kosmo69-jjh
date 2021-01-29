package design.di;

public class Z {
	X x = null;
	public Z(X x) {
		this.x = x;
	}

	public Z() {
	}

	public void methodZ() {
		System.out.println("Z 호출");
	}
	public static void main(String[] args) {
		X x = new X();
		x.y.methodY();
	}
}
