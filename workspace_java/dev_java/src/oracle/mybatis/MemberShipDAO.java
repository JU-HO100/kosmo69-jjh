package oracle.mybatis;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.tomato_step4.ChatMemberShip;
import net.tomato_step4.ZipCodeSearch;

public class MemberShipDAO {
		String resource = "oracle/mybatis/MapperConfig.xml";
		Reader reader = null;
		//Reader = 문서를 읽는대 필요한 클래스
		//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader <-> Writer
		//mybatis에서 지원하는 클래스로 
		SqlSessionFactory sqlMapper = null;
		
		public List<Map<String,Object>> getMember(){
			List<Map<String,Object>> memList = null;
			SqlSession session = null;
			try {
				reader = Resources.getResourceAsReader(resource);//io가 들어가 있기 때문에 반드시 예외처리해야 한다.
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);//
				session = sqlMapper.openSession();
				memList = session.selectList("getMember");
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			if(memList == null) {
				memList = new ArrayList<>();
			}
			return memList;
	}
	
		public static void main(String[] args) {
			MemberShipDAO mdao = new MemberShipDAO();
			List<Map<String,Object>> memList = mdao.getMember();
			System.out.println("memList.size() ===> :" +memList.size());
		}

}
