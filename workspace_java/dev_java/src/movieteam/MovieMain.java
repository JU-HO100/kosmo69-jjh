package movieteam;

import javax.swing.JFrame;


public class MovieMain {
	MovieViewLogin mvl = new MovieViewLogin();

public MovieMain() {
	
}
	
	public static void main(String[] args) {
		MovieMain mm = new MovieMain();
		mm.mvl.initDisplay();

	}

}
