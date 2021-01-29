package nickname;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import design.test.MemberVO;

public class NickNameDetail extends JDialog implements ActionListener {
	JScrollPane jspLine = null;//jp_center를 위에 얹어야 하기 때문에 여기서 초기화를 하면 않된다.
//	JScrollPane jspLine = new JScrollPane();
	//현재 중앙에 JScrollPane을 사용한 상태이고 그 이유는 테두리선을 활용하여
	//그위에 새로운 속지를 얹어서 추가적인 화면 콤퍼넌트들을 배치할 수 있다.
	//이때 Layouth대신 일일이 좌표값을 활용하여 배치해 본다.
	JPanel jp_center 	   = new JPanel();
	JPanel jp_south 	   = new JPanel();
	JLabel jlb_gender 	   = new JLabel("성별");
	JTextField jtf_gender  = new JTextField();
	JLabel jlb_zipcode 	   = new JLabel("우편번호");
	JTextField jtf_zipcode = new JTextField();
	JLabel jlb_address	   = new JLabel("주소");
	JTextField jtf_address = new JTextField(6);
	JButton jbtn_save      = new JButton("저장");
	JButton jbtn_close     = new JButton("닫기");
	JButton jbtn_select     = new JButton("우편번호찾기");
	JButton jbtn_select2     = new JButton("찾기");
	
	public NickNameDetail() {
		initDisplay();
	}
	
	public void update() {
		System.out.println("수정 메소드 호출 성공");
	}
	public void initDisplay() {
		//JDialog의 디폴트 레이아웃은 BorderLayout인대
		//직접 좌표값을 활용하여 배치 할때는 레이아웃이 필요없다.
		jp_center.setLayout(null);//FlowLayout이다-null-뭉갠다
		jlb_gender.setBounds(20, 20, 50, 20);
		jtf_gender.setBounds(80, 20, 100, 20);
		jlb_zipcode.setBounds(20, 45, 60, 20);
		jtf_zipcode.setBounds(80, 45, 80, 20);
		jbtn_select.setBounds(170, 45, 120, 20);
		jlb_address.setBounds(20, 70, 60, 20);
		jtf_address.setBounds(80, 70, 200, 20);
		jbtn_select2.setBounds(290, 70, 60, 20);
		jp_center.add(jlb_gender);
		jp_center.add(jtf_gender);
		jp_center.add(jlb_zipcode);
		jp_center.add(jtf_zipcode);
		jp_center.add(jlb_address);
		jp_center.add(jtf_address);
		jp_center.add(jbtn_select);
		jp_center.add(jbtn_select2);
		jspLine = new JScrollPane(jp_center);//스크롤바가 생성될 일이 없다면 생략
		jbtn_save.addActionListener(new ActionListener() {//메소드 안에 클래스가 구현되어 있다.
			@Override
			public void actionPerformed(ActionEvent e) {//implements를 쓰지 않아도 쓸수있게 해준다.
				update();
				
			}
		});
		jbtn_close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		jp_south.add(jbtn_close);
		this.setTitle("상세보기");
		this.add("Center",jspLine);
		this.add("South",jp_south);
		this.setSize(400,300);
		this.setVisible(true);//만일 전변으로 인스턴스화를 하였다면 false로 바꿔주세요. 
							   //이벤트가 일어나면 그때 true로 바꿔주세요.
	}	
	//////////////////[[setter|getter]]//////////////////////
	public void setGender(String gender) {
		jtf_gender.setText(gender);
	}
	public void getGender() {
		jtf_gender.getText();
		/* 메소드를 활용하여 초기화 하기
		//mVO.setGender(jtf_gender.getText());
		//MemberVO mVO = new MemberVO();
		 */
		//생성자의 파라미터를 활용하여 초기화 한다.
		MemberVO mVO = new MemberVO(null,jtf_gender.getText());
	
	}
	//////////////////[[setter|getter]]//////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}



}
