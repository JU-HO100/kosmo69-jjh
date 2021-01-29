package com.mvc3.board;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공"+pMap);
		List<Map<String, Object>> bList = null;
		return bList;
	}

}
