package book.ch14;

public class P491 {

	public static void main(String[] args) {
		int arr[] = new int[3];
		try {
			for(int i=0;i<=3;i++) {//0 1 2 3:탈출
				System.out.println("앞");
				arr[i] = i;//arr[3] = 3;ArrayIndexOutofBoundsException
				System.out.println("뒤");
				System.out.println(arr[i]);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
