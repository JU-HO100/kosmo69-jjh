package oracle.mybatis;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sun.glass.ui.Size;
import com.util.DBConnectionMgr;
import com.util.MyBatisCommonFactory;
import com.vo.MemberShip;

public class MyBatisZipCodeSearch extends JFrame implements ItemListener, FocusListener, ActionListener, MouseListener {
	// 선언부
	MyBatisCommonFactory mbf = new MyBatisCommonFactory();
	SqlSessionFactory ssf = null;
	// 물리적으로 떨어져있는 db서버와 연결통로 만들기

	String zdo = null;
	Connection con = null;
	// 위에서 연결되는 쿼리문을 전달할 전령의 역할을 하는 인터페이스 객체 생성하기 = 일꾼 생성
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 조회된 결과를 화면에 처리해야 하므로 오라클에 커서를 조작하기 위해 ResultSet추가
	JPanel jp_north = new JPanel();
	// insert here
	String zdos[] = { "전체", "서울", "경기", "강원" };
	String zdos2[] = { "전체", "부산", "충남", "대구" };
	Vector<String> vzdos = new Vector<>();// vzdos.size()==>0
	JComboBox jcb_zdo = new JComboBox(zdos);// West
	JComboBox jcb_zdo2 = null;// West
	JTextField jtf_search = new JTextField("동이름을 입력하세요.");// Center
	JButton jbtn_search = new JButton("조회");// East
	String cols[] = { "우편번호", "주소" };
	String data[][] = new String[0][2];
	DefaultTableModel dtm_zipcode = new DefaultTableModel(data, cols);
	JTable jtb_zipcode = new JTable(dtm_zipcode);
	JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);;
	String zdos3[] = null;
	int size = 0;
	MemberShip ms = null;
	List<Map<String, Object>> zdoList = null;

	// 생성자
	public MyBatisZipCodeSearch() {
		System.out.println("MyBatisZipCodeSearch()호출 성공");
		this.ssf = mbf.getSqlSessionFactory();
		// SqlSessionFactory ssf = MyBatisCommonFactory에 있는 getSqlSessionFactory메소드를
		// 불러온다.
		// getSqlSessionFactory 메소드 안에는 init()메소드가 들어 있으며 그 init메소드는
		// ZipCodeMapperConfig.xml클래스의 정보(오라클 정보)가 들어 있으면 호출했을 때
		// 오라클의 정보를 가지고 새로운 ssf를 생성한다.
		zdoList = getZdoList();
	}

	public MyBatisZipCodeSearch(MemberShip ms) {
		this();
		this.ms = ms;
	}

