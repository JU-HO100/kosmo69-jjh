package book.ch2;

import javax.swing.JOptionPane;

public class Addition3 {

	public static void main(String[] args) {
		int x=0, y=0, z=0, result;
		String xVal, yVal, zVal;
		xVal = JOptionPane.showInputDialog("첫번째 숫자 입력하세요.");
		yVal = JOptionPane.showInputDialog("두번째 숫자 입력하세요.");
		zVal = JOptionPane.showInputDialog("세번째 숫자 입력하세요.");
		x=Integer.parseInt(xVal);
		y=Integer.parseInt(yVal);
		z=Integer.parseInt(zVal);
		result = x*y*z;
		System.out.println(result);
		//결과를 나타내기
		JOptionPane.showInternalMessageDialog(null, "The result is"+result, "처리결과", JOptionPane.INFORMATION_MESSAGE);
        //java 가상 머신과의 연결고리를 끊어버림.
		System.exit(0);
		//////////////eng of main
	}

}