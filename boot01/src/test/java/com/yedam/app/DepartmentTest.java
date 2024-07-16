package com.yedam.app;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.departments.mapper.DepartmentsMapper;
import com.yedam.app.departments.service.DepartmentsVO;

@SpringBootTest
class DepartmentTest {

	@Autowired
	DepartmentsMapper depMapper;
	
	//@Test
	void contextLoad() {
		assertNotNull(depMapper);
	}
	
	//@Test
	void selectAllDep() {
		List<DepartmentsVO> list = depMapper.selectDepAll();
		assertTrue(!list.isEmpty());
	}
	
//	@Test
	void selectDepInfo() {
		DepartmentsVO depVO = new DepartmentsVO();
		depVO.setDepartment_id(60);
		DepartmentsVO findVO = depMapper.selectDepInfo(depVO);
		assertEquals(findVO.getDepartment_name(), "IT");
	}
	
	//@Test
	void insertDepInsert() {
		DepartmentsVO  depVO = new DepartmentsVO();
		depVO.setDepartment_id(280);
		depVO.setDepartment_name("CEO");
		depVO.setLocation_id(1700);
		depVO.setManager_id(103);
		
		int result = depMapper.insertDepInfo(depVO);
		assertEquals(depVO.getDepartment_id(),280);
	}
	
	@Test
	void updateDepInfo() {
		DepartmentsVO depVO = new DepartmentsVO();
		depVO.setDepartment_id(280);
		
		DepartmentsVO findVO = depMapper.selectDepInfo(depVO);
		findVO.setDepartment_name("Slave");
		findVO.setLocation_id(1700);
		findVO.setManager_id(103);
		
		int result = depMapper.updateDepInfo(findVO.getDepartment_id(), findVO);
		assertEquals(1, result);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
