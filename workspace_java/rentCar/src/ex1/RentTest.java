package ex1;

public class RentTest {
	public static void main(String[] args) {
		//회원 가입
		Member mb = new Member();
		mb.regMember();
		
		//조회
		Car car = new Car();
		car.checkCarInfo();
		
		//예약
		Reserve reserve = new Reserve();
		reserve.reserveCar();
		
	}

}
