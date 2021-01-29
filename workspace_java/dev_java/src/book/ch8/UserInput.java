package book.ch8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UserInput extends JOptionPane implements ActionListener {
	private JLabel jlb_time = null;
	String ip;
	int port;
	public UserInput(JLabel jlb_time2, String ip, int port) {
		this.jlb_time = jlb_time2;
		this.ip = ip;
		this.port = port;
		
		this.setSize(400,300);
		this.setVisible(true);
		

		String user = JOptionPane.showInputDialog("아이피와 주소번호를 입력하세요");
		System.out.println("사용자가 입력한 값은"+user);
		String ip = "192.168.0.38";
		int port = 5000;
		try {
			Socket socket = new Socket(ip,port);
		} catch (Exception e) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
