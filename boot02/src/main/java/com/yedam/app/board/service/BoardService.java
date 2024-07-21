package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	
	public List<BoardVO> boardList();
	
	public BoardVO boardInfo(BoardVO boardvo);
	
	public int insertBoard(BoardVO boardvo);
	
	public Map<String, Object> updateBoard(BoardVO boardvo);
	
	public int deleteBoard(int boardNo);
	
}
