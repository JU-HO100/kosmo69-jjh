package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
   public static void main(String[] args) {
      ApplicationContext context = 
            new ClassPathXmlApplicationContext("com\\di\\helloBean.xml");
      HelloBean helloBean = (HelloBean)context.getBean("helloBean");//id이다.
      String msg = helloBean.getGreeting("Hi");
      System.out.println(msg);      
   }
}