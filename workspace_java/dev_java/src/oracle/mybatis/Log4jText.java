package oracle.mybatis;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jText {
	static Logger logger = Logger.getLogger(Log4jText.class);
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src//oracle//mybatis//log4j.properties");
			Properties prop = new Properties();
			prop.load(fis);
			PropertyConfigurator.configure(prop);
			logger.info("여기");
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}finally {
			
		}
	}
}
