package com.recipe;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * AOP 프레임워크를 활용하여 트랜잭션 처리하는 구간인다.
 */
@Service
public class RecipeLogic {
	Logger logger = LogManager.getLogger(RecipeLogic.class);
	//required가 false일때는 해당 클래스가 없어도 에러가 아니지만 true일땐 필수이니까 에러가 발생한다.
	@Autowired(required=false)
	private SqlMemberDao sqlRecipeMDao = null;
	public int recipeInsert(Map<String, Object> pmap) {
		logger.info("boardList 호출 성공"+pmap);
		int result = 0;
		int mresult = sqlRecipeMDao.recipeMInsert(pmap);
		if(mresult==1) {
			result = 1;
		}
		return result;
	}
	
	public List<Map<String, Object>> boardList(Map<String, Object> pmap) {
		logger.info("boardList 호출 성공"+pmap);
		List<Map<String, Object>> bList = null;
		bList = sqlRecipeMDao.recipeList(pmap);
		return bList;
	}
	

}
