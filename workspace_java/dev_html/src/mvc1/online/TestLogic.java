package mvc1.online;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);
	SqlTestDao stdao = new SqlTestDao();
	public List<Map<String, Object>> subjectList() {
		logger.info("시험과목 목록 호출");
    	List<Map<String,Object>> subList = null;
    	subList = stdao.subjectList();//select한다
    	if(subList == null) {//NullPointExection 방지 코드
    		subList = new ArrayList<>();
    	}
		return subList;
	}
	


}
