package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service		//service쪽에서 aop동작!! 트랜젝셔널!!
public class BoardServiceImpl implements BoardService{
	
	//=========필드주입방식 사용X일때=>  생성자 주입방식
	private BoardMapper boardMapper;
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper){
		this.boardMapper = boardMapper;
	}
	//========= 생성자 주입방식 

	@Override
	public List<BoardVO> boardList() {
		return boardMapper.selectBoardAll();
	}

	@Override
	public BoardVO boardInfo(BoardVO boardvo) {
		return boardMapper.selectBoardInfo(boardvo);
	}

	@Override
	public int insertBoard(BoardVO boardvo) {
		int result = boardMapper.insertBoardInfo(boardvo);
		return result == 1 ? boardvo.getBoardNo() : -1;
	}

	@Override
	public Map<String, Object> updateBoard(BoardVO boardvo) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = boardMapper.updateBoardInfo(boardvo);
		
		if(result ==1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", boardvo);
		
		return map;
	}

	@Override
	public int deleteBoard(int boardNo) {
		return boardMapper.deleteBoardInfo(boardNo);
	}


	
}
