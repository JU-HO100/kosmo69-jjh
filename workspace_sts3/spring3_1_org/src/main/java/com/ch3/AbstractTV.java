package com.ch3;

public abstract class AbstractTV {//추상클래스는 abstract의 유무로 확인할 수 있다.
	//메소드 오버라이딩에 대한 문법체크를 위해서 - 선언부는 반드시 일치해야 한다.
	AbstractTV(){}
	public abstract void showTV();
	public abstract void powerOn();
	public abstract void powerOff();
	public abstract void volumeUp();
	public abstract void volumeDown();
	
}
