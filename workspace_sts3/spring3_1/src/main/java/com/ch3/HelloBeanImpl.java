package com.ch3;

public class HelloBeanImpl implements HelloBean {
	private String msg = null;
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Spring!!! " +this.msg;
	}
	//라이프 사이클을 이용한 간섭, 관여 할 때 사용할 수 있는 메소드 이다.
	public void initMethod() {
		System.out.println("Bean이 초기화된 후 호출되는 메소드");
	}
	public void destroyMethod() {
		System.out.println("Bean이 소멸되기 전에 호출되는 메소드");
	}
}
