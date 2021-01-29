package com.ch3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//선언부 = 추상클래스 | 생성부 = 구현체 클래스
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
//		TV tv = (TV)factory.getBean("ltv");
//		TV tv = (TV)factory.getBean("stv");
//		TV tv = (TV)factory.getBean("stv", SamsungTV.class);
		TV tv = (TV)factory.getBean("ltv", LGTV.class);
		tv.showTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

		factory.close();
	}

}
