package com.yujin.app.mapper;

import java.util.List;

import com.yujin.app.service.DetailInfoVO;

public interface WelfareMapper {
	//아이디만 입력
	public int insertId(DetailInfoVO servId);
	
	//리스트받기
	public List<DetailInfoVO> basicInfo();
	
	//데이터 전체출력
	
	public int insertData(DetailInfoVO vo);
	
	
	
}
