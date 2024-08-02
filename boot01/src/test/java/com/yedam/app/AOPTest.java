package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yedam.app.aaa.service.AaaService;

@SpringBootTest
public class AOPTest {
	@Autowired
	AaaService aaaService;
	
	//@Test
	public void transational() {
		aaaService.insert();
	}
	
	
	//시큐리티에서 사용하는 인코딩된 비밀번호 가져와서 db에 update해주고 로그인실행
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void testEncoder() {
		
	String password="1234";
			
	String enPwd = passwordEncoder.encode(password);
	System.out.println("enPwd" +  enPwd);
	
	boolean matchResult = passwordEncoder.matches(password,enPwd);
	System.out.println("matchResult" +  matchResult);
	}

	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
