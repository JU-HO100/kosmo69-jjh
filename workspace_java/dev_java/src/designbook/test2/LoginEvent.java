package designbook.test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginEvent implements ActionListener {
	TestLoginView tl = null;
	TestSignUp ts = new TestSignUp(this);
	TestDAO ldao = new TestDAO(this);
	TestViewVO	tvo = null;
	TestSearchView tsv = new TestSearchView(this);
	public LoginEvent(TestLoginView tl) {
		this.tl = tl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		tvo = ldao.Login(tl.jtf_id.getText(), tl.jtf_pw.getText());
		if(obj == tl.jbtn_exit) {
			System.exit(0);
		}
		else if(obj == tl.jbtn_sign) {
			ts.initDisplay();
		}
		else if(obj == tl.jbtn_login) {
//			if(tl.jtf_id.getText().equals("")||tvo.getMEM_ID()==null||tl.jtf_pw.getText().equals("")||tvo.getMEM_PW()==null) {
//				JOptionPane.showMessageDialog(tl, "아이디와 비밀번호를 확인해주세요.");
//				return;
//			}
			if(tl.jtf_id.getText().equals("")) {
				JOptionPane.showMessageDialog(tl, "아이디를 입력해주세요.");
				
			}
			else {
				JOptionPane.showMessageDialog(tl, "로그인 되었습니다.");
				tl.setVisible(false);
				tsv.initDisplay();
				return;
			}
		}
	}

}
