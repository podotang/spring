package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

//@AllArgsConstructor : 필드 매개변수로 생성자만드는방식 / lombok꺼
@Controller
public class BoardController {
	
	//DI
	//=========필드주입방식 사용X일때=>  생성자 주입방식 
	private BoardService service;
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	//========= 생성자 주입방식 

	// 전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = service.boardList();
		model.addAttribute("boardlist",list);
		return "board/boardList";
		//classpath:/templates/     board/boardList     .html
	}
	
	// 단건조회 : URI - boardInfo / PARAMETER - BoardVO(QueryString)
	// 커맨드객체 : 어노테이션 사용안하는 순수데이터형태
	//          RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO vo, Model model) {
		BoardVO findvo = service.boardInfo(vo);
		model.addAttribute("boardinfo",findvo);
		return "board/boardInfo";
	}
	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {	//일반적이 <form/> 활용
		return "board/boardInsert";
	}
	// 등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO(QueryString)
	//             RETURN - 단건조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO vo) {
		int bid = service.insertBoard(vo);
		return  "redirect:boardInfo?boardNo=" + bid;
	}
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO(QueryString)
	//               RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdate(BoardVO vo, Model model) {
		BoardVO findvo = service.boardInfo(vo);
		model.addAttribute("boardinfo",findvo);
		return "board/boardUpdate";
	}
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO(JSON)
	//             RETURN - 수정결과 데이터(Map)	//리턴이 데이터 = ajax 처리 == @ResponseBody사용!!!!
	@PostMapping("boardUpdate")
	@ResponseBody	//ajax
	public Map<String, Object> boardUpdate(@RequestBody BoardVO vo){
		return service.updateBoard(vo);
	}
	// 삭제 - 처리 : URI - boardDelete / PARAMETER - Integer
	//             RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
//	public String boardDelete(Integer boardNo) { 
	// 방법 2가지 @RequestParam붙으면 필수임!
	// @RequestParam 없어도 상관없는 상황 붙으면 400에러남
		public String boardDelete(@RequestParam Integer boardNo) {
		service.deleteBoard(boardNo);
		return "redirect:boardList";
	}
	
	
	
	
	
	
	
	
	
}














