package np.mem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDao {
	Logger logger = LogManager.getLogger(MemberDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	/********************************
	 * 회원가입
	 * @param 
	 		- field
				 	-REGISTER			: 게시물 리스트
				  	-ID_CHECK			: 인기 게시물 리스트	(아이디 파라미터만 필요)
				    -NICK_CHECK			: 단일 게시물과 내용	(닉네임 파라미터만 필요)
			    
			- m_id					= 아이디
			- m_pw					= 비밀번호
			- m_zip					= 주소
			- m_hp					= 전화번호
			- m_name				= 이름
			- m_nick				= 닉네임
			- m_gender				= 성별
			- m_birth				= 생년월일
			- m_mail				= 이메일주소
	 *********************************/
	public String memRegister(Map<String, Object> pmap) {
		String regiMsg = null;
			sqlSessionTemplate.selectOne("proc_Regi", pmap);
			regiMsg = pmap.get("msg").toString();
			logger.info(regiMsg);
		return regiMsg;
	}

	/********************************
	 * 회원탈퇴
	 * @param 
			- m_id			= 아이디
			- m_pw			= 비밀번호
	 *********************************/
	public String withDraw(Map<String, Object> pmap) {
		String deleteMsg = null;
			sqlSessionTemplate.selectOne("proc_mem_withdrawal", pmap);
			deleteMsg = pmap.get("msg").toString();
			logger.info(deleteMsg);
		return deleteMsg;
	}

	/********************************
	 * 로그인
	 * @param 
			- m_id			= 아이디
			- m_pw			= 비밀번호
	 *********************************/
	public List<Map<String, Object>> Login(Map<String, Object> pmap) {
		List<Map<String, Object>> list = new ArrayList<>();
			sqlSessionTemplate.selectOne("proc_mem_login", pmap);
			logger.info(pmap);
			list = (ArrayList) pmap.get("csr");
			for (Map<String, Object> map : list) {
				logger.info("DAO>>Login>>" + map);
			}
		return list;
	}

	/********************************
	 * 회원정보 수정
	 * @param 
			- m_id				= 아이디(고정)
			- m_pw				= 현재 비밀번호
			- c_pw				= 바꿀 비밀번호
			- c_zip				= 바꿀 주소
			- c_hp				= 바꿀 전화번호
			- c_nick			= 바꿀 닉네임
			- c_mail			= 바꿀 이메일주소
	 *********************************/
	public String updateMypage(Map<String, Object> pmap) {
		String updateMsg = null;
			sqlSessionTemplate.selectOne("proc_mem_update", pmap);
			updateMsg = pmap.get("msg").toString();
			logger.info(updateMsg);
		return updateMsg;
	}

	/********************************
	 * ID & PW 찾기
	 * @param 
	 		- field
				 	-ID_SEARCH			: 아이디 찾기
				  	-PW_SEARCH			: 비밀번호 찾기
			    
			- m_id				= 아이디 (비밀번호찾기에만 필요함)
			- m_hp				= 전화번호
			- m_mail			= 이메일
	 *********************************/
	public String forgotID_PW(Map<String, Object> pmap) {
		List<Map<String, Object>> list = new ArrayList<>();
		String msg = null;
			sqlSessionTemplate.selectOne("proc_idpw_search", pmap);
			logger.info(pmap);
			list = (ArrayList) pmap.get("csr");
			for (Map<String, Object> map : list) {
				logger.info(map.get("M_ID"));
				if (map.get("MSG") == null) {
					msg = map.get("M_ID").toString();
				} else {
					msg = map.get("MSG").toString();
				}
			}
		return msg;
	}

	/********************************
	 * 셰프 양식서 제출
	 * @param 
	 		- field
				 	-POP_RECIPE_NUM			: 나의 인기 게시물 개수 체크(3개이상 or 3개미만)
				  	-SUBMIT_RESUME			: 셰프 양식서 보내기
			    
			- m_id					= 아이디
			- main_food				= 주력요리		[콤보박스]
			- writting				= 자기소개서
	 *********************************/
	public String chefResume(Map<String, Object> pmap) {
		String msg = null;
			// 물음표에 매개변수로 전달된 데이터 매핑
			sqlSessionTemplate.selectOne("proc_chef_resume", pmap);
			msg = pmap.get("msg").toString();
			logger.info(msg);
		return msg;
	}

	/********************************
	 * 회원 신고
	 * @param 
			- m_id				= 내 아이디
			- user_id			= 신고할 아이디
	 *********************************/
	public String memReport(Map<String, Object> pmap) {
		String msg = null;
			// 물음표에 매개변수로 전달된 데이터 매핑
			sqlSessionTemplate.selectOne("proc_mem_report", pmap);
			msg = pmap.get("msg").toString();
			logger.info(msg);
		return msg;
	}

	/********************************
	 * 셰프 랭킹, 그리고 거기서 셰프 클릭했을때 나오는 게시글
	 * @param 
	 		- field
				 	-CHEF_RANKING			: 좋아요 순으로 셰프 랭킹이 표시됨
				  	-CHECK_CHEF				: 셰프 아이디 클릭시 해당 셰프가 등록한 게시물 출력
			    
			- m_id					= 클릭한 셰프의 아이디
	 *********************************/
	public List<Map<String, Object>> chefDetail(Map<String, Object> pmap) {
		List<Map<String, Object>> list = new ArrayList<>();
			sqlSessionTemplate.selectOne("proc_chef_list", pmap);
			logger.info(pmap);
			list = (ArrayList) pmap.get("csr");
			for (Map<String, Object> map : list) {
				logger.info("DAO>>chefDetail>>" + map);
			}
		return list;
	}

	//리턴 결과로 아무것도 없기에 selectOne 으로 하던 selectList 로 하던 상관없다.
		/********************************
		 * 회원 상세보기 - 마이페이지, 나의 쿠킹클래스 체크
		 * @param 
		 		- field
					 	-MY_PAGE				: 내 정보
					  	-CHECK_COOKCLASS		: 내가 신청중인 쿠킹클래스 현황보기
				    
				- m_id					= 내 아이디
		 *********************************/
	public List<Map<String, Object>> myPage(Map<String, Object> pmap) {
		List<Map<String, Object>> list = new ArrayList<>();
			sqlSessionTemplate.selectList("proc_check_mypage", pmap);
			logger.info(pmap);
			list = (ArrayList) pmap.get("csr");
			for (Map<String, Object> map : list) {
				logger.info("DAO>>myPage>>" + map);
			}
			logger.info(pmap);
		return list;
	}
	
	public String checkChef(Map<String, Object> pmap) {
		String msg = null;
			// 물음표에 매개변수로 전달된 데이터 매핑
			sqlSessionTemplate.selectOne("proc_chef_Check", pmap);
			msg = pmap.get("msg").toString();
			logger.info(msg);
		return msg;
	}

}
