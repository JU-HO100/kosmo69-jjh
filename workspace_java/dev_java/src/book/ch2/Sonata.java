package book.ch2;

public class Sonata {
	public int speed = 0;//다른 패키지 안에서 쓰고싶다면 앞에 public을 넣어줘야 한다.
    void speedUP() {
    	speed = +1;
    }
    void speedDown() {
    	speed = -1;
    }
	//메인 스레드(Thread)-우선순위 1번
	public static void main(String[] args) {
		Sonata Mycar = new Sonata();
		System.out.println(Mycar);
		Mycar.speedUP();
		Sonata Timecar = new Sonata();
		System.out.println(Timecar);
		Timecar.speedUP();
		System.out.println(Mycar.speed);
		
	}

}
