package design.ditest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalcEventHandler implements ActionListener {
	String first = null;
	String second = null;
	public MyCalcView mcv = null;
	public MyCalcEventHandler() {}
	public MyCalcEventHandler(MyCalcView myCalcView) {
		this.mcv = myCalcView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String command = e.getActionCommand();
		System.out.println("사용자가 선택한 버튼은 "+ command + " 입니다.");
		//너 7번 버튼 누른거야?
//		if(obj == mcv.jbtn) {
		if(obj == mcv.jbtn7) {
//			mcv.jtf.setText(command);
			System.out.println(command+"버튼 누른건데....");
			mcv.jtf.setText(mcv.jtf.getText()+mcv.jbtn7.getText());
		}
		else if(obj == mcv.jbtn9) {
//			mcv.jtf.setText(command);
			System.out.println(command+"버튼 누른건데....");
			mcv.jtf.setText(mcv.jtf.getText()+9);
		}
		else if(obj == mcv.jbtnc) {
			System.out.println(command+"버튼 누른건데....");
//			mcv.jtf.setText(null);
			mcv.jtf.setText("");
		}
		else if(obj == mcv.jbtnplus) {
			System.out.println(command+"버튼 누른건데....");
			first = mcv.jtf.getText();
			mcv.jtf.setText("");
			mcv.jtf.setText(mcv.jtf.getText()+command);
			
		}
		else if(obj == mcv.jbtnequal) {
			System.out.println(command+"버튼 누른건데....");
			String result = mcv.mcl.account("+","","");
			mcv.jtf.setText(result);
		}
		
	}
}
