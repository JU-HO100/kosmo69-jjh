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
		return new DeptController();
	}
	@Bean
	public DeptLogic deptLogic() {
		return new DeptLogic();
	}
	@Bean
	public DeptDao deptDao() {
		return new DeptDao();
	}
}
