package game.baseball;
/*
 * for문 안에서 break문을 만나면 for문을 빠져 나가는 것이고
 * if문 안에서 return을 만나면 메소드를 빠져나간다.
 */

public class Account1 {
	public String account(String user) {
		//문자열의 길이를 체크하고 싶을 때
		if(user.length()!=3) {
			return "세 자리 숫자를 입력하세요.";
		}
	int temp = Integer.parseInt(user);
	int my[] = new int[3];
	my[0] = temp/100;
	my[0] = (temp%100)/10;
	my[0] = temp%10;
	for(int a=0;a<3;a++) {
		System.out.println(my[a]+"");
	}
	System.out.println();
	return "0스트라이크 2볼";
	}
	public static void main(String[] args) {
	//insert here
		Account1 a1 = new Account1();
		String result = a1.account("2568");
		System.out.println("1.256"+result);

	}

}
