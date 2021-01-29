package com.ch3;

public class HelloBeanImpl implements HelloBean {
	
	private String msg = null;
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getGreeting() {
		
		return "Spring!!! " +this.msg;
	}
	
	//LifeCycle을 이용한 간섭, 관여할 때 사용하는 메소드
	public void initMethod() {
		System.out.println("Bean이 초기화된 후 호출되는 메소드");
	}
	
	public void destroyMethod() {
		System.out.println("Bean이 소멸되기 직전에 호출되는 메소드");
	}


}
