package net.tomato_step4;

public class Protocol {
	//대기상태 일 때 
	public static final int WAIT 			= 100; 
	//단톡방 개설 할 때  - 방을 만들 때
	public static final int ROOM_CREATE 	= 200; 
	//단톡방 목록을 처리 할 때  - 방 목록을 갱신할 때
	public static final int ROOM_LIST 		= 210;//중요
	//단톡방 입장 했을 때 
	public static final int ROOM_IN 		= 220;
	//단톡방 입장한 사람들의 목록을 볼 때 - 입장한 사람들의 리스트를 관리하기 위해
	public static final int ROOM_INlIST 	= 230;//중요
	//단톡방을 나갔을 때
	public static final int ROOM_OUT 		= 290;
	//여러사람과 대화하기
	public static final int MULTI 			= 300; 
	//1:1 대화하기
	public static final int WHISPER 		= 310; 
	//대화명 변경
	public static final int CHANGE 			= 320;
	//대화 내용 사이의 토큰
	public static final String seperator 	= "|";
	
}
