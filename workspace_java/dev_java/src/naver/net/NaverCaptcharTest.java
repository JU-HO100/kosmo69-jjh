package naver.net;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;


import javafx.scene.layout.Border;

public class NaverCaptcharTest extends JFrame implements ActionListener {
		JPanel 		jp_north 		= new JPanel();
		JButton 	jbtn_reload		= new JButton("리셋");
		JTextField 	jtf 			= new JTextField(10);
		JButton 	jbtn_confirm 	= new JButton("확인");
		JLabel 		jlb				= new JLabel("캡쳐이미지");
		Container 	cont 			= this.getContentPane();
		String path = "C:\\workspace_java\\dev_java\\src";
		
	public NaverCaptcharTest() {
		initDisplay();
	}
	
	
	public void initDisplay() {
		jlb.setBorder(BorderFactory.createEtchedBorder());
		jbtn_reload.addActionListener(this);
		jbtn_confirm.addActionListener(this);
		jp_north.add(jbtn_reload);
		jp_north.add(jtf);
		jp_north.add(jbtn_confirm);
		this.add("Center",jlb);
		this.add("North",jp_north);
		this.setSize(380, 380);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new NaverCaptcharTest();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == jbtn_reload) {
			//키받아오는 코드 추가하기
			String clientId = "90jq7NL5ySok8wfSJgEs"; //애플리케이션 클라이언트 아이디값";
	        String clientSecret = "95WuXvzsWM"; //애플리케이션 클라이언트 시크릿값";
	        //생성자에서 받은 키를 어떻게 밑으로 집어 넣지?
	        String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
		    String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + code;
		    //<>안에 String를 2개 줬다 왜? 밑의 ID와 비번을 받기 위해? 그렇다면 왜 2개를 써서 따로 받았지? ID와 비밀번호를 따로 관리하니까?
		    Map<String, String> requestHeaders = new HashMap<>();
		    requestHeaders.put("X-Naver-Client-Id", clientId);
		    requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		    String responseBody = get(apiURL, requestHeaders);
		    
		    
		    ApiExamCaptchaImage2 aci = new ApiExamCaptchaImage2();
		    String fileName = aci.getFileName(responseBody);
		    System.out.println("새로고침 이미지 호출"+fileName);
		    fileName = fileName+".jpg";
			//이미지 미리보기 시작
			ImageIcon originIcon = new ImageIcon(path+fileName);
			//ImageIcon에서 Image 추출하기
			Image originImg = originIcon.getImage();
			//추출된 이미지의 크기를 조절하여 새로운 Image객체 생성
			Image changeImg = originImg.getScaledInstance(300, 380, Image.SCALE_SMOOTH);
			//새로운 Image로 ImageIcon 객체를 생성
			ImageIcon icon = new ImageIcon(changeImg);
			jlb.setIcon(icon);
			//revalidate는 새 구성 요소가 추가되거나 이전 요소가 제거되면 컨테이너에서 호출됨.
			//이 호출은 레이아웃 관리자에서 새 구성 요소를 호출
			cont.revalidate();
		}
	}
		
		
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
//	                responseBody.append("{Key:키값}");
	            }

	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }

}
