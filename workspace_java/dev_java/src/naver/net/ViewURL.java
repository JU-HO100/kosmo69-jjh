package naver.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.URL;
import java.net.URLConnection;

public class ViewURL {
	public ViewURL(String strURL) {
		try {
			URL myURL = new URL(strURL);
			URLConnection myCon = myURL.openConnection();//임포트할 때 넷을 사용하여야 한다.
			myCon.connect();
			//브라우저는 마임타입을 통해서 해당하는 페이지에 대한 해석을 하게 된다. 태그는 해석하고 내용만 출력 해 준다. 인터프리터의 역활을 한다. 누가? 브라우저
			//마임타입이 선언되어 있어야 브라우저가 그게 알맞게 해석을 해준다.
			String headerType = myCon.getContentType();//mime type 메인타입/서브타입 text/html, text/xml, text/javascript
			InputStream is = myCon.getInputStream();//듣기할때 사용한다.
//			ObjectInputStream ois = soket.getInpuStreadm();위의 문장과 똑같다.
			//new를 통해서 객체를 생성하는 경우는 단독으로 사용할 때 만 사용가능하고
			//다른 디바이스나 다른 시스템(h/w 하드웨어)과 연계하여 요청과 응답을 처리할 때 필요하다.
			//new를 통해서가 아니라 주소번지.메소드()와 같은 형태로 객체 주입을 받는다.
			/* ex)
			 * A a = new A();
			 * A a = new B();
			 * A a = XXX.methodA();
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			is.read();//이렇게 쓰면 1줄만 쓸수 있지만
			String data = null;
			while((data=br.readLine())!=null) {//br.readLine가 아니면 계속 돌아라
				System.out.println(data);
			}
			//사용한 io는 반드시 닫아 줘야한다.
			br.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//이렇게 되면 해당 페이지의 정보가 외부에 노출될 수 있음으로 중요한 정보는 절대로 쿼리스트링으로 내보내면 안된다.
	//또한 스크립트 코드들도 노출이 되지 않도록 외부에 별도로 작성하고 import해서 사용하도록 한다.
	//XXX.js, XXX.css로 저장해 둔다. //따로 관리하기 위해
	//경로의 경우에도 절대경로를 노출 당하면 서버에 대한 정보가 외부에 노출될 수도 있음으로 반드시 상대경로를 사용할 것.
	//상대경로를 사용하면 전체경로를 알 수 없다.
	public static void main(String[] args) {
//		http://192.168.0.38:9000/dev_web/login.jsp?mem_id=test
		ViewURL vu = new ViewURL("http://192.168.0.38:9000/dev_web/login.jsp?mem_id=test");
	}
}
