package naver.net;
/*
 * java.io를 가지고 읽기와 쓰기가 가능하다.
 * java.net을 가지고 통신이 가능하다 = 외부(naver, kakao, 아마존, 도커, ...등)에서 제공하는 서비스를 이용할 수 있다.
 * 위 2개는 반드시 try-catch를 써야한다. = 반드시 예외처리 해야한다. -문법적인 문제를 당하지 않기 위해
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;//Uniform Resource Locator의 약자 = HTTP프로토콜을 사용하여 서비스를 제공하는 시스템에 접속하려면 당현히 필요하다.
import java.util.HashMap;
import java.util.Map;

// 네이버 캡차 API 예제 - 키발급
public class ApiExamCaptchaNkey2 {
//	static { int i = 0; }//이렇게 쓰면 메인 thread보다 먼저 실행된다 하지만 조심해야한다.
	//메인메소드 - 시작지점 - main Thread - 가장 먼저 실행된다.
    /*
     *30~39-40~47-48~68 
     * 
     */
	public static void main(String[] args) {
    	//생성자 활용연습, 클래스 쪼개기, 인터페이스와 추상클래스 중심 코딩하기, Spring, Devenm, AnyFrame, Struts
        String clientId = "90jq7NL5ySok8wfSJgEs"; //애플리케이션 클라이언트 아이디값"; - 사용자가 입력할 파라미터 값
        String clientSecret = "95WuXvzsWM"; //애플리케이션 클라이언트 시크릿값"; - 사용자가 입력할 파라미터 값 - 

        String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
        //웹서버에 요청을 보낼때 주소 뒤에 ?붙이고 변수이름=값&변수이름2=값2&변수이름3=값3 -쿼리 스트링(사용자가 입력한값을 네이버 서버에 전송할 수 있다.)
        //1개가 아닌 2개,3개를 검색하고 싶을때는 값 뒤에 &을 붙인다.
        String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;//https의 s는 아무나 쓸수 없다. 국가에서 인정된 기관 혹은 사람만 쓸 수 있다.
        
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        //네이버 서버에서 전송된 key값이 담기는 곳
        String responseBody = get(apiURL, requestHeaders);//아이디와 비번을 파라미터로 가져와서 네이버가 인증과정 거침
       
        System.out.println(responseBody);//key 출력
        
        ApiExamCaptchaImage2 aci = new ApiExamCaptchaImage2(responseBody);
    }
//소켓통신 대신 Web(웹)통신을 한다.
//Web(웹) 통신을 할때는 http프로토콜을 사용한다. - 그래서 직접 소켓통신을 생성하고 관리 할 필요가 없다.
    private static String get(String apiUrl, Map<String, String> requestHeaders){
    	//네이버 서버와 연결통로 확보한다.
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }
            //네이버에서 보내주는 응답 코드를 받기 - int- 100 200 210
            int responseCode = con.getResponseCode();
            //정상적으로 응답이 도착했는지 체크함
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출 - 200(상수값)
            	//여기서 readBody가 호출
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

    private static HttpURLConnection connect(String apiUrl){//API의 URL(naver의 서버주소)을 받아서(Key를 발급받기 위해)
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
 * @return - 리턴으로 받는 값은 키값이다
 * @param  - 서버에서 전송된 정보를 가진다.
 */
    
    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);//StreamReader에다 업핸드 한다.
//                responseBody.append("{Key:키값}");
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
