package com.javaex.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;

@Repository
public class BoardRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//--게시판 전체 리스트
	public List<BoardVO> boardSelect(){//1다오 1쿼리 그래서 쪼개져있다!
     	
		System.out.println("BoardRepository.boardSelect");//ㅇㅋ
		
		List<BoardVO> boardList = sqlSession.selectList("board.selectList");
		
	
		return boardList;
	}
	
	
	

	//--게시판 전체 리스트2(페이징)           서비스에서 보낸 걸 받는다
	public List<BoardVO> boardSelect2(Map<String, Integer> limitMap){ //1다오 1쿼리
     	
		System.out.println("BoardRepository.boardSelect222");//ㅇㅋ
		
		List<BoardVO> boardList = sqlSession.selectList("board.selectList2",limitMap);
		
		return boardList;
	}
	
	
	//전체 글갯수(페이징)
	public int selectTotalCount() { //1다오 1쿼리
		System.out.println("BoardRepository.selectTotalCount");

		int totalCount = sqlSession.selectOne("board.selectTotalCount");
		
		return totalCount;
		
	}
	
	
	
	
	
	
	
	
	
	//글등록
	public int boardInsert() {
		
		System.out.println("BoardRepository.boardInsert");//ㅇㅋ
		return 0;
	}
	
}
