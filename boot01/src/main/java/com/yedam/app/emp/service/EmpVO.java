package com.yedam.app.emp.service;

import lombok.Data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class EmpVO {
	private int empid;
	private String empname;
	private int mgr;
	private double sal;
	private int deptid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")		// 파라미터 자동변환
	private Date hiredate;	//2024/07/01	:기본 날짜인식
}
