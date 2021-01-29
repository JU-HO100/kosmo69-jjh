package book.ch2;

public class Sonata2 {
		int speed = 0;
	    void speedUP() {
	    	speed = +1;
	    }
	    void speedDown() {
	    	speed = -1;
	    }
		//메인 스레드(Thread)-우선순위 1번
		public static void main(String[] args) {
			Sonata myCar = new Sonata();
			System.out.println(myCar);
			Sonata timeCar = new Sonata();
//내안에 있는 메소드라 하더라도 주소번지를 붙여서 호출함.
//이유는 static이 붙어 있는 메소드
			timeCar.speedUP();
			System.out.println(timeCar.speed);
			System.out.println(timeCar);
	}//end of main

}
