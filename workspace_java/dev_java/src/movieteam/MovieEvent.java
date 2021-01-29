package movieteam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import design.book.BookManager;




public class MovieEvent extends JDialog implements  ActionListener {
	MovieViewLogin mvl = null;
	Display d = new Display(this);
	MovieSignup ms = new MovieSignup(this);

	
	
	public MovieEvent(MovieViewLogin movieViewLogin) {
		this.mvl = movieViewLogin;
	}

	public MovieEvent(Display display) {
		this.d = display;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	if(obj == mvl.jbtn_exit) {
    		System.exit(0);
    	}
    	else if(obj == mvl.jbtn_login) {
			 System.out.println("로그인 호출");
//			 if("".equals(mvl.jtf_id.getText())) {
//					 JOptionPane.showMessageDialog(this, "아이디를 확인하세요","INFO",JOptionPane.INFORMATION_MESSAGE);
//				 return;
//			 }
//			 else {
				 mvl.setVisible(false);
				 d.initDisplay();
// 			}
		 }
    	else if(obj == mvl.jbtn_signup) {
			 System.out.println("회원가입 호출");
			 ms.initDisplay();
		 }
		}

}

