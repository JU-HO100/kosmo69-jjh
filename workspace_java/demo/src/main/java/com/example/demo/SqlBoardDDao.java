package com.example.demo;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//DAO = Data Access Object 디자인 패턴이다.
@Service
public class SqlBoardDDao {
	Logger logger = LogManager.getLogger(SqlBoardDDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	public int boardDInsert(Map<String, Object> pmap) {
		logger.info("DDao boardDInsert 호출"+pmap);
		int result = 0;
		result = sqlSessionTemplate.insert("boardDInsert",pmap);
		logger.info(result);
		return result;
	}
	public int baordDDelete(Map<String, Object> pMap) {
		logger.info("DDao Delete 호출");
		int result = 0;
		result = sqlSessionTemplate.delete("boardDDelete",pMap);
		logger.info(result);
		return result;
	}
	public void boardDUpdate(Map<String, Object> pMap) {
		logger.info("DDao Update 호출");
		int result = 0;
		result = sqlSessionTemplate.update("boardDUpdate",pMap);
		logger.info("DDao -> mybatis"+result);
	}
	
}	
