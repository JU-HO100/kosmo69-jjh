package movieteam;

public class MovieMemberVO {
	
 private int 	mm_zipcode    = 0;
 private String mm_id         = null;
 private String mm_pw         = null;
 private String mm_nickname   = null;
 private String mm_gender     = null;
 private String mm_name       = null;
 private String mm_address    = null;
 
 public MovieMemberVO() {}
 public MovieMemberVO(int mm_zipcode, String mm_id, String mm_pw
		 			, String mm_nickname, String mm_gender
		 			, String mm_name, String mm_address) {
	 
          this.mm_zipcode = mm_zipcode ;
          this.mm_id      = mm_id      ;
          this.mm_pw      = mm_pw      ;
          this.mm_nickname= mm_nickname;
          this.mm_gender  = mm_gender  ;
          this.mm_name    = mm_name    ;
          this.mm_address = mm_address ;
 }
 
 
public String getMm_id() {
	return mm_id;
}
public void setMm_id(String mm_id) {
	this.mm_id = mm_id;
}
public String getMm_pw() {
	return mm_pw;
}
public void setMm_pw(String mm_pw) {
	this.mm_pw = mm_pw;
}
public String getMm_nickname() {
	return mm_nickname;
}
public void setMm_nickname(String mm_nickname) {
	this.mm_nickname = mm_nickname;
}
public String getMm_gender() {
	return mm_gender;
}
public void setMm_gender(String mm_gender) {
	this.mm_gender = mm_gender;
}
public String getMm_name() {
	return mm_name;
}
public void setMm_name(String mm_name) {
	this.mm_name = mm_name;
}
public int getMm_zipcode() {
	return mm_zipcode;
}
public void setMm_zipcode(int mm_zipcode) {
	this.mm_zipcode = mm_zipcode;
}
public String getMm_address() {
	return mm_address;
}
public void setMm_address(String mm_address) {
	this.mm_address = mm_address;
}

}
