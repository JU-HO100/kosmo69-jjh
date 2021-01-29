package book.ch4;

public class SwitchTest2 {
	String msg;
	public void methodA() {
		int i = 0;
		boolean isOk = false;
		while(!isOk) {
			String msg = "오늘 스터디 할까?";
			switch(i) {
		case 0: {
				String msg = "";//4번열과 겹침
		}break;
		default:
			break;
		}
	}
}
	public static void main(String[] args) {
		int j = 0;
//		for(int i=0;i<3;i++) {
		for(j=0;j<3;j++) {
			
		}
		System.out.println(j);
	}////////////end of main
}