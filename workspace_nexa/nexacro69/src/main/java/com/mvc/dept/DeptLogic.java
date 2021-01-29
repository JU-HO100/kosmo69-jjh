package com.mvc.dept;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptLogic {
	  Logger logger = Logger.getLogger(DeptLogic.class);
	   @Autowired
	   private DeptDao deptDao = null;
	   public List<Map<String,Object>> deptList(){
	      logger.info("Logic deptList 호출 ");
	      List<Map<String,Object>> deptList = null;
	      deptList = deptDao.deptList();
	      return deptList;
	   }

}
