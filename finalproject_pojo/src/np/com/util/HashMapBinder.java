package np.com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
/*
 * 공통코드 체험하기
 * 사용자로부터 입력 받은 값을 효과적으로 처리해 본다
 * API 보는 방법과 활용능력을 키워본다.
 */
public class HashMapBinder  {
	
	public HttpServletRequest request = null;
	
	public HashMapBinder(HttpServletRequest request) {
		this.request = request;
	}


	public void bind(Map<String,Object> target) {
		target.clear();  // 이전 값을 기억하지 못하게 혹시모르니 클린 해놓자
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()) {
			//<input name="mem_id">  가 오는거임
			String key = en.nextElement(); // mem_id, mem_pw, mem_addr, mem_hp
//			String[] values = request.getParameterValues(key);
			target.put(key,request.getParameter(key));
		}
	}
}
