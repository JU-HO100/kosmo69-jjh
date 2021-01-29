package np.com.api;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NaverCaptcharTest3 extends JFrame implements ActionListener {
	JPanel jp_north = new JPanel();
	JButton jbtn_reload = new JButton("새로고침");	
	JLabel jlb = new JLabel("캡챠이미지");//중앙-JFrame-BorderLayout	
	Container cont = this.getContentPane();
	String path = "D:\\workspace_java\\dev_java\\";
	public NaverCaptcharTest3() {
		initDisplay();
	}
	public void initDisplay() {
		jlb.setBorder(BorderFactory.createEtchedBorder());
		jbtn_reload.addActionListener(this);
		jp_north.add(jbtn_reload);
		this.add("Center", jlb);
		this.add("North", jp_north);
		this.setSize(320,250);
		this.setVisible(true);		
	}
	public static void main(String[] args) {
		new NaverCaptcharTest();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == jbtn_reload) {
			//키받아오는 코드 추가하기
	        String clientId = "MPV9wUDBJhlicgRFgTNj"; //애플리케이션 클라이언트 아이디값";사용자가 입력할 값-파라미터
	        String clientSecret = "mBTOnStDjP"; //애플리케이션 클라이언트 시크릿값";-비번-파라미터. 나랑 다르잖아

	        String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
	        //웹서버에 요청을 보낼때 주소 뒤에 ?붙이고 변수이름=값&변수이름2=값2&변수이름3=값3 쿼리스트링(사용자가 입력한값을 네이버 서버에 전송할 수 있다)
	        String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	        //네이버 서버에서 전송된 키값이 담기는 곳
	        String responseBody = get(apiURL, requestHeaders);//아이디와 비번을 파라미터로 받아서 네이버가 인증과정 거침			
			
	        
	        ApiExamCaptchaImage aci = new ApiExamCaptchaImage();
			String fileName = aci.getFileName(responseBody);
			System.out.println("새로고침 이벤트 호출 "+fileName);//1602039339479
			fileName = fileName+".jpg";
			//이미지 미리보기 시작 처리
			ImageIcon originIcon = new ImageIcon(path+fileName);
			//ImageIcon에서 Image를 추출하기
			Image originImg = originIcon.getImage();
			//추출된 이미지의 크기를 조절하여 새로운 Image객체 생성
			Image changeImg = originImg.getScaledInstance(300, 380, Image.SCALE_SMOOTH);
			//새로운 Image로 ImageIcon객체를 생성
			ImageIcon icon = new ImageIcon(changeImg);
			jlb.setIcon(icon);
			//revalidate는 새 구성 요소가 추가되거나 이전 요소가 제거되면 컨테이너에서 호출됨.
			//이 호출은 레이아웃 관리자에게 새 구성 요소 목록을 기반으로 재설정하도록 지시하는 명령임.
			cont.revalidate();			
		}
		
	}
///////////////////////////// [[네이버 키 발급 관련 시작]]////////////////////////////
    private static String get(String apiUrl, Map<String, String> requestHeaders){
    	//네이버 서버와 연결통로 확보
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }
            //네이버에서 보내주는 응답 코드를 담기- 100 200 210
            int responseCode = con.getResponseCode();
            //정상적으로 응답이 도착했는지 체크-200
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출-200
            	//메소드 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }
/*
 * @return - 키값이다.
 * @param - 서버에서 전송된 정보를 가짐.
 */
    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
                //responseBody.append("{key:키값}");
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }	
///////////////////////////// [[네이버 키 발급 관련  끝]]////////////////////////////
}
