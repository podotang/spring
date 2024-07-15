package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.departments.service.DepartmentsVO;

@Controller
public class DepartmentsTestController {

	@RequestMapping(path="deptest", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String deptest(DepartmentsVO depVO) {
		String result = "";
		result += "path : /deptest\n";
		result += "\t depId : " + depVO.getDepartment_id();
		result += "\t depName : " + depVO.getDepartment_name();
		
		return result;
	}
	
	
}
