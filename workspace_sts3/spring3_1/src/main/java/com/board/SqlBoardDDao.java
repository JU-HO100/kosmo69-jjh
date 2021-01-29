package com.board;

import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
//DAO:Data Access Object 디자인패턴
@Service
public class SqlBoardDDao {
	Logger logger = Logger.getLogger(SqlBoardDDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public int boardDInsert(Map<String, Object> pMap) {
		logger.info("boardDInsert 호출 성공"+pMap);
		int result = 0;
		result = sqlSessionTemplate.insert("boardDInsert",pMap);
		logger.info(result);
		return result;
	}
	public void baordDDelete(Map<String, Object> pmap) {
		logger.info("DDao Delete 호출 성공"+pmap);
		int result = 0;
		result = sqlSessionTemplate.delete("boardMDelete",pmap);
		//sqlSessionTemplate.commit();
		//sqlSession.commit(); POJO에서 할때 사용 했음
		logger.info(result);
		
	}
}
