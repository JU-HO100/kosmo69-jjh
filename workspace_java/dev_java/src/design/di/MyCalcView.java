package design.di;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyCalcView extends JFrame {
	public JTextField jtf = new JTextField();
	public JButton jbtn = new JButton("7");
	public void initDisplay() {
		this.add("North", jtf);
		this.add("Center", jbtn);
		this.setTitle("전자계산기");
		this.setSize(400, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MyCalcView mcv = new MyCalcView();
		mcv.initDisplay();
	}

}
