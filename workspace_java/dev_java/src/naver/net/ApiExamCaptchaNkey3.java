package naver.net;
/*
 * java.io -> 읽기와 쓰기가 가능
 * java.net -> 통신이 가능- 외부(네이버, 카카오, 아마존, 도커...)에서 제공하는 서비스를 이용할 수 있다.
 * 위 두 개는 반드시 try..catch . 반드시 예외처리 할것.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;//Uniform Resource Locator - HTTP프로토콜을 사용하여 서비스를 제공하는 시스템에 접속하려면
import java.util.HashMap;
import java.util.Map;

// 네이버 캡차 API 예제 - 키발급
public class ApiExamCaptchaNkey3 {
	//생성자 활용연습, 클래스 쪼개기, 인터페이스와 추상클래스 중심 코딩하기, Spring, Deven, AnyFrame, Struts
	static {
		int i = 0;
	}
	//메인메소드 - 시작점 - main thread - 가장 먼저 실행된다.
	/*
	 * 29~38-39-46-47-67
	 * 
	 */
    public static void main(String[] args) {
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

        System.out.println(responseBody);//key출력
        //추가된 부분입니다.
        ApiExamCaptchaImage aci = new ApiExamCaptchaImage(responseBody);
    }
//소켓통신 대신에 웹통신을 한다.
//http프로토콜을 사용한다.
//소켓을 직접 생성하고 관리할 필요가 없다.
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
//네이버 서버에 컨텍하기
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
}
