package movieteamX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import design.book.BookManager;
import movieteam.Display;
import movieteam.MovieSignup;
import movieteam.MovieViewLogin;
import movieteam.MovieZipCodeSearch;




public class MovieEvent2 implements MouseListener, ActionListener {
	Display 	d = null;
//	MovieViewLogin2 mvl2 = null;
	MovieViewLogin mvl = null;
	MovieSignup ms = null;
	MovieZipCodeSearch mzcs = null;

	public MovieEvent2() {
	}
	public MovieEvent2(Display d) {
		this.d = d;
	}
	public MovieEvent2(MovieViewLogin mvl) {
		this.mvl = mvl;
	}
//	public MovieEvent2(MovieViewLogin2 mvl2) {
//		this.mvl2 = mvl2;
//	}
	public MovieEvent2(MovieSignup ms) {
		this.ms = ms;
	}
	public MovieEvent2(MovieZipCodeSearch mzcs) {
		this.mzcs = mzcs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	if(obj == mvl.jbtn_exit) {//시작화면의 나가기버튼을 누름
    		System.exit(0);
    	}
    		if(obj == mvl.jbtn_login) {
			 System.out.println("로그인 호출");
			 if("".equals(mvl.jtf_id.getText())) {
					 JOptionPane.showMessageDialog(mvl.jtf_id, "아이디를 확인하세요","INFO",JOptionPane.INFORMATION_MESSAGE);
				 return;
			 
			 }else if("".equals(mvl.jpf_pw.getText())){
				 JOptionPane.showMessageDialog(mvl.jpf_pw, "아이디를 확인하세요","INFO",JOptionPane.INFORMATION_MESSAGE);
				 return;
    		}else {
				 mvl.setVisible(false);
				 d = new Display();
				 d.initDisplay();
				 d.setVisible(true);
			 } 
		 	 }else if(obj == mvl.jbtn_signup){
				 mvl.setVisible(false);
				 ms.initDisplay();
			 }
	}	 
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}

