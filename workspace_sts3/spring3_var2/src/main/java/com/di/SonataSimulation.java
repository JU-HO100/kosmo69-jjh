package com.di;


import org.springframework.beans.factory.BeanFactory; // spring-bean.jar
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext; // spring-context.jar
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class SonataSimulation {
	// 요청 과 응답이 없다. request, response
	// 웹 서비스를 제공할 수 없다.
	// 이것만으로는 안드로이드 와 연계가 불가능 하다.
	// 자바 어플리케이션 에서는 톰캣 서버를 기동하지 않으므로 xml 문서를 스캔하지 않는다.
	// setter 메소드는 필요 없다.
	// 생성자 객체 주입법은 필요한가?
	// setter 객체 주입법 코드는 자바에서 처리하고
	// 생성자 객체 주입법 코드는 xml 에서 처리한다.
	// setter 객체 주입법은 동종간에 처리시에 사용되고 - 권장사항
	// 생성자 객체 주입법은 이종간에 사용된다. - 자바와 myBatis, 자바 와 오라클
	// 결론적으로 xml 과 xml 사이에서도 객체 주입을 처리할 수 있다. - 지원한다.
	/* 나는 인스턴스화 를 할 수 있다.
	 * ArrayList al = new ArrayList();
	 * ArrayList al = null;
	 * ArrayList al = 타입.methodA();
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// xml 문서를 스캔 - web.xml(배치서술자) - IO로 읽고 쓰기 - 너무 느리다, 서버에 너무 부담 된다.
		// spring-core.jar 관리  - Bean 관리 <bean id="" class|type (type이 더 넓다).="추상클래스 or 인터페이스(더 추상적)" />
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\di\\sonataBean.xml");
		Resource resource = new FileSystemResource("C:\\workspace_sts3\\spring3\\src\\main\\java\\com\\di\\sonataBean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);	
		Sonata mycar = (Sonata)context.getBean("myCar");
		Sonata hercar = (Sonata)factory.getBean("herCar");
		Sonata himcar = (Sonata)factory.getBean("himCar");
		Sonata gnomcar = new Sonata();
		System.out.println(mycar);
		System.out.println(hercar);
		System.out.println(himcar);
		System.out.println(gnomcar);
	}

}
