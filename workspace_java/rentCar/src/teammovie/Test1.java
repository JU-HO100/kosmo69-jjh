package teammovie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 extends JFrame implements ActionListener{

	JButton jbtn = new JButton("삭제");
	
	
	public void initDisplay() {
		jbtn.addActionListener(this);
		this.add("Center", jbtn);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public Test1() {
		initDisplay();
	}
	
	public static void main(String[] args) {
		new Test1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == jbtn) {
			this.setVisible(false);
		}
		
		
	}

}
