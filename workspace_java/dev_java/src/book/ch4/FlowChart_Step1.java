package book.ch4;

import java.awt.SystemTray;
//odd:홀수의 합 담기, even:짝수의 합 담기, int:1부터 10까지의 변하는 값을 담을 변수 
public class FlowChart_Step1 {
	int odd=0, even=0, i=0;
	public static void main(String[] args) {
		FlowChart_Step1 fcs = new FlowChart_Step1();
		for(fcs.i=1;fcs.i<=10;fcs.i=fcs.i+1) { 
		
			if(fcs.i%2==0) {
				fcs.even = fcs.even + fcs.i;
			}//////////end of if
		else{//그럼 홀수야?
			fcs.odd = fcs.odd + fcs.i;
		}

			System.out.println("1");
	}///////////////end of else
}////////////////end of for
}
