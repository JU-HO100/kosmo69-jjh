package book.ch3;

import java.awt.SystemTray;

public class P76_2 {
	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		if((++x<y)&(x>y--)) { //참일때
			System.out.println("참일때");
		}
		else {//거짓일때
			System.out.println("거짓일때");
		}
		//insert here
		//x=2, y=1
//		System.out.println("x="+x+", y="+y);
//		System.out.println("=======[[after]]=======")
//		x=1;
//		y=2
//		if((++x>y)&&(x<y--)) {
//			System.out.println("참일때");
//		}
//		else {//거짓일때
//			System.out.println("거짓일때");
//		}
		x=1;
		y=2;		
		System.out.println("x="+x+". y="+y);
		if((++y>x)&(y<x--)) {
			System.out.println("참일때");
	}
		else {//거짓일때
		System.out.println("거짓일때");
//		x=1;
//		y=2;		
//		System.out.println("x="+x+". y="+y);
 // 	if((++x>y)|(x<y--)) {
//			System.out.println("참일때");
//	}
//		else {//거짓일때
//			System.out.println("거짓일때");
//			x=1;
//			y=2;		
			System.out.println("x="+x+". y="+y);
			if((++x<=y)||(x>y--)) {
				System.out.println("참일때");//x=2, y=2
			}
			else {//거짓일때
				System.out.println("거짓일때");
    } 
     }
	}
	}
//}
