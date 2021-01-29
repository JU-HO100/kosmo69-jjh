package Ocjp.basic;

public class Q3 {

	public static void main(String[] args) {
		int x=5;
		boolean b1 = true;
		boolean b2 = false;
		
		if((x==4)&&  !b2) 
		{
			//&& 연산자가 두 개일때는 첫번째 조건이 거짓이면 뒤에 조건은 안본다.
			System.out.println("1");
			System.out.println("2"); //if 2번째 줄은 조건에 상관없이 무조건 실행이 된다 {} 생략한다
		} //false
		if((b2==true)&& b1) 
		{
			System.out.println("3");//true
		}
	}

}
	 

			



	
	
