package com.javaex.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVO;

@Repository
public class GuestbookRepository {

	@Autowired
	private SqlSession sqlSession;
	
	
//	public GuestbookVO guestbookSelect(GuestbookVO guestbookVO) {
//		
//		System.out.println("UserRepository.userInsert");//ㅇㅋ
//		
//		int count = sqlSession.insert("user.insert", userVO);
//		
//		return count;
//		}
		
}
