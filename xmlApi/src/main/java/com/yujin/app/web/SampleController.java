package com.yujin.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yujin.app.service.KomoranService;

@Controller
public class SampleController {
	
	@Autowired
	KomoranService service;
	
	@GetMapping("")
	    public String plain() {
		 return "/test/test";
	    }
	 
	 @GetMapping("test")
	    public String test() {
		 return "/test/test2";
	    }
	 
	 @GetMapping("komoran")
	    public String komoran() {
		 service.action();
		 return "/test/komoran";
	    }
	 
	 @PostMapping("annyang")
	 @ResponseBody
	 public String anny() {
		 return "/test/komoran";
	 }
	 
	 @GetMapping("annyang")
	    public String annyang() {
		 return "/test/annyang";
	    }

	 
	 
	 
	 
}

