package test;

public class Sungjuk4 {
	int tot = 0;
	
	int hap1(int jumsu1, int jumsu2, int jumsu3, int inwon) {
		System.out.println(jumsu1+ " " +jumsu2+ " " +jumsu3+ "응시원수"+inwon);
		double hap1 = (jumsu1+jumsu2+jumsu3)/(double)inwon;
		System.out.println("합1 평균은"+hap1);
		return jumsu1+jumsu2+jumsu3;
	}
    int hap2(int jumsu4, int jumsu5, int jumsu6, int inwon) {
    	System.out.println(jumsu4+ " " +jumsu5+ " " +jumsu6+ "응시원수"+inwon);
    	double hap2 = (jumsu4+jumsu5+jumsu6)/(double)inwon;
    	System.out.println("합2 평균은"+hap2);
    	return jumsu4+jumsu5+jumsu6;
    	
    }
    int hap3(int jumsu7, int jumsu8, int jumsu9, int inwon) {
    	System.out.println(jumsu7+ " " +jumsu8+ " " +jumsu9+ "응시원수"+inwon);
		double hap3 = (jumsu7+jumsu8+jumsu9)/(double)inwon;
		System.out.println("합3 평균은"+hap3);
		return jumsu7+jumsu8+jumsu9;

	}
    int hap(int hap1, int hap2, int hap3, int inwon) {
    	System.out.println(hap1+ " " +hap2+ " " +hap3+ "총평균"+inwon);
    	double hap = (hap1+hap2+hap3)/(double)inwon;
    	System.out.println("총합"+hap1+hap2+hap3);
    	return hap1+hap2+hap3;
    }
	public static void main(String[] args) {
		Sungjuk4 sj4 = new Sungjuk4();
		System.out.println();
		sj4.tot = 10;
		sj4.hap1(75, 86, 93, 3);
		sj4.hap2(75, 91, 94, 3);
		sj4.hap3(72, 93, 98, 3);
//		sj4.hap(hap1, hap2, hap3, 3);
		
	}
		
		
		

	}

