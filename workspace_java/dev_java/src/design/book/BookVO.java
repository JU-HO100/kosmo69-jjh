package design.book;
//한번에 한개 로우만 담을 수 있다.
//INSERT, DELETE는 한개(row) 호은 여러개의(row)를 추가, 삭제 할 수 있다.
//UPDATE는 한개(row)를 모두 수정할 수도 있고 한 개컬럼만 수정도 가능하다.
//만일 여러개 로우를 담으려면 Vector이나 ArrayList를 써야 한다.
public class BookVO {
	private  int	b_no      = 0;//도서번호
	private  String b_name    = null;//도서명
	private  String author    = null;//저자
	private  String publish   = null;//출판사
	private  String b_info    = null;//도서 상세정보
	private  String B_img     = null;//도서 이미지
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getB_info() {
		return b_info;
	}
	public void setB_info(String b_info) {
		this.b_info = b_info;
	}
	public String getB_img() {
		return B_img;
	}
	public void setB_img(String b_img) {
		B_img = b_img;
	}
 
}
