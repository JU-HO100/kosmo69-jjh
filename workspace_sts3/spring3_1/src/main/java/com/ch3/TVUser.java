package com.ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//선언부 추상클래스 생성부 구현체 클래스
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		TV stv = context.getBean("stv", SamsungTV.class);
		stv = null;
		stv = context.getBean("lgtv", LGTV.class);		
		stv.powerOn();
		stv.powerOff();
		stv.volumeUp();
		stv.volumeDown();
		context.close();
	}

}
