package book.ch2;
//주석은 실행되지 않습니다.
//주석에는 업무에 대한 내용과 담장자 이름, 버전정보등 회사 고유 업무 내용이
//포함 됩니다.
//따라서 배포할땐 xxx.class만 배포해야 됩니다.
public class Variable2 {
	//전변의 위치
	int i;//0
	//int j;//전역변수 - 초기화를 생략할수 있다.
	/***********************************
	 * 로그인 버튼을 누르면 이 메소드를 호출(O),선언
	 * @param id - 사용자가 입력하는 아이디(값)을 받는다.
	 * @param pw - 사용자가 입력하는 비밀번호(값)을 받는다.
	 * @return - 아이디와 비밀번호를 비교해서 모두 일치하면(교집합)
	 * 학습목표
	 * 나는 메소드의 파라미터 자리에 선언되는 변수가 무엇인지 ((지역변수 or 전역변수),(위치))
	 * 설명할수 있다.
	 * 내안에 있는 메소드라 하더라도 메인메소드에서 호출 하려면
	 * 인스턴스화한 후 인스턴스변수.login("apple","123");
	 * 회원가입 - 등록 - 오라클
	 * 로그인 - 조회(찾기) 
	 ***********************************/
	String login(String id, String pw) {
		return "홍길동님 환영합니다.";
	}
	void methodA() {//i는 지변임. methodA안에서만 접근가능함.
		System.out.println("지역변수i :"+i);//지역변수
		int i = 4;
		//내 안에 있는 메소드는 인스턴스화 없이 호출 할수 있다.
		login("haha","123");//메소드 호출
	}
	public static void main(String[] args) {
		Variable2 v2 = new Variable2();//인스턴스화
		v2.methodA();
//		int i = 4;
		//insert here - 전역변수 i를 찍어주는 코드를 추가하세요.
//		Variable1 v2 = new Variable1();//클래스가(이름) 달라서 오류가 남
		System.out.println("전역변수i :"+v2.i);
//		v2.login("haha","123");//여기서는 왜 문법 에러가 나는 걸까요?
	}

}
