package design.test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InstanceTest extends JFrame {
//	JPanel jp_n = null;
	JButton jbtn_n = null;//4
	
	
	
	public InstanceTest() {
		jbtn_n = new JButton("북쪽"); 
	//	jp_n = new JPanel();
		
	}
	public InstanceTest(String label) {
		JButton jbtn_s = new JButton(label); //2

		
	}
	
	public void initDisplay() {
		if(jbtn_n!=null) 		
			
			this.add("North",jbtn_n);//3
		this.setSize(500, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		JFrame jf = new InstanceTest("남쪽");
		InstanceTest it = new InstanceTest();//1
		it.initDisplay();//나에게 있으니 호출이 가능하다.
		

	}

}
