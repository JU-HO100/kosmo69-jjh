package book.ch3;

public class E {

	public static void main(String[] args) {
		//배열 이름의 주소번지와 첫번째 방의 주소번지가 같은 값이므로
		//같은 타입의 값을 여러개 담을 수 있는 변수 args는 0번부터 사용하게되었다.
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		int j=0;
		System.out.println(args[j++]);//0
		System.out.println(args[j++]);//1
		System.out.println(args[j++]);//2
//		System.out.println(args[j++]+10);//2
		
	}

}
