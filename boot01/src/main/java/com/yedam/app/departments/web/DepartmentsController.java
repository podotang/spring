package com.yedam.app.departments.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.departments.service.DepartmentsService;
import com.yedam.app.departments.service.DepartmentsVO;

@Controller
public class DepartmentsController {

	@Autowired
	DepartmentsService depService;
	
	@GetMapping("depList")
	public String depList(Model model) {
		List<DepartmentsVO> list = depService.depList();
		model.addAttribute("depList", list);
		return "dep/list";
	}
	
	@GetMapping("depInfo")
	public String depInfo(DepartmentsVO depVO, Model model) {
		DepartmentsVO findVO = depService.depInfo(depVO);
		model.addAttribute("depInfo",findVO);
		return "dep/info";
	}
	
	@GetMapping("depInsert")
	public String depInsertForm() {
		return "dep/insert";
	}
	
	@PostMapping("depInsert")
	public String depInsertProcess(DepartmentsVO depVO) {
		int did = depService.depInsert(depVO);
		String url = null;
		if(did>-1) {
			url = "redirect:depInfo?department_id=" + did;
		}else {
			url = "redirect:depList";
		}
		return url;
		
	}
	
	
	
}
