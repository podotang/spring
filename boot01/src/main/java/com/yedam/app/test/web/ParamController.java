package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class ParamController {
	// QueryString => 커맨드객체 : 클래스 타입
	// QueryString => @RequestParam : 기본타입, 단일값
	
//	@PostMapping("comobj")
	@RequestMapping(path="comobj", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "path : / comobj\n";
		result += " \t empid : " + empVO.getEmpid();
		result +="\t empname : " + empVO.getEmpname();
//		result +="\t hiredate : " + empVO.getHiredate();
		return result;
	}
	
	@RequestMapping(path="reqparam", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam(
			String empname,
			@RequestParam Integer empid,	//@RequestParam은 필수이고 변수명이 키가된다
			@RequestParam(name = "message", defaultValue= "NO message", required=true) String msg) {
		String result = "";
		result += "path : / reqparam\n";
		result += " \t empid : " + empid;
		result +="\t empname : " + empname;
		result +="\t msg : " + msg;
		return result;
	}
	
	//@PathVariable : 경로에 값을 포함하는 방식, 단일 값 Method는 상관 X , content-type 도 상관 X
//	@RequestMapping(path={"path/{id}/{pwd}", "path/{id}"})
	@RequestMapping(path="path/{id}/{pwd}")
	@ResponseBody
	public String pathVariable(@PathVariable String id, @PathVariable(name="pwd") String password) {
		String result = "";
		result += "path : / path{id} /{pwd} \n";
		result += " \t id : " + id;
		result += " \t pwd : " + password;
		return result;
	}
	
	@RequestMapping(path={"path2/{id}/{pwd}", "path2/{id}"})
	@ResponseBody
	public String pathVariable2(@PathVariable String id, @PathVariable(name="pwd", required =false) String password) {
		if (password == null ) password="1234";	//defaultValue 주는것과 같은 역할	// 마지막값에 대해서만 있을때없을때 설정이 가능
		String result = "";
		result += "path : / {id} /{pwd} \n";
		result += " \t id : " + id;
		result += " \t pwd : " + password;
		return result;
	}
	
	//@RequestBody : JSON 포맷, 배열 or 객체 ->헤더부분안걸들임 
	// Method : POST, PUT
	// Content-type : application/json
	
	// 배열로진행
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {
		String result = "";
		result += "path : / resbody\n";
		result += " \t empid : " + empVO.getEmpid();
		result +="\t empname : " + empVO.getEmpname();
		return result;
	}
	
	// 
	
	@PostMapping("resbodyList")
	@ResponseBody
	public String requestBodyList(@RequestBody List<EmpVO> list) {
		String result = "path : /resbodyList \n";
		for(EmpVO empVO : list) {
			result += "\n";
			result += " \t empid : " + empVO.getEmpid();
			result +="\t empname : " + empVO.getEmpname();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
