package net.tomato_step4;

import java.awt.Button;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/*
 * 선언부와 생성부의 이름이 다른것을 권장한다.
 * 이것을 지키면 재사용성과 이식성을 높일 수 있다.
 * 파라미터나 리턴 타입으로 좀 더 다양한 객체를 받을 수 있다.
 * 따라서 내가 가진 메소드 변수뿐 아니라 더 많은 것을 *누릴 수도*(없으면 사용할 수 없다) 있다.
 * 
 */
public class MapTest {
	synchronized void m() {//동기화
		
	}
	void m2() {
		
	}
	
	
	void methodA(List<Integer> list) {
		
	}
	void methodB(ArrayList<Integer> list2) {//경합이 벌어 질 때에는 사용하면 안된다(버그의 원인이 된다). -멀티-
		
	}
	void methodC(Vector<String> list3) {
		
	}
	void methodD(Vector<Object> list4) {
		
	}
	
	
	public static void main(String[] args) {//map을 사용하는 경우는 네이버,구글,다음,카카오 같은 구분되게 사용자에게 정보를 제공해야 할 경우 map을 자주 사용한다.
		MapTest mt = new MapTest();
		ArrayList<Integer> al = new ArrayList<>();
//		ArrayList<Object> al = new ArrayList<>();
		Vector<String> v = new Vector<>();
		Vector<Object> v2 = new Vector<>();
		List<Button> li = new ArrayList<>();
		List<Integer> li2 = new ArrayList<>();
//		mt.methodA(list);//al, v, li 안된다. -- <>안에 제네릭타입이 맞지 않기 때문?
		mt.methodA(al);// 제네릭 타입까지 일치한다.
//		mt.methodA(v);//
		//더 작은 타입은 더 넓은 타입에 들어갈 수 있다.
//		mt.methodA(li);// 제네릭 타입이 일치하지 않으니까 에러
		mt.methodB(al);
//		mt.methodC(li2);
		mt.methodC(v);
//		mt.methodD(v);//똑같은 vector이지만 사용할 수 없다 - 제네릭 타입이 다르다. 
		mt.methodD(v2);//제네릭 타입까지 맞추면 사용할 수 있다.
		/*동일한 타입이더라도 제네릭 타입이 다르면 사용할 수 없다.
		*제네릭 타입이 더 작다 하더라도 더 큰 타입이 담지 못 한다.
		*웹서비스 or 모바일 서비스시에는 우선순위가 높은 편이다.
		*단점은 순서가 없다. - 차례가 안맞는다. 
		*/
		List<Map<String,Object>> mapList = new ArrayList<>();//map의 정보를 list에 다시 담았다.
		Map<String,Object> map = new HashMap<>();//-중요- -인터페이스 변수 = new 구현체클래스( );-
		Map<String,Object> table = new Hashtable<>();//뒤에 구현체 클래스가 바뀌었다.  
		map.put("one", 10);
		map.put("tow", "가산동");
		map.put("three", 3.14);
//		System.out.println(map.get("one"));
//		System.out.println(map.get("tow"));
//		System.out.println(map.get("three"));
		//맵에 저장된 정보를 관리가능 - 유지
		mapList.add(map);
		map = new HashMap<>();
		map.put("one", 20);
		map.put("tow", "구로구");
		map.put("three", 6.28);
//		System.out.println(map.get("one"));
//		System.out.println(map.get("tow"));
//		System.out.println(map.get("three"));
		mapList.add(map);
		map = new HashMap<>();
		map.put("one", 30);
		map.put("tow", "금천구");
		map.put("three", 9.42);
//		System.out.println(map.get("one"));
//		System.out.println(map.get("tow"));
//		System.out.println(map.get("three"));
		mapList.add(map);
		//여기에 (ArrayList)안의 정보를 꺼내서 출력해 보시오. 
//		System.out.println(map);
//		System.out.println(mapList);
		
		Object obj[] = map.keySet().toArray();//map에서 제공하는 keySet이라는 메소드를 호출.
		Set<String> set = map.keySet();//keySet의 리턴 타입은 set으로 되어 있다.
		Object obj2[] = set.toArray();//set을 이용해서 toArray를 호출할수 있다. 
		for(int i=0;i<obj.length;i++) {//(obj.length)배열의 길이 많큼 반복
			String key = obj[i].toString();//i의 값을 [ ]에 저장
			System.out.println(map.get(key));//그 key값을 호출
		
		}
		for(int j=0;j<mapList.size();j++) {
			Map rmap = mapList.get(j);
			Object objs[] = map.keySet().toArray();
			for(int i=0;i<objs.length;i++) {
				String keys = objs[i].toString();
				System.out.println(map.get(keys));
			}
		}
		
 }
}
