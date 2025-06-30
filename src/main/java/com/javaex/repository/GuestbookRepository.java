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

	
	
		public int guestbookInsert(GuestbookVO guestbookVO) {
			
			System.out.println("GuestbookRepository.guestbookInsert");
			System.out.println(guestbookVO);
			int count = sqlSession.insert("guestbook.insert", guestbookVO);
			
			return count;
			
		}
}
