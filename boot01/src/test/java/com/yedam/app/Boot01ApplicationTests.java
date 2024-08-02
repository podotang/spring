package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;


@SpringBootTest
class Boot01ApplicationTests {
	
	@Autowired
	EmpMapper empmapper;
	
	//@Test
	void contextLoads() {
		assertNotNull(empmapper);
	}
	
	//@Test
	void selectEmpAll() {
		//전체조회 list 타입이 널일수없음 빈리스트라도 돌려줌으로 널값확인하면안됨
		List<EmpVO> list = empmapper.selectEmpAll();
		assertTrue(!list.isEmpty());
	}
	
	//@Test
	void selectEmpInfo() {
		//단건조회
		EmpVO empvo = new EmpVO();
		empvo.setEmpid(114);
		
		EmpVO findVO = empmapper.selectEmpInfo(empvo);
		assertEquals(findVO.getEmpname(),"Den");
	}
	
	//@Test
	void insertEmpInfo() {
		//등록
		EmpVO empvo = new EmpVO();
		empvo.setEmpname("사쿠");
		empvo.setSal(12000);
		empvo.setDeptid(40);
		
		int result = empmapper.insertEmpInfo(empvo);
//		assertEquals(result,1);
		assertEquals(empvo.getEmpid(),205);
	}
	
// @Test
	void updateEmpInfo() {
		// 1.단건조회 => 2.업데이트
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(4);
		
		// 1-2). 조회
		EmpVO findVO = empmapper.selectEmpInfo(empVO);
		findVO.setEmpname("사쿠야");
		findVO.setSal(99999);
		findVO.setMgr(12);
		findVO.setDeptid(30);
		
		// 2. 업데이트
		int result = empmapper.updateEmpInfo(findVO.getEmpid(), findVO);
		assertEquals(1,result);
	}
	
//	@Test
	void deleteEmpInfo() {
		int result = empmapper.deleteEmpInfo(3);
		assertEquals(1,result);
	}
	
	
	
	
	
	
	
	
	
}










