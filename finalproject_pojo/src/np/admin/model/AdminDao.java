package np.admin.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import np.com.util.MyBatisCommonFactory;


public class AdminDao {
   Logger logger = Logger.getLogger(AdminDao.class);
   private static final String NAMESPACE = "np.admin.mybatis.AdminMapper.";
   private SqlSessionFactory sqlMapper = null;
   
   // 싱글톤
   private static AdminDao instanceDao = new AdminDao();
   private AdminDao() {
      sqlMapper = MyBatisCommonFactory.getSqlSessionFactory();
   }
   public static AdminDao getInstance() {
      return instanceDao;
   }
   
   
   /*****************************************
    관리자 전용 검색기능 (검색은 전체관리자 권한 가능)
    @param   
       -field
          -ADMIN_RIGHT         : 관리자 권한 리스트
          -ADMIN_BOARD         : 레시피 게시판 관련 검색
          -ADMIN_MEMBER        : 회원 관련 검색
          -ADMIN_CLASS         : 쿠킹클래스 관련 검색
         
       -category             = 어떤 카테고리로 검색할지?
       
          -ADMIN_BOARD(field) 일 때
             [전체보기]
                -'GENERAL'
                
             [버튼]
                -'CATEGORY'      (data : 한식,중식,일식,양식)
                -'FOODGROUP'   (data : 면,찌개,국,탕,디저트,etc..)
                -'B_STATUS'      (data : 인기게시글,일반게시글)
                -'M_STATUS'      (data : 탈퇴회원,일반회원,셰프,관리자)
                
             [범위검색]
                -'LIKE_CNT','HIT'
                
             [일반검색]
                {정확한정보기입}
                   -'MENUCD','M_ID'
                {유사정보기입}
                   -'FOODNAME','HASHTAG','M_NICK','CREATION_DATE'
               
          -ADMIN_MEMBER(field) 일 때
             [전체보기]
                -'GENERAL'
                
             [버튼]
                -'M_GENDER'      (data : 영구추방, 일시추방, 탈퇴, 남자, 여자, 관리자)
                                  -(실제버튼)남자,여자
                                  
                -'CHEF_APPLY'   (data : 영구추방, 일시추방, 탈퇴, 회원, 셰프신청, 셰프)
                                  -(실제버튼)회원, 셰프신청, 셰프
                                  
                -'CHECKBLIST'   (data : 정상, 일시정지, 블랙리스트)
                
             [범위검색]
                -'REPORT','AGE','M_LIKE','RCNT','PRCNT'
                
             [일반검색]
                {정확한정보기입}
                   -'M_NAME','M_ID'
                {유사정보기입}
                   -'M_NICK','M_ZIP','M_HP','M_DAY','M_BIRTH','M_MAIL',
             
          -ADMIN_CLASS(field) 일 때
              [전체보기]
                 -'GENERAL'
                 
              [버튼]
                 -'M_STATUS'   (data : 신청중,수락,반려,셰프)
                 
              [범위검색]
                 - X
                 
              [일반검색]
                 {정확한정보기입}
                    -'C_CLASSCD','M_ID','CHEF_ID'
                 {유사정보기입}
                    -'M_NICK','CHEF_NICK','COOK_NAME','C_NEEDS','C_ZIP','C_ZIPDETAIL'
          
       -keyword                  = 일반 키워드 검색
       -option_keyword1         = A ~ B 검색이 필요할때의 A 검색어
       -option_keyword2         = A ~ B 검색이 필요할때의 B 검색어
    ****************************************/
   public List<Map<String, Object>> adminSearch(Map<String,Object> pmap) {
      List<Map<String, Object>>list = new ArrayList<>();
      SqlSession session = null;
      try {
         session = sqlMapper.openSession();
         session.selectOne(NAMESPACE+"proc_admin_search",pmap);
         logger.info(pmap);
         list = (ArrayList)pmap.get("csr");
         for(Map<String,Object> map:list) {
            logger.info("DAO>>adminSearch>>"+map);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      return list;
   }
   
   /*****************************************
    총관리자, 멤버관리자 전용
    @param   
       -field
          -GIVE_RIGHT              : (총관리자only) 권한 위임
         -DELETE                   : (총관리자only) 권한 삭제
         -PUT_BLACK                : (멤버관리자) 블랙리스트 추가
         -PUT_PAUSE                : (멤버관리자) 일시정지리스트 추가
         -RELEASE_PAUSE_MEM        : (멤버관리자) 일시정지회원 풀어주기
         -READ_WRITTING            : (멤버관리자) 셰프신청글 보기
         -COMMIT_CHEF              : (멤버관리자) 셰프로 승격시켜주기
         
       -admin_id             = 어드민 계정 아이디
       -m_id               = 어드민으로 조정시킬 아이디
       -right               = 무슨 권한?
    ****************************************/
   public List<Map<String, Object>> adminMemDao(Map<String,Object> pmap) {
      List<Map<String, Object>>list = new ArrayList<>();
      SqlSession session = null;
      try {
         session = sqlMapper.openSession();
         session.selectOne(NAMESPACE+"proc_admin_mem_controller",pmap);
         logger.info(pmap);
         list = (ArrayList)pmap.get("csr");
         for(Map<String,Object> map:list) {
            logger.info("DAO>>adminMemDao>>"+map);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      return list;
   }
   
   /*****************************************
    게시판, 쿠킹클래스 관리자 전용
    @param   
       -field
          -DELETE_COOKCLASS      :(쿠킹클래스관리자) 쿠킹클래스 강제 제거
          -KICK_PERSON_CC        :(쿠킹클래스관리자) 쿠킹클래스내 회원 제거
          -DELETE_BOARD          :(게시판관리자)      게시글 강제 삭제
         
       -admin_id             = 어드민 계정 아이디
       -m_id               = 어드민으로 조정시킬 아이디
       -b_c_num            = 게시판번호 or 쿠킹클래스번호
    ****************************************/
   public String adminBCDao(Map<String,Object> pmap) {
      List<Map<String, Object>>list = new ArrayList<>();
      String msg = null;
      SqlSession session = null;
      try {
         session = sqlMapper.openSession();
         session.selectOne(NAMESPACE+"proc_admin_other_control",pmap);
         logger.info(pmap);
         list = (ArrayList)pmap.get("csr");
         for(Map<String,Object> map:list) {
            msg = (String)map.get("MSG");
            logger.info("DAO>>adminBCDao>>"+msg);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      return msg;
   }
   

   
}