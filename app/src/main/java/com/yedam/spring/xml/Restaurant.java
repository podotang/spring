package com.yedam.spring.xml;

public class Restaurant {
	
	private Chef chef;
	
	//빈주입시 꼭 필요한부분 해당클래스가 주입받는 클래스 가지고있어야함
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
