package com.yujin.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	 @GetMapping("/sample/plain")
	    public void plain() {

	        System.out.println("/plain");
	    }
}
