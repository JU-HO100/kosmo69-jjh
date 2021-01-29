package book.ch3;

public class Sungjuk2 {
	/*
	 * 홍길동 학생의 국어,수학,영어 점수를 파라미터로 받아옵니다.
	 * hap메소드를 설계할 때 리턴타입을 int로 한 이유는 avg메소드에서
	 * 재사용하기 위함이다.
	 * @param jumsu1 = 75
	 * @param jumsu1 = 80
	 * @param jumsu1 = 90
	 * @param int
	 */
	
	int hap(int jumsu1, int jumsu2, int jumsu3) {
		int hap;
		hap=jumsu1+jumsu2+jumsu3;
		System.out.println(hap);
		return hap;
	}
	double avg(double hap) {
		double avg;
		avg=hap/3;
		System.out.println(avg);
		return avg;
	}
	
	public static void main(String[] args) {
		Sungjuk2 sj = new Sungjuk2();
	    int hap = sj.hap(75, 80, 90);
	    sj.avg(hap);
	    
//insert here

		
	}
}
