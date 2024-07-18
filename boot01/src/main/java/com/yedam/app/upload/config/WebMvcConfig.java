package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration	//설정 조절하는클래스
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Value("${file.upload.path}")		//실행시 경로설정
	private String uploadPath;
	
	//경로 등록
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")					// url
				.addResourceLocations("file:///"+uploadPath, ""); 	//실제경로 
		//WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	
	
	
}
