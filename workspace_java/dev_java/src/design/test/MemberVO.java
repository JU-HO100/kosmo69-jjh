package design.test;

public class MemberVO {
	private String nickName = null;
	private String gender = null;
	public MemberVO(String nicName, String gender){
		this.nickName = nickName;
		this.gender = gender;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
