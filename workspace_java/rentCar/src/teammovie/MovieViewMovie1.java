package teammovie;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Team.MovieEvent;

public class MovieViewMovie1 extends JFrame {
	JPanel jp_c		 	= new JPanel();
	JPanel jp_s 		= new JPanel();
	JButton jbtn_yes	= new JButton("선택");
	JButton jbtn_no 	= new JButton("취소");
	JTextArea jta		= null;
	JScrollPane jsp		= null;
	MovieEvent me		= new MovieEvent(this);
	String imgPath 			= "C:\\workspace_java\\rentCar\\src\\teammovie\\";
	ImageIcon iicon 		= new ImageIcon(imgPath+"s1.png");
	public MovieViewMovie1() {
	}
	public void initDisplay() {
		jsp = new JScrollPane(jta);
		jta = new JTextArea() {
		public void paint(Graphics g) {
			g.drawImage(iicon.getImage(), 0, 0, null);
			Point p = jsp.getViewport().getViewPosition();

		}
		};
		jbtn_yes.addActionListener(me);
		jbtn_no.addActionListener(me);
		jp_s.add("South",jbtn_yes);
		jp_s.add("South",jbtn_no);
		this.add("South",jp_s);
		this.add("Center",jp_c);
		this.setTitle("극한직업");
		this.setSize(500, 500);
		this.setLocation(800,250);
		this.setVisible(true);
	}
	
	
	
}
