package com.yedam.app.emp.service;

import lombok.Data;

import java.util.Date;

@Data
public class EmpVO {
	private int empid;
	private String empname;
	private int mgr;
	private double sal;
	private int deptid;
	private Date hiredate;
}
