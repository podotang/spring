package com.yedam.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//컨테이너 생성
		
		Restaurant res = (Restaurant) ctx.getBean(Restaurant.class);
//		Chef chef = new Chef();
		
		res.run();
		
		
	}
}
