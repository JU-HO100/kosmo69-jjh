package design.di;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalcEventHandler implements ActionListener {
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
		if(true) {
			System.out.println(command+"버튼 누른건데....");
		}
	}
}
