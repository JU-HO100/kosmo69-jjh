package book.ch8;

public class ObjectTest {

	public static void main(String[] args) {
		Dog d = new Dog();
		Dog d2 = null;
		d2 =d; // d2의 주소번지를 d의 주소번지의 값으로 만들어 줫다.
		Cat c = new Cat();
		//equals메소드로 비교하면 그 변수가 가리키는 객체가 같은지를 비교하는 것이고
		//==으로 비교하면 그 변수들의 주소번지 값이 같은지를 비교하는 것이다.
		if(d.equals(c)) {
			System.out.println("true");
		}
		if(!d.equals(c)) {
			System.out.println("false");
		}
		System.out.println(d2==d);//두개의 변수는 서로 같은 주소번지 값을 가리킨다.
		System.out.println(d2.equals(d));//두개의 변수는 서로 같은 주소번지 값을 가리킨다. equals
		System.out.println(d.getClass());//어떤 클래스의 인스턴스인지를 알 수 있도록 객체의 클래스를 반환한다. getClass
		System.out.println(d.hashCode());//고유 ID를 말한다. hasCode
		System.out.println(d.toString());//UI 솔루션을 자바코드로 말아서 사용할 때 사용한다.
	
	}

}
