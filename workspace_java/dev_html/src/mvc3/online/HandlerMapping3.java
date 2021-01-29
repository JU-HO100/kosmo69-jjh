package mvc3.online;

import org.apache.log4j.Logger;


public class HandlerMapping3 {
	public static Controller3 getController(String command) {
		Logger logger = Logger.getLogger(HandlerMapping3.class);
		Controller3 controller = null;
		String commands[] = command.split("/");//받아온 이름을 / 기준으로 앞뒤로 나눈다
		if(commands.length == 2) {
			logger.info("conMapper-commands = "+commands);
			//업무 이름이 오는자리(work)
			String work = commands[0];// commands[]배열의 0번째(배열은0번부터이니까 1번째)값을 work에 담았다.
			//login(메소드이름이면서 처리해야 할 업무이름이면서 처리해야 할 업무 이름이온다.)==>응답페이지
			String requestName = commands[1];// commands[]배열의 1번째(배열은0번부터이니까 2번째)값을 requestName에 담았다. 
			if("member".equals(work)) {
				controller = new MemberController3(requestName);
			}
			else if("onLineTest".equals(work)) {
				controller = new TestController3(requestName);
			}
			else {
				logger.info("work의 값이 잘못됬어");
			}
		}
		return controller;
	}
}
