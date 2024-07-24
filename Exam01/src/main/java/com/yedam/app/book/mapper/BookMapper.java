package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;
import com.yedam.app.book.service.RentVO;

public interface BookMapper {
	public List<BookVO> selectAllBook();
	public BookVO selectBook(BookVO vo);
	
	public int bookNo();
	
	public int insertBook(BookVO vo);
	public int updateBook(BookVO vo);
	public int deleteBook(int bookNO);
	public List<RentVO> rentStatus();

}
