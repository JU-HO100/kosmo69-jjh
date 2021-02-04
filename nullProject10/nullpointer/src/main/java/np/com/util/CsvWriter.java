package np.com.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


public class CsvWriter {
	Logger logger = Logger.getLogger(CsvWriter.class);
	public int createCSV(List<Map<String, Object>> list, String title, String filepath){
		//false : 덮어쓰기  true : 새로운 데이터는 이어붙이기
		//FileWriter만 사용하면 한글 깨짐 에러가 남
		//BufferedWriter 를 같이 사용하자
		int resultCount =0;	
		try{
		    BufferedWriter fw = 
		            new BufferedWriter(new FileWriter(filepath+"\\"+title+".csv", false));

		    //head 세팅
		    fw.append("word,freq");
		    fw.newLine();
		for(Map<String, Object> rmap : list){
			 fw.write(rmap.get("KEYWORD")+","+rmap.get("KEYCOUNT"));
			  fw.newLine();
			  resultCount++;
			if(resultCount % 100 == 0) 
				logger.info("resultCount :"+resultCount + "//" + list.size());
		     }

			fw.flush();
		      // 객체 닫기
		      fw.close();

		}catch (Exception e) {
		  e.printStackTrace();
		}
			return resultCount;
		}
}
