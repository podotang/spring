package com.yedam.app.book.service;

import lombok.Data;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class RentVO {
	private int rentNo;	//대여번호
	private int bookNo;	//도서번호
	private int rentPrice;	//대여금액
	@DateTimeFormat(pattern = "yy/MM/dd")	
	private Date rentDate;	//대여일자
	private String rentStatus;	//반납여부
	
	private int cnt;	// 갯수
	private int allsum;	// 총계
}
