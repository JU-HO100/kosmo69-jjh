package np.com.util;

public class HangulConversion {
	public static String toKor(String en) {
		if(en == null) return null;
		try {
			//받아올때는 8859_1  반환할때는 euc-kr
			return new String(en.getBytes("8859_1"),"euc-kr");
		}catch(Exception e){
			return en;
		}
	}
	public static String toUTF(String en) {
		if(en == null) return null;
		try {
			//받아올때는 8859_1  반환할때는 euc-kr
			return new String(en.getBytes("8859_1"),"utf-8");
		}catch(Exception e){
			return en;
		}
	}
}