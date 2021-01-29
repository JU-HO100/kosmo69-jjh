package np.admin.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDao {
	Logger logger = LogManager.getLogger(AdminDao.class);


	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;


	/*****************************************
	 관리자 전용 검색기능 (검색은 전체관리자 권한 가능)
	 @param	
	 	-field
	 		-ADMIN_RIGHT			: 관리자 권한 리스트
	 		-ADMIN_BOARD			: 레시피 게시판 관련 검색
	 		-ADMIN_MEMBER			: 회원 관련 검색
	 		-ADMIN_CLASS			: 쿠킹클래스 관련 검색
			
	 	-category 				= 어떤 카테고리로 검색할지?
	 	
	 		-ADMIN_BOARD(field) 일 때
	 			-'MENUCD','CATEGORY','FOODGROUP','FOODNAME','HASHTAG'
	 			  ,'M_ID','M_NICK','CREATION_DATE','HIT','M_STATUS','B_STATUS'
	 			  
	 		-ADMIN_MEMBER(field) 일 때
	 			-'M_ID','M_NICK','M_ZIP','M_HP','M_NAME','M_DAY','M_GENDER'
	 			,'M_BIRTH','AGE','M_MAIL','CHEF_APPLY','CHECKBLIST','REPORT'
	 			
	 		-ADMIN_CLASS(field) 일 때
	 			-'C_CLASSCD','M_ID','M_NICK','M_STATUS','CHEF_ID','CHEF_NICK'
	 			,'COOK_NAME','C_NEEDS','C_ZIP','C_ZIPDETAIL'
	 		
	 	-keyword				= 일반 키워드 검색
	 	-option_keyword1		= A ~ B 검색이 필요할때의 A 검색어
	 	-option_keyword2		= A ~ B 검색이 필요할때의 B 검색어
	 ****************************************/
	public List<Map<String, Object>> adminSearch(Map<String, Object> pmap) {
		logger.info("adminSearch dao 호출");
		List<Map<String, Object>> list = new ArrayList<>();
		sqlSessionTemplate.selectOne("proc_admin_search", pmap);
		list = (ArrayList) pmap.get("search");
		for(Map<String,Object> map:list) {
			logger.info("DAO>>adminSearch>>"+map);
			}
		return list;
	}
	
	/*****************************************
	 총관리자, 멤버관리자 전용
	 @param	
	 	-field
	 		-GIVE_RIGHT 		 		: (총관리자only) 권한 위임
			-DELETE						: (총관리자only) 권한 삭제
			-PUT_BLACK					: (멤버관리자) 블랙리스트 추가
			-PUT_PAUSE					: (멤버관리자) 일시정지리스트 추가
			-RELEASE_PAUSE_MEM			: (멤버관리자) 일시정지회원 풀어주기
			-READ_WRITTING				: (멤버관리자) 셰프신청글 보기
			-COMMIT_CHEF				: (멤버관리자) 셰프로 승격시켜주기
			
	 	-admin_id 			= 어드민 계정 아이디
	 	-m_id				= 어드민으로 조정시킬 아이디
	 	-right				= 무슨 권한?
	 ****************************************/
	public List<Map<String, Object>> adminMemDao(Map<String, Object> pmap) {
		logger.info("adminMemDao 호출");
		List<Map<String, Object>> list = new ArrayList<>();
		sqlSessionTemplate.selectOne("proc_admin_mem_controller", pmap);
		list = (ArrayList) pmap.get("masterCsr");
		for(Map<String,Object> map:list) {
			logger.info("DAO>>adminMemDao>>"+map);
			}
		return list;
	}
	
	/*****************************************
	 게시판, 쿠킹클래스 관리자 전용
	 @param	
	 	-field
	 		-DELETE_COOKCLASS		:(쿠킹클래스관리자) 쿠킹클래스 강제 제거
	 		-KICK_PERSON_CC			:(쿠킹클래스관리자) 쿠킹클래스내 회원 제거
	 		-DELETE_BOARD			:(게시판관리자)		게시글 강제 삭제
			
	 	-admin_id 			= 어드민 계정 아이디
	 	-m_id				= 어드민으로 조정시킬 아이디
	 	-b_c_num			= 게시판번호 or 쿠킹클래스번호
	 ****************************************/
	public String adminBCDao(Map<String, Object> pmap) {
		logger.info("adminSearc dao 호출");
		String msg = null;
		List<Map<String, Object>> list = new ArrayList<>();
		sqlSessionTemplate.selectOne("proc_admin_other_control", pmap);
		list = (ArrayList) pmap.get("masterCsr");
		for(Map<String,Object> map:list) {
			msg = (String)map.get("MSG");
			logger.info("DAO>>adminBCDao>>"+msg);
		}
		return msg;
	}
	
}
