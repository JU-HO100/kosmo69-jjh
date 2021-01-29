package designbook.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import oracle.db.DeptApp;

public class SearchEvent implements ActionListener, MouseListener {
	SearchView sv = null;
	ClientManager cm = new ClientManager(this);
	SelectView sev = new SelectView(this);
	public SearchEvent(SearchView sv) {
		this.sv = sv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == sv.jbtn_search|| obj == sv.jtf_search) {//엔터를 눌렀을 때에도 쓸 수 있게 해줬다.
			cm.BookList(sv.jtf_search.getText());//SearchView의 검색을하기 위해 ClientManager의 BookList메소드의 내용을 호출

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
	public void mousePressed(MouseEvent e) {//더블클릭 했을 때 Select창에 내가 조회하고 싶은 정보를 띄운다
		if(e.getClickCount()>=2) {//더블 클릭
//			int index[] = sv.jt_bookcode.getSelectedRow();//Row는 단수이기 때문에 복수인 [](배열)을 사용할 수 없다.
			System.out.println("더블 클릭");//확인용
			int index[] = sv.jt_bookcode.getSelectedRows();//내가 보고싶은 row 정보를 담는다.
			if(index.length == 0) {//1개의 row도 선택하지 않았을 때  
				JOptionPane.showMessageDialog(sv,"조회할 Row를 선택하세요");//선택하지 않았을 때 확인용 메세지
				return;
			}
			else if(index.length > 1) {//선택한 row가 1개 초과일 때 
				JOptionPane.showMessageDialog(sv,"조회할 Row를 1개만 선택하세요");//선택한 row가 2개 이상일때 메세지
				return;
			}
			else {//그 외
				int B_no = (int) sv.dtm_bookcode.getValueAt(index[0], 0);//테이블에서 선택한 row의 도서번호를 가져옴
				//ValueAt = 값이 있는 Row , index[] = 내가 선택한 Row
				String B_name = (String) sv.dtm_bookcode.getValueAt(index[0], 1);//선택한 row의 도서이름을 가져옴
				String author = (String) sv.dtm_bookcode.getValueAt(index[0], 2);// 
				String B_info = (String) sv.dtm_bookcode.getValueAt(index[0], 4);// 
				
				sev.jlb_noins.setText(String.valueOf(B_no));
				sev.jlb_titleins.setText(String.valueOf(B_name));
				sev.jlb_authins.setText(String.valueOf(author));
				sev.jta_storyins.setText(String.valueOf(B_info));
				sev.initDisplay();
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
