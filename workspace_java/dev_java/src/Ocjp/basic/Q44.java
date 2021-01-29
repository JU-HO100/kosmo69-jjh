package Ocjp.basic;

public class Q44 {
			 public String doit(int x, int y) {
			 return "a";
			 }			
			 public String doit(int... vals) {  //비정형인자
			 return "b";
			 }
			 public static void main(String[] args) {
				 Q44 q = new Q44();
				 System.out.println(q.doit(4, 5));
	}

}
