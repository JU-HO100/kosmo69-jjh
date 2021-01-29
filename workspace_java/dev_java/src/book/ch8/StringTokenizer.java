package book.ch8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
public class StringTokenizer implements ActionListener {
	
	String ip = "192.168.0.38";
	UserInput user = new UserInput();
	String user = null;
	user = JOptionPane.showInputDialog("IP번호와 Port번호를 입력하세요");
	int port = 2000;
	StringTokenizer st = new StringTokenizer(user,"#");
	ip = st.nextTokenizer();
	String imsi = st.nextToken();
	port = Integer.parseInt(imsi);
	System.out.println("사용자가 입력한 ip와 port는"+ip+","+port);
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

