package np.com.controller;

import java.io.IOException;

public class MyOkHttpClient {
	private static String BASE_URL = "https://kauth.kakao.com";
	private static String APP_KEY = "f61c36ee28b1fe4d00e270bcf75d344d";
	private static String REDIRECT_URI = "http://192.168.0.38:8000/member/index.jsp";
	
	private MyOkHttpClient() {}
	
	public static void getAccessToken(String authorizationCode)
			throws IOException 
	{
//		OkHttpClient client = new OkHttpClient();
		
		
	}
	
	
	
}
