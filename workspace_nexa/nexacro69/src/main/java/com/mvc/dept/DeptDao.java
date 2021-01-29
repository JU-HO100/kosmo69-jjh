package com.mvc.dept;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptDao {
	Logger logger = Logger.getLogger(DeptDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate= null;
	public List<Map<String,Object>> deptList(){
		logger.info("Dao deptList");
		List<Map<String,Object>> deptList = new ArrayList<Map<String,Object>>();
		deptList = sqlSessionTemplate.selectList("deptList");
		return deptList;
		
	}
}
