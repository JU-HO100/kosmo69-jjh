package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
/*
 * 공통코드 체험하기
 * 사용자로부터 입력 받는 값을 효과적으로 처리해 보자.
 * API보는 방법과 활용능력을 키워본다.
 * 
 */

public class HashMapBinder {
	public HttpServletRequest request = null;
	public HashMapBinder() {
		
	}
	public HashMapBinder(HttpServletRequest request) {
		this.request = request;
	}
	public void bind(Map<String,Object> target) {
		target.clear();//휴지통 비우기
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements());
			//<input name="mem_id">
			String key = en.nextElement();//mem_id , mem_pw, mem_addr, mem_hp 등 여러개가 올수있다.
			target.put(key,HangulConversion.toUTF(request.getParameter(key)));
			
	}
	
}
