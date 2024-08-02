package com.yedam.app.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.security.mapper.UserMapper;
import com.yedam.app.security.service.LoginUserVO;
import com.yedam.app.security.service.UserVO;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	private UserMapper mapper;
	
	@Autowired
	CustomerUserDetailsService(UserMapper mapper){
		this.mapper = mapper;
	}
	
	@Override		// 인증을 하기위한 정보조회 //사람이 등록되었는지 안되어있는지 까지만 확인가능 비번은따로 프로바이더에서
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO uvo = mapper.getUserInfo(username);
		
		if(uvo == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new LoginUserVO(uvo);
	}
		
	

}
