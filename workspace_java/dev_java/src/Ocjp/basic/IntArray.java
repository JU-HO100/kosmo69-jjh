package Ocjp.basic;
//배열의 시작 인덱스는 항상 0 이다.
//이유는 a2의 주소번지와 a2[0]의 주소번지가 같기 때문이다.
//229540==229540
//double = 229540 229548
public class IntArray {
	void a2Print(int[] a) {
		for(int i=0;i<2;i++) { //배열의 크기가 2가 된다.
	//	for(int i=0;i<a.length;i++) { //a.length 자체가 주소번지이다. -값에 의한 호출이 아닌 참조에 의한 호출
			System.out.println(a[i]);//0 , 1
		}
		//개선된 for문 - 가진걸 다 보여줘야할때 쓴다. 예)10개가 있으면 10개를 다 보여준다.
		for(int b:a) { //앞은 타입의 자리이고 뒤는 배열의 자리이다 - b라는 타입의 a배열을 다 보여줘
			System.out.println(b);
		}
	}//벡터는 여러가지의 타입을 넣을수 있고 중간중간 빠진 곳에 끼워넣기를 할수 있다.
	 //length와 벡터의 차이는 타입의 갯수와 끼워넣기를 할수 있냐 없냐의 차이이다.
	public static void main(String[] args) {
		int i,j = 0;//이럴 경우 j만 초기화 됐다.
		i=2;        //그래서 i는 따로 초기화를 해야한다.
		System.out.println(i+", "+j);
		int x[],y=0;
		//int[]a, b=0;//이경우 뒤에 b는 int가 아닌 배열이다
		int[]a2, b2;
		//선언시에는 대괄호를 반드시 붙이지만 생성시에는 생략한다.
		//파라미터 자리에 배열을 넘길 수 있다. - 이 연습을 하면 클래스 활용에 도움이 된다.
		a2 = new int[2];//이경우 값이 2개가 들어있다. 0 , 0 
		a2 = new int[3];//여기는 값이 3개가 들어있다. 0 , 0 , 0	
		//insert here
		IntArray ia = new IntArray();
		ia.a2Print(a2);
	}
}
