package nickname;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//디폴트 생성자는 생략이 가능하다. -왜냐하면 파라미터가 없으니까 JVM이 대신 해줄 수 있다.
public class NickNameList extends JFrame implements MouseListener, ActionListener {
	static NickNameList nnlist = null;
	Font f = new Font("굴림체",Font.BOLD,20);
	JPanel jp_center 	   = new JPanel();
	JPanel jp_north 	   = new JPanel();
	//BorderLayout의 경우엔 Center로 주면 기본적으로 주앙을 꽉 채운다
	//그러나 FlowLayout으로 하면 잘 보인다. - 생성자의 파라미터로 컬럼의 크기를 지정하여 텍스트 필드에 사이드를 결정해야한다.
	JTextField jtf_search  = new JTextField(25);
	JButton jbtn_search    = new JButton("검색");
	//전역변수- 이유는 actionPerforemd에서도 그 주소버지를 사용
	
	String cols[] = {"대화명","성별"};
	String data[][] = {
			 {"test","남"}
			,{"apple","여"}
			,{"tomato","여"}
	};
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	//테이블 생성시 데이터셋에 대한 헤더 초기화부분이 필요하다. =>이때 dtm이 필요하다.
	JMenuBar jmb 		   = new JMenuBar();
	JMenu jm 			   = new JMenu("Edit");
	JMenuItem jmi_input    = new JMenuItem("입력");
	JMenuItem jmi_su 	   = new JMenuItem("수정");
	JMenuItem jmi_del 	   = new JMenuItem("삭제");
	JMenuItem jmi_sel 	   = new JMenuItem("조회");
	JMenuItem jmi_exit 	   = new JMenuItem("나가기");
	JTable jtb = new JTable(dtm);//매칭을 해줘야 만나는 부분에서 소통을 한다.
	JScrollPane jsp = new JScrollPane(jtb
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public void initDisplay() {
		jtb.addMouseListener(this);
		jmi_input.addActionListener(this);
		jmi_su.addActionListener(this);
		jmi_del.addActionListener(this);
		jmi_sel.addActionListener(this);
		jmi_exit.addActionListener(this);
		jm.add(jmi_input);
		jm.add(jmi_su);
		jm.add(jmi_del);
		jm.add(jmi_sel);
		jm.add(jmi_exit);
		jmb.add(jm);
		nnlist.setJMenuBar(jmb);	
		jp_north.setLayout(new BorderLayout());
		jtf_search.setFont(f);
		jp_north.add("Center",jtf_search);
		jp_north.add("East",jbtn_search);
		nnlist.add("North",jp_north);
		this.add("Center",jsp);
		this.setTitle("단톡명단");
		this.setSize(450, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		nnlist = new NickNameList();
//		new NickNameList().initDisplay();
		nnlist.initDisplay();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()>=2) {
			//너 더블 클릭 했니?
			System.out.println("더블 클릭 한거야");
			int index[] = jtb.getSelectedRows();
			if(index.length == 0) {
				JOptionPane.showMessageDialog(this,"조회할 데이터를 선택하세요.");
				return;
			}
			else if(index.length > 1) {
					JOptionPane.showMessageDialog(this,"데이터를 한 건만 선택하세요.");
					return;
			}		
			else {
				String nickName = (String)dtm.getValueAt(index[0], 0);
				System.out.println("nickName : "+nickName);
				NickNameDetail nnd = new NickNameDetail();//initDisplay가 호출됨.
				refreshData();
			}
	}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//전체 조회 혹은 조건 검색 구현 - 재사용할 수 있도록 메소드로 처리한다.
		public void refreshData() {
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//너 입력할거니
		if(jmi_input == obj) {
			System.out.println("입력 호출");
		}
		
		//수정을 원하니?
		else if(jmi_su == obj) {
			System.out.println("수정 호출");
			
		}
		//삭제 하고싶니?
		else if(jmi_del == obj) {
			System.out.println("삭제 호출");
			
		}
		//전체 조회 하고 싶니?
		else if(jmi_sel == obj) {
			System.out.println("조회 호출");
			refreshData();
		}
		//종료하고 싶니?
		else if(jmi_exit == obj) {
			System.out.println("나가기 호출");
			System.exit(0);
			
		}
		
	}
		

}

