package book.ch3;

import javax.swing.JOptionPane;

public class C {

	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("첫번째 숫자를 입력하고 엔터치기");
		System.out.println(s);
		String s2 = JOptionPane.showInputDialog("두번째 숫자를 입력하고 엔터치기");
		System.out.println("s2==========>"+s2);
		int A = Integer.parseInt(s);//String s의 문자를 숫자로 형전환 함
		int B = Integer.parseInt(s2);//String s2의 문자를 순자로 형전환 함
		System.out.println(A+B);
		

		
	}

}
