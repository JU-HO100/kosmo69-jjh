package design.di;

public class X {
	public int x = 1;
	Y y = new Y(this);
	Z z = new Z(this);
	public void methodX() {
		y.methodY();
		z.methodZ();
	}
	public static void main(String[] agrs) {
		X x = new X();
		x.methodX();
		
	}

}
