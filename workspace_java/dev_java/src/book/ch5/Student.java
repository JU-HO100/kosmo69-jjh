package book.ch5;
/*공통사항
 * 둘다 반드시 메소드가 같은 이름일때만 로딩한다.
 * 메소드 이름이 다른 건 고려 대상이 아니다.
 *
 * 메소드 오버로딩
 * 자바에서는 같은 이름의 메소드를 여러개 정의할 수 있다.
 * 단 반드시 파라미터의 갯수나 타입이 달라야 한다.
 * 리턴 타입이 있고 없고는 영향이 없다.
 * 예외를 던지고 던지지 않고는 영향이 없다.(실행에러)
 * 접근 제한자가 있고 없고 나 범위가 다른 것도 영향이 없다.
 * 
 * 메소드 오버라이딩 
 * 전제 조건으로 반드시 상속관계에 있을 때만 가능하다.
 * 부모 클래스의 원형을 절대로 건드리면 안된다.
 * 파라미터나 리턴 타입을 수정하지 않는다.
 * 기능에 대한 구현만 바꾸어 사용하는 것이다.
 */
public class Student {
	void go() {
		System.out.println("가주세요.");
	}
	//파라미터 자리는 사용자로 부터 입력받는 값이므로 사용자가 입력한 정보를 활용하여 답을 줄 수 있다.
	//사용자의 정보를 듣게 됨으로써 맞춤형 서비스를 제공할 수 있다.
	void go(String location) {
		System.out.println(location+"으로 가주세요.");
		
	}
	void go(String location2, int x) {
		System.out.println(location2+"으로 가주세요.");
		
	}
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.go();
		s1.go("가산동");
		s1.go("가산동", 54);
		//이러한 규칙이 생성자에도 동일하게 적용된다.
	}

}
