package book.ch5;

public class StringTest {

	public static void main(String[] args) {
		String msg = "hello";
		msg = msg.replace('e', 'o');//replace= 앞의 e를 뒤의 o로 바꾼다.
		System.out.println(msg);
		StringBuilder sb = new StringBuilder("hello");
		sb.append(" world!!!");//
		System.out.println(sb.toString());
		String str = "hello";
		str=str+" world";
		str+=" java";
		System.out.println(str);
	}

}
