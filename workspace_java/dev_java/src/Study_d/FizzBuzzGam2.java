package Study_d;

public class FizzBuzzGam2 {
	public void methodA() {
		int i = 1;
		//1부터 100까지 센다.
//		for(int i=1;i<=100;i++) {
		while(i<101) {
			switch(i%35) {
			case 0: {
				System.out.println("FizzBuzz");
				break;
			}
			case 5: case 10: case 15: case 20: case 25: case 30:  {
				System.out.println("Fizz");
				break;
			}
			case 7: case 14: case 21: case 28: {
				System.out.println("Buzz");
				break;
			}
			default: {
				System.out.println(i);	
			}
	}
				i = i + 1;
	}
	}
public static void main(String[] args) {
	FizzBuzzGam2 fbg = new FizzBuzzGam2();
		fbg.methodA();
}
}
