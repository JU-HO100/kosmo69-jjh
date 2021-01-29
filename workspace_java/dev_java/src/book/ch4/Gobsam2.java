package book.ch4;
public class Gobsam2 {
	//반복문 사용시 무한루프를 방지할 수 있는 코드를 생각해보세요.
	public static void main(String[] args) {
		int i=2;
		int j=1;
		while(i<=9) {
			j=1;
			while(j<=9) {
			System.out.println(i+"*"+j+"="+(i*j));
				
			j =	j + 1;
			}
			i =	i + 1;
		}

	}

}
