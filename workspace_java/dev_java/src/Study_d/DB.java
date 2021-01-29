package Study_d;

public class DB { //오라클 연동 
	Connection            con        = null;  //**데이터베이스와 연결
    PreparedStatement    pstmt   = null; //**오라클 서버에 셀렉트 문을 가져가고, 요청한 후 결과를 받아오는 역할
    ResultSet               rs         = null; //**오라클의 살고 있는 일꾼이 있다. 옵티마이저, 포인터
   public void idInsert(String B_ID, String B_PW, String B_CNAME, String B_HP) {
         //메소드 idInsert에 파라미터값을 문자로 4개줄꺼야
         int result = 0;
         //insert문 등록
         StringBuilder sql = new StringBuilder();
         //StringBuilder 호출한다.append를 사용하면 데이터가 쌓이므로 StringBuilder사용하여 공간을 한정해서 처리속도를 
         //높인다(맞나모름).
         //**StringBuffer => 멀티스레드에서 안전하다 - 목표1과 필요한사람 다수일때는 멀티스레드 => 스케줄을 조정하는것, 다수가 합의해서 순서대로
          //**StringBuilder => 싱글스레드에서 안전하다 - 1:1 - 이 두개는 연동하는데 쓰인다
         sql.append("INSERT INTO CLIENTLIST(B_ID, B_PW, B_CNAME, B_HP) VALUES(?,?,?,?)");
         //**변수 sql에 메소드 사용하여 첨부한다.(오라클에 있는 CLIENTLIST에(B_ID, B_PW, B_CNAME, B_HP불러오고
         //**VALUES에 물음표는 내가 사용하려는 파라미터들이다.차후 숫자를 붙여 물음표에 대한 순차적인 값을준다.
         //**정확히 말하면 47번에서는 B_ID, B_PW, B_CNAME, B_HP라는 헤더가 있는 테이블에 
         //** B_ID헤더를 가진 위치에 첫번째 물음표값을 입력한다는것 나머지 이하동문
         try {//예외처리문
            con = dbMgr.getConnection();
            //con는 dbMgr를 통해서 오라클에있는 정보를 가져올꺼야
            pstmt = con.prepareStatement(sql.toString());
            //pstmt는  con가 가져온 정보를 다 넘겨받는 역할
            //(근데 넘겨줄때는 sql 사용하여 처리속도도 빠르게하고 toString으로 숫자도 문자열로 바꿔서 쓰레기값을 줄여서 준다)
            //**쓰레기값을 줄여준다는것은 몰랐음... 
            //**pstmt는 명령문을 가져가고 가져오는역할을 한다 그 역할을 하는 친구를 A라고 했을때 A에게 
            //**DB에 연결한후(con.) 명령문을 가져가고가져오는 역할을해라(prepareStatement) 어떤 명령문을? sql에 붙은 
            //*모든 명령문을(sql.toString)
            pstmt.setString(1, B_ID);
            //pstmt에 문자 SQL에서 컬럼 1번째 자리에 있는 B_ID 받을꺼야
            //** 첫번째 물음표(1)위치에 B_ID의값을 넣을꺼야 => B_ID의 값이란?38번에 받아온 STRING타입의 값을 이야기한다
            //** 이하동문
            pstmt.setString(2, B_PW);
          //pstmt에 문자 SQL에서 컬럼 2번째 자리에 있는 B_PW 받을꺼야
            pstmt.setString(3, B_CNAME);
            //pstmt에 문자 SQL에서 컬럼 3번째 자리에 있는 B_CNAME 받을꺼야
            pstmt.setString(4, B_HP);
            //pstmt에 문자 SQL에서 컬럼 4번째 자리에 있는 B_HP 받을꺼야
            pstmt.executeUpdate();
            //pstmt가 받은 정보들을 실행시켜서 업데이트해줘
         } catch (Exception e) {
            e.printStackTrace();
            //잘못된걸 추적해줘
}
