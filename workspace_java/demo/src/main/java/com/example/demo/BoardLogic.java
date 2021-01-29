package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * AOP 프레임 워크를 활용하여 트랜잭셕 처리하는 구간임. 
 */
@Service
public class BoardLogic {
   Logger logger = LogManager.getLogger(BoardLogic.class);
   
   //false일때는 해당 클래스가 없어도 에러가 아니지만 true일땐 필수이니까 에러 발생한다.
   @Autowired(required=false)
   private SqlBoardMDao sqlBoardMDao= null;
   
   @Autowired(required=false)
   private SqlBoardDDao sqlBoardDDao= null;
   
   public int boardInsert(Map<String, Object> pMap) {
      logger.info("Logic Insert 호출"+pMap);
      int bm_no = 0;
      int bm_group = 0;
      if(pMap.get("bm_group")!=null) {
         bm_group = Integer.parseInt(pMap.get("bm_group").toString());
      }
      //글번호 채번한 결과를 파라미터에 저장
      bm_no = sqlBoardMDao.getBmno();
      pMap.put("bm_no",bm_no);
      //너 댓글이니?
      if(bm_group > 0) {
         pMap.put("bm_group",bm_group);
         sqlBoardMDao.bmStepUpdate(pMap);
         int pos = 0;
         int step = 0;
         if(pMap.get("bm_pos") !=null) {
            pos = Integer.parseInt(pMap.get("bm_pos").toString());
         }
         pMap.put("bm_pos", pos+1);
         if(pMap.get("bm_step") !=null) {
            step = Integer.parseInt(pMap.get("bm_step").toString());
         }
         pMap.put("bm_step", step+1);
      }
      //너 새글이야?
      else { 
         bm_group = sqlBoardMDao.getBmGroup();
         pMap.put("bm_group", bm_group);
         pMap.put("bm_pos", 0);
         pMap.put("bm_step", 0);
      }
      int mresult = sqlBoardMDao.boardMInsert(pMap);
      //첨부파일이 있니?
      if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length() > 1) {
         pMap.put("bm_no",bm_no);
         pMap.put("bs_seq",1);
         int dresult = sqlBoardDDao.boardDInsert(pMap);
      }
      return mresult;
   }
   
   public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
      logger.info("boardList 호출 성공"+pMap);
      List<Map<String, Object>> bList = new ArrayList<>();
      bList = sqlBoardMDao.boardList(pMap);
      String gubun = "";
      if(pMap.get("gubun")!=null) {
    	  gubun = pMap.get("gubun").toString();
      }
      //조건을 두 가지로 함 :조건검색의 결과가 하나의 로우인 경우도 포함되니까 gubun키값을 추가
      if(bList.size()==1 && "detail".equals(pMap.get("gubun").toString())) {
    	  logger.info("Logic List gubun"+"gubun");
    	  int bm_no = 0;
    	  if(pMap.get("bm_no")!=null) {
    		  bm_no = Integer.parseInt(pMap.get("bm_no").toString());
    	  }
    	  sqlBoardMDao.hitCount(bm_no);
      }
      return bList;
   }

	public int boardDelete(Map<String, Object> pMap) {
		int result = 0;
		try {
			String filePath = "C:\\workspace_java\\spring3_1\\src\\main\\webapp\\pds\\";
			String filename = pMap.get("bs_file").toString();
			String fullPath = filePath+filename;
			//실제 존재하는 파일 이름을 객체로 생성하기
			File file = new File(fullPath);
			logger.info("file:"+file);
			if(file !=null) {//첨부파일이 널이 아니야?
				if(file.exists()) {
					pMap.put("bs_file",1);
					result = sqlBoardDDao.baordDDelete(pMap);
					boolean isOk = file.delete();
					logger.info(isOk);
					
				} else {// 아니 널이야
					result = -1;
				}
				logger.info("result : "+ result);
				if(result==-1 || result == 1) {
					
				}
			} else {
				logger.info("result : "+ result);
				sqlBoardMDao.boardMDelete(pMap);
				result = 1;
			}
		} catch (Exception e) {
			logger.info("Exception:"+e.toString());
		}
		return 0;
	}/////////////////////// end of delete
	
	public int boardUpdate(Map<String,Object> pMap) {
		logger.info("Logic Update 호출");
		int result = 0;
		result = sqlBoardMDao.boardMUpdate(pMap);
		//첨부파일이 존재하니?
		if(pMap.get("hbs_file")!=null && pMap.get("hbs_file").toString().length()>1) {
			sqlBoardDDao.boardDUpdate(pMap);
		}
		return result;
	}/////////////////////// end of update

}