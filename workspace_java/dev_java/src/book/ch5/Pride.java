package book.ch5;

public class Pride extends Object {//모든 클래스의 아버지 , toString()를 가지고 있다
	int speed = 0;
	public String toString() {//toString 자체가 주소번지이다.
		return "그녀의 자동차";//리턴값에 이때까지 호출한 주소번지는 toString를 호출한 것이다.
	}
	public static void main(String[] args) {
		Pride herCar = new Pride();
		System.out.println(herCar);
		System.out.println(herCar.toString());
	}

}
