package design.ditest;

public class X {
	Y y = new Y(this);
	Z z = new Z(this);
	public void methodA() {
		y.methodY();
		z.methodZ();
	}
	public static void main(String[] args) {
		X x = new X();
		x.methodA();
	}
}
