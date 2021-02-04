package np.mem.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import np.com.util.MyBatisCommonFactory;


public class CookClassDao {
	Logger logger = Logger.getLogger(CookClassDao.class);
	private static final String NAMESPACE = "np.mem.mybatis.CookClassMapper.";
	private SqlSessionFactory sqlMapper = null;
	
	// 싱글톤
	private static CookClassDao instanceDao = new CookClassDao();
	private CookClassDao() {
		sqlMapper = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public static CookClassDao getInstance() {
		return instanceDao;
	}
	
	/*****************************************
	 쿠킹클래스
	 @param	
	 	- field
			  	- OPEN_COOKCLASS		: (셰프전용)쿠킹클래스 생성
			  	- ATTEND_COOKCLASS 		: 쿠킹클래스 참가
			  	- UPD_COOKCLASS			: (셰프전용)쿠킹클래스 수정
			  	
	  	- c_classcd			= 쿠킹클래스 번호
	  	- m_id				= 본인 아이디
	  	- c_cook			= 요리명 혹은 글제목		↓ 쿠킹클래스 생성시 필요
	  	- c_ingredients		= 준비물
	  	- c_zip				= 주소
	  	- c_zipdetail		= 상세주소
	  	- c_member			= 최대인원
	  	- c_date			= 집합날짜
	  
	 ****************************************/
	public String cookingClass(Map<String,Object> pmap) {
		SqlSession session = null;
		String regiMsg=null;
		try {
			session = sqlMapper.openSession();
			session.selectOne(NAMESPACE+"proc_cookclass",pmap);
			regiMsg = pmap.get("msg").toString();
			logger.info(regiMsg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return regiMsg;
	}
	
	/*****************************************
	 쿠킹클래스 취소
	 	* 셰프일땐 쿠킹클래스 삭제, 회원일땐 그냥 취소
	 @param	
	  -c_classcd		= 쿠킹클래스 번호
	  -m_id 			= 회원 아이디(로그인중인 내 아이디)
	 ****************************************/
	public String cancelClass(Map<String,Object> pmap) {
		SqlSession session = null;
		String regiMsg=null;
		try {
			session = sqlMapper.openSession();
			session.selectOne(NAMESPACE+"proc_cancel_cookclass",pmap);
			regiMsg = pmap.get("msg").toString();
			logger.info(regiMsg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return regiMsg;
	}
	
	/*****************************************
	 쿠킹클래스 리스트
	 @param	
	 	-m_id 	= 로그인전용 페이지이라서 사용
	 ****************************************/
	public List<Map<String, Object>> showClass(Map<String,Object> pmap) {
		List<Map<String, Object>>list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			session.selectOne(NAMESPACE+"proc_show_cookclass",pmap);
			logger.info(pmap);
			list = (ArrayList)pmap.get("csr");
			for(Map<String,Object> map:list) {
				logger.info("DAO>>showClass>>"+map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	
	/*****************************************
	 셰프전용
	 클래스 신청 회원보기
	 신청회원 수락, 신청회원 반려
	 @param	
	 	-field 
	 		- SHOW_APPLY_USERS		: 내 쿠킹클래스 신청한 회원 목록 보기
	 		- ACCEPT_MYCLASS		: 선택 회원을 내 쿠킹클래스에 등록시키기
	 		- DENY_MYCLASS			: 선택 회원을 내 쿠킹클래스에서 거절하기
	 	-chef_id				= 셰프 아이디(내 아이디)
	 	-c_classcd				= 클래스 번호
	 	-m_id					= 처리할 회원 아이디
	 ****************************************/
	public List<Map<String, Object>> classForChef(Map<String,Object> pmap) {
		List<Map<String, Object>>list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			session.selectOne(NAMESPACE+"proc_cookclass_forChef",pmap);
			logger.info(pmap);
			list = (ArrayList)pmap.get("csr");
			for(Map<String,Object> map:list) {
				logger.info("DAO>>classForChef>>"+map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
