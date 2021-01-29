package book.ch6;
/*
 * methodA에 선언된 지변을 외부 다른 메소드에서 유지 또는 사용할 수 있나요?
 * 1)static으로 선언한 변수를 사용하는 것.
 * 2)전변과 초기화 하기 this.i = i;-전역변수

 */
public class LocalVariable {
	
	int i = 1;
	static int j = 2;//싱글톤이다. -공유
	//*static타입의 변수*는 *non-static영역*에서 사용하는 것은 가능하다.
	void methodA() {
		int i;
		i = 10;
		this.i = i;
		System.out.println(i);//i=10 - 9번라인
		System.out.println(j);//j=2  - 5번라인
	}
	/*
	 * *static영역*에서는 *non-static*를 사용이 불가능하다.
	 * 해결방법은 인스턴스화를 사용하면 가능하다.
	 * 
	 */
	public static void main(String[] args) {
		//메인 메소드에서 지역변수 i는 접근이 불가능하다.
		LocalVariable lv = new LocalVariable();
		System.out.println(lv.i);
		System.out.println(LocalVariable.j);
		j=100;
		lv.methodA();//
		
	
	
	
	}

}
