package com.spring.mvc1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class DeptDao {
	Logger logger = Logger.getLogger(DeptLogic.class);

	public List<Map<String, Object>> deptList() {
		logger.info("deptList 호출 Dao");
		List<Map<String,Object>> deptList = new ArrayList<>();
		
		return deptList;
	}

}
