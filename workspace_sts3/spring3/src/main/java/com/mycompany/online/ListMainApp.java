package com.mycompany.online;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
/*
 * insaBean.xml문서를 스캔하자.
 * 왜냐하면 객체 주입, 의존성 주입 받고 싶다면....
 *  스캔한 내용은  스프링에서 제공하는 ApplicationContext나  혹은 BeanFactory를 통해서 관리 받을 수 있다.
 *  그 중에서 BeanFactory로 진행하였다.
 *  parsing error발생한 상황, bean create 받지 못하는 문제로 에러발생
 *  ListController에 대한 빈생성이라는 사실을 착각 - List<String>
 * 
 */
public class ListMainApp {
	List<String> listList = null;
	public void setListList(List<String> listList) {
		this.listList = listList;
	}
	//프레임워크에는 그 사람의 사상이 들어있다.
	//프레임워크는 그 사람의 생각에서 시작되었다.
	public static void main(String[] args) {
		ListMainApp lma = new ListMainApp();
		//Context를 시작시킬 때 모든  Singleton Bean을 미리 로딩함으로써 빈이 필요할 때 즉시 사용할 수 있도록 보장해줌.
		//spring-core.jar - 빈을 관리하는 공장1-더 많은 기능 2번보다.
		//어플리케이션 동작시 Bean생성되기를 기다릴 필요가 없다.
		//스프링에게 의존하는(주입받는, 제어권이 나한테 없는)방법은 getBean() 호출함으로써 얻어낸다. 주소번지를....
		//공통점
		/* Bean의 생성과 소멸을 담당. <bean id="member-controller" class="com.xxx.MemberController"/>
		 * Bean생성시에 필요한 속성을 정의할 수 있다.
		 * <bean>
		 * 	<property name="listBean"></property>
		 * </bean>
		 * Bean LifeCycle에 대한 메소드를 호출할 수 있다.
		 * init()-service()-destroy()지원함.
		 * <bean id="member-controller" class="com.xxx.MemberController" init-method="initMethod destroy-method="destroyMethod"/>
		   init-method:해당 빈이 초기화된 후 호출되는 메소드
		 * destroy-method:해당 빈이 소멸되기 전에 호출되는 메소드
		 */
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\mycompany\\online\\insaBean.xml");
		ListController list2 = (ListController)context.getBean("insaBean");
		for(String insa:list2.listBean) {
			System.out.println(insa);
		}
		List<String> insaList = null;
		insaList = new ArrayList<>();
		insaList.add("안녕");
		insaList.add("안녕하세요.");
		insaList.add("기분좋은 하루되세요.");
		for(String insa:insaList) {
			System.out.println(insa);
		}		
		insaList = null;//캔티데이트상태로 전환-넌 쓰레기 값이야.찜 destroy()
		Resource resource = 
				new FileSystemResource
				("D:\\workspace_sts3\\spring3\\src\\main\\java\\com\\mycompany\\online\\insaBean.xml");
		//getBean()메소드가 호출될 때 까지 Bean의 생성을 미룸.
		////spring-core.jar - 빈을 관리하는 공장2
		BeanFactory factory = new XmlBeanFactory(resource);
		ListController list = (ListController)factory.getBean("insaBean");
		//List<String> list = (ListController)factory.getBean("insaBean");
		System.out.println(list.listBean);
	}
}







