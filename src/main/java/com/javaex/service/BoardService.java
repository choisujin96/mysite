package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.BoardRepository;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	//--게시판 전체 리스트
	public List<BoardVO> exeList() {
		System.out.println("BoardService.exeList");	//ㅇㅋ
		List<BoardVO> boardList = boardRepository.boardSelect();
		return boardList;

	}
	
	//글쓰기
	public int exeBoardAdd() {
		System.out.println("BoardService.exeBoardAdd");
		boardRepository.boardInsert();
		
		return 0;
		
		
	}
	
}
