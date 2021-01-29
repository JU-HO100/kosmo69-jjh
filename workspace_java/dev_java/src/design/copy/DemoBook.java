package design.copy;

import javax.swing.JDialog;
import javax.swing.JTextField;

import design.book.BookVO;

public class DemoBook extends JDialog {
	JTextField jtf_name = new JTextField();
	String title = null;
	BookVO bVO = null;
	public DemoBook() {}
	public void initDisplay() {
//		set("입력",null); //단위 테스트용
		this.add("North",jtf_name);
		this.setTitle(title);
		this.setSize(400, 500);
		this.setLocation(750,200);
		this.setVisible(true);
	}
	/****************************************************************
	 * BookManager에서 SELECT한 후 결정된 정보를 set메소드의 파라미터로 넘겨 받는다.
	 * @param title - 사용자가 선택한 버튼이나 혹은 메뉴 내용을 파라미터로 넘겨 받아야 한다. 입력|수정|상세보기
	 * @param bVO - bVO가 null이면 BookManager에서 사용자가 입력 버튼을 누른것이다.
	 * @author Kosmo_08 2020-08-28 수정
	 ***************************************************************/
	public void set(String title, BookVO bVO) {
		this.title = title;
		if(bVO!=null) {
			setName(bVO.getB_name());//*중 요*//
		}
	}
	public void setName(String b_name) {
		jtf_name.setText(b_name);
	}
	public String getName() {
		return jtf_name.getText();
	}
	public static void main(String[] args) {
		DemoBook db = new DemoBook();
		db.initDisplay();
	}

}
