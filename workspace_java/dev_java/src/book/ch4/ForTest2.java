package book.ch4;

public class ForTest2 {

	public static void main(String[] args) {
		for(int i=0;i<5;i++) {//break를 만나면 for문을 나간다.
			if(i==1) break;//if문이 return를 만나면 메소드를 나간다.
			System.out.println(i);	
			
		}
		System.out.println("여기");

	}
}
