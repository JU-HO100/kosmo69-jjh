package report.ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomGame {

	public static void main(String[] args) 
			throws IOException 
	{

		Random r = new Random();
		int dap = r.nextInt(10);
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
			System.out.println("0부터 9사이의 숫자를 하나 입력하세요.");
			String str = null;
			while((str=br.readLine())!=null) {
				System.out.println("사용자가 입력한 값 ===>"+str);
				if(Integer.parseInt(str)==dap) {
					System.out.println("정답입니다.");
					break;
				}
			else if(Integer.parseInt(str) > dap) {
				System.out.println("낮춰라");
			}	
			else if(Integer.parseInt(str) < dap) {
				System.out.println("높여라");
			}
			}
	
	}
}

/*
	boolean isStop = false;
	int i=1;
	while(!isStop) {
		int num = r.nextInt(10);
		System.out.println(num);
		if(1>5) {
			break;

}
*/