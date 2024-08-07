package com.yujin.app.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yujin.app.service.KomoranService;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

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
	 
//	 @GetMapping("komoran")
//	    public String komoran() {
//		 service.action();
//		 return "/test/komoran";
//	    }
	 
	 @PostMapping("annyang")
	 @ResponseBody
	 public String anny() {
		 return "/test/komoran";
	 }
	 
//	 @GetMapping("annyang")
//	    public String annyang() {
//		 return "/test/annyang";
//	    }

	 @GetMapping("/analyze")
	 public String getAnalyzePage() {
	     return "test/annyang"; // GET 요청 시 반환할 페이지 또는 데이터
	 }
	 
	 
	 @ResponseBody
	 @PostMapping("/analyze")
	    public List<String> analyzeText(@RequestBody Map<String, String> payload) {
	        return service.analyzeText(payload.get("text"));
	    }
	 
//	 @ResponseBody
//	 @PostMapping("/analyze")
//	    public List<String> analyzeText(@RequestBody Map<String, String> payload) {
//	        String text = payload.get("text");
//	        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
//	        KomoranResult result = komoran.analyze(text);
//	        return result.getNouns();
//	    }
	 
	 
	 
}