//화면처리부
	public void initDisplay() {
		jbtn_search.requestFocus();
		jtb_zipcode.addMouseListener(this);
		jbtn_search.addActionListener(this);
		jtf_search.addFocusListener(this);
		jp_north.setLayout(new BorderLayout());
//      vzdos.copyInto(zdos2);
		for (int x = 0; x < zdos2.length; x++) {
			vzdos.add(zdos2[x]);
		}
		for (String s : vzdos) {
			System.out.println("s===>" + s);
		}
//      jcb_zdo2.add(jcb_zdo);
		Vector<String> v = new Vector<>();
		for (int i = 0; i < zdoList.size(); i++) {
			Map<String, Object> rmap = zdoList.get(i);
//    	  rmap.keySet().toArray();//내가 직접 이런 구조를 설계해 보기 - 사용자 정의 클래스 활용하기 연습
			String zdo = rmap.get("ZDO").toString();// 분석
			//zdo = zdo.substring(5, 7);
			//System.out.println(zdoList.get(i).keySet().toArray());
//    	  zdoList.get(i).keySet().toArray()
			v.add(zdo);

		}
		jcb_zdo2 = new JComboBox(v);
		jcb_zdo2.addItemListener(this);
		jp_north.add("West", jcb_zdo2);
		jp_north.add("Center", jtf_search);
		jp_north.add("East", jbtn_search);
		this.add("North", jp_north);
		this.add("Center", jsp_zipcode);
		this.setTitle("우편번호 검색-MyBatis");
		this.setSize(430, 400);
		this.setVisible(true);
	}

	
	public List<Map<String, Object>> getZdoList() {
		SqlSession sqlSession = mbf.getSqlSessionFactory().openSession();
		List<Map<String, Object>> zdoList = new ArrayList<>();// List가 더 상위의 인터페이스다 그래서 Map과 ArrayList를 쓸 수 있다.
		try {
			zdoList = sqlSession.selectList("getZDOList"); //리턴타입
			size = zdoList.size();
			System.out.println("size");
			
		} catch (Exception e) {
			System.out.println("Exceptioin:" + e.toString());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();//사용하고 난뒤 닫아줘야 한다. *중요*
			}
		}
		
		return zdoList;
	}
	

	// 메인메소드
	public static void main(String[] args) {
		MyBatisZipCodeSearch zcs = new MyBatisZipCodeSearch();
		zcs.initDisplay();
	}

	public void refeshData(String zdo, String dong) {
		System.out.println("zdo:" + zdo + ",dong:" + dong);
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("zdo", zdo);
		pMap.put("dong", dong);
		int i = 1;
		SqlSession sqlSession = ssf.openSession();//지역변수의 성격을 갖는다. - 메소드를 따로 관리하는 영역
		try {
			list = sqlSession.selectList("getAddressList", pMap);
			System.out.println("list.size():"+list.size());
			if (list.size() > 0) {// 벡터의 사이즈가 0보다 크니?
				while (dtm_zipcode.getRowCount() > 0) {// 집코드 테이블에 있는 로우갯수가 0보다 크니?
					dtm_zipcode.removeRow(0);// 집코드 데이블의 로우를 0으로 초기화 해주세요
				}
			}
			Iterator<Map<String, Object>> iter = list.iterator();
			Object keys[] = null;
			if ((list == null) || (list.size() < 1)) {// null은 항상 조심해야 한다.
//       if((v.size()<1)||(v==null)) {//이렇게 할 경우 앞의 v.size<1의 자리에서 nullpoint 에러를 만난 수도 있다.
				JOptionPane.showMessageDialog(this, "데이터가  조회되지 않았습니다.");
				return;
			} else {
				while (iter.hasNext()) {
					HashMap date = (HashMap) iter.next();
					keys = date.keySet().toArray();
					Vector<Object> oneRow = new Vector<>();
					oneRow.add(0, date.get(keys[0]));
					oneRow.add(1, date.get(keys[1]));
					dtm_zipcode.addRow(oneRow);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("focusGained 호출성공");
		if (e.getSource() == jtf_search) {
			jtf_search.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_search) {
			String user = jtf_search.getText();
			refeshData(zdo, user);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {// 콜백메소드의 파라미터는 내가 호출한게 아니다.-콜백메소드의 파라미터는 객체 주입을 받는다.
		Object obj = e.getSource();
		if (obj == jcb_zdo2) {
			if (e.getStateChange() == ItemEvent.SELECTED) {// static이면서 final
				zdos3 = new String[size];// 위치를 생각해보자
//				for(int i=0;i<zdos.length;i++) {
//					zdos3[i]=jcb_zdo2.getItemAt(i).toString();
//				}
				zdo = zdos3[jcb_zdo2.getSelectedIndex()];
//				if (zdo.equals("전체")) {// 오라클에서는 콤보박스에 전체 라는 값이 빈문자열일 확률이 높다.
//					zdo = "";// 그래서 빈 문자열을 넘겼다.
//				}
			}
		}
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
		if (e.getClickCount() >= 2) {
			// 너 더블 클릭 했니?
			System.out.println("더블 클릭 한거야");
			int index[] = jtb_zipcode.getSelectedRows();
			if (index.length == 0) {
				JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하세요.");
				return;
			} else if (index.length > 1) {
				JOptionPane.showMessageDialog(this, "데이터를 한 건만 선택하세요.");
				return;
			} else {
				int zipcode = (Integer) dtm_zipcode.getValueAt(index[0], 0);
				String address = (String) dtm_zipcode.getValueAt(index[0], 1);
				System.out.println(zipcode + " , " + address);
//            ms.jtf_zipcode.setText(String.valueOf(zipcode));
//            ms.jtf_address.setText(String.valueOf(address));
				this.dispose();

			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
