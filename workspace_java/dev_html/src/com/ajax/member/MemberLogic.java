package com.ajax.member;

import java.util.Map;

import org.apache.log4j.Logger;
/*
 * logic 클래스의 역할은 업무에 대한 프로세스(멀티[SELECT,INSERT SELECT, UPDATE, SELECT, DELETE], 다중처리)를 이해하고 있으며
 * 그 조회한 결과를 어떤 테이블에 추가할 것인가 등을 판단하고 결정하는 일을 담당한다.
 * 하나의 로직 하나의 메소드 안에서 DAO에 있는 여러개의 메소드를 한번에 요청할 수도 있다.
 * 트랜잭션 처리는 로직에서 담당하는 것이 옳다.
 * commit과 rollback의 메소드를 호출해야 하는 시점도 여기이다.
 * 공통된 관심사를 분리하기 위해서 AOP을 활용 = API를 활용 (AOP 프레임워크가 따로 있다.) <-> OOP
 * 이것을 사용할 경우 자동으로 트랜잭션처리를 할 수 있고, 일괄적으로 적용이 가능해서 업무에 대한 시간을 절약이 가능하다.
 * 반복되는 코드를 줄여준다.
 * 
 * con.setAutoCommit(true); = 자동커밋-즉시커밋 , 일괄처리하고 싶다면 false를 해야한다.
 * false = 기다렸다가 정상처리 되었을 때 한번에 commit 한다.
 * int r1 = pstmt.executeUpdate();//insert or update or delete
 * int r2 = pstmt.executeUpdate();
 * if(r1==r2 && r2==r1) con.commit();
 * con.setAutoCommit(true)로 바꾸어야 한다. 디폴트는 true이다.
 * commit을 하게 되면 rollback이 되지 않는다. 
 * 직접 오라클과 연동하지 않아야 한다. 그래야 트랜잭션을 적용할 수 있다. 
 * 그렇게 해야만 재사용성이 높아진다.
 * 그러기 위해 독립적이어야만 한다. - 독립적이니까 결합도는 낮아지고, 결합도가 낮아지니까 재사용성이 높아진다.
 * 
 * 
 */

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
/*
 *	오라클과 연동하는 일을 담당하는 클래스 객체 주입 필요함.
 *	항상 뒤에 있는 클래스를 앞에서 인스턴스화 해야 함.
 */
	SqlMemberDao smDao = null;//선언시에는 null로 하였다가 필요한 시점에서 객체주입 받는다.-권장사항
	public String login(Map<String,Object> pmap) {
		logger.info("login 호출 성공");
		String mem_name = null;
		Map<String,Object> rmap = null;
		smDao = new SqlMemberDao();
		mem_name =  smDao.login(pmap);
		logger.info("오라클에서 꺼낸 이름:"+mem_name);
		return mem_name;
	}
}
