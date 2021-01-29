package com.spring.mvc1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class DeptLogic {
	Logger logger = Logger.getLogger(DeptLogic.class);
	private DeptDao deptDao = null;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	public List<Map<String, Object>> deptList() {
		logger.info("deptList 호출");
		List<Map<String,Object>> deptList = null;
		deptList = deptDao.deptList();
		return deptList;
	}

}
