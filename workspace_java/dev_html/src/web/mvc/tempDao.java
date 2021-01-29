package web.mvc;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class tempDao {
	Logger logger = Logger.getLogger(tempDao.class);
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	String resource = "com/util/Configuration.xml";
	SqlSessionFactory sqlMapper = null;
	int result = 0;
	
	public List<Map<String,Object>> getTempList(){
		List<Map<String,Object>> tempList = null;
		SqlSession session = null;
		try {
		Reader reader = Resources.getResourceAsReader(resource);
		sqlMapper = new SqlSessionFactoryBuilder().build(reader, "development2");
		logger.info("sqlMapper "+sqlMapper);
		session = sqlMapper.openSession(true);
		tempList = session.selectList("getTempList");
			logger.info("boardList : " + tempList);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
		}
		if(tempList==null) {
			tempList = new ArrayList<>();
		}
		return tempList;
	}
	public List<Map<String,Object>> getYearList(){
		List<Map<String,Object>> yearlist = null;
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader, "development2");
			logger.info("sqlMapper "+sqlMapper);
			session = sqlMapper.openSession(true);
			yearlist = session.selectList("getYearList");
			logger.info("boardList : " + yearlist);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
		}
		if(yearlist==null) {
			yearlist = new ArrayList<>();
		}
		return yearlist;
	}
	public List<Map<String,Object>> getConTempList(Map<String,Object> pMap){
		List<Map<String,Object>> conTempList = null;
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader, "development2");
			logger.info("sqlMapper "+sqlMapper);
			session = sqlMapper.openSession(true);
			conTempList = session.selectList("getConTempList", pMap);
			logger.info("boardList : " + conTempList);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
		}
		if(conTempList==null) {
			conTempList = new ArrayList<>();
		}
		return conTempList;
	}
	public List<Map<String,Object>> getCalTempList(Map<String,Object> pMap){
		List<Map<String,Object>> calTempList = null;
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader, "development2");
			logger.info("sqlMapper "+sqlMapper);
			session = sqlMapper.openSession(true);
			calTempList = session.selectList("getCalTempList", pMap);
			logger.info("boardList : " + calTempList);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
		}
		if(calTempList==null) {
			calTempList = new ArrayList<>();
		}
		return calTempList;
	}
	/*
	public List<Map<String,Object>> getTempList(Map<String,Object> pMap){
		List<Map<String,Object>> tempList = null;
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader, "development2");
			logger.info("sqlMapper "+sqlMapper);
			session = sqlMapper.openSession(true);
			tempList = session.selectList("getTempList", pMap);
			logger.info("boardList : " + tempList);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
		}
		if(tempList==null) {
			tempList = new ArrayList<>();
		}
		return tempList;
	}
	*/
	//단위테스트용
	public static void main(String[] args) {
		tempDao tDao = new tempDao();
		Map<String,Object> pmap = new HashMap<>();
		/********** getBoardList 테스트
		pmap.put("ubNum","B_NUM");
		pmap.put("keyword","1");
		System.out.println(bDao.getBoardList(pmap));
		***********/
		pmap.put("sYear", 2011);
		pmap.put("eYear", 2012);
		pmap.put("gubun","MAX");
		pmap.put("sMonth", 01);
		pmap.put("eMonth", 03);
		
		List<Map<String, Object>> list = tDao.getCalTempList(pmap);
		System.out.println(list);
	}
}
