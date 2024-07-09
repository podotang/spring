package com.yedam.spring.annotation;

import org.springframework.stereotype.Component;

//빈으로 등록한다는뜻
@Component
public class Chef {
	public void cooking() {
		System.out.println("DI:annotation 방식");
	}
}
