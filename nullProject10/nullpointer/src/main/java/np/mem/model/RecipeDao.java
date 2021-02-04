package np.mem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeDao {
	Logger logger = LogManager.getLogger(RecipeDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	
	/*****************************************
	  글쓰기
	  @param
		  - category			= 대분류(양식, 중식, 한식, 일식)
		  - foodgroup			= 소분류(찜, 구이, 튀김, 디저트..) 
		  -	m_id				= 회원 아이디
		  - foodname			= 게시판제목
		  - main_img			= 게시판목록에서 사용할 이미지 경로	
		  - recipe_info			= 게시판 내용
		  - sub_img				= 게시판 본문에서 본문 Step과 같이 사용할 이미지	"이미지경로1,이미지경로2,..."
		  - jaelyo				= 문자열[ 재료('고추장, 된장, 양파, 대파')]	
		  - weight				= 문자열[ 계량('4,2,반,반')]
		  - unit				= 문자열[ 단위('Tbs, Tbs, 개, 쪽')]	
		  - hashtag				= 문자열[ 해시태그('사랑하는, 어머님께, 드리는, 선물 
	 ****************************************/
	public String boardWrite(Map<String, Object> pmap) {
		logger.info("boardWrite dao 호출");
		logger.info(pmap.get("category"));
		logger.info(pmap.get("foodgroup"));
		logger.info(pmap.get("m_id"));
		logger.info(pmap.get("foodname"));
		logger.info(pmap.get("main_img"));
		logger.info(pmap.get("recipe_info"));
		logger.info(pmap.get("sub_img"));
		logger.info(pmap.get("jaelyo"));
		logger.info(pmap.get("weight"));
		logger.info(pmap.get("unit"));
		logger.info(pmap.get("hashtag"));
		String regiMsg = null;
		sqlSessionTemplate.selectOne("proc_board_insert", pmap);
		regiMsg = pmap.get("msg").toString();
		logger.info(regiMsg);
		return regiMsg;
	}
	
	/*****************************************
	 글 수정(글 쓰기보다 글no 파라미터 한개 더 필요)
	 @param
		   - menucd 			= 게시판 번호
		   - category			= 대분류(양식, 중식, 한식, 일식) 
		   - foodgroup			= 소분류(찜, 구이, 튀김, 디저트..)
		   - m_id				= 회원 아이디
		   - foodname			= 게시판제목
		   - main_img			= 게시판목록에서 사용할 이미지 경로	
		   - recipe_info		= 게시판 내용
		   - sub_img			= 게시판 본문에서 본문 Step과 같이 사용할 이미지	"이미지경로1,이미지경로2,..."
		   - jaelyo				= 문자열[ 재료('고추장, 된장, 양파, 대파')]
		   - weight				= 문자열[ 계량('4,2,반,반')]
		   - unit				= 문자열[ 단위('Tbs, Tbs, 개, 쪽')]
		   - hashtag			= 문자열[ 해시태그('사랑하는, 어머님께, 드리는, 선물')] 
	 ****************************************/
	public String boardUpdate(Map<String, Object> pmap) {
		logger.info("boardUpdate dao 호출");
		String regiMsg = null;
		sqlSessionTemplate.selectOne("proc_board_update", pmap);
		regiMsg = pmap.get("msg").toString();
		logger.info(regiMsg);
		return regiMsg;
	}

	/*****************************************
	 글 삭제
	 @param
	  		- menucd				= 게시판 번호
	  		- m_id					= 회원아이디
	 ****************************************/
	public String boardDelete(Map<String, Object> pmap) {
		logger.info("boardDelete dao 호출");
		String regiMsg = null;
		sqlSessionTemplate.selectOne("proc_board_delete", pmap);
		regiMsg = pmap.get("msg").toString();
		logger.info(regiMsg);
		return regiMsg;
	}

	/********************************
	 * 게시물보기
	 * @param 
	 		- field
			 	-BOARD_LIST			: 게시물 리스트
			  	-POP_BOARD_LIST		: 인기 게시물 리스트
			    -BOARD_CONTENT		: 단일 게시물과 내용
			    
			- menucd			= 게시물 번호 (단일게시물 진입시 사용)
	 *********************************/
	public List<Map<String, Object>> boardView(Map<String, Object> pmap) {
		logger.info("boardView dao 호출");
		logger.info(pmap.get("menucd"));
		List<Map<String, Object>> list = new ArrayList<>();
		sqlSessionTemplate.selectOne("proc_board_list", pmap);
		list = (ArrayList) pmap.get("csr");
		for(Map<String,Object> map:list) {
			logger.info("DAO>>boardlist>>"+map);
		}
		return list;
	}
	
	/********************************
	 * 게시물 검색
	 * @param 
	  		- field
			  	-M_NICK				: 게시자 검색(정확한 이름 기수)
			  	-FOODNAME			: 제목 검색			(대충검색해도 됨)
			    -RECIPE_INFO		: 본문 내용 검색	(대충검색해도 됨)
			    -JAELYO				: 재료 검색			(대충검색해도 됨)
			    -CATEGORY			: 한식, 양식, 일식, 중식		[버튼]
			    -FOODGROUP			: 찜, 구이, 디저트, 면, etc..	[버튼]
			    
			- keyword			= 게시물 검색
	   
	 *  @param keyword		= 검색어
	 *********************************/
	public List<Map<String, Object>> boardSearch(Map<String, Object> pmap) {
		logger.info("boardSearch dao 호출");
		List<Map<String, Object>> list = new ArrayList<>();
		sqlSessionTemplate.selectOne("proc_board_search", pmap);
		list = (ArrayList) pmap.get("csr");
		for(Map<String,Object> map:list) {
			logger.info("DAO>>boardSearch>>"+map);
		}
		return list;
	}

	/********************************
	 * 재료, 대분류, 소분류 리스트 가져오기
	 * @param 
	 * 		- field
			  	-LAGE_CATEGORY		= 대분류
			   	-SMALL_CATEGORY		= 소분류
			   	-JAELYO_LIST		= 재료 리스트
	 *********************************/
	public List<Map<String, Object>> listForGiveInfo(Map<String, Object> pmap) {
		logger.info("listForGiveInfo dao 호출");
		List<Map<String, Object>> list = new ArrayList<>();
		sqlSessionTemplate.selectOne("proc_board_give_info", pmap);
		list = (ArrayList) pmap.get("csr");
		for (Map<String, Object> map : list) {
			logger.info("DAO>>infolist>>"+map);
		}
		return list;
	}

	/********************************
	 * 좋아요
	 * @param
	 		- field
			  	- CHECK_LIKE		: 내가 좋아요를 눌렀는지?
			   	- ALL_LIKES			: 게시글의 총 좋아요 개수 (사용할 필요 없을듯)
			   	- CLICK_LIKE		: 좋아요 등록, 취소
			   	
			- menucd			= 현재 보고있는 페이지 번호
			- m_id				= 내 아이디
	 *********************************/
	public String boardLikes(Map<String, Object> pmap) {
		logger.info("boardLikes dao 호출");
		String regiMsg = null;
		sqlSessionTemplate.selectOne("proc_board_likes", pmap);
		regiMsg = pmap.get("msg").toString();
		logger.info(regiMsg);
		return regiMsg;
	}
	
	/********************************
	    * 차트를 그리기 위한 수치를 가져오는 프로시저
	    * (대분류, 소분류, 좋아요개수를 가져온다)
	    * @param 
	             - -
	    *********************************/
	public List<Map<String, Object>> forChart(Map<String, Object> pmap) {
		logger.info("forChart dao 호출");
		List<Map<String, Object>> list = new ArrayList<>();
		sqlSessionTemplate.selectOne("proc_chart_for", pmap);
		list = (ArrayList) pmap.get("csr");
		for (Map<String, Object> map : list) {
			logger.info("DAO>>forChart>>"+map);
		}
		return list;
	}	
	
	/********************************
	 * 검색된 검색 키워드
	 * @param 
	 		- field
	 			- GENERAL_WORDCLOUD
	 			- MY_WORDCLOUD
	 		- m_id
	 *********************************/
	public List<Map<String, Object>> getWord_bySearch(Map<String, Object> pmap) {
		logger.info("getWord_bySearch dao 호출");
		List<Map<String, Object>> list = new ArrayList<>();
		sqlSessionTemplate.selectOne("proc_wordcloud", pmap);
		list = (ArrayList) pmap.get("csr");
		for (Map<String, Object> map : list) {
			logger.info("DAO>>getWord_bySearch>>"+map);
		}
		return list;
	}	
}
