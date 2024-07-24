package com.yedam.app.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.book.service.RentVO;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	//전체리스트
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = service.bookList();
		model.addAttribute("booklist",list);
		return "book/booklist";
	}
	
	//등록페이지 
	@GetMapping("bookInsert")
	public String bookForm(Model model, BookVO bvo) {
		int bookNo = service.bookNumber(bvo.getBookNo());
		model.addAttribute(bookNo);
		return "book/bookform";
	}
	
	
	//등록기능
	@PostMapping("bookInsert")
	public String bookInsert(BookVO vo) {
		int bno = service.bookInsert(vo);
		return "redirect:bookList";
	}
	
	
	//대출현황 조회
	@GetMapping("rentStatus")
	public String rentBook(Model model) {
		List<RentVO> rent = service.rentList();
		model.addAttribute("rents",rent);
		return "book/rentlist";
	}
	
	
	
	
	
}













