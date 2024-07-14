package com.yedam.app.departments.service;

import java.util.List;
import java.util.Map;

public interface DepartmentsService {
	
	public List<DepartmentsVO> depList();
	
	public DepartmentsVO depInfo(DepartmentsVO depVO);
	
	public int depInsert(DepartmentsVO depVO);
	
	public Map<String, Object> depUpdate(DepartmentsVO depVO);
	
	public Map<String, Object> depDelete(DepartmentsVO depVO);
}
