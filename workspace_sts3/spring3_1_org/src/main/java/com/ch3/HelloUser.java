package com.ch3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloUser {

	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		HelloBean hello = (HelloBean)factory.getBean("helloBean", HelloBeanImpl.class);
		HelloBean hello2 = factory.getBean("byeBean", HelloBeanImpl.class);
		//뒤에 타입을 적어줬기 때문에 캐스팅 연산자가 필요 없다. - 타입체크를 해줬다.
		
		String insa = hello.getGreeting();
		System.out.println(insa);
		System.out.println(hello2.getGreeting());
		//타입이 String이기 때문에 String 변수 에 담거나 out.purintln에 직접 담았다.
		factory.close();
	}

}
