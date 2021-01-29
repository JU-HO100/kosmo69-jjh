package com.recipe;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
//DAO = Data Access Object 디자인 패턴이다.
//@Repository //가 올 수도 있다.
@Service
public class SqlMemberDao {
	Logger logger = LogManager.getLogger(SqlMemberDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	//insert into board_master_t(b_no,b_title,b_name) values(?,?,?)
	public int MemberInsert(Map<String, Object> pmap) {
		logger.info("Dao recipeMInsert 호출"+pmap);
		int result = 0;
		String cday = sqlSessionTemplate.selectOne("cday",pmap);
		logger.info(cday);
		return result;
	}
	
	public List<Map<String, Object>> memberList(Map<String, Object> pmap) {
		logger.info("MDao recipeList 호출");
		List<Map<String,Object>> rList = null;
		rList = sqlSessionTemplate.selectList("recipeList",pmap);
		return rList;
	}
	
}
