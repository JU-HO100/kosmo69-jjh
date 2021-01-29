package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.mvc1.DeptController;

public class MainForDept {
	   public static void main(String args[]) {
	      ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
	      DeptController deptController = context.getBean("deptController", DeptController.class);
	      System.out.println(deptController.deptList());
	   }
	}