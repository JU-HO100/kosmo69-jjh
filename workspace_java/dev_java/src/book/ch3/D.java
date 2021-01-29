package book.ch3;
/*
 *대입연산자 오른쪽에 있는 값을 왼쪽에 대입한다. 
 * 주의사항
 * 작은 값을 더 큰 타입에 대입하는 건 합법이다.
 * 그러나 큰 타입을 작은 타입의 변수에 대입하는 건 불법이다.
 * 내 논리로 이해가 안되면 질문하세요.
 * 내 논리로 이해가 된게 아니면 내께 아닙니다.
 */
public class D {

	public static void main(String[] args) {
		int i = 1;
		double d = i;//d는 1
		i = (int)d;//강제 형전화 i=1
		//(오른쪽에서 왼쪽으로 대입한다 그러하여 왼쪽에있는 정수를 뒤쪽에 써주면 형전환을 할수 있다)
        //i = 정수(타입이 실수보다 작음) , d = 실수(타입이 정수보다 큼)
		float f = 1.5f;//1.5f
		i = (int)f;//1
		float f1 = (float)d;
		System.out.println("f1;"+f1);//1		

	}

}
