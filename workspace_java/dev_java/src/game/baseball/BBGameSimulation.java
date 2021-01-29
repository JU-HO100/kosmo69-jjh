package game.baseball;

public class BBGameSimulation {

	public static void main(String[] args) {
		BaseBallGame2 bbg = new BaseBallGame2();
		bbg.ranCom();
		System.out.println(bbg.com[0]+""+bbg.com[1]+""+bbg.com[2]);
		System.out.println("==========[[for문으로 테스트하기]]==========");
		//만일 10번 확인하고 싶으면
		/*
		for(int i=0;i<10;i++) {
			bbg.ranCom();
			System.out.println(bbg.com[0]+""+bbg.com[1]+""+bbg.com[2]);
		}
		*/
		String result = bbg.account("318");
		System.out.println("result::"+result);
		
	}

}
