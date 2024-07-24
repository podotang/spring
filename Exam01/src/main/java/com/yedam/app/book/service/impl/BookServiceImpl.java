package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.book.service.RentVO;

import groovyjarjarantlr4.v4.parse.ANTLRParser.parserRule_return;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookMapper mapper;
	
	@Override
	public List<BookVO> bookList() {
		return mapper.selectAllBook();
	}

	@Override
	public BookVO bookInfo(BookVO vo) {
		return mapper.selectBook(vo);
	}

	@Override
	public int bookInsert(BookVO vo) {
		return mapper.insertBook(vo);
	}

	@Override
	public List<RentVO> rentList() {
		return mapper.rentStatus();
	}

	@Override
	public int bookNumber() {
		return mapper.bookNo();
	}



	
}














