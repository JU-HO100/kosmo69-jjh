package Study_d;

public class VariableTest {
	int tot=0;
	//사용자로부터 3개의 점수를 입력 받는다. -지역변수 자리이다.
	//초기화는 언제 이루어지나요? - when, where, what, how, why, 
	/****************************************************
	 * 
	 * @param jumsu1 - 90
	 * @param jumsu2 - 85
	 * @param jumsu3 - 95
	 * @param inwon - 응시원수
	 * @return
	 */
	int hap(int jumsu1, int jumsu2, int jumsu3, int inwon) {
		System.out.println(jumsu1+ " " +jumsu2+ " " +jumsu3+ "응시원수:"+inwon);
		double avg = (jumsu1+jumsu2+jumsu3)/(double)inwon;
		double avg2 = (jumsu1+jumsu2+jumsu3)/(double)inwon;
		System.out.println("평균은:"+avg);
		System.out.println("평균은:"+avg2);
		return jumsu1+jumsu2+jumsu3;
	}
	public static void main(String[] args) {
		//내가 가진 메소드 일지라도 static영역에서 호출할 때는
		//반드시 인스턴스화 해야된다.
		VariableTest vt = new VariableTest();//인스턴스화
        //vt.jumsu1;//지변은 인스턴스 변수.변수이름으로 초기화 및 호출 할수 없다.
		vt.tot = 10;
		vt.hap(90, 85, 95, 3);//값에 의한 호출이다. call by value *실제코드에서도 필요하다*
		//4개의 변수가 한꺼번에 초기화가 끝났다.
		
	}

}
