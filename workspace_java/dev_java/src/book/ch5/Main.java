package book.ch5;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
class Sub extends JDialog{
	Main m = null;//여기서 new를 쓰면 망한다. - 복제본이기 때문에
	public Sub(Main m) {
		this.m = m;
		m.getButton().setText("가입");
		this.add("Nothe",m.getButton());
		this.setTitle("Sub화면 입니다");
		this.setSize(300, 200);
		this.setVisible(true);
	}
	
}
public class Main extends JFrame {
	JButton jbtn_add = new JButton("등록");
	public Main getInstance() {
		Main m = null;
		if(m!=null) {//null 체크를 하여 복사본이 만들어지는 것을 방어한다
			m = new Main();//하나 - 싱글톤
		}
		return m;
	}
	public JButton getButton() {
		return jbtn_add;
	}
	public static void main(String[] args) {
		Main m = new Main();
		Sub sub = new Sub(m); 
			

	}

}
