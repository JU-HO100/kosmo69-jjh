package com.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.mvc1.DeptController;
import com.spring.mvc1.DeptDao;
import com.spring.mvc1.DeptLogic;

@Configuration
public class AppContext {
	
	//<bean id="deptController" class="com.di.DeptController"/>
	@Bean
	public DeptController deptController() {
		return new DeptController();//여기서 new는 spring이 해준다. - 내가 관리하지 않는다. 이유 - 메소드 위에 @Bean을 받았기 때문에
	}
	@Bean
	public DeptLogic deptLogic() {
		return new DeptLogic();//여기서 new는 spring이 해준다. - 내가 관리하지 않는다. 이유 - 메소드 위에 @Bean을 받았기 때문에
	}
	@Bean
	public DeptDao deptDao() {
		return new DeptDao();//여기서 new는 spring이 해준다. - 내가 관리하지 않는다. 이유 - 메소드 위에 @Bean을 받았기 때문에
	}
	
}
