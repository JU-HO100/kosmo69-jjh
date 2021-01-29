package book.ch3;

public class Sungjuk3 {
	int hap(int Jumsu1, int Jumsu2, int Jumsu3, int Jumsu4) {
		int hap = Jumsu1 + Jumsu2 + Jumsu3 + Jumsu4;
		System.out.println(hap);
		return hap;
	}
		double avg(double hap) {
			double avg;
		avg=hap/4;
		System.out.println(avg);
		return avg;
		
		}
	public static void main(String[] args) {
		Sungjuk3 sj = new Sungjuk3();
		int hap = sj.hap (80, 85, 90, 70);
		double avg = sj.avg (hap);

	}

}
