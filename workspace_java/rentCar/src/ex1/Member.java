package ex1;

public class Member {
	//선언부
	//디폴트 변수
	String id;
	String pw;
	String name;
	String address;
	String phoneNum;

	//회원등록
	public void regMember() {
		System.out.println("회원가입");
	}
	
	//회원 정보 조회
	public String viewMember() {
		System.out.println("정보 조회");
		return null;
	}
	//회원 정보 수정
	public void modMember() {
		System.out.println("정보 수정");
	}
	//회원 정보 삭제
	public String delMember() {
		System.out.println("정보 삭제");
		return null;
	}
		

}
