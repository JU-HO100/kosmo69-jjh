package designbook.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class SignEvent implements ActionListener{
	SignUp su = null;
	BookClientDAO bDAO = new BookClientDAO();
	BookClientVO bVO = null;
	public SignEvent(SignUp su) {
		this.su = su;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == su.jbtn_close) {
			su.setVisible(false);
		}
		else if(obj == su.jbtn_conf) {
			bVO = bDAO.Bookconf(su.jtf_id.getText());
			if(su.jtf_id.getText().equals("")) {//아이디 중복검사 할 때 아이디를 입력하지 않은경우
				JOptionPane.showMessageDialog(su, "아이디를 입력해 주세요.");
				return;
			}
			else if(su.jtf_id.getText().equals(bVO.MEM_ID)) {
				JOptionPane.showMessageDialog(su, "아이디를 사용할수 없습니다");
				return;
			}
			else {
				JOptionPane.showMessageDialog(su, "아이디를 사용할수 있습니다");
				return;
			}
		}
		else if(obj == su.jbtn_ins) {
			bDAO.bookinserth(su.jtf_id.getText(), su.jtf_pw.getText(), su.jtf_name.getText(), su.jtf_hp.getText());
			JOptionPane.showMessageDialog(su, "회원가입이 완료되었습니다.");
			su.setVisible(false);
			return;
		}
		
		
	}
}
