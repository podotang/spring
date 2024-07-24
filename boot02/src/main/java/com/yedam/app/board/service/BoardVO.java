package com.yedam.app.board.service;

import lombok.Data;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class BoardVO {
	private int boardNo;	//번호
	private String boardTitle;	//제목
	private String boardContent;	//내용
	private String boardWriter;		//작성자
	
	//java.util.date :yyyy/MM/dd => 스타일이 기본임
	//<input type="date"> : @DateTimeFormat();
	@DateTimeFormat(pattern = "yyyy-MM-dd")		// 파라미터 자동변환
	private Date regdate;	//작성일
	private Date updatedate;	//수정일
	private String image;		//첨부이미지
}
