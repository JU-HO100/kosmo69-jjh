package designbook.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginEvent implements ActionListener {
	LoginView lv = null;
	SignUp su = new SignUp(this);
	SearchView sv = new SearchView(this);
	BookClientDAO bDAO = new BookClientDAO();
	
	public LoginEvent() {
	}
	public LoginEvent(LoginView loginView) {
		this.lv = loginView;
	}
	public void methodA() {
		System.out.println("1");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		BookClientVO bVO = bDAO.Booklogin(lv.jtf_id.getText(), lv.jtf_pw.getText());
		System.out.println("bVO.mem_id===>"+bVO.getMEM_ID());
		if(obj == lv.jbtn_sign) {
			su.initDisplay();
		}
		else if(obj == lv.jbtn_login) {
			if (lv.jtf_id.getText().equals("")||bVO.getMEM_ID()== null||lv.jtf_pw.getText().equals("")||bVO.getMEM_PW()==null) {
				JOptionPane.showMessageDialog(lv,"아이디와 비밀번호를 확인하세요.","INFO",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else {
				JOptionPane.showMessageDialog(lv,"로그인 되었습니다.","INFO",JOptionPane.INFORMATION_MESSAGE);
				lv.setVisible(false);
				sv.initDisplay();
				return;
			}
		}
		else if(obj == lv.jbtn_exit) {
			System.exit(0);
		}
	}

}
