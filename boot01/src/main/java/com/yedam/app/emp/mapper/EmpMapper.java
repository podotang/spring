package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	//전체조회
	public List<EmpVO> selectEmpAll();
	//단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	//등록 int 타입 사용하고 서비스에서 바꿈
	public int insertEmpInfo(EmpVO empVO);
	//수정
	public int updateEmpInfo(int empId, EmpVO empVO);
	//삭제
	public int deleteEmpInfo(int empId);
}

