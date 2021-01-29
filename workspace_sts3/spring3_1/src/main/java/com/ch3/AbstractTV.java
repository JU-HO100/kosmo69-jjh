package com.ch3;

public abstract class AbstractTV {
	//메소드 오버라이딩에  대한 문법체크를 위해서-선언부는 반드시 일치해야 한다.
	AbstractTV(){}
	public abstract void powerOn();
	public abstract void powerOff();
	public abstract void volumeUp();
	public abstract void volumeDown();
}
