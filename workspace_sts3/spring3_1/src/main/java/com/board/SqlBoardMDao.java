package com.board;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class SqlBoardMDao {
	Logger logger = Logger.getLogger(SqlBoardMDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	//insert into board_master_t(b_no, b_title,,,,,) values(seq_board_no.nextval, "안녕하세요",..)
	public int boardMInsert(Map<String, Object> pMap) {
		logger.info("boardMInsert 호출 성공"+pMap);
		int result = 0;
		result = sqlSessionTemplate.insert("boardMInsert",pMap);
		logger.info(result);
		return result;
	}
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> bList = null;
		bList = sqlSessionTemplate.selectList("boardList",pMap);
		return bList;
	}
	//board_master69에 들어갈 글번호 채번하기
	public int getBmno() {
		logger.info("getBmno 호출 성공");
		int bm_no = 0;
		bm_no = sqlSessionTemplate.selectOne("getBmno");//getBmno
		logger.info("getBmno 호출 성공 bm_no:"+bm_no);
		return bm_no;
	}
	public void bmStepUpdate(Map<String, Object> pMap) {
		logger.info("bmStepUpdate 호출 성공"+pMap);
		int result = 0;
		result = sqlSessionTemplate.update("bmStepUpdate",pMap);
		logger.info(result);
	}
	public int getBmGroup() {
		logger.info("getBmGroup 호출 성공");
		int bm_group = 0;
		bm_group = sqlSessionTemplate.selectOne("getBmGroup");//getBmno
		logger.info("getBmGroup 호출 성공 bm_group:"+bm_group);
		return bm_group;
	}
	public void boardMDelete(Map<String, Object> pmap) {
		logger.info("MDao Delete 호출 성공"+pmap);
		int result = 0;
		result = sqlSessionTemplate.delete("boardMDelete",pmap);//id로 접근하기 때문에 insert로 해도 상관없다
		//sqlSessionTemplate.commit();
		//sqlSession.commit(); POJO에서 할때 사용 했음
		logger.info(result);
		
	}
}
