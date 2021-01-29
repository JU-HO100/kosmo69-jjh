package book.ch8;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	
	public static void main(String[] args) {
		//Vector 멀티스레드에서 안전하다. 속도는 느리다. -같이쓴다 -wait 기다려야한다.
		List list = new ArrayList();//싱글스레드에 안전하다. 멀티스레드보다 빠르다.
		Dog d = new Dog();
		list.add(d);
		Cat c = new Cat();
		list.add(c);
		for(int i=0;i<list.size();i++) {
			Object obj = list.get(i);//타입을 찾을수 있는 연산자 흔치 않다, 다른게 없다.
			if(obj instanceof Dog) {
				System.out.println("강아지!");
			}
			if(obj instanceof Cat) {
				System.out.println("고양이!");
			}
			System.out.println(obj);
		}
	}
}
