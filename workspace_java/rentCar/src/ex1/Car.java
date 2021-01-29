package ex1;

public class Car {
	String carNumber;
	String carName;
	String carColor;
	int    carSize;
	String carMaker;

	//차 정보 조회
	public String checkCarInfo() {
		System.out.println("차 정보 조회");
		return null;
	}
	//차 정보 등록
	public void regCarInfo() {
		System.out.println("차 정보를 등록합니다.");
	}
	//차 정보 수정
	public void modCarInfo() {
		System.out.println("차 정보를 수정합니다.");
	}
	//차 정보 삭제
	public void delCarInfo() {
		System.out.println("차 정보를 삭제합니다.");
	}
}
