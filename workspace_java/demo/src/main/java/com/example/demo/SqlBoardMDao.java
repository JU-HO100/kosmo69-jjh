package com.example.demo;

import java.io.File;
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
public class SqlBoardMDao {
	Logger logger = LogManager.getLogger(SqlBoardMDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	//insert into board_master_t(b_no,b_title,b_name) values(?,?,?)
	public int boardMInsert(Map<String, Object> pmap) {
		logger.info("Dao boardMInsert 호출"+pmap);
		int result = 0;
		result = sqlSessionTemplate.insert("boardMInsert",pmap);
		logger.info(result);
		return result;
	}
	
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("MDao boardList 호출");
		List<Map<String,Object>> bList = null;
		bList = sqlSessionTemplate.selectList("boardList",pMap);
		return bList;
	}

	public void bmStepUpdate(Map<String, Object> pMap) {
		logger.info("bmStepUpdate 호출 성공"+pMap);
		int result = 0;
		result = sqlSessionTemplate.update("bmStepUpdate",pMap);
		logger.info(result);
	}

	public int getBmno() {
		logger.info("getBmno 호출 성공");
		int bm_no = 0;
		bm_no = sqlSessionTemplate.selectOne("getBmno");//getBmno
		logger.info("getBmno 호출 성공 bm_no:"+bm_no);
		return bm_no;
	}
	//글전체 레코드 구하기
	public int totalRecord() {
		logger.info("MDao totalRecord 호출");
		int tot = 0;
		tot = sqlSessionTemplate.selectOne("totalRecord");//getBmno
		logger.info("tot 호출 성공 tot:"+tot);
		return tot;
	}
	//글 그룹번호 채번하기
	public int getBmGroup() {
		logger.info("getBmGroup 호출 성공");
		int bm_group = 0;
		bm_group = sqlSessionTemplate.selectOne("getBmGroup");//getBmno
		logger.info("getBmGroup 호출 성공 bm_group:"+bm_group);
		return bm_group;
	}

	public void hitCount(int bm_no) {
		logger.info("hitCount 호출 성공");
		sqlSessionTemplate.update("hitCount",bm_no);//bm_no
	}

	public int boardMDelete(Map<String, Object> pMap) {
		logger.info("MDao Delete 호출");
		int result = 0;
		result = sqlSessionTemplate.delete("boardMDelete",pMap);
		logger.info(result);
		return result;
	}

	public int boardMUpdate(Map<String, Object> pMap) {
		logger.info("MDao Update 호출");
		int result = 0;
		result = sqlSessionTemplate.update("boardMUpdate",pMap);
		logger.info("MDao -> mybatis"+result);
		return result;
	}
	
}
