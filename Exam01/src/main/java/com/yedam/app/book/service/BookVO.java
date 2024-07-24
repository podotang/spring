package com.yedam.app.book.service;

import lombok.Data;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


@Data
public class BookVO {
	private int bookNo;	//책번호
	private String bookName;	//이름
	private String bookCoverimg;	//커버
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date bookDate;	//출판일
	private int bookPrice;	//가격
	private String bookPublisher;	//출판
	private String bookInfo;	//소개
	
	private int allsum;
	private int cnt;
}
