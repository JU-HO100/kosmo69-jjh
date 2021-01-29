package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"config"})//config 패키지도 스캔해준다
@ComponentScan(basePackages= {"web.android"})//패키지가 등록이 되어 있지 않으면 스캔을 못해 404가 뜬다
public class RootConfig {
	
	
}
