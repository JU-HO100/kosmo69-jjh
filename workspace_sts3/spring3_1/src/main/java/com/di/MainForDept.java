package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.mvc1.DeptController;
import com.spring.mvc1.DeptDao;
import com.spring.mvc1.DeptLogic;

public class MainForDept {
	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		DeptController deptController = context.getBean("deptController", DeptController.class);
		DeptLogic deptLogic = context.getBean("deptLogic", DeptLogic.class);
		DeptDao deptDao = context.getBean("deptDao", DeptDao.class);
		deptController.setDeptLogic(deptLogic);
		deptLogic.setDeptDao(deptDao);
		deptController.deptList();
		//System.out.println(deptController.deptList());
	}
}
