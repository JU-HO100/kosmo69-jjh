package net.tomato_step4;

import java.util.List;
import java.util.Vector;

public class RoomSimulation {

	public static void main(String[] args) {
		List<Room> roomList = new Vector<>();
		List<String> nameList69 = new Vector<>();
//		List<String> nameList = new Vector<>();
		Room room = new Room();
		nameList69.add("박한규");
		nameList69.add("김태민");
		nameList69.add("정주호");
		room.setTitle("자바54기");
		room.setCurrent(5);
		roomList.add(room);
		List<String> nameList54 = new Vector<>();
		nameList54.add("김호철");
		nameList54.add("정래인");
		nameList54.add("종희선");
		room = new Room("자바 54기",5);
		room.setTitle("자바69기");
		room.setCurrent(3);
		roomList.add(room);
		room = new Room("자바 69기",3);
		room.setTitle("자바70기");
		room.setCurrent(13);
		roomList.add(room);
		room = new Room("자바70기",13);
		System.out.println(room.getCurrent());
		System.out.println(room.getTitle());
//		List<ChatServerThread> userList = new Vector<>();
		System.out.println(roomList.size());
		for(int i=0;i<roomList.size();i++) {
			Room r = roomList.get(i);
			System.out.println(r.getCurrent()+" ");
			System.out.println(r.getTitle());
				
		}
	}

}
