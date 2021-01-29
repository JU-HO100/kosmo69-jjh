package Ocjp.basic;

public class Q12 {
	int x = 0;
	public static void main(String[] args) {
		 int x = 5;  //main에서 선언된 지역변수
	//	 Q12 p = null; //선어만 되었다 - 이 주소번지를 사용하면 NullPointerException이 발생한다 - Runtime 에러
		 Q12 q = new Q12();
		 q.doStuff(q);
		 System.out.print(" main x = "+ q.x);//5
	}//////////////end of main
	
	void doStuff(Q12 p) {
//	void doStuff(x) {
		System.out.print(" doStuff x = "+ (p.x+2)); 
//		 System.out.print(" doStuff x = "+ x++);  //5
	}//////////////end of douStuff
	void doStuff(int x) {
		System.out.print(" doStuff x = "+ ++this.x); 
	}
}//////////////////end of Q12