package book.ch4;

public class RandomTest {

	public static void main(String[] args) {
		int com[] = new int[3];
		for(int n=0;n<=9;n++) {
		com[0]=(int)(Math.random()*10);
		do {
			com[1]=(int)(Math.random()*10);			
		}while(com[0]==com[1]);
		do {
			com[2]=(int)(Math.random()*10);			
		}while(com[0]==com[2]||com[1]==com[2]);
		System.out.println(com[0]+""+com[1]+""+com[2]);
		//덧셈을 방지하기 위해 ""를 넣었다
	
	}

}
}