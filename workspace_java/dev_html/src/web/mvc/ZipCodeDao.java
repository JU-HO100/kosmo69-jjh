package web.mvc;

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

public class ZipCodeDao {
	Logger logger  = Logger.getLogger(EmpDao.class);
	//myBatis연동시 공통부분을 클래스로 분할해 보기(반복되는 코드는 개선해 본다)
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	//xml문서가 물리적으로 어디에 있는지를 알아야 함.-어느 회사 제품인지, 서버의 IP주소, port번호, 계정정보
	String resource = "com/util/Configuration.xml";
	SqlSessionFactory sqlMapper = null;	
	/*
	 * 제목: 동정보를 입력받아서 우편번호 조회하기 구현 - Map
	 * @param dong 사용자가 입려한 동 이름을 받는다
	 * @return List<Map<String,Object>> - n건 조회 -> 사용자가 선택(onDblClickRow, onSelect) -> 등록화면에 우편번호 넣기
	 * @author 이순신 2020년 11월 07일 수정중
	 */
	public List<Map<String,Object>> getZipCodeList(String dong){
		List<Map<String,Object>> zipList = null;
		SqlSession session = null;
		try {
			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어와야 함.Reader<->Writer
			//문서를 읽는데 필요한 클래스
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper "+sqlMapper);
			//커넥션 연결 위한 사전 코드
			//아래서 생성한 session은 insert(), update(), delete(), selectOne, selectList, selectMap
			session = sqlMapper.openSession();
			zipList = session.selectList("getZipCodeList", dong);
			logger.info("zipList : "+zipList);
//			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}////////////////////////////// end of try-catch-finaly ////////////////////////////////
		return zipList;
	}/////////////////////////////////// end of ZipCode Map ///////////////////////////////////////
	/*
	 * 제목: 동정보를 입력받아서 우편번호 조회하기 구현 - VO
	 * @param dong 사용자가 입려한 동 이름을 받는다
	 * @return List<ZipCodeVO> - n건 조회 -> 사용자가 선택(onDblClickRow, onSelect) -> 등록화면에 우편번호 넣기
	 * @author 이순신 2020년 11월 06일 수정 완료
	 */
	public List<ZipCodeVO> getZipCodeList2(String dong){
		SqlSession session = null;
		List<ZipCodeVO> zipList = null;
		try {
			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어와야 함.Reader<->Writer
			//문서를 읽는데 필요한 클래스
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper "+sqlMapper);//로그확인용
			session = sqlMapper.openSession();//연결이 됨 - 쿼리문을 요청할 수 있다.
			zipList = session.selectList("getZipCodeList2", dong);
			logger.info("zipList : "+zipList);
//			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}////////////////////////////// end of try-catch-finaly ////////////////////////////////	
		return zipList;
	}////////////////////////////////// end of ZipCode VO /////////////////////////////////////
	public List<Map<String,Object>> getZdo(){
		List<Map<String,Object>> zdoList = null;
		SqlSession session = null;
		try {
			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어와야 함.Reader<->Writer
			//문서를 읽는데 필요한 클래스
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper "+sqlMapper);
			//커넥션 연결 위한 사전 코드
			//아래서 생성한 session은 insert(), update(), delete(), selectOne, selectList, selectMap
			session = sqlMapper.openSession();
			zdoList = session.selectList("getZdo");//getZipCodeList3
			logger.info("zdoList : "+zdoList);
//			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}////////////////////////////// end of try-catch-finaly ////////////////////////////////
		return zdoList;
	}
	public List<Map<String,Object>> getAddress(Map<String,Object> pmap){
		List<Map<String,Object>> addrList = null;
		SqlSession session = null;
		try {
			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어와야 함.Reader<->Writer
			//문서를 읽는데 필요한 클래스
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper "+sqlMapper);
			//커넥션 연결 위한 사전 코드
			//아래서 생성한 session은 insert(), update(), delete(), selectOne, selectList, selectMap
			session = sqlMapper.openSession();
			addrList = session.selectList("getAddress",pmap);//getZipCodeList3
			logger.info("addrList : "+addrList);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}////////////////////////////// end of try-catch-finaly ////////////////////////////////
		return addrList;
	}
	
//	public static void main(String[] args) {
//		ZipCodeDao zDao = new ZipCodeDao();
//		List<Map<String,Object>> aList = new ArrayList<>();
//		Map<String,Object> amap = new HashMap<>();
//		amap.put("key", "가산동");
//	}
	
}
 