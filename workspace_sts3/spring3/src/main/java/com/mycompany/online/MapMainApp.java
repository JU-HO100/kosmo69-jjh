package com.mycompany.online;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MapMainApp {
	public static void main(String[] args) {
		MapMainApp mma = new MapMainApp();
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\mycompany\\online\\nameBean.xml");
		//nameBean.xml문서에 있는 id값을 파라미터에 적음
		MapTest mt = (MapTest)context.getBean("nameBean");//id이다.
		//List<String> list = (ListController)factory.getBean("insaBean");
		//MapTest에 선언해둔 전역변수 이름을 호출하는 것임.
		//이 때 사용되는 이름은 반드시 nameBeam.xml에 등록된 property속성에 적은 name과 일치해야 함.
		//이 부분이 의존성 주입이 일어나는 부분임.
		System.out.println(mt.mapBean);
	}
}







