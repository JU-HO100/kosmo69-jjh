package com.ch3;

public class LGTV implements TV {
	
	@Override
	public void showTV() {
		System.out.println("===> LGTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("전원 켠다");
		
	}

	@Override
	public void powerOff() {
		System.out.println("전원 끈다");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("볼륨 높인다");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("볼륨 줄인다");
		
	}

}
