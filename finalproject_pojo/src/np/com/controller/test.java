package np.com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("a","야");
		map.put("b","호");
		list.add(map);
		
		System.out.println(list);
		
		for(Map<String, Object> rmap:list) {
			System.out.println(rmap.get("a"));
		}
	}

}
