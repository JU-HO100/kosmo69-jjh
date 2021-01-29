package mvc2.online;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestSimullation {

	public static void main(String[] args) {
		TestLogic tl = new TestLogic();
		List<Map<String,Object>> testList = tl.swDesignExam();
		Map<String,Object> pmap = new HashMap<String, Object>();
		System.out.println(testList);
	}

}
