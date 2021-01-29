package bookingmovie;
public class ScheduleVO {
	private String  sc_code    =      null;
	private String  seat_code  =      null;
	private String  m_code     =      null;
	private String  day        =      null;
	private String  time       =      null;
	
//	public ScheduleVO() {}
//	public ScheduleVO(String sc_code, String SEAT_CODE, String M_CODE, String DAY, String Time) {
//		this.SC_CODE      = SC_CODE  ;
//		this.SEAT_CODE    = SEAT_CODE;
//		this.M_CODE       = M_CODE   ;
//		this.DAY          = DAY      ;
//		this.TIME         = TIME     ;		
//	}
	/////////////////////////////////////////////////////
	public String getSC_CODE() {//상영스케줄코드
		return sc_code;
	}
	public void setSC_CODE(String sc_code) {
		this.sc_code = sc_code;
	}
//////////////////////////////////////////////////////////
	
	public String getSEAT_CODE() {//좌석예매코드
		return seat_code;
	}
	public void setSEAT_CODE(String seat_code) {
		this.seat_code = seat_code;
	}
////////////////////////////////////////////////////////	
	
	public String getM_CODE() {//영화코드
		return m_code;
	}
	public void setM_CODE(String m_CODE) {
		this.m_code = m_CODE;
	}
///////////////////////////////////////////////////////////
	
	public String getDAY() {//날짜코드
		return day;
	}
	public void setDAY(String day) {
		this.day = day;
	}
////////////////////////////////////////////////////////	
	
	public String getTIME() {//시간코드
		return time;
	}
	public void setTIME(String time) {
		this.time = time;
	}
	
                           

}
