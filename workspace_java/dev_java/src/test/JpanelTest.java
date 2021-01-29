package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JpanelTest extends JFrame implements ActionListener {
	private static JpanelTest  jpt = new JpanelTest();
		
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setLocation(500, 300);//Size
		jf.setPreferredSize(new Dimension(500, 300));
		Container test = jf.getContentPane();
		JPanel vjp = new JPanel();
		JPanel ljp = new JPanel();
		test.add(vjp);
		vjp.setLayout(new BorderLayout());
		vjp.add(ljp, BorderLayout.WEST);
		ljp.setLayout(new BoxLayout(ljp, BoxLayout.Y_AXIS));
		ActionListener al = new JpanelTest();
		for(i=1;i<4;i++) {
			JButton jbtn = new JButton();
			ljp.add(jbtn);
			jbtn.addActionListener(al);
		}
		firstRight();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
