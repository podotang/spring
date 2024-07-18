package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper") //basePackages 있어야 싱클톤패턴안깨짐 : 범위좁힘
public class Boot02Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot02Application.class, args);
	}

}
