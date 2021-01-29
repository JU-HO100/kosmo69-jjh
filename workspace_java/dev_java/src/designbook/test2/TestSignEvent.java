package designbook.test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class TestSignEvent implements ActionListener {
	TestSignUp tsu = null;
	TestDAO tdao = new TestDAO(this);
	public TestSignEvent() {}
	
	public TestSignEvent(TestSignUp tsu) {
		this.tsu = tsu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		TestViewVO tvo = null;
		
		if(obj == tsu.jbtn_close) {
			System.exit(0);
		}
		else if(obj == tsu.jbtn_conf) {
			tvo = tdao.SingUpjon(tsu.jtf_id.getText());
			if(tsu.jtf_id.getText().equals("")) {
				JOptionPane.showMessageDialog(tsu, "아이디를 입력하세요.");
				return;
			}
			else if(tsu.jtf_id.getText().equals(tvo.getMEM_ID())) {
				JOptionPane.showMessageDialog(tsu, "아이디를 사용할 수 없습니다.");
				return;
			}else {
				JOptionPane.showMessageDialog(tsu, "아이디를 사용할 수 있습니다.");
				return;
			}
		}
		else if(obj == tsu.jbtn_ins) {
			tdao.SingUpins(tsu.jtf_id.getText(),tsu.jtf_pw.getText(),tsu.jtf_name.getText(),tsu.jtf_hp.getText());
			if("".equals(tsu.jtf_pw.getText())) {
				JOptionPane.showMessageDialog(tsu, "비밀번호를 입력해 주세요.");
				return;
			}
			else if("".equals(tsu.jtf_name.getText())) {
				JOptionPane.showMessageDialog(tsu, "이름를 입력해 주세요.");
				return;
			}
			else if("".equals(tsu.jtf_hp.getText())) {
				JOptionPane.showMessageDialog(tsu, "핸드폰 번호를 입력해 주세요.");
				return;
			}else {
				JOptionPane.showMessageDialog(tsu, "회원가입이 되었습니다.");
				tsu.setVisible(false);
				return;
			}
		}
	}
}
