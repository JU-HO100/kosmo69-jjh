package book.ch14;

public class P491_3 {

	public static void main(String[] args) {
		int arr[] = new int[3];
		try {
			for(int i=0;i<=3;i++) {//0 1 2 3:탈출
				System.out.println("앞");
				arr[i] = i;//arr[3] = 3;ArrayIndexOutOfBoundsException
				System.out.println("뒤");
				System.out.println(arr[i]);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException :"+e.toString());
		}catch (Exception e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {//예외를 여러가지 확인할 수 있다. try-catch의 내용들이  예외가 발생하더라도 무조건 실행됨. 단 가상머신과 연결고리가 끊기면 예외.
			System.out.println("예외가 발생하더라도 무조건 실행됨. 단 가상머신과 연결고리가 끊기면 예외");
			
		}
	}

}
