package book.ch9;

public class PlayerTest {

	public static void main(String[] args) {
		Unit[] group = new Unit[4];
		group[0] = new Marin();
		group[1] = new Tank();
		group[2] = new Marin();
		group[3] = new Dropship();
		for(int i=0;i<group.length;i++) {
			group[i].move(100, 300);
		}
		//개선된 for문은 전체를 모두 출력할 때 쓴다.
		for(Object obj:group) {
			if(obj instanceof Marin) {
				System.out.println("마린이 100, 300으로 이동하였다.");
			}
			if(obj instanceof Tank) {
				System.out.println("탱크가 100, 300으로 이동하였다.");
			}
			if(obj instanceof Dropship) {
				System.out.println("드랍쉽이 100, 300으로 이동하였다.");
			}
		}
	}

}
