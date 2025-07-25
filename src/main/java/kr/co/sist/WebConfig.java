package kr.co.sist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${upload.saveDir}")
	private String uploadDir;

	/**
	 * ResourceHandlerRegistry 클래스로 정적리소스(파일, 이미지)를 jar파일 외부에 저장
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**") // URL의 경로
		.addResourceLocations("file:" + uploadDir + "/"); // HDD의 경로
	}// addResourceHandlers
	
}// class
