package book.ch14;

public class P491_4 {
	//메소드 오버로딩 조건에 예외처리를 던지고 안던지고 하는 문제는 영향이 없다.
	public void methodA() throws ArrayIndexOutOfBoundsException{
		int arr[] = new int[3];
		for(int i=0;i<=3;i++) {//0 1 2 3:탈출
			System.out.println("앞");
			arr[i] = i;//arr[3] = 3;ArrayIndexOutOfBoundsException
			System.out.println("뒤");
			System.out.println(arr[i]);
		}
	}
	//int i를 써서 메소드 오버로딩 조건을 만족 시켰다.
	public void methodA(int i) throws ArrayIndexOutOfBoundsException, Exception{
		
	}
	public static void main(String[] args) {
		P491_4 p = new P491_4();
		try {
			p.methodA();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("toString :"+e.toString());
		}
		
	}

}
