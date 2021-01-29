package com.mycompany.online;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/******************************************************************
 * 
 * insaBean.xml 문서를 스캔하자.
 * 왜냐하면 객체주입, 의존성 주입 받고 싶다면....
 * 스캔한 내용은 스프링에서 제공하는 ApplicationContext나 혹은 BeanFactory 를 통해서 관리 받을 수 있다.
 * 그 중에서 BeanFactory 로 진행 하였다.
 * parsing error 발생한 상황, bean create 받지 못하는 문제로 에러발생
 * ListController 에 대한 빈 생성 이라는 사실을 착각 - List<String>
 *
 *******************************************************************/
public class ListMainApp {
	   List<String> listList = null;
	   public void setListList(List<String> listList) {
	      this.listList = listList;
	   }
	   // 프레임워크에는 그 사람의 사상이 들어있다.
	   // 프레임워크는 그 사람의 생각에서 시작되었다.
	   public static void main(String[] args) {
	      ListMainApp lma = new ListMainApp();
	      // Context를 시작시킬 때 모든 Singleton Bean을 미리 로딩함으로써 빈이 필요할 때 즉시 사용할 수 있도록 보장해준다.
	      // spring-core.jar 에서 관리해준다. - Bean을 관리 해주는 공장. 1번! - 더 많은 기능을 지원 한다. 2번 보다..
	      // 어플리케이션 동작시 Bean 생성 되기 를 기다릴 필요가 없다.
	      // Spring 에게 의존하는 (주입받는, 제어권이 나한테 없는) 방법은 getBean()을 호출함으로써 얻어낸다. 
	      // 주소번지를... 누구를? spring에서 ApplicationContext 에서 -> spring-core.jar 에서
	      /*******************************************************************************************************************************
	       * Bean의 생성과 소멸을 담당한다. <bean id="member-controller" class="com.xxx.MemeberController"/>
	       * Bean 생성시 에 필요한 속성을 정의할 수 있다.
	       * <bean>
	       *  <property bame="listBean"></property>
	       * </bean>
	       * Bean LifeCycle에 대한 메소드를 호출할 수 있다.
	       * init() - service() - destroy() 지원한다. - Spring 에서도 똑같이..
	       * <bean id="member-controller" class="com.xxx.MemeberController" init-method="initMethod" destroy-method="destroyMethod"/>
	       * init-method : 해당 빈이 초기화 된 후 호출되는 메소드
	       * destroy-method : 해당 빈이 소멸되기 전에 호출되는 메소드
	       *******************************************************************************************************************************/
	      ApplicationContext context = new ClassPathXmlApplicationContext("com\\mycompany\\online\\insaBean.xml");
	      ListController list2 = (ListController)context.getBean("insaBean");
	      for(String insa:list2.listBean) {
	    	  System.out.println(insa); // 제어역전 , DI 으로 받는 거다
	    	  // 인사는 Hi ~!     // 제어역전 , DI 으로 받는 거다
	    	  // 인사는 Hello ~!	// 제어역전 , DI 으로 받는 거다
	    	  // 인사는 Bye ~!		// 제어역전 , DI 으로 받는 거다
	      }
	      List<String> insaList = null;
	      insaList = new ArrayList<>();
	      insaList.add("안녕"); // 순제어
	      insaList.add("안녕하세요."); // 순제어
	      insaList.add("기분좋은 하루 되세요."); // 순제어
	      for(String insa:insaList) {
	    	  System.out.println(insa);
	      }
	      insaList = null; // 캔디데이트상태로 전환한다. - 넌 쓰레기 값이야. 찜 destroy()
	      Resource resource = new FileSystemResource("C:\\workspace_sts3\\spring3\\src\\main\\java\\com\\mycompany\\online\\insaBean.xml");
//	      Resource resource = new FileSystemResource("com\\mycompany\\online\\insaBean.xml");
	      // getBean() 메소드가 호출될 때 까지 Bean의 생성을 미룬다.
	      // spring-core.jar 에서 관리해준다. - Bean을 관리 해주는 공장. 2번!
	      BeanFactory factory = new XmlBeanFactory(resource);
	      ListController list = (ListController)factory.getBean("insaBean"); 
	      System.out.println(list.listBean); //  제어역전 , DI 으로 받는 거다 [인사는 Hi ~!, 인사는 Hello ~!, 인사는 Bye ~!]
	   }
}	
