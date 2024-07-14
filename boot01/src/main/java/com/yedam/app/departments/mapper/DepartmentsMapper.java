package com.yedam.app.departments.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.departments.service.DepartmentsVO;

public interface DepartmentsMapper {
	//전체조회
	public List<DepartmentsVO> selectDepAll();
	//단건조회
	public DepartmentsVO selectDepInfo(DepartmentsVO depVO);
	//등록
	public int insertDepInfo(DepartmentsVO depVO);
	//수정
	public int updateDepInfo(@Param("did")int department_id, @Param("dep")DepartmentsVO depVO);
	//삭제
	public int deleteDepInfo(int department_id);
}
