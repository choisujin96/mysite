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
		
		
		
		
		
		//방명록 저장하고 키값 가져오기(ajax)
		public int guestbookInsertKey(GuestbookVO guestbookVO) {

			System.out.println("GuestbookRepository.guestbookInsertKey");
			System.out.println(guestbookVO); //3개
			
			int count = sqlSession.insert("guestbook.insertkey", guestbookVO);
			System.out.println(guestbookVO);// no값 추가됨
			
			System.out.println(count);
			
			return guestbookVO.getNo();
		}
		
		
		//글 1개 가져오기
		public GuestbookVO guestbookSelectOne(int no) {
			
			//System.out.println("GuestbookRepository.guestbookSelectOne");
			//System.out.println(no);
			
			//가져온 글 출력
			GuestbookVO guestbookVO = sqlSession.selectOne("guestbook.selectOne", no);
			System.out.println(guestbookVO);
			
			return guestbookVO;
		}
		
		
		
		
		
		//삭제하기
		public int guestbookDelete(GuestbookVO guestbookVO) {
			System.out.println("GuestbookRepository.Delete()");
			System.out.println(guestbookVO);
			int count = sqlSession.delete("guestbook.delete", guestbookVO);
			
			return count;
		}
		
		
		//아이디사용유무 체크 (회원가입)
		public void userSelectById() {
			System.out.println();
		}
		
}
