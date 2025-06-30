package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;

@Repository
public class BoardRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//--게시판 전체 리스트
	public List<BoardVO> boardSelect(){
     	
		System.out.println("BoardRepository.boardSelect");//ㅇㅋ
		
		List<BoardVO> boardList = sqlSession.selectList("board.selectList");
		
	
		return boardList;
	}
	
	
	public int boardInsert() {
		
		System.out.println("BoardRepository.boardInsert");
		return 0;
	}
	
}
