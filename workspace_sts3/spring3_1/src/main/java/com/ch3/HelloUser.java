package com.ch3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloUser {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");		
		HelloBean helloBean = 
				(HelloBean)context.getBean("helloBean", HelloBeanImpl.class);
		HelloBean helloBean2 = new HelloBeanImpl();
		String insa = helloBean.getGreeting();
		System.out.println(insa);
		String insa2 = helloBean2.getGreeting();
		System.out.println("insa2 ==> "+insa2);
		System.out.println(helloBean==helloBean2);
	}

}
