package mission;

public class FizzBuzzGame2 {

		public void methodA() {
		for(int i=1;i<=100;i++) {
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
	}
	
	
		public static void main(String[] args) {
			FizzBuzzGame2 fbg = new FizzBuzzGame2();
			fbg.methodA();
			System.out.println();
			
			
		}
		}