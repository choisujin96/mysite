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
	
	public List<BoardVO> exeList() {
		System.out.println("BoardService.exeList");	//ㅇㅋ
		List<BoardVO> boardList = boardRepository.boardSelect();
		return boardList;

	}
	
}
