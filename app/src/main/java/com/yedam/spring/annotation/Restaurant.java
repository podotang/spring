package com.yedam.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//빈으로 등록한다는뜻
@Component
public class Restaurant {
	
	private Chef chef;
	
	@Autowired		//autowired 로 이거쓰라고 알려줌 //생성자 세터 다 가능
	Restaurant(Chef chef) {
		System.out.println("생성자 인젝션");
		this.chef = chef;
	}
	Restaurant(){}
	
	public void setChef(Chef chef) {
		System.out.println("세터 인젝션");
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
