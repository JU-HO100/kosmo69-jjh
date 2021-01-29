package book.ch2;

import javax.swing.JOptionPane;

//non-static변수나 메소드는 static영역에서 사용할 수 없다.
public class Addtion {

	public static void main(String[] args) {
		//사용자에 의한 첫번째 문자열 입력
		String firstNumber="5";
		firstNumber = JOptionPane.showInputDialog("첫번째 숫자 입력하세요.");
		//사용자에 의한 두번째 문자열 입력
		String secondNumber="10";
		int number1;//첫번째 숫자 추가
		int number2;//두번째 숫자 추가
		int sum;//number1과 number2더하기
		//사용자 스트링으로 부터 첫번째 숫자 읽기
//=Integer.parseInt(firstNumber);
		number1=Integer.parseUnsignedInt(firstNumber);
		number2=Integer.parseUnsignedInt(secondNumber);
		sum = number1+number2;
		System.out.println(sum);
		//결과 나타내기
		JOptionPane.showMessageDialog(null, "The sum is"+sum, "처리 결과", JOptionPane.INFORMATION_MESSAGE);
	}

}
