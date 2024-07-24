package com.yedam.app.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> bookList();
	public BookVO bookInfo(BookVO vo);
	public int bookNumber();
	public int bookInsert(BookVO vo);
	
	public List<RentVO> rentList();
}
