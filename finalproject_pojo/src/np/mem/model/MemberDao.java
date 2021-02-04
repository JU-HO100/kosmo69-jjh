package np.mem.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import np.com.util.MyBatisCommonFactory;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	private static final String NAMESPACE = "np.mem.mybatis.MemberMapper.";
	private SqlSessionFactory sqlMapper = null;
	
	// 싱글톤
	private static MemberDao instanceDao = new MemberDao();
	private MemberDao() {
		sqlMapper = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public static MemberDao getInstance() {
		return instanceDao;
	}
	

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
	public String memRegister(Map<String,Object> pmap) {
		SqlSession session = null;
		String regiMsg=null;
		try {
			session = sqlMapper.openSession();
			// 물음표에 매개변수로 전달된 데이터 매핑
			session.selectOne(NAMESPACE+"proc_Regi",pmap);
			regiMsg = pmap.get("msg").toString();
			logger.info(regiMsg);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return regiMsg;
	}
	
	
	/********************************
	 * 회원탈퇴
	 * @param 
			- m_id			= 아이디
			- m_pw			= 비밀번호
	 *********************************/
	public String withDraw(Map<String,Object> pmap){
		SqlSession session = null;
		String deleteMsg=null;
		try {
			session = sqlMapper.openSession();
			session.selectOne(NAMESPACE+"proc_mem_withdrawal",pmap);
			deleteMsg = pmap.get("msg").toString();
			logger.info(deleteMsg);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return deleteMsg;
	}
	
	
	/********************************
	 * 로그인
	 * @param 
			- m_id			= 아이디
			- m_pw			= 비밀번호
	 *********************************/
	public List<Map<String, Object>> Login(Map<String,Object> pmap) {
		List<Map<String, Object>>list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			session.selectOne(NAMESPACE+"proc_mem_login",pmap);
			logger.info(pmap);
			list = (ArrayList)pmap.get("csr");
			for(Map<String,Object> map:list) {
				logger.info("DAO>>Login>>"+map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	
	/********************************
	 * 회원정보 수정
	 * @param 
			- m_id				= 아이디(고정)
			- m_pw			= 현재 비밀번호
			- c_pw				= 바꿀 비밀번호
			- c_zip				= 바꿀 주소
			- c_hp				= 바꿀 전화번호
			- c_nick			= 바꿀 닉네임
			- c_mail			= 바꿀 이메일주소
	 *********************************/
	public String updateMypage(Map<String,Object> pmap){
		SqlSession session = null;
		String updateMsg=null;
		try {
			session = sqlMapper.openSession();
			session.selectOne(NAMESPACE+"proc_mem_update",pmap);
			updateMsg =  pmap.get("msg").toString();
			logger.info(updateMsg);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return updateMsg;
	}
	
	
	//단일 데이터라 쓸데없지만 커서로 한번 받아봄 ㅎㅎ
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
	public String forgotID_PW(Map<String,Object> pmap) {
		List<Map<String, Object>>list = new ArrayList<>();
		String msg = null;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			session.selectOne(NAMESPACE+"proc_idpw_search",pmap);
			logger.info(pmap);
			list = (ArrayList)pmap.get("csr");
			for(Map<String,Object> map:list) {
				logger.info(map.get("M_ID"));
				if(map.get("MSG")== null) {
					msg = map.get("M_ID").toString();
				}else {
					msg= map.get("MSG").toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
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
	public String chefResume(Map<String,Object> pmap) {
		SqlSession session = null;
		String msg=null;
		try {
			session = sqlMapper.openSession();
			// 물음표에 매개변수로 전달된 데이터 매핑
			session.selectOne(NAMESPACE+"proc_chef_resume",pmap);
			msg = pmap.get("msg").toString();
			logger.info(msg);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return msg;
	}
	
	
	/********************************
	 * 회원 신고
	 * @param 
			- m_id				= 내 아이디
			- user_id			= 신고할 아이디
	 *********************************/
	public String memReport(Map<String,Object> pmap) {
		SqlSession session = null;
		String msg=null;
		try {
			session = sqlMapper.openSession();
			// 물음표에 매개변수로 전달된 데이터 매핑
			session.selectOne(NAMESPACE+"proc_mem_report",pmap);
			msg = pmap.get("msg").toString();
			logger.info(msg);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
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
	public List<Map<String, Object>> chefDetail(Map<String,Object> pmap) {
		List<Map<String, Object>>list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			session.selectOne(NAMESPACE+"proc_chef_list",pmap);
			logger.info(pmap);
			list = (ArrayList)pmap.get("csr");
			for(Map<String,Object> map:list) {
				logger.info("DAO>>chefDetail>>"+map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
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
	public List<Map<String, Object>> myPage(Map<String,Object> pmap){
		List<Map<String, Object>> list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			session.selectList(NAMESPACE+"proc_check_mypage",pmap);
			logger.info(pmap);
			list = (ArrayList)pmap.get("csr");
			for(Map<String,Object> map:list) {
				logger.info("DAO>>myPage>>"+map);
			}
			logger.info(pmap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	   /********************************
	    * 셰프 전용(쿠킹클래스등록) 페이지를 위한 조건
	    * @param 
	         - m_id               = 내 아이디(셰프인지 아닌지 체크)
	    *********************************/
	   public String checkChef(Map<String, Object> pmap) {
	      SqlSession session = null;
	      String msg=null;
	      try {
	         session = sqlMapper.openSession();
	         // 물음표에 매개변수로 전달된 데이터 매핑
	         session.selectOne(NAMESPACE+"proc_chef_Check",pmap);
	         msg = pmap.get("msg").toString();
	         logger.info(msg);
	         session.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return msg;
	   }
	


}
