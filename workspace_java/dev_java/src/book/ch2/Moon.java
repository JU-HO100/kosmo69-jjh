package book.ch2;

import javax.swing.JOptionPane;

public class Moon {
	double a, b;
	
	public static void main(String[] args) {
		String a = JOptionPane.showInputDialog("지구의 몸무게");
		System.out.println(a+"kg");
		String b = JOptionPane.showInputDialog("달의몸무게");
//		double b = a*b;
		System.out.println(b+"kg");
	//	double b = (a*0.17);
	}

}
