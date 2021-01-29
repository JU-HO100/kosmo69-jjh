package design.ditest;

public class Z {
	public X x = null;
	public Z(X x) {
		this.x = x;
	}
	public void methodZ() {
		System.out.println("methodZ() 호출 성공");
		x.y.methodY();
	}
}
