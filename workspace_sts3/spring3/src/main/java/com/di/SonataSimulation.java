package com.di;

import org.springframework.beans.factory.BeanFactory;//spring-bean.jar
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;//spring-context.jar
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class SonataSimulation {
//요청과 응답이 없다.
//웹서비스를 제공할 수 없다.
//이것만으로는 안드로이드와 연계가 불가	
//자바 어플리케이션에서는 톰캣서버를 기동하지 않으므로 xml 문서를 스캔하지 않는다.	
//setter메소드는 필요 없다.
//생성자 객체 주입법은 필요한가?	
//setter객체 주입법 코드는 자바에서 처리하고
//생성자 객체 주입법 코드는 xml에서 처리한다.
//setter객체 주입법은 동종간에 처리시에 사용되고 -권장사항
//생성자 객체 주입법은 이종간에 사용된다.-자바와 myBatis, 자바와 오라클
//결론적으로 xml과 xml사이에서도 객체 주입을 처리할 수 있다. -지원한다.
/* 나는 인스턴스화를 할 수 있다.
 * ArrayList al = new ArrayList();
 * ArrayList al = null;
 * ArrayList al = 타입.methodA();
 * 	
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//xml문서를 스캔- web.xml(배치서술자) - IO로 읽고 쓰기 - 너무 느려, 서버에 너무 부담
		//spring-core.jar관리-빈관리 <bean id="" class|type="추상클래스 or 인터페이스(더 추상적)"/>
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\di\\sonataBean.xml");
		Resource resource = 
				new FileSystemResource
				("D:\\workspace_sts3\\spring3\\src\\main\\java\\com\\di\\sonataBean.xml");
		//getBean()메소드가 호출될 때 까지 Bean의 생성을 미룸.
		////spring-core.jar - 빈을 관리하는 공장2
		BeanFactory factory = new XmlBeanFactory(resource);//가운데 줄은 depricated
		Sonata myCar = (Sonata)context.getBean("myCar");
		Sonata herCar = (Sonata)factory.getBean("herCar");
		Sonata himCar = (Sonata)factory.getBean("himCar");
		Sonata gnomCar = new Sonata();
		System.out.println(myCar);
		System.out.println(herCar);
		System.out.println(himCar);
		System.out.println(gnomCar);
		
	}

}










