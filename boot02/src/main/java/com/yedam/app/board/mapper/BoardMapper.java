package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;


public interface BoardMapper {
	//전체조회
	public List<BoardVO> selectBoardAll();
	//단건조회
	public BoardVO selectBoardInfo(BoardVO boardvo);
	//등록 int 타입 사용하고 서비스에서 바꿈
	public int insertBoardInfo(BoardVO boardvo);
	//수정
	public int updateBoardInfo(BoardVO boardvo);
	//삭제
	public int deleteBoardInfo(int boardNo);

}
