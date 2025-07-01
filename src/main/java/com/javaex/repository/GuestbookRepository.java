package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVO;

@Repository
public class GuestbookRepository {
	
	@Autowired
	private SqlSession sqlSession;
	

		//전체데이터 가져오기
		public List<GuestbookVO> guestbookSelect() {
			System.out.println("GuestbookRepository.selectList");		 //게스트북xml의 (방)이름. 진짜이름 -->쿼리문의 위치 
			List<GuestbookVO> guestbookList = sqlSession.selectList("guestbook.selectList");
		
			
			return guestbookList;
		}

		

		//전체데이터 가져오기2(페이징)
		public List<GuestbookVO> guestbookSelect2() {
			System.out.println("GuestbookRepository.selectList22");		
			List<GuestbookVO> guestbookList = sqlSession.selectList("guestbook.selectList");
			
	
			return null;
		}

		
		
		
		//전체 글갯수(페이징)
		public int selectTotalCount() { //1다오 1쿼리
			System.out.println("GuestbookRepository.selectTotalCount");

			int totalCount = sqlSession.selectOne("board.selectTotalCount");
			
			return totalCount;
			
		}
		
		
		
		
	
		//방명록저장
		public int guestbookInsert(GuestbookVO guestbookVO) {
			
			System.out.println("GuestbookRepository.guestbookInsert");
		
			int count = sqlSession.insert("guestbook.insert", guestbookVO);
			
			return count;
			
		}
		
		
		//삭제하기
		public int guestbookDelete(GuestbookVO guestbookVO) {
			System.out.println("GuestbookRepository.Delete()");
			System.out.println(guestbookVO);
			int count = sqlSession.delete("guestbook.delete", guestbookVO);
			
			return 0;
		}
}
