package book.ch5;

class Param {
	int ival;
}	
public class TestParam {
		void effectParam(Param p) {
			//p = new Param();//Param의 method를 불러온다 / 100
			p.ival = 500;
			System.out.println("sub ival===>"); 
		}//1.500 2.100
		
	public static void main(String[] args) {
		TestParam tp = new TestParam();
		Param p = new Param();
		p.ival = 100;
		tp.effectParam(p);//effectParam의 method를 불러온다 / 500
		System.out.println("main ival====>");
	}   //1.500 2.500
}
