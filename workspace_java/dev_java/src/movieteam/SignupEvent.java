package movieteam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class SignupEvent extends JDialog implements ActionListener {
//	Vector<String> v = new Vector<String>();
//	MovieZipCodeSearch mzcs = null;
	MovieSignup ms = null;
	DeptMovie dm = new DeptMovie(this);	
	
	int a = 1;
	
	public SignupEvent(MovieSignup movieSignup) {
		this.ms = movieSignup;
	}

//	public SignupEvent(MovieZipCodeSearch movieZipCodeSearch) {
//		this.mzcs = movieZipCodeSearch;
//	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		ResultSet rs = null;
//		List<MemberVO> deptList = dm.deptList(ms.jtf_id.getText());
		
		if(obj == ms.jbtn_close) {
//			 ms.setVisible(false);
			 ms.dispose();
		 }
		else if(obj == ms.jbtn_ins) {
			
			
			 ms.dispose();
				} 
		
		else if(obj == ms.jbtn_maching) {
		
			if(a == dm.rs("account")) {
				JOptionPane.showMessageDialog(ms,"ID를 사용할수 없습니다","Information",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(ms,"ID를 사용할수 있습니다.","Information",JOptionPane.INFORMATION_MESSAGE);
			}
//		}
//		int m = 0;
//		
//		for(m=0;m<deptList.size();m++) {
//			MemberVO mVO = deptList.get(m);
//			if("".equals(ms.jlb_id.getText())) {
//				JOptionPane.showMessageDialog(ms,"ID를 사용할수 없습니다.","Information",JOptionPane.INFORMATION_MESSAGE);
//			}
//			else {
//				JOptionPane.showMessageDialog(ms,"ID를 사용할수 있습니다.","Information",JOptionPane.INFORMATION_MESSAGE);
//			}
//		}
//		 return;
	}
}
