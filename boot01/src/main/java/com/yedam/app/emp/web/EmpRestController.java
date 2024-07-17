package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@CrossOrigin(origins = "http://localhost:5000")
@RestController	//ajax 전용 @Controller +  모든 메소드에 @ResponseBody선언 //페이지 요청Controller없음
public class EmpRestController {
	//내부 Controller 가 모두 ajax 전용
	@Autowired
	EmpService empService;
	// REST : get, post, put, delete 메소드 사용
	
	//전체조회
	@GetMapping("emps")
	public List<EmpVO> empList(){
		return empService.empList();
	}
	
	//단건조회
	@GetMapping("emps/{empid}")
	public EmpVO empInfo(@PathVariable Integer empid) {	//requestparam으로 인식 어노테이션없으면
		EmpVO empVO = new EmpVO();		//@PathVariable은 vo바로 사용못해서 담아서 보내줌
		empVO.setEmpid(empid);		
		return empService.empInfo(empVO);
	}
	
	//등록
	@PostMapping("emps")	//@PathVariable, @RequestBody 두가지 방법 가능
	public int empInsert(@RequestBody EmpVO empVO) {
		return empService.empInsert(empVO);
	}
	
	//수정 => Patch
	@PutMapping("emps/{empid}")	//단건조회
	public  Map<String,Object> empUpdate(@PathVariable Integer empid, @RequestBody EmpVO empVO) {	// 등록
		empVO.setEmpid(empid);
		return empService.empUdate(empVO); 
	}
		
	//삭제
	@DeleteMapping("emps/{empid}")
	public Map<String,Object> empDelete(@PathVariable Integer empid) {	//requestparam으로 인식 어노테이션없으면
		EmpVO empVO = new EmpVO();		//@PathVariable은 vo바로 사용못해서 담아서 보내줌
		empVO.setEmpid(empid);		
		return empService.empDelete(empVO);
	}
	
	
	
	
	
}

















