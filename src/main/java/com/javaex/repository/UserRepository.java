package com.javaex.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVO;

@Repository
public class UserRepository {


	
	@Autowired
	private SqlSession sqlSession;

	
	public int userInsert(UserVO userVO) {
		
		System.out.println("UserRepository.userInsert");//ㅇㅋ
		
		int count = sqlSession.insert("user.insert", userVO);
		
		return count;
		
		
	}
	
	 public UserVO userSelectOneByIdPw(UserVO userVO) {
		 
		 System.out.println("UserRepository.userSelectOneByIdPw");//ㅇㅋ
		 //System.out.println(userVO); //id pw (0x999)
		 
		 UserVO authUser = sqlSession.selectOne("user.SelectOneByIdPw", userVO); 
		 //System.out.println(authUser); //a의 정보가 들어있다(0x567)
		 
		 return authUser;
	 }

	
	 //--user정보가져오가ㅏ(no) -->회원정보수정폼
	 public UserVO userSelectByNo(int no) {
		 System.out.println("UserRepository.userSelectByNo"); //ㅇㅋ
		
		 System.out.println(no);
		
		 UserVO userVO = sqlSession.selectOne("user.userSelectByNo",no);
		// System.out.println(userVO);
		 
		 return userVO;
		 
	 }
	 
	 public int userUpdate(UserVO userVO) {
		 
		 System.out.println("UserRepository.userUpdate");

		 
		 int count = sqlSession.update("user.update",userVO);
		 return count;
	 }
	 
}
