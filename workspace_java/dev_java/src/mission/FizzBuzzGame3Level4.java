package mission;

public class FizzBuzzGame3Level4 {
		public void methodA(int start, int end) {
			int i = start;
			//1~100까지 센다.
		while(i<=end) {
			if((i%5==0)&&(i%7==0)) {
			System.out.println("FizzBuzz");
			}else if(i%5==0) {
				System.out.println("Fizz");
		}
		else if(i%7==0) {
			System.out.println("Buzz");
		}			
		System.out.println(i);	
		i++;//계산을 다하고 내려왔다가 조건이 맞으면 다시 못올라가게 내보낸다
		}
		//insert here - i값은 얼마일까요?
	}
	
		public static void main(String[] args) {
			FizzBuzzGame3Level4 fbg = new FizzBuzzGame3Level4();
			fbg.methodA(5,10);
	}
}