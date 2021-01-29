package ex1;

public class Reserve {
	String resCarNumber;
	String resDate;
	String useBeginDate;
	String returnDate;

	//예약 하기
	public void reserveCar() {
		System.out.println("예약을 하겠습니까?");
	}
	public void modReserveInfo() {
		System.out.println("예약을 수정하시겠습니까?");
	}
	public void cancelReserveInfo() {
		System.out.println("예약을 취소합니다.");
	}
	
}
