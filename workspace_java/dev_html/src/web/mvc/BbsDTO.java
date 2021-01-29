package web.mvc;

public class BbsDTO {
	private int 	B_NUM;
	private int 	B_HITS;
	private String 	B_TITLE;
	private String 	B_DAY;
	private String 	B_MEM;
	private String 	B_PW;
	private String 	B_CONTENTE;

	public BbsDTO() {
	}

	public BbsDTO(String B_TITLE, String B_MEM, String B_PW, String B_CONTENTE) {
		super();
		this.B_TITLE = B_TITLE;
		this.B_MEM = B_MEM;
		this.B_PW = B_PW;
		this.B_CONTENTE = B_CONTENTE;
	}
	public String getB_TITEL() {
		return B_TITLE;
	}
	public String getB_MEM() {
		return B_MEM;
	}
	public String getB_PW() {
		return B_PW;
	}
	public String getB_CONTENTE() {
		return B_CONTENTE;
	}


}
