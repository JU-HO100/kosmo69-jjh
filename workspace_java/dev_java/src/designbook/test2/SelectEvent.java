package designbook.test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEvent implements ActionListener {
	TestSelectView tsv = null;
	//생성자
	public SelectEvent() {}

	public SelectEvent(TestSelectView tsv) {
		this.tsv	= tsv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
