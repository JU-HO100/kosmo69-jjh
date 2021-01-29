package naver.net;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 네이버 캡차 API 예제 - 캡차 이미지 수신
public class ApiExamCaptchaImage {
//생성자 추가하기 - 
	public ApiExamCaptchaImage() {}
	public ApiExamCaptchaImage(String key) {
		 String clientId = "90jq7NL5ySok8wfSJgEs"; //애플리케이션 클라이언트 아이디값"; - 사용자가 입력할 파라미터 값
	        String clientSecret = "95WuXvzsWM"; //애플리케이션 클라이언트 시크릿값"; - 사용자가 입력할 파라미터 값 - 
	        key = key.substring(8, 24);//8,24 인 이유 = {1. 2.k3.e4.y5. 6.:7. a8.asdfa.... a24.} 8번째 자리부터 , 24번째 자리부터 받아온다.
	        String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + key;
	        
	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	        String responseBody = get(apiURL, requestHeaders);//아이디와 비번을 파라미터로 가져와서 네이버가 인증과정 거침 - 이미지소스를 가져옴
	        System.out.println(responseBody);
	}
	public String getFileName(String key) {
		String clientId = "90jq7NL5ySok8wfSJgEs"; //애플리케이션 클라이언트 아이디값"; - 사용자가 입력할 파라미터 값
		String clientSecret = "95WuXvzsWM"; //애플리케이션 클라이언트 시크릿값"; - 사용자가 입력할 파라미터 값 - 
		key = key.substring(8, 24);//8,24 인 이유 = {1. 2.k3.e4.y5. 6.:7. a8.asdfa.... a24.} 8번째 자리부터 , 24번째 자리부터 받아온다.
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + key;
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String filename = get(apiURL, requestHeaders);//아이디와 비번을 파라미터로 가져와서 네이버가 인증과정 거침 - 이미지소스를 가져옴
		return filename;
	}
    public static void main(String[] args) {
        String clientId = "90jq7NL5ySok8wfSJgEs"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "95WuXvzsWM"; //애플리케이션 클라이언트 시크릿값";
        //생성자에서 받은 키를 어떻게 밑으로 집어 넣지?
        String key = ""; // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
        String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
        //<>안에 String를 2개 줬다 왜? 밑의 ID와 비번을 받기 위해? 그렇다면 왜 2개를 써서 따로 받았지? ID와 비밀번호를 따로 관리하니까?
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);

        System.out.println(responseBody);
    }
	
    	private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return getImage(con.getInputStream());
            } else { // 에러 발생
                return error(con.getErrorStream());
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

    private static String getImage(InputStream is){
        int read;
        byte[] bytes = new byte[1024];
        // 랜덤한 이름으로  파일 생성
        String filename = Long.valueOf(new Date().getTime()).toString();
        File f = new File(filename + ".jpg");
        try(OutputStream outputStream = new FileOutputStream(f)){
            f.createNewFile();
            while ((read = is.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
//            return "이미지 캡차가 생성되었습니다.";<<리턴 값이 바껴야 된다.
            return filename;
        } catch (IOException e) {
            throw new RuntimeException("이미지 캡차 파일 생성에 실패 했습니다.",e);
        }
    }

    private static String error(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
