package com.ch3;

public class SamsungTV implements TV {
	
	@Override
	public void showTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("전원 On");
		
	}

	@Override
	public void powerOff() {
		System.out.println("전원 Off");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("볼륨 Up");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("볼륨 Down");
		
	}

}
