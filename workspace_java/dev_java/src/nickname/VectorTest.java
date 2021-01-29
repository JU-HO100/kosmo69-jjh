package nickname;

import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("v.size()==0"+v.size());
		v.add("바나나");//Vector은 넣은 순서대로 자리가 생긴다.(순서)
		v.add("수박");
		v.add(1,"체리");//끼워넣기가 가능하다.
		for(Object obj:v) {
			String f = (String)obj;
			System.out.println(f);
		}
	}

}
