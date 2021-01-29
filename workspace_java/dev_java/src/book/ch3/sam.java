package book.ch3;

import javax.swing.JOptionPane;

public class sam {

	public static void main(String[] args) {
		String firstNumber = "0";
		firstNumber = JOptionPane.showInputDialog("곱하고 싶은 숫자");
		String secondNumber = "0";
		secondNumber = JOptionPane.showInputDialog("제곱할 숫자.");
		int number1;
		int number2;
		double sum;
		number1=Integer.parseUnsignedInt(firstNumber);
		number2=Integer.parseUnsignedInt(secondNumber);
		sum=Math.pow(number1, number2);
		JOptionPane.showInternalMessageDialog(null,"The Math.pow"+sum,"처리결과", JOptionPane.INFORMATION_MESSAGE);

	}

}
