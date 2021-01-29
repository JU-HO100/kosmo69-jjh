package net.tomato_step4;

import java.util.List;
import java.util.Vector;
import java.util.jar.Attributes.Name;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Room {
	//현재 단톡방에 들어와 있는 사용자 스레드만 관리하기
	List<ChatServerThread> userList = new Vector<>();
	//사용자의 닉네임을 따로 관리 하고 싶다면?
	List<String> userNickname = new Vector<>();
	List<String> nameList = new Vector<>();
	String title = null;//톡방명
	String state = null;//대기실, 참여중...ss
	//현재 인원 수
	int current = 0;
	//최대 인원 수
	int Max = 0;

	
	public Room() {}
	public Room(String title, int current) {//타입 맞추는 것을 조심하자
		this.title = title;
		this.current = current;
	}
	public Room(String title, String state, int current) {
		this.title = title;
		this.state = state;
		this.current = current;
	}

	public List<ChatServerThread> getUserList() {
		return userList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getMax() {
		return Max;
	}
	public void setMax(int max) {
		this.Max = max;
	}
	public void setUserList(List<ChatServerThread> userList) {
		this.userList = userList;
	}
}
