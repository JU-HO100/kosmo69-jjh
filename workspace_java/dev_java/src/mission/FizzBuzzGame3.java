package mission;

public class FizzBuzzGame3 {
		public void methodA(int start, int end) {
			//1~100까지 센다.
		for(int i=start;i<=end;i++) {
			if((i%5==0)&&(i%7==0)) {
			System.out.println("FizzBuzz");
			
			}else if(i%5==0) {
				System.out.println("Fizz");
		}
		else if(i%7==0) {
			System.out.println("Buzz");
		}			
		System.out.println(i);	
		
		
		}
		//insert here - i값은 얼마일까요?
	}
	
		public static void main(String[] args) {
			FizzBuzzGame3 fbg = new FizzBuzzGame3();
			fbg.methodA(5,10);
	}
}