package Study_d;

public class G_i {

		int g_i;
		void methodA() {
		int a_i;
			a_i = 2;
			g_i++;
		}
			void methodB() {
				g_i = g_i+5;			
		}
			public static void main(String[] args) {
				//insert here - methodA를 호출 하였다.
				//g_i는 얼마일까요?
				G_i gi = new G_i();
			gi.methodA();
			System.out.println(gi.g_i);
			gi.methodB();
			System.out.println(gi.g_i);
			G_i g1 = new G_i();
			g1.methodA();
			System.out.println(g1.g_i);
			
			
	
	}

}
