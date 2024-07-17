package com.yedam.app.aaa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aaa.mapper.AaaMapper;
import com.yedam.app.aaa.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{
	
	@Autowired
	AaaMapper aaaMapper;
	
	//어노테이션도 속성을가짐
	// @Transactional(timeout = ) 서버딜레이생겨도 시간지나면강제종료 :타임아웃이 실행되면 문제가있는상태라서
	@Transactional()	//pl/sql로도 제어가능 but 이게더 편함
	@Override
	public void insert() {
		aaaMapper.aaaInsert("101");
		aaaMapper.aaaInsert("a101");
	}

}
