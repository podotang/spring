package com.yedam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//컨테이너 생성
		
		//tv라는 id기반호출
		TV tv = (TV) ctx.getBean("tv");
		tv.turnOn();
		
		//class자체에대한 정보 호출
		TV subTv = (TV) ctx.getBean(TV.class);
		subTv.turnOn();
		
		if(tv == subTv) {
			System.out.println("같은 인스턴스");
		}else {
			System.out.println("다른 인스턴스");
		}
	}
}
