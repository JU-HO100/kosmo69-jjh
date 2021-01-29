package book.ch3;

public class P74 {

	public static void main(String[] args) {
//		int x=2;
//		int y=1;
//		y=++x;//x=?, y=?
//		System.out.println("x="+x+", y="+y);
//		x=5;
//        y=x--;
        
//        int a = 3;
//        int b = 6;
//        System.out.println("a="+b+",b="+b);
//        System.out.println("a="+b+",b="+a);
//          System.out.println();
        int x = 0;
        int y = 1;
//        x=--y; //x=? 0
//        y=++y; //y=? 1
//        System.out.println();
//       x=x-y;// -1
//        y=x++;// -1
        x=x-y++;
        y=--x;
        System.out.println();
        
        
	}

}
