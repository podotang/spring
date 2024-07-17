package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.aaa.service.AaaService;

@SpringBootTest
public class AOPTest {
	@Autowired
	AaaService aaaService;
	
	@Test
	public void transational() {
		aaaService.insert();
	}
}
