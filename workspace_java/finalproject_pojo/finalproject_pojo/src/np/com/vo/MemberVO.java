package np.com.vo;

import java.util.ArrayList;
import java.util.Date;

public class MemberVO {
	private String field="";				// 'REGISTER', 'ID_CHECK', 'NICK_CHECK' - 회원, 'M_NAME','M_TEL','M_ID' - 관리자
	private String m_id = "";			//--------------------------여기서부터		#1
	private String m_pw = "";
	private String m_zip = "";
	private String m_hp = "";
	private String m_name = "";
	private String m_nick = "";
	private String m_gender = "";
	private Date m_birth = null;
	private String m_mail = "";			//------------------------여기까지가 회원가입 필요 변수	#1
	private String chef_apply = "";	//--------#2
	private int m_like =0;					//--------#2
	private String msg = "";				//프로시저로 단일 데이터만 불러 올때 사용할 변수
	private ArrayList cursor = null;	//관리자 페이지에서 커서로 회원 정보 담을때 필요한 변수
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_zip() {
		return m_zip;
	}
	public void setM_zip(String m_zip) {
		this.m_zip = m_zip;
	}
	public String getM_hp() {
		return m_hp;
	}
	public void setM_hp(String m_hp) {
		this.m_hp = m_hp;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}
	public Date getM_birth() {
		return m_birth;
	}
	public void setM_birth(Date m_birth) {
		this.m_birth = m_birth;
	}
	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}
	public String getChef_apply() {
		return chef_apply;
	}
	public void setChef_apply(String chef_apply) {
		this.chef_apply = chef_apply;
	}
	public int getM_like() {
		return m_like;
	}
	public void setM_like(int m_like) {
		this.m_like = m_like;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ArrayList getCursor() {
		return cursor;
	}
	public void setCursor(ArrayList cursor) {
		this.cursor = cursor;
	}
	
}
