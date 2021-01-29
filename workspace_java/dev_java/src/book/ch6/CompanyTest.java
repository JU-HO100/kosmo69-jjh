package book.ch6;

public class CompanyTest {

	public static void main(String[] args) {
		Company cp1 = Company.getInstance();//private타입을 가져올수 없으므로 get을 사용하여 호출하였다.
		Company cp2 = Company.getInstance();
		System.out.println(cp1 == cp2);//2개인 변수의 주소번지가 같으므로 true이다.
	
	}

}
