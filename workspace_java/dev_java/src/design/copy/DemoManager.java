package design.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import design.book.BookVO;

public class DemoManager extends JFrame implements ActionListener{
	JMenuBar jmb 	  = new JMenuBar();
	JMenu jm_edit 	  = new JMenu("edit");
	JMenuItem jmi_ins = new JMenuItem("입력");
	JMenuItem jmi_upd = new JMenuItem("수정");
	JMenuItem jmi_det = new JMenuItem("상세보기");
	DemoBook db 	  = new DemoBook();
	BookVO bVO 		  = null;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//입력
		if(obj == jmi_ins) {
			db.set(e.getActionCommand(),null);
			db.initDisplay();
		}
		//수정
		else if(obj == jmi_upd) {
			bVO = new BookVO();
			bVO.setB_name("혼자 배우는 자바");
			db.set(e.getActionCommand(),bVO);
			db.initDisplay();
		}
		//상세보기
		else if(obj == jmi_det) {
			bVO = new BookVO();
			bVO.setB_name("혼자 배우는 오라클");
			db.set(e.getActionCommand(),bVO);
			db.initDisplay();
		}
		
	}
	public void initDisplay() {
		jmi_ins.addActionListener(this);
		jmi_upd.addActionListener(this);
		jmi_det.addActionListener(this);
		
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_det);
		jmb.add(jm_edit);
		this.setJMenuBar(jmb);
		this.setSize(400, 500);
		this.setLocation(300,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		DemoManager dm = new DemoManager();
		dm.initDisplay();
	}
}
