package mvc2.online;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);
	//객체 주입 대상
	private TestDao testDao = null;
	public TestLogic() {
		testDao = new TestDao();
	}
	public List<Map<String, Object>> swDesignExam() {
		logger.info("swDesignExam 호출");
		List<Map<String,Object>> testList = null;
		testList = testDao.swDesignExam();
		return testList;
	}
	public String isOk(Map<String, Object> pmap) {
		logger.info("isOk 호출");
		String msg = null;
		msg = testDao.isOk(pmap);
		return msg;	
	}
	public List<Map<String, Object>> subList() {
		logger.info("subjectList 호출");
		List<Map<String,Object>> subList = null;
		subList = testDao.subjectList();
		return subList;
	}
}
