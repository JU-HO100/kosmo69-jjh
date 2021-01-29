package game.baseball;

public class StringTest {

	public static void main(String[] args) {
		String s1 = new String("apple");
		String s2 = new String("apple");
		String s3 = "haha";
		//s1의 주소번지와 s2의 주소번지가 같니?
		System.out.println(s1==s2);////////////////false가 출력될 것이다.
		//false
		//s1이 가리키는 문자열과 s2가 가리키는 문자열이 같은거야?
		System.out.println(s1.equals(s2));/////////true가 출력될 것이다.
		//true
	}

}
