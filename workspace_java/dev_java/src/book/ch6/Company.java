package book.ch6;

public class Company {
	private static Company instance = null;
	private Company() {
		System.out.println("Company 디폴트 생성자 호출 성공");
	}
	public static Company getInstance() {
		if(instance == null) {//null을 체크한 후 인스턴스화 한다.
			instance = new Company();//instance값이 null이 아니라면 인스턴스화를 한다.
		}
		return instance;
	}
}
