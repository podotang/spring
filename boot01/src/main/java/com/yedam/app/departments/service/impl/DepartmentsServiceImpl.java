package com.yedam.app.departments.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.departments.mapper.DepartmentsMapper;
import com.yedam.app.departments.service.DepartmentsService;
import com.yedam.app.departments.service.DepartmentsVO;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{

	@Autowired
	private DepartmentsMapper depMapper;
	
	@Override
	public List<DepartmentsVO> depList() {
		return depMapper.selectDepAll();
	}

	@Override
	public DepartmentsVO depInfo(DepartmentsVO depVO) {
		return depMapper.selectDepInfo(depVO);
	}

	@Override
	public int depInsert(DepartmentsVO depVO) {
		int result = depMapper.insertDepInfo(depVO);
		return result == 1 ? depVO.getDepartment_id() : -1;
	}

	@Override
	public Map<String, Object> depUpdate(DepartmentsVO depVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = depMapper.updateDepInfo(depVO.getDepartment_id(), depVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", depVO);
		return map;
	}

	@Override
	public Map<String, Object> depDelete(DepartmentsVO depVO) {
		Map<String, Object> map = new HashMap<>();
		
		int result = depMapper.deleteDepInfo(depVO.getDepartment_id());
		
		if(result== 1) {
			map.put("empid", depVO.getDepartment_id());
		}
		
		return map;
	}

	
}
