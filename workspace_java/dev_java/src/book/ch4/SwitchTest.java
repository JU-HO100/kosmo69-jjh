package book.ch4;

public class SwitchTest {
	public int others(int x) {//파라미터 자리에 x값은 호출할 때 결정됩니다.
		switch(x) {
		case 6: x--;//if
		case 5: x--;
		case 4: x--;
		case 3: x--;
		break;//switch문을 탈출한다
		default: x--;
		break;
		}///////////end of switch
		return x;//2
	}
	//method 앞에 static이 있으면 인스턴스화가 필요없다.
	//static이 없는 메소드를 호출할때는 무조건 인스턴스화를 해야한다.
	//파라미터 자리는 지역변수 자리 이다. - 반드시 초기화를 해주어야 한다. - 선언만 하는것은 문제 되지 않지만 사용할 땐 문제가 된다.(코딩해본사람)
	public static int switchit(int x) {
		int j = 1;
		switch(x) {
	case 1: j++;
	case 2: j++;
	case 3: j++;
	case 4: j++;
	case 5: j++;
	default: j++;//else(switch)
	}
		return j+x;//
}	

public static void main(String[] args) {
	//insert here - switchit 호출시 x값을 4로 한다면 출력 결과는 얼마일까요?
	//static메소드인 main안에서 static으로 선언된 switchit메소드를 호출 할때는 클래스 이름으로.메소드이름으로 호출한다.
//	int x=SwitchTest.switchit(4);
	SwitchTest st = new SwitchTest();
	int x = st.others(5);
	System.out.println(x);
	System.out.println("=================");
	int x2=SwitchTest.switchit(4);//공유(원본)
	System.out.println(x2);
	
}
}
